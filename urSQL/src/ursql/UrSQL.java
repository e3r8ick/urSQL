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
    public static void main(String[] args) throws SchemaAlreadyExistsException{
        
        Table tabla = new Table("Tabla1","C:\\Users\\Erick\\Documents\\MasNetBeansProjects\\urSQL\\urSQL\\urSQL\\Metadata\\Tablas\\TablaTabla1.xml");
        
        List list = new ArrayList();
        list.add("Erick");
        list.add("Maikol");
        list.add("Nestor");
        BTree<Register, String> tree = new BTree<Register, String>();
        tree.insert(new Register(list,tabla), "Erick");
        tree.insert(new Register(list,tabla), "Juan");
        tree.insert(new Register(list,tabla), "Maikol");
        tree.insert(new Register(list,tabla), "Nestor");
        tree.insert(new Register(list,tabla), "Pepe");
        tree.insert(new Register(list,tabla), "Jona");
        
        tabla.setRegisterTree(tree);
        
       //RuntimeDatabaseProcessor run = new RuntimeDatabaseProcessor();
       //tabla.setRegisterTree(tree);
       SystemCatalog system = new SystemCatalog(); 
       Schema esquema = new Schema("Esquema1","C:\\Users\\Erick\\Documents\\MasNetBeansProjects\\urSQL\\urSQL\\urSQL\\Metadata\\Esquemas\\EsquemaEsquema1.xml");
       system.createSchema("EsquemaPrueba");
       system.saveSchemas();
       system.loadSchemas();
       
       esquema.addTable(tabla);
       esquema.saveTables();
       esquema.loadTables();
    }
    
}
