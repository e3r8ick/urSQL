package objects;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * 
 * @author maikol_beto
 * @version 1.0
 */
public class SystemCatalog {
    
    protected String errorFile;
    
    protected String queryHistoryFile;
    
    private List<Schema> schemas; /* cambiar ésta estructura por otra mas eficiente */
    
    /* IMPORTANTE: falta implementar el plan de la base de datos */
    
    protected final String schemasFile = "metadata/schemasFile.xml";
    
    public SystemCatalog()
    {
        /* cargar los esquemas en el archivo schemasFile*/
       loadSchemas();
    }
    
    public Schema getSchema (String name)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void createSchema (String name)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * 
     */
    public void saveSchemas(){
        for(int i = 0; i<getSchemas().size();i++)
            try {
               Element tabla = new Element(getSchemas().get(i).name);
               Document doc = new Document(tabla);

               for(int j = 0; j < getSchemas().get(j).tables.size();j++){
               tabla.addContent(new Element("DataFile").setText(((Table)getSchemas().get(j).tables.get(i)).getDataFile()));
               }

               XMLOutputter xmlOutput = new XMLOutputter();

               xmlOutput.setFormat(Format.getPrettyFormat());
               xmlOutput.output(doc, new FileWriter("C:\\Users\\Erick\\Documents\\MasNetBeansProjects\\urSQL\\urSQL\\urSQL\\Metadata\\Esquemas\\Esquema"+getSchemas().get(i).name+".xml"));

               System.out.println("Esquema "+getSchemas().get(i).name+" Salvado");
         } catch (IOException io) {
           System.out.println(io.getMessage());
         }
    }

    public void loadSchemas(){
    //Se crea un SAXBuilder para poder parsear el archivo
       SAXBuilder builder = new SAXBuilder();
       File File = new File( schemasFile );
       try
       {
           //Se crea el documento a traves del archivo
           Document document = (Document) builder.build( File );
           //Se obtiene la raiz 
           Element rootNode = document.getRootElement();
           System.out.println("Base de datos cargada");
           //Se obtiene la lista de hijos de la raiz 
           List list = rootNode.getChildren();
           //Se recorre la lista de hijos
           for ( int j = 0; j < list.size(); j++ )
           {
               //Se obtiene el elemento 
               Element schema = (Element) list.get(j);
               //Se obtiene el atributo que esta en el tag 
                  System.out.println( "Esquema: "+schema.getValue());
                  loadSingleSchema(schema.getValue());
           }
       }catch ( IOException | JDOMException io ) {
           System.out.println( io.getMessage() );
       }
    }
    
    public void loadSingleSchema(String schemaXml){
        //Se crea un SAXBuilder para poder parsear el archivo
       SAXBuilder builder = new SAXBuilder();
       File File = new File( schemaXml );
       try
       {
           //Se crea el documento a traves del archivo
           Document document = (Document) builder.build( File );
           //Se obtiene la raiz 
           Element rootNode = document.getRootElement();
           //System.out.println("Base de datos cargada");
           //Se obtiene la lista de hijos de la raiz 
           List list = rootNode.getChildren();
           //Se recorre la lista de hijos
           for ( int j = 0; j < list.size(); j++ )
           {
               //Se obtiene el elemento 
               Element schema = (Element) list.get(j);
               //Se obtiene el atributo que esta en el tag 
                   System.out.println("Esquemall: "+schema.getName()+","+schema.getValue());
                   schemas.add(new Schema(schema.getName(),schema.getValue()));
           }
       }catch ( IOException | JDOMException io ) {
           System.out.println( io.getMessage() );
       }
    }
    
    /**
     * @return the schemas
     */
    public List<Schema> getSchemas() {
        return schemas;
    }
    
    public void addSchema(Schema schema){
        schemas.add(schema);
    }

    /**
     * @param schemas the schemas to set
     */
    public void setSchemas(List<Schema> schemas) {
        this.schemas = schemas;
    }
    
    
    
}
