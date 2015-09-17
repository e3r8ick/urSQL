package objects;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import objects.constraints.Constraint;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * Representación en caliente de un esquema, de una base de datos en el motor
 * de base de datos
 * @author maikol_beto
 * @version 1.0
 */
public class Schema {
    
    protected List<Table> tables;  /* cambiar por una estructura mas eficiente */
    
    protected String name;
    
    protected String tablesFile;
    
    /**
     * Crea un objeto de tipo Schema por primera vez, es decir sin tablas
     * @param name Nombre de la base de datos (Schema)
     */
    public Schema (String name)
    {
        this.name = name;
        tables = new ArrayList<>();
        tablesFile = "C:\\Users\\Erick\\Documents\\MasNetBeansProjects\\urSQL\\urSQL\\urSQL\\Metadata\\Esquemas\\Esquema"+name+".xml";
        /* crear archivo de las tablas */
    }
    
    /**
     * Carga un objeto de tipo Schema que ya existe en disco, y sus columnas que 
     * están en el archivo tablesFile
     * @param name Nombre de la base de datos (Schema)
     * @param tablesFile Archivo con referencias a las tablas que perteneces a
     * ésta base de datos (Schema)
     */
    public Schema (String name, String tablesFile)
    {
        this.tablesFile = tablesFile;
        tables = new ArrayList<>();
        loadTables();
        
    }
    
    /**
     * Crea una tabla nueva en ésta base de datos (Schema)
     * @param name Nombre de la tabla
     * @param columnNames Nombres de las columnas de la tabla
     * @param columnTypes Tipos de datos de las columnas de la tabla
     * @param columnSizes Tamaño de cada una de las columnas de la tabla
     * @param constraints Constraints iniciales de la tabla
     */
    public void createTable (   String name, 
                                List<String> columnNames, 
                                List<Integer> columnTypes,
                                List<Integer> columnSizes, 
                                List<Constraint> constraints)
    {
        tables.add(new Table (  name, 
                                columnNames, 
                                columnTypes, 
                                columnSizes,
                                constraints));
    }
    
    /**
     * Retorna una tabla que pertenezca a éste schema 
     * @param name Nombre de la tabla que se busca
     * @return Tabla que se busca
     */
    public Table getTable (String name)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Carga desde disco todas las tablas que se encuentren referenciadas en 
     * el archivo tablesFile
     */
    public void loadTables ()
    {
        for(int i = 0; i<tables.size();i++){
            //Se crea un SAXBuilder para poder parsear el archivo
           SAXBuilder builder = new SAXBuilder();
           File File = new File( tables.get(i).getDataFile() );
           try
           {
               //Se crea el documento a traves del archivo
               Document document = (Document) builder.build( File );
               //Se obtiene la raiz 
               Element rootNode = document.getRootElement();
               name = rootNode.getName();
               System.out.println("Tabla: "+tables.get(i).name+" cargada");
               //Se obtiene la lista de hijos de la raiz 
               List list = rootNode.getChildren();
               //Se recorre la lista de hijos
               for ( int j = 0; j < list.size(); j++ )
               {
                   //Se obtiene el elemento 
                   Element tabla = (Element) list.get(i);
                   //Se obtiene el atributo que esta en el tag 
                  // List list2 = tabla.getChildren();
                   //for(int k = 0; k < list2.size();k++){
                       System.out.println( "TablaInfo: "+tabla.getValue());
                       //Se obtiene la lista de hijos del tag 
                       List lista_campos = tabla.getChildren();
                       //Se recorre la lista de campos
                      /*for ( int j = 0; j < lista_campos.size(); j++ )
                       {
                           System.out.print( "\t"+((Element)lista_campos.get(j)).getName()
                           +": ");
                           //Se obtiene el elemento 
                           Element campo = (Element)lista_campos.get( j );
                           String valor = campo.getValue();
                           System.out.print(valor);
                           System.out.println("");
                   }*/
               }
           }catch ( IOException | JDOMException io ) {
               System.out.println( io.getMessage() );
           }
        }
    }
    
    
     /**
     * Guarda el esquema en disco 
     */
    public void saveTables(){
        for(int i = 0; i<tables.size();i++){
            try {
            Element tabla = new Element(name);
            Document doc = new Document(tabla);


            tabla.addContent(new Element("DataFile").setText(tables.get(i).getDataFile()));
            tabla.addContent(new Element("MetaDataFile").setText(tables.get(i).metadataFile));


            XMLOutputter xmlOutput = new XMLOutputter();

            // display nice nice
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(doc, new FileWriter("C:\\Users\\Erick\\Documents\\MasNetBeansProjects\\urSQL\\urSQL\\urSQL\\Metadata\\Tablas\\Tabla"+name+".xml"));

            System.out.println("Tabla "+name+" salvada");
          } catch (IOException io) {
            System.out.println(io.getMessage());
          }
        }
    }

    /**
     * 
     * @param table 
     */
    public void addTable(Table table){
        tables.add(table);
    }
    
    public void dropSchema(){
        File xmlFile = new File( tablesFile );
        xmlFile.delete();
        System.out.println("Esquema Borrado");
    }
}
