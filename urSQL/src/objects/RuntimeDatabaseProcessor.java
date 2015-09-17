package objects;

import exceptions.SchemaAlreadyExistsException;
import interpreter.objects.AggregateFunction;
import interpreter.objects.ColumnDefinition;
import interpreter.objects.Constraint;
import interpreter.objects.WhereStatment;
import java.util.ArrayList;
import java.util.List;

/**
 * @author maikol_beto
 */
public class RuntimeDatabaseProcessor {
    
    protected SystemCatalog systemCatalog = new SystemCatalog();
    
    
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
        List<String> lista = new ArrayList<>();
        return lista;
    }
    
    /**
     * Inicia todos los componentes y retorna un reporte
     * @return Componentes iniciados y el nombre/id del proceso 
     */
    public String start ()
    {
        return "";
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
    public String displayDatabase (String name)
    {
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
    public int setDatabase (String name)
    {
        return 0;
    }
    
    public int createTable (String name, 
                            String primaryKey, 
                            List<ColumnDefinition> columns)
    {
        System.out.println("nombre: " + name);
        System.out.println("llave primaria: " + primaryKey);
        for (ColumnDefinition column : columns)
        {
            System.out.println(column.toString());
        }
        return 0;
    }
    
    public int alterTable (Constraint constraint)
    {
        System.out.println("tabla: " + constraint.name);
        System.out.println(constraint.toString());
        return 0;
    }
    
    public int dropTable (String name)
    {
        return 0;
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
