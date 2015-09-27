package objects;

import exceptions.*;
import interpreter.objects.*;
import objects.constraints.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import objects.select.JoinObject;
import objects.select.SelectColumn;
import ursql.ResultSet;
import ursql.ResultSetDisplay;
import ursql.ResultSetNode;
import utils.Constants;

/**
 * Recibe las intrucciones del intérprete de comandos para llamar al 
 * SystemCatalog y ejecutarlas
 * @author maikol_beto
 * @version 1.0
 */
public class RuntimeDatabaseProcessor {
    
    private SystemCatalog systemCatalog;
    
    protected Schema actualSchema;
    
    public String result;
    
    public List<String> resultList;
    
    public int errorCode; // 0 no errors, 1 empty message, -1 error
    
    public ResultSet selectAnswer;
    
    public RuntimeDatabaseProcessor(){
        systemCatalog = new SystemCatalog();
        
        result = "";
        resultList = new ArrayList<>();
        errorCode = 1;
        selectAnswer = null;
        
    }
    
    /**
     * Crea un nuevo Schema a partir del nombre
     * @param name Nombre del Schema que queremos crear
     * @throws java.lang.Exception En caso de que el Schema ya exista
     */
    public void createDatabase (String name) throws Exception
    {
        errorCode = -1;
        getSystemCatalog().createSchema(name);
        errorCode = 0;
    }
    
    /**
     * Elimina el Schema cuyo nombre sea name
     * @param name Nombre del Schema que se desea borrar
     * @throws java.lang.Exception En caso de que el Schema no exista
     */
    public void dropDatabase (String name) throws Exception
    {
        errorCode = -1;
        getSystemCatalog().deleteSchema(name);
        errorCode = 0;
    }
    
    /**
     * Genera un listado de todos los Schemas existentes
     * @return Lista con los nombres de los esuqemas
     */
    public void listDatabases ()
    {
        List<Schema> list = systemCatalog.getSchemas();
        for (Schema database : list)
        {
            resultList.add(database.name);
        }
        if (resultList != null)
            result = resultList.toString();
        else
            result = "";
        
        System.out.println(result);
    }
    
    /**
     * Inicia todos los componentes y retorna un reporte
     * @return Componentes iniciados y el nombre/id del proceso 
     */
    public String start ()
    {
        String answer = "";
        /* IMPORTANTE: cargar todas las bases de datos */
        List<Schema> list = systemCatalog.getSchemas();
        List<String> schemesList = new ArrayList<>();
        for (Schema database : list)
        {
            String reportline = "";
            reportline += "El Scheme: " + database.getName() + " contiene las siguientes tablas:\n";
            for (Table tabla : database.getTables())
            {
                reportline += "   - " + tabla.name + "\n";
            }
            answer += reportline;
        }
        System.out.println(answer);
        return answer;
    }
    
    /**
     * Genera un reporte del estado de los componentes de urSQL indicando si 
     * están ejecutándose o no
     * @return Nombre/id del proceso
     */
    public String getStatus ()
    {
        return "";
    }
    
    /**
     * Muestra un reporte con todoos los objetos del esquema indicado. 
     * @param name Database name
     * @return Listado de tablas y para cada tabla las columnas (nombre, tipo
     * de datos, null constraint), constraints, cantidad de elementos en la 
     * tabla entre otros.
     * @throws java.lang.Exception En caso de que el Schema no exista
     */
    public void displayDatabase (String name) throws Exception
    {
        errorCode = -1;
        String totalResult = "";
        Schema schema = systemCatalog.getSchema(name);
        List<Table> tablas = schema.getTables();
        for (Table tabla : tablas)
        {
            totalResult += ("Table: " + tabla.name + "\n");
            
            List<String> titulo = Arrays.asList("Field", "Type", "Null", "Key");
            ResultSetDisplay rsd = new ResultSetDisplay(titulo);
            for (int index = 0; index<tabla.columnNames.size(); index++)
            {
                String nule = "YES";
                String key = "";
                for (Constraint constraint : tabla.constraints)
                {
                    if (constraint.type == Constants.NOT_NULL)
                    {
                        if ( ((NotNull)constraint).column.equalsIgnoreCase(tabla.columnNames.get(index)) )
                        {
                            nule = "NO";
                        }
                    }
                    if (constraint.type == Constants.PRIMARY_KEY)
                    {
                        if ( ((PrimaryKey)constraint).primaryKey.equalsIgnoreCase(tabla.columnNames.get(index)) )
                        {
                            key = "PK";
                        }
                    }
                    if (constraint.type == Constants.FOREIGN_KEY)
                    {
                        if ( ((ForeignKey)constraint).column.equalsIgnoreCase(tabla.columnNames.get(index)) )
                        {
                            key = "FK";
                        }
                    }
                }
                String type = tabla.columnTypes.get(index).toString();
                String field = tabla.columnNames.get(index);
                
                List<String> values = Arrays.asList(field, type, nule, key);
                ResultSetNode node = new ResultSetNode(values);
                rsd.addRow(node);
            }
            //rsd.print();
            
            totalResult += rsd.toString();
            totalResult += "\n";
        }
        errorCode = 0;
        result = totalResult;
        
        System.out.println(result); /* Quitar cuando sea API */
    }
    
    /**
     * Detiene todos los procesos de urSQL
     */
    public void stop ()
    {
        
    }
    
    /**
     * Establece el esquema actual sobre el que se aplicarán los comandos 
     * posteriores
     * @param name Schema name
     * @throws java.lang.Exception En caso de que el Schema no exista
     */
    public void setDatabase (String name) throws Exception
    {
        errorCode = -1;
        Schema oldSchema = systemCatalog.getSchema(name);
        actualSchema = oldSchema;
        errorCode = 0;
    }
    
