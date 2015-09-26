package objects;

import bplustree.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import objects.constraints.*;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import utils.Constants;

/**
 * Representación en caliente de una tabla de la base de datos 
 * @see StoredDataManager
 * @author maikol_beto
 */
public class Table {
    
    protected List<String> columnNames;
    
    protected List<Integer> columnTypes;
    
    protected List<Integer> columnSizes;
    
    protected String name;
    
    private String dataFile;
    
    protected String metadataFile;
    
    protected String indexesFile;
    
    //protected List<Register> registerTree;  
    
    private bplustree.BTree<Register, String> registerTree;
    
    protected List<Constraint> constraints;
    
    protected List<String> indexes; /* cambiar el tipo de la lista por un objeto Index */
    
    /* IMPORTANTE: falta por implementar la caché */
    
    /**
     * Crea un objeto de tipo Table por primera vez, es decir sin datos
     * @param name Nombre de la tabla en la base de datos
     * @param columnNames Nombres de las columnas de la tabla
     * @param columnTypes Tipos de datos de las columnas de la tabla
     * @param columnSizes Tamaño en bytes de los datos de cada columna
     * @param constraints Constraints de las columnas de la tabla
     */
    public Table (  String name, 
                    List<String> columnNames, 
                    List<Integer> columnTypes,
                    List<Integer> columnSizes, 
                    List<Constraint> constraints)
    {
        for (Constraint constr : constraints)
        {
            System.out.println(constr.toString());
        }
        registerTree = new BTree();
    }
    
    /**
     * Carga un objeto Table desde el archivo metadataFile almacenado en disco
     * @param name Nombre de la tabla en la base de datos
     * @param metadataFile Archivo de metadatos de la tabla
     */
    public Table (  String name, 
                    String metadataFile)
    {
        this.name = name;
        this.metadataFile = metadataFile;
        registerTree = new BTree();
    }
    
    /**
     * Guarda el objeto registerTree el cual contiene los registros de la tabla
     * en disco (en un archivo xml)
     */
    public void saveTree()
    {
        registerTree.toString();
        /* for(int i = 0; i<registerTree;i++){
            try {
            Element tabla = new Element(tables.get(i).name);
            Document doc = new Document(tabla);


            tabla.addContent(new Element("DataFile").setText(tables.get(i).getDataFile()));
            tabla.addContent(new Element("MetaDataFile").setText(tables.get(i).metadataFile));


            XMLOutputter xmlOutput = new XMLOutputter();

            // display nice nice
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(doc, new FileWriter(Constants.TABLES_PATH+name+".xml"));

            System.out.println("Tabla "+name+" salvada");
          } catch (IOException io) {
            System.out.println(io.getMessage());
          }
        }*/
         
    }
    
    /**
     * Carga el arbol de los registros en el objeto registerTree desde un 
     * archivo xml
     * @param xmlFile Archivo donde se almacena el arbol en disco 
     */
    public void loadTree(String xmlFile)
    {
        
    }
    
            
    public void createConstraint (Constraint constraint)
    {
        constraints.add(constraint);
    }
    
    public List<Constraint> getConstraintsByType (int type)
    {
        throw new UnsupportedOperationException("Not supported yet.");
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
     * @return the registerTree
     */
    public bplustree.BTree<Register, String> getRegisterTree() {
        return registerTree;
    }

    /**
     * @param registerTree the registerTree to set
     */
    public void setRegisterTree(bplustree.BTree<Register, String> registerTree) {
        this.registerTree = registerTree;
    }

    /**
     * @return the metadataFile
     */
    public String getMetadataFile() {
        return metadataFile;
    }

    /**
     * @param metadataFile the metadataFile to set
     */
    public void setMetadataFile(String metadataFile) {
        this.metadataFile = metadataFile;
    }
    
    
}
