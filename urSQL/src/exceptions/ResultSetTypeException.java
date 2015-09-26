package exceptions;

/**
 * @author maikol_beto
 */
public class ResultSetTypeException extends Exception{

    public ResultSetTypeException(String columna, String tipo) {
        super ("Error: No se puede convertir el tipo de dato de la columna " + columna + " al tipo " + tipo);
    }
    
}
