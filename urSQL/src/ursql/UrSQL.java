/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ursql;

import XMLmanager.*;
import JSONmanager.*;


/**
 *
 * @author Erick
 */
public class UrSQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        XMLreader xmlreader = new XMLreader("C:\\Users\\Erick\\Documents\\MasNetBeansProjects\\urSQL\\urSQL\\urSQL\\src\\XMLmanager\\archivoXML.xml");
        XMLwriter xmlwriter = new XMLwriter();
        JSONreader jsonreader = new JSONreader("archivojson.json");
        JSONwriter jsonwriter = new JSONwriter();        
    }
    
}
