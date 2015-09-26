
package objects.select;

/**
 * @author maikol_beto
 */
public class Column extends SelectColumn {
    
    public String column;

    public Column(String column, int type) {
        this.column = column;
        this.type = type;
    }
    
    
    
}
