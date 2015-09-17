package interpreter.analizador;

/**
 * @author maikol_beto
 */
public class token {
    
    private int col;
    private int row;
    private String cadena;
    private boolean esDigito;
    
    public token(int col, int row, String cadena, boolean esDigito ) {
        this.col = col;
        this.row = row;
        this.cadena = cadena;
        this.esDigito = esDigito;
    }
    
    public token(){
        
    }
    
    public token(int col, int row, String cadena ) {
        this.col = col;
        this.row = row;
        this.cadena = cadena;
        esDigito = false;
    }
    
    public int getCol() {
        return (this.col)+1;
    }
    
    public int getRow() {
        return (this.row)+1;
    }
    
    public String getCadena() {
        return this.cadena;
    }
    
    public void setCadena(String c) {
        cadena = c;
    }
    
    public int getEntero() {
        if (esDigito)
        {
            return Integer.parseInt(cadena);
        }
        else
        {
            return -1;
        }
    }
    
    public boolean esDigito()
    {
        return this.esDigito;
    }
    
}
