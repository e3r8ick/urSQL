package interpreter.objects;

/**
 * @author maikol_beto
 */
public class WhereStatment {
    
    public String column;
    public String operator;
    public String value;
    
    public WhereStatment (String column, String operator, String value)
    {
        this.column = column;
        this.operator = operator;
        this.value = value;
    }
    
    @Override
    public String toString()
    {
        return column + operator + value;
    }
    
}
