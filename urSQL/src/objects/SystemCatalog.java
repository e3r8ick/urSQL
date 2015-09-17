package objects;

import exceptions.SchemaAlreadyExistsException;
import exceptions.SchemaDoesntExistsException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import utils.Constants;

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

    public SystemCatalog() 
    {
        schemas = new ArrayList<>();   
    }
    
    public Schema getSchema (String name)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void createSchema (String name) throws Exception
    {
        /* IMPORTANTE: Agregar Nuevo Schema al archivo xml */
        Schema newSchema = new Schema(name);
        if (schemas.contains(newSchema))
        {
            throw new exceptions.SchemaAlreadyExistsException();
        }
        else
        {
            schemas.add(newSchema);
        }
    }
    
    public void deleteSchema (String name) throws SchemaDoesntExistsException
    {
        Schema newSchema = new Schema(name);
        if (schemas.contains(newSchema))
        {
            schemas.remove(newSchema);
            
        }
        else
        {
            throw new exceptions.SchemaDoesntExistsException();
        }
    }
    
    /**
     * 
     */
    public void saveSchemas(){
        for(int i = 0; i<getSchemas().size();i++){
            try {
               Element tabla = new Element("SchemasFile");
               Document doc = new Document(tabla);

               tabla.addContent(new Element("SchemaFile").setText((getSchemas().get(i).tablesFile)));

               XMLOutputter xmlOutput = new XMLOutputter();

               xmlOutput.setFormat(Format.getPrettyFormat());
               xmlOutput.output(doc, new FileWriter(Constants.SCHEMAS_FILE));

               System.out.println("Esquema "+getSchemas().get(i).name+" Salvado");
         } catch (IOException io) {
           System.out.println(io.getMessage());
         }
        }
        for(int i = 0; i<getSchemas().size();i++){
            try {
               Element tabla = new Element(getSchemas().get(i).name);
               Document doc = new Document(tabla);

               tabla.addContent(new Element("TableFile").setText((getSchemas().get(i).tablesFile)));

               XMLOutputter xmlOutput = new XMLOutputter();

               xmlOutput.setFormat(Format.getPrettyFormat());
               xmlOutput.output(doc, new FileWriter(Constants.SCHEMAS_FILE));

               System.out.println("Esquema "+getSchemas().get(i).name+" Salvado");
         } catch (IOException io) {
           System.out.println(io.getMessage());
         }
        }
    }

    public void loadSchemas(){
    //Se crea un SAXBuilder para poder parsear el archivo
       SAXBuilder builder = new SAXBuilder();
       File File = new File( Constants.SCHEMAS_FILE );
       try
       {
           //Se crea el documento a traves del archivo
           Document document = (Document) builder.build( File );
           //Se obtiene la raiz 
           Element rootNode = document.getRootElement();
           System.out.println("Archivo de esquemas cargado");
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
                   System.out.println("Esquema: "+schema.getName()+","+schema.getValue());
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

    /**
     * @param schemas the schemas to set
     */
    public void setSchemas(List<Schema> schemas) {
        this.schemas = schemas;
    }
    
    
    
}
