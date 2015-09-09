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

import java.io.FileWriter;
import java.io.IOException;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
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
    
    public void saveTable(){
        try {
 
        Element tabla = new Element(name);
        Document doc = new Document(tabla);
        tabla.addContent(new Element("DataFile").setText(dataFile));
        tabla.addContent(new Element("MetaDataFile").setText(metaDataFile));
        

        XMLOutputter xmlOutput = new XMLOutputter();
 
        // display nice nice
        xmlOutput.setFormat(Format.getPrettyFormat());
        xmlOutput.output(doc, new FileWriter("C:\\Users\\Erick\\Documents\\MasNetBeansProjects\\urSQL\\urSQL\\urSQL\\src\\Base de Datos\\Tabla"+name+".xml"));
 
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
