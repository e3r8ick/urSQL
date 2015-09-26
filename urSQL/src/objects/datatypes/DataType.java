package objects.datatypes;

/**
 * @author maikol_beto
 */
public class DataType implements Comparable<DataType> {
    
    public int type;
    public int size;

    @Override
    public int compareTo(DataType o) {
        return Integer.compare(this.type, o.type);
    }
    
    
    
}
