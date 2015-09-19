package ursql;

import bplustree.*;
import exceptions.SchemaAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;
import objects.Register;
import objects.RuntimeDatabaseProcessor;
import objects.Schema;
import objects.SystemCatalog;
import objects.Table;
        
/**
 * @author Erick
 */
public class UrSQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SchemaAlreadyExistsException, Exception{
        
        Table tabla = new Table("Tabla1","C:\\Users\\Erick\\Documents\\MasNetBeansProjects\\urSQL\\urSQL\\urSQL\\Metadata\\Tablas\\TablaTabla1.xml");
        
        List list = new ArrayList();
        list.add("Erick");
        list.add("Maieytkol");
        list.add("Neeystor");
        List list2 = new ArrayList();
        list.add("Erick2");
        list.add("Maiko2l");
        list.add("Nestor2");
        List list3 = new ArrayList();
        list.add("E47rick");
        list.add("Mai74kol");
        list.add("Nest74or");
        BTree<Register, String> tree = new BTree<>();
        tree.insert(new Register(list,tabla), "Erick");
        //tree.insert(new Register(list2,tabla), "Juan");
       // tree.insert(new Register(list3,tabla), "Maikol");
        tabla.saveTree();
        tabla.setRegisterTree(tree);
        tabla.saveTree();
        
        
       //RuntimeDatabaseProcessor run = new RuntimeDatabaseProcessor();
       //tabla.setRegisterTree(tree);
      /* SystemCatalog system = new SystemCatalog(); 
       Schema esquema = new Schema("Esquema1","C:\\Users\\Erick\\Documents\\MasNetBeansProjects\\urSQL\\urSQL\\urSQL\\Metadata\\Esquemas\\EsquemaEsquema1.xml");
       system.createSchema("EsquemaPrueba");
       system.saveSchemas();
       system.loadSchemas();
       
       esquema.addTable(tabla);
       esquema.saveTables();
       esquema.loadTables();*/
    }
    
}
