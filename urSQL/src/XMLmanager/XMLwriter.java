 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XMLmanager;

import java.io.FileWriter;
import java.io.IOException;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author Erick
 */
public class XMLwriter {
    
     public XMLwriter(String data) {
         String[] info = data.split("@");
 
      try {
 
        Element tabla = new Element(info[0]);
        Document doc = new Document(tabla);
        String[] registros = info[1].split("#");
        Element registro = new Element("Registro");
 
        for(int i=0;i<info.length;i++){
            registro.addContent(new Element("firstname").setText("yong"));
        }
        
        doc.getRootElement().addContent(registro);
 
        // new XMLOutputter().output(doc, System.out);
        XMLOutputter xmlOutput = new XMLOutputter();
 
        // display nice nice
        xmlOutput.setFormat(Format.getPrettyFormat());
        xmlOutput.output(doc, new FileWriter("C:\\Users\\Erick\\Documents\\MasNetBeansProjects\\urSQL\\urSQL\\urSQL\\src\\XMLmanager\\outputXML.xml"));
 
        System.out.println("Escritura completada");
      } catch (IOException io) {
        System.out.println(io.getMessage());
      }
    }
}