    /**
     * Crea un nuevo Table en urSQL para el Scheme seleccionado (actualSchema)
     * @param name Nombre del nuevo Table
     * @param primaryKey Llave primaria del nuevo Table
     * @param columns Definición de cada una de las columnas del Table 
     * @see ColumnDefinition
     * @throws Exception En caso de que la tabla ya exista
     */
    public void createTable (String name, 
                            String primaryKey, 
                            List<ColumnDefinition> columns) throws Exception
    {
        errorCode = -1;
        if (actualSchema == null)
        {
            throw new exceptions.NoSchemaSelectedException();
        }
        else
        {
            actualSchema.createTable(name, primaryKey, columns);
        }
        errorCode = 0;
    }
    
    /**
     * Modifica un Table, vinculando una de sus columnas a otra columna en otra
     * Table (Llave foránea)
     * @param name Nombre del Table
     * @param constraint Definición del Constraint ForeignKey que deseamos crear
     * @throws Exception En los siguientes casos:
     * 1. El objeto Table no existe
     * 2. El Table que se desea referenciar no existe
     * 3. La columna que se desea referenciar no existe
     * 4. Las columnas son de tipos distintos
     */
    public void alterTable (String name, Constraint constraint) throws Exception
    {
        errorCode = -1;
        if (actualSchema == null)
        {
            throw new exceptions.NoSchemaSelectedException();
        }
        else
        {
            Table oldTable = actualSchema.getTable(name);
            oldTable.createConstraint(constraint, 
                    actualSchema.getTable(((ForeignKey)constraint).referencedTable));
        }
        errorCode = 0;
    }
    
    /**
     * Elimina un objeto Table de la base de datos
     * @param name Nombre del Table que deseamos eliminar
     * @throws Exception En caso en el que el Table no exista o esté siendo 
     * referenciada por otro Table
     */
    public void dropTable (String name) throws Exception
    {
        errorCode = -1;
        if (actualSchema == null)
        {
            throw new exceptions.NoSchemaSelectedException();
        }
        else
        {
            actualSchema.deleteTable(name);
        }
        errorCode = 0;
    }
    
    /**
     * 
     * @param name
     * @param tableName
     * @param columnName
     * @return 
     */
    public int createIndex (String name,
                            String tableName,
                            String columnName)
    {
        return 0;
    }
        
    public void select ( List<SelectColumn> selectionList,
                        String tableNameFrom,
                        List<JoinObject> listJoin,
                        WhereStatment whereStatment,
                        String groupingColumns) throws Exception
    {
        errorCode = -1;
        ResultSet rs;
        if (actualSchema == null)
        {
            throw new exceptions.NoSchemaSelectedException();
        }
        else
        {
            Table actualTable = actualSchema.getTable(tableNameFrom);
            
            String whereStatmentColumn = "";
            String whereStatmentOperator = "";
            String whereStatmentValue = "";
            if (whereStatment != null)
            {
                whereStatmentColumn = whereStatment.column;
                whereStatmentOperator = whereStatment.operator;
                whereStatmentValue = whereStatment.value;
            }
            
            List<Register> joinResult = new ArrayList<>();
            if (!listJoin.isEmpty())
            {
                joinResult = actualSchema.applyJoin(tableNameFrom, listJoin);
            }
            
            rs = actualTable.select(    selectionList, 
                                        joinResult, 
                                        whereStatmentColumn, 
                                        whereStatmentOperator, 
                                        whereStatmentValue, 
                                        groupingColumns);
            
        }
        errorCode = 0;
        selectAnswer = rs;
        
        System.out.println(rs.toString()); /* Quitar cuando sea API */
    }
    
    /**
     * Actualiza las filas del Table que cumplan la condición del WHERE, o todos
     * los datos de la columna
     * @param tableName Nombre del Table en el que vamos a actualizar los datos
     * @param columnName Columna que vamos a modificar
     * @param newValue Nuevo valor que va a tomar la o las filas
     * @param whereStatment Condición del WHERE
     * @return 
     */
    public int update ( String tableName,
                        String columnName,
                        String newValue,
                        WhereStatment whereStatment)
    {
        System.out.println("comando dml update completado");
        return 0;
    }
    
    public void delete ( String tableName,
                        WhereStatment whereStatment) throws Exception
    {
        errorCode = -1;
        if (actualSchema == null)
        {
            throw new exceptions.NoSchemaSelectedException();
        }
        else
        {
            Table actualTable = actualSchema.getTable(tableName);
            actualTable.deleteRegister( whereStatment.column,
                                        whereStatment.operator,
                                        whereStatment.value);
        }
        errorCode = 0;
    }
    
    /**
     * Inserta en Table los valores para las columnas especificadas
     * @param tableName
     * @param columns
     * @param values
     * @return 
     */
    public void insertInto ( String tableName,
                            List<String> columns,
                            List<String> values) throws Exception
    {
        errorCode = -1;
        if (columns.size() != values.size())
            throw new exceptions.NumberOfValuesException();
        if (actualSchema == null)
        {
            throw new exceptions.NoSchemaSelectedException();
        }
        else
        {
            Table actualTable = actualSchema.getTable(tableName);
            actualTable.insertRegister(columns, values);
        }
        errorCode = 0;
    }

    /**
     * @return the systemCatalog
     */
    public SystemCatalog getSystemCatalog() {
        return systemCatalog;
    }

    /**
     * @param systemCatalog the systemCatalog to set
     */
    public void setSystemCatalog(SystemCatalog systemCatalog) {
        this.systemCatalog = systemCatalog;
    }
    
}
