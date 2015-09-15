/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package API;

/**
 *
 * @author Erick
 */

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

public class Table {
    
    private String name;
    private String dataFile;
    private String metaDataFile;
    
    public Table(String pName){
        name = pName;
        dataFile = "direccion de el archivo";
        metaDataFile = "direccion del meta data";
    }
    
    /**
     * carga la tabla de disco
     * @param path
     */
    public void loadTable(String path){
         //Se crea un SAXBuilder para poder parsear el archivo
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File( path );
        try
        {
            //Se crea el documento a traves del archivo
            Document document = (Document) builder.build( xmlFile );
            //Se obtiene la raiz 
            Element rootNode = document.getRootElement();
            name = rootNode.getName();
            System.out.println("Tabla: "+name+" cargada");
            //Se obtiene la lista de hijos de la raiz 
            List list = rootNode.getChildren();
            //Se recorre la lista de hijos
            for ( int i = 0; i < list.size(); i++ )
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
    
    
    /**
     * Guarda la tabla en disco 
    */
    public void saveTable(){
        try {
 
        Element tabla = new Element(name);
        Document doc = new Document(tabla);
        
        
        tabla.addContent(new Element("DataFile").setText(dataFile));
        tabla.addContent(new Element("MetaDataFile").setText(metaDataFile));
        

        XMLOutputter xmlOutput = new XMLOutputter();
 
        // display nice nice
        xmlOutput.setFormat(Format.getPrettyFormat());
        xmlOutput.output(doc, new FileWriter("C:\\Users\\Erick\\Documents\\MasNetBeansProjects\\urSQL\\urSQL\\urSQL\\src\\Metadata\\Tablas\\Tabla"+name+".xml"));
 
        System.out.println("Tabla "+name+" salvada");
      } catch (IOException io) {
        System.out.println(io.getMessage());
      }
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the dataFile
     */
    public String getDataFile() {
        return dataFile;
    }

    /**
     * @param dataFile the dataFile to set
     */
    public void setDataFile(String dataFile) {
        this.dataFile = dataFile;
    }

    /**
     * @return the metaDataFile
     */
    public String getMetaDataFile() {
        return metaDataFile;
    }

    /**
     * @param metaDataFile the metaDataFile to set
     */
    public void setMetaDataFile(String metaDataFile) {
        this.metaDataFile = metaDataFile;
    }
}
