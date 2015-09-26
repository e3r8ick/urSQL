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
        loadSchemas();
    }
    
    
    public Schema getSchema (String name)
    {
        Schema tmp = schemas.get(0);
        for(int i = 0; i<schemas.size();i++){
            if(schemas.get(i).getName().equals(name)){
                System.out.println(schemas.get(i));
                tmp =schemas.get(i);
                break;
            }
        }
        if(!(tmp.getName().equals(name))){
            System.out.println("Esquema no encontrado");
        }
        return tmp;
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
            File directorio = new File(utils.Constants.DATOS + name);
            directorio.mkdir();
        }
    }
    
    public void deleteSchema (String name) throws SchemaDoesntExistsException
    {
        Schema newSchema = new Schema(name);
        if (schemas.contains(newSchema))
        {
            schemas.remove(newSchema);
            File directorio = new File(utils.Constants.DATOS + name);
            directorio.delete();
        }
        else
        {
            throw new exceptions.SchemaDoesntExistsException();
        }
    }
    
    /**
     * 
     */
    public void saveSchemas() throws IOException{
        Element schemasList = new Element("SchemasFile");
        Document doc = new Document(schemasList);
        for(int i = 0; i<getSchemas().size();i++){
            try {
               schemasList.addContent(new Element((getSchemas().get(i)).getName()).setText((getSchemas().get(i).tablesFile)));
               
               XMLOutputter xmlOutput = new XMLOutputter();

               xmlOutput.setFormat(Format.getPrettyFormat());
               xmlOutput.output(doc, new FileWriter(Constants.SCHEMAS_FILE));

               System.out.println("Esquema "+getSchemas().get(i).getName()+" Salvado");
         } catch (IOException io) {
           System.out.println(io.getMessage());
         }
        }
        XMLOutputter xmlOutput = new XMLOutputter();

        xmlOutput.setFormat(Format.getPrettyFormat());
        xmlOutput.output(doc, new FileWriter(Constants.SCHEMAS_FILE));
        for(int i = 0; i<getSchemas().size();i++){
            try {
               Element tabla = new Element(getSchemas().get(i).getName());
               Document doc2 = new Document(tabla);

               tabla.addContent(new Element("TableFile").setText((getSchemas().get(i).tablesFile)));

               XMLOutputter xmlOutput2 = new XMLOutputter();

               xmlOutput2.setFormat(Format.getPrettyFormat());
               xmlOutput2.output(doc2, new FileWriter(Constants.SCHEMA_PATH+getSchemas().get(i).getName()+".xml"));

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
           System.out.println("No hay esquemas para cargar");
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
           Schema tmp=new Schema(rootNode.getName());
           schemas.add(tmp);
           for ( int j = 0; j < list.size(); j++ )
           {
               //Se obtiene el elemento 
               Element schema = (Element) list.get(j);
               //Se obtiene el atributo que esta en el tag 
                   System.out.println(rootNode.getName()+": "+
                           schema.getName()+","+schema.getValue());
                   tmp.addTable(new Table(schema.getName(),schema.getValue()));
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
