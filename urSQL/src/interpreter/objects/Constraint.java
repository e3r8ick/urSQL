
package interpreter.objects;

/**
 * @author maikol_beto
 */
public class Constraint {
    
    public String name;
    public String column;
    
    public String referencedTable; 
    public String referencedColumn; 
    
    public Constraint ( String column, 
                        String referencedTable,
                        String referencedColumn)
    {
        this.column = column;
        this.referencedTable = referencedTable;
        this.referencedColumn = referencedColumn;
    }
    
    @Override
    public String toString ()
    {
        return "constraint: " + name + "(" + column + ")" + 
                " hace referencia a " + referencedTable + "(" + 
                referencedColumn + ")";
    }
    
}
