package objects.constraints;

/**
 * @author maikol_beto
 */
public class Constraint implements Comparable<Constraint> {
    
    public int type;

    @Override
    public int compareTo(Constraint o) {
        return Integer.compare(this.type, o.type);
    }
        
}
