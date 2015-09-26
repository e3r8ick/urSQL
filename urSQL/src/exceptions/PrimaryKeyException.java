package exceptions;

/**
 * @author maikol_beto
 */
public class PrimaryKeyException extends Exception{

    public PrimaryKeyException() {
        super ("Error: La llave primaria no coincide con ninguna columna de la tabla");
    }
    
}
