package objects;

import exceptions.*;
import interpreter.objects.*;
import objects.constraints.*;
import java.util.ArrayList;
import java.util.List;
import objects.select.SelectColumn;
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
    
    
    public RuntimeDatabaseProcessor(){
        systemCatalog = new SystemCatalog();
    }
    
    /**
     * Crea un nuevo Schema a partir del nombre
     * @param name Nombre del Schema que queremos crear
     * @throws java.lang.Exception En caso de que el Schema ya exista
     */
    public void createDatabase (String name) throws Exception
    {
        getSystemCatalog().createSchema(name);
    }
    
    /**
     * Elimina el Schema cuyo nombre sea name
     * @param name Nombre del Schema que se desea borrar
     * @throws java.lang.Exception En caso de que el Schema no exista
     */
    public void dropDatabase (String name) throws Exception
    {
        getSystemCatalog().deleteSchema(name);
    }
    
    /**
     * Genera un listado de todos los Schemas existentes
     * @return Lista con los nombres de los esuqemas
     */
    public void listDatabases ()
    {
        for(int i = 0; i<getSystemCatalog().getSchemas().size();i++){
            System.out.println(getSystemCatalog().getSchemas().get(i).getName());
        }
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
    public String displayDatabase (String name) throws Exception
    {
        Schema schema = systemCatalog.getSchema(name);
        List<Table> tablas = schema.getTables();
        for (Table tabla : tablas)
        {
            System.out.println("Table: " + tabla.name);
            utils.DisplayHelper help = new utils.DisplayHelper();
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
                help.addRow(    field, 
                                type, 
                                nule, key);
            }
            help.print();
            System.out.println("");
        }
        return "";
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
        Schema oldSchema = systemCatalog.getSchema(name);
        actualSchema = oldSchema;
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
        if (actualSchema == null)
        {
            throw new exceptions.NoSchemaSelectedException();
        }
        else
        {
            actualSchema.createTable(name, primaryKey, columns);
        }
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
    }
    
    /**
     * Elimina un objeto Table de la base de datos
     * @param name Nombre del Table que deseamos eliminar
     * @throws Exception En caso en el que el Table no exista o esté siendo 
     * referenciada por otro Table
     */
    public void dropTable (String name) throws Exception
    {
        if (actualSchema == null)
        {
            throw new exceptions.NoSchemaSelectedException();
        }
        else
        {
            actualSchema.deleteTable(name);
        }
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
        
    public int select ( List<SelectColumn> selectionList,
                        String tableNameFrom,
                        List<String> listJoin,
                        WhereStatment whereStatment,
                        String groupingColumns) throws Exception
    {
        if (actualSchema == null)
        {
            throw new exceptions.NoSchemaSelectedException();
        }
        else
        {
            Table actualTable = actualSchema.getTable(tableNameFrom);
            if (whereStatment == null)
            {
                if (groupingColumns.equals(""))
                {
                    actualTable.select(selectionList);
                }
                else
                {

                }
            }
            else
            {
                if (groupingColumns.equals(""))
                {
                    actualTable.select( selectionList, 
                                        whereStatment.column, 
                                        whereStatment.operator, 
                                        whereStatment.value);
                }
                else
                {

                }
            }
        }
        return 0;
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
