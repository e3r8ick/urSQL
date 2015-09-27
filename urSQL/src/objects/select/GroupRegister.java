package objects.select;

import exceptions.AggregateFunctionTypeException;
import java.util.List;
import objects.Register;
import objects.datatypes.DataType;
import utils.Constants;
import utils.Convert;

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
    public String applyFunction (int type) throws Exception
    {
        if (type == Constants.COUNT)
        {
            return String.valueOf(registers.size());
        }
        else if (type == Constants.AVERAGE)
        {
            if (columnType.type == Constants.INTEGER)
            {
                int total = 0;
                for (Register register : registers)
                {
                    total += Integer.parseInt(register.atributeValues.get(columnIndex));
                }
                total = total / registers.size();
                return String.valueOf(total);
            }
            else if (columnType.type == Constants.INTEGER)
            {
                java.math.BigDecimal total = new java.math.BigDecimal("0.0");
                for (Register register : registers)
                {
                    java.math.BigDecimal temp = new 
                        java.math.BigDecimal(register.atributeValues.get(columnIndex));
                    total = total.add(temp);
                }
                total = total.divide(new java.math.BigDecimal(registers.size()));
                return total.toString();
            }
            else
            {
                throw new exceptions.AggregateFunctionTypeException();
            }
        }
        else if (type == Constants.MAX)
        {
            String max = "";
            for (Register register : registers)
            {
                String tempValue = register.atributeValues.get(columnIndex);
                if (Convert.compare(max, "<", tempValue, columnType.type))
                    max = tempValue;
            }
            return max;
        }
        else if (type == Constants.MIN)
        {
            String min = "";
            for (Register register : registers)
            {
                String tempValue = register.atributeValues.get(columnIndex);
                if (Convert.compare(min, ">", tempValue, columnType.type))
                    min = tempValue;
            }
            return min;
        }
        else
        {
            return "";
        }
    }
    
}
