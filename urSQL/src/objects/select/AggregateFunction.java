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
    
}
