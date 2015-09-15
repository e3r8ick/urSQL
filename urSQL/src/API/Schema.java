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
import java.util.ArrayList;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


public class Schema {
    
    private ArrayList Tables;
    private String tablesFile;
    private String name;
    
    public Schema(String pName, String path){
        Tables = new ArrayList();
        name = pName;
        tablesFile = path;
    }
    
    public Schema(String pName){
        Tables = new ArrayList();
        name = pName;
        tablesFile = "C:\\Users\\Erick\\Documents\\MasNetBeansProjects\\urSQL\\urSQL\\urSQL\\src\\Metadata\\Esquemas\\Esquema"+name+".xml";
    }
    
    /**
     * Agrega una tabla al esquema
     * @param table 
     */
    public void addTable(Table table){
        Tables.add(table);
    }
    
    /**
     * Cargar el esquema del disco
     * @param path
     */
    public void loadSchema(String path){
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
            System.out.println("Esquema: "+name+" cargado");
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
                    System.out.println( "Tabla: "+tabla.getValue());
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
     * Guarda el esquema en disco 
     */
    public void saveSchema(){
        try {
            Element tabla = new Element(name);
            Document doc = new Document(tabla);
            
            for(int i = 0; i < Tables.size();i++){
            tabla.addContent(new Element("DataFile").setText(((Table)Tables.get(i)).getDataFile()));
            }

            XMLOutputter xmlOutput = new XMLOutputter();

            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(doc, new FileWriter("C:\\Users\\Erick\\Documents\\MasNetBeansProjects\\urSQL\\urSQL\\urSQL\\src\\Metadata\\Esquemas\\Esquema"+name+".xml"));

            System.out.println("Esquema "+name+" Salvado");
      } catch (IOException io) {
        System.out.println(io.getMessage());
      }
    }

    /**
     *
     * @return the Tables
     */
    public ArrayList getTables() {
        return Tables;
    }

    /**
     * @param Tables the Tables to set
     */
    public void setTables(ArrayList Tables) {
        this.Tables = Tables;
    }

    /**
     * @return the tablesFile
     */
    public String getTablesFile() {
        return tablesFile;
    }

    /**
     * @param TablesFile the tablesFile to set
     */
    public void setTablesFile(String TablesFile) {
        this.tablesFile = TablesFile;
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
}
