package objects;

import com.sun.corba.se.impl.orbutil.closure.Constant;
import exceptions.NoSchemaSelectedException;
import exceptions.SchemaAlreadyExistsException;
import exceptions.SchemaDoesntExistsException;
import interpreter.objects.AggregateFunction;
import interpreter.objects.ColumnDefinition;
import interpreter.objects.WhereStatment;

import objects.constraints.*;

import java.util.ArrayList;
import java.util.List;
import utils.Constants;

/**
 * @author maikol_beto
 */
public class RuntimeDatabaseProcessor {
    
    protected SystemCatalog systemCatalog = new SystemCatalog();
    
    protected Schema actualSchema;
    
    
    /**
     * Crea un nuevo esquema
     * @param name Database name
     * @throws java.lang.Exception En caso de que el Schema ya exista
     */
    public void createDatabase (String name) throws Exception
    {
        systemCatalog.createSchema(name);
    }
    
    /**
     * Elimina el esquema indicado
     * @param name Database name
     * @throws java.lang.Exception En caso de que el Schema no exista
     */
    public void dropDatabase (String name) throws Exception
    {
        systemCatalog.deleteSchema(name);
    }
    
    /**
     * Genera un listado de todos los esquemas existentes
     * @return Lista con los nombres de los esuqemas
     */
    public List<String> listDatabases ()
    {
        List<Schema> list = systemCatalog.getSchemas();
        List<String> schemesList = new ArrayList<>();
        for (Schema database : list)
        {
            schemesList.add(database.name);
            System.out.println(database.name);
        }
        return schemesList;
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
            reportline += "El Scheme: " + database.name + " contiene las siguientes tablas:\n";
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
     * @return Error code
     */
    public void setDatabase (String name) throws Exception
    {
        Schema oldSchema = systemCatalog.getSchema(name);
        actualSchema = oldSchema;
    }
    
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
    
    public int createIndex (String name,
                            String tableName,
                            String columnName)
    {
        return 0;
    }
    
    public int select ( List<String> selectionList, 
                        AggregateFunction aggregateFunction,
                        String tableNameFrom,
                        List<String> listJoin,
                        WhereStatment whereStatment,
                        String groupingColumns)
    {
        System.out.println("comando dml select completado");
        return 0;
    }
    
    public int update ( String tableName,
                        String columnName,
                        String newValue,
                        WhereStatment whereStatment)
    {
        System.out.println("comando dml update completado");
        return 0;
    }
    
    public int delete ( String tableName,
                        WhereStatment whereStatment)
    {
        System.out.println("comando dml delete completado");
        return 0;
    }
    
    public int insertInto ( String tableName,
                            List<String> columns,
                            List<String> values)
    {
        System.out.println("comando dml insert into completado");
        return 0;
    }
    
}
