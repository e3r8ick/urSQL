package objects.select;

/**
 * @author maikol_beto
 */
public class JoinObject {
    
    public String tableForJoin;
    
    public String columnFirstTable;
    
    public String columnSecondTable;

    public JoinObject(String tableForJoin, String columnFirstTable, String columnSecondTable) {
        this.tableForJoin = tableForJoin;
        this.columnFirstTable = columnFirstTable;
        this.columnSecondTable = columnSecondTable;
    }
    
    
    
}
