package objects.constraints;

/**
 * @author maikol_beto
 */
public class PrimaryKey extends Constraint implements utils.Constants {
    
    public String primaryKey;
    
    public PrimaryKey (String primaryKey)
    {
        this.primaryKey = primaryKey;
        this.type = PRIMARY_KEY;
    }
    
    @Override
    public String toString ()
    {
        return "Primary Key: " + primaryKey;
    }
}
