package exceptions;

/**
 * @author maikol_beto
 */
public class NoPrimaryKeyException extends Exception {

    public NoPrimaryKeyException() {
        super ("Error: No hay valor para la llave primaria en el conjunto de valores que se desean insertar");
    }
    
}
