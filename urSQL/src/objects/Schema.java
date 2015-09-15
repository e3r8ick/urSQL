package objects;

import java.util.ArrayList;
import java.util.List;
import objects.constraints.Constraint;

/**
 * Representación en caliente de un esquema, de una base de datos en el motor
 * de base de datos
 * @author maikol_beto
 * @version 1.0
 */
public class Schema {
    
    protected List<Table> tables;  /* cambiar por una estructura mas eficiente */
    
    protected String name;
    
    protected String tablesFile;
    
    /**
     * Crea un objeto de tipo Schema por primera vez, es decir sin tablas
     * @param name Nombre de la base de datos (Schema)
     */
    public Schema (String name)
    {
        this.name = name;
        tables = new ArrayList<>();
        /* crear archivo de las tablas */
    }
    
    /**
     * Carga un objeto de tipo Schema que ya existe en disco, y sus columnas que 
     * están en el archivo tablesFile
     * @param name Nombre de la base de datos (Schema)
     * @param tablesFile Archivo con referencias a las tablas que perteneces a
     * ésta base de datos (Schema)
     */
    public Schema (String name, String tablesFile)
    {
        this.tablesFile = tablesFile;
        loadTables();
    }
    
    /**
     * Crea una tabla nueva en ésta base de datos (Schema)
     * @param name Nombre de la tabla
     * @param columnNames Nombres de las columnas de la tabla
     * @param columnTypes Tipos de datos de las columnas de la tabla
     * @param columnSizes Tamaño de cada una de las columnas de la tabla
     * @param constraints Constraints iniciales de la tabla
     */
    public void createTable (   String name, 
                                List<String> columnNames, 
                                List<Integer> columnTypes,
                                List<Integer> columnSizes, 
                                List<Constraint> constraints)
    {
        tables.add(new Table (  name, 
                                columnNames, 
                                columnTypes, 
                                columnSizes,
                                constraints));
    }
    
    /**
     * Retorna una tabla que pertenezca a éste schema 
     * @param name Nombre de la tabla que se busca
     * @return Tabla que se busca
     */
    public Table getTable (String name)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Carga desde disco todas las tablas que se encuentren referenciadas en 
     * el archivo tablesFile
     */
    public void loadTables ()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
