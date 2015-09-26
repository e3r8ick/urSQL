package objects;

import java.util.List;
import objects.datatypes.DataType;

/**
 * Representación en caliente de un registro de la base de datos
 * @version 1.0
 * @author maikol_beto
 */
public class Register implements Comparable<Register>  {
    
    protected List<DataType> atributeTypes;
    
    protected List<String> atributeValues;
    
    protected long pointer;
    
    protected String primaryKey;
    
    /**
     * Crea un objeto Register a partir de una lista de valores y los datos de
     * la tabla a la que pertenece dicho registro
     * @param registerValues Valores (en disco) del registro
     * @param tabla Tabla a la cual pertenece el registro
     */
    public Register (List<String> registerValues, Table tabla, String primaryKey) throws Exception
    {
        atributeValues = registerValues;
        atributeTypes = tabla.columnTypes;
        this.primaryKey = primaryKey;
        pointer = BinaryFilesIO.writeRegister(tabla.dataFile, registerValues, tabla);
    }

    @Override
    public int compareTo(Register o) {
        return primaryKey.compareTo(o.primaryKey);
    }
    
    @Override
    public boolean equals (Object o)
    {
        return primaryKey.equalsIgnoreCase(((Register)o).primaryKey);
    }
    
    @Override
    public String toString ()
    {
        String answer = "";
        for (String value : atributeValues)
        {
            answer += value + ";";
        }
        return (String) answer.subSequence(0, answer.length()-2);
    }
    
    
}
