package interpreter.objects;

/**
 * Clase para representar las funciones Agregadas, además de moverlas desde el 
 * interprete hacia la base de datos
 * @author maikol_beto
 * @version 1.0
 */
public class AggregateFunction {
    
    public String name;
    public String column;
    
    /**
     * @param name Nombre de la función de agregación, pueden ser: COUNT, 
     * AVERAGE, MIN o MAX
     * @param column Columna sobre la cual aplican las funciones de agregación
     */
    public AggregateFunction (String name, String column)
    {
        this.name = name;
        this.column = column;
    }
    
    @Override
    public String toString()
    {
        return name + "(" + column + ")";
    }
    
}
