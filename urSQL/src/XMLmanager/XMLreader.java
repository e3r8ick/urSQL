/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package XMLmanager;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.jdom2.Document;         // |
import org.jdom2.Element;          // |\ Librerías
import org.jdom2.JDOMException;    // |/ JDOM
import org.jdom2.input.SAXBuilder; // |

/**
 *
 * @author Erick
 */
public class XMLreader {
    
    public XMLreader(String path){
        //Se crea un SAXBuilder para poder parsear el archivo
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File( path );
        try
        {
            //Se crea el documento a traves del archivo
            Document document = (Document) builder.build( xmlFile );
            //Se obtiene la raiz 
            Element rootNode = document.getRootElement();
            System.out.println(rootNode.getAttribute("nombre").getValue()+":");
            //System.out.println(rootNode.getValue());
            //Se obtiene la lista de hijos de la raiz 
            List list = rootNode.getChildren( "registro" );
            //Se recorre la lista de hijos
            for ( int i = 0; i < list.size(); i++ )
            {
                //Se obtiene el elemento 
                Element tabla = (Element) list.get(i);
                //Se obtiene el atributo que esta en el tag 
               // List list2 = tabla.getChildren();
                //for(int k = 0; k < list2.size();k++){
                    System.out.println( "Llave: "+tabla.getAttribute("llave").getValue());
                    //Se obtiene la lista de hijos del tag 
                    List lista_campos = tabla.getChildren();
                    //Se recorre la lista de campos
                    for ( int j = 0; j < lista_campos.size(); j++ )
                    {
                        System.out.print( "\t"+((Element)lista_campos.get(j)).getName()
                        +": ");
                        //Se obtiene el elemento 
                        Element campo = (Element)lista_campos.get( j );//aqui########
                        String valor = campo.getValue();
                        System.out.print(valor);
                        System.out.println("");
                   // }
                }
            }
        }catch ( IOException | JDOMException io ) {
            System.out.println( io.getMessage() );
        }
    }
}
