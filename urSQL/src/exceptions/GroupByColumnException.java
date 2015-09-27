
package exceptions;

/**
 * @author maikol_beto
 */
public class GroupByColumnException extends Exception {

    public GroupByColumnException() {
        super ("Error: Existen columnas en el SELECT que no se pueden mostrar, debiso al comando GROUP BY");
    }
    
}
