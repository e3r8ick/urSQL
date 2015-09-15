package objects.constraints;

/**
 * @author maikol_beto
 */
public class ForeignKey extends Constraint implements utils.Constants {
    
    public String column;
    
    public String referencedTable;
    
    public String referencedColumn;
    
    public ForeignKey ( String column, 
                        String referencedTable, 
                        String referencedColumn)
    {
        this.column = column;
        this.referencedTable = referencedTable;
        this.referencedColumn = referencedColumn;
        
        this.type = FOREIGN_KEY;
    }
    
    @Override
    public String toString ()
    {
        return column + " References Column " + referencedColumn + " in Table " + referencedTable;
    }
    
}
