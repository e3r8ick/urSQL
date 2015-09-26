package interpreter.objects;

import objects.datatypes.DataType;

/**
 * Clase que representa cada definición de columna en el comando CREATE TABLE
 * contiene el nombre, el tipo y la nulabilidad de cada columna
 * @author maikol_beto
 * @version 1.0
 */
public class ColumnDefinition {
    
    public String name;
    public DataType type;
    public Boolean nullability; //true if NULL, false if NOT NULL 
    
    /**
     * @param name Nombre de la columna
     * @param type Tipo de dato que almacena la columna
     * @param nullability El valor de la columna puede ser nulo o no; true si 
     * puede ser NULL, falso si es NOT NULL 
     */
    public ColumnDefinition(String name, DataType type, Boolean nullability)
    {
        this.name = name;
        this.type = type;
        this.nullability = nullability;
    }
    
    @Override
    public String toString ()
    {
        return "nombre: " + name + " tipo: " + type + " nulo? " + nullability.toString();
    }
}
