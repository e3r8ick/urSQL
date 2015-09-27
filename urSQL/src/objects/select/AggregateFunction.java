package objects.select;

import java.util.List;
import utils.Constants;

/**
 *
 * @author Maikol
 */
public class AggregateFunction extends SelectColumn {

    public int function;
    
    public String column;
    
    public AggregateFunction (String column, int function, int type) {
        this.type = type;
        this.column = column;
        this.function = function;
    }
    
    public String toString()
    {
        String type = "";
        if (function == Constants.COUNT)
            type = "COUNT";
        else if (function == Constants.AVERAGE)
            type = "AVERAGE";
        else if (function == Constants.MIN)
            type = "MIN";
        else if (function == Constants.MAX)
            type = "MAX";
        return type + "(" + column + ")";
    }
    
}
