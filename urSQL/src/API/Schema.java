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
import java.util.ArrayList;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


public class Schema {
    
    private ArrayList Tables;
    private String tablesFile;
    private String name;
    
    public Schema(String pName){
        Tables = new ArrayList();
        name = pName;
        tablesFile = "direccion del archivo";
    }
    
    public void saveSchema(){
        try {
 
        Element tabla = new Element(name);
        Document doc = new Document(tabla);
        tabla.addContent(new Element("DataFile").setText(tablesFile));
        
 
        XMLOutputter xmlOutput = new XMLOutputter();
 
        // display nice nice
        xmlOutput.setFormat(Format.getPrettyFormat());
        xmlOutput.output(doc, new FileWriter("C:\\Users\\Erick\\Documents\\MasNetBeansProjects\\urSQL\\urSQL\\urSQL\\src\\Base de Datos\\Esquema"+name+".xml"));
 
        System.out.println("Esquema "+name+" Salvado");
      } catch (IOException io) {
        System.out.println(io.getMessage());
      }
    }

    /**
     * @return the Tables
     */

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
