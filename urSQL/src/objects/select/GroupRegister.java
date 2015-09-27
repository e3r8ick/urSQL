package objects.select;

import java.util.List;
import objects.Register;
import objects.datatypes.DataType;
import utils.Constants;

/**
 * @author maikol_beto
 */
public class GroupRegister {
    
    public String columnValue;
        
    public int columnIndex;
    
    public DataType columnType;
    
    public List<Register> registers;

    public GroupRegister(   String columnValue, 
                            int columnIndex, 
                            List<Register> registers,
                            DataType columnType) {
        this.columnValue = columnValue;
        this.columnIndex = columnIndex;
        this.registers = registers;
        this.columnType = columnType;
    }
    
    /* IMPORTANTE COMPLETAR */
    public String applyFunction (int type)
    {
        if (type == Constants.COUNT)
        {
            return String.valueOf(registers.size());
        }
        else
        {
            return "";
        }
    }
    
}
