package exceptions;

/**
 * @author maikol_beto
 */
public class TableDoesntExistsException extends Exception {

    public TableDoesntExistsException() {
    
        super ("Error: La tabla no existe, por lo que no se puede crear un constraint sobre ella");
    }
    
    
    
}
