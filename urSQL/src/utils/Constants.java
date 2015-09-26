package utils;

/**
 * @author maikol_beto
 */
public interface Constants {
    
    public final int PRIMARY_KEY = 0;
    public final int FOREIGN_KEY = 1;
    public final int NOT_NULL = 2;
    
    public final int INTEGER = 0;
    public final int CHAR = 1;
    public final int DECIMAL = 2;
    public final int VARCHAR = 3;
    public final int DATETIME = 4;
    /* faltan tipos de datos por implementar */
    
    /* tamaño en bytes de cada tipo de dato */
    public final int INTEGER_SIZE = 4;
    public final int CHAR_SIZE = 1;
    public final int DECIMAL_SIZE = 16;
    public final int VARCHAR_SIZE = 25;
    public final int DATETIME_SIZE = 12;
    
    public final int COUNT = 1;
    public final int AVERAGE = 2;
    public final int MIN = 3;
    public final int MAX = 4;
    
    public final int COLUMN = 1;
    public final int AGGREGATEFUNCTION = 2;
    
    public final String DATOS = "Metadata/Datos/";
    
    public final String SCHEMA_PATH = "Metadata/Esquemas/Esquema";
    public final String TABLES_PATH = "Metadata/Tablas/Tabla";
    public final String SCHEMAS_FILE = "Metadata/schemasFile.xml";
    
}
