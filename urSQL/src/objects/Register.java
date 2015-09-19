package objects;

import java.util.List;

/**
 * Representación en caliente de un registro de la base de datos
 * @version 1.0
 * @author maikol_beto
 */
public class Register implements Comparable<Register>  {
    
    protected List<String> atributeTypes;
    
    protected List<String> atributeValues;
    
    protected long pointer;
    
    protected String primaryKey;
    
    /**
     * Crea un objeto Register a partir de una lista de valores y los datos de
     * la tabla a la que pertenece dicho registro
     * @param registerValues Valores (en disco) del registro
     * @param tabla Tabla a la cual pertenece el registro
     */
    public Register (List<String> registerValues, Table tabla)
    {
        
    }

    @Override
    public int compareTo(Register o) {
        return primaryKey.compareTo(o.primaryKey);
    }
    
    
}
