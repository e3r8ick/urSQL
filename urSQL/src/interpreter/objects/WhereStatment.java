package interpreter.objects;

/**
 * Clase para poder transportar el comando WHERE y sus datos desde el intérprete 
 * a la base de datos
 * @author maikol_beto
 * @version 1.0
 */
public class WhereStatment {
    
    public String column;
    public String operator;
    public String value;
    
    /**
     * @param column Columna de referencia para su comparación
     * @param operator Operador para comparar la columna de referencia con value
     * o verificar si su valor es o no es null
     * @param value Valor con el cual vamos a comparar la columna de referencia
     */
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
