package objects;

import java.util.List;

/**
 * 
 * @author maikol_beto
 * @version 1.0
 */
public class SystemCatalog {
    
    protected String errorFile;
    
    protected String queryHistoryFile;
    
    protected List<Schema> schemas; /* cambiar ésta estructura por otra mas eficiente */
    
    /* IMPORTANTE: falta implementar el plan de la base de datos */
    
    protected final String schemasFile = "metadata/schemasFile.xml";
    
    public SystemCatalog()
    {
        /* cargar los esquemas en el archivo schemasFile*/
    }
    
    public Schema getSchema (String name)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void createSchema (String name)
    {
        /* IMPORTANTE: Agregar Nuevo Schema al archivo xml */
        Schema newSchema = new Schema(name);
        schemas.add(newSchema);
    }
    
    
    
}
