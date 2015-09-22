package objects;

import exceptions.ConstraintColumnDoesntExistsException;
import exceptions.PrimaryKeyException;
import interpreter.objects.ColumnDefinition;
import objects.datatypes.*;
import objects.constraints.*;

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

/**
 * Representación en caliente de una tabla de la base de datos 
 * @see StoredDataManager
 * @author maikol_beto
 */
public class Table implements utils.Constants, Comparable<Table> {
    
    protected List<String> columnNames;
    
    protected List<DataType> columnTypes;
    
    protected List<Integer> columnSizes;
    
    protected String name;
    
    private String dataFile;
    
    protected String metadataFile;
    
    protected String indexesFile;
    
    //protected List<Register> registerTree;  
    
    protected bplustree.BTree<Register, String> registerTree;
    
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
                    String primaryKey, 
                    List<ColumnDefinition> columns) throws Exception
    {        
        columnNames = new ArrayList<>();
        columnTypes = new ArrayList<>();
        columnSizes = new ArrayList<>();
        constraints = new ArrayList<>();        
        
        this.name = name;
        
        for (ColumnDefinition column : columns)
        {
            columnNames.add(column.name);
            columnTypes.add(column.type);
            if (column.type.type == CHAR)
            {
                columnSizes.add( ((URSQL_Char) column.type).variableSize); 
            }
            else
            {
                columnSizes.add(column.type.size); 
            }
            if (!column.nullability)
            {
                constraints.add(new NotNull(column.name));
            }
        }
        if (!columnNames.contains(primaryKey))
        {
            throw new exceptions.PrimaryKeyException();
        }
        constraints.add(new PrimaryKey(primaryKey));
        
    }
    
    /**
     * Constructor para comparaciones rápidas
     * @param name Nombre de la tabla que se desea comparar
     */
    public Table (String name)
    {
        this.name = name;
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
    }
    
    /**
     * Guarda el objeto registerTree el cual contiene los registros de la tabla
     * en disco (en un archivo xml)
     */
    public void saveTree()
    {
         
    }
    
    /**
     * Carga el arbol de los registros en el objeto registerTree desde un 
     * archivo xml
     * @param xmlFile Archivo donde se almacena el arbol en disco 
     */
    public void loadTree(String xmlFile)
    {
        
    }
    
    /**
     * Guarda la tabla en disco
     */
    public void saveTable(){
       
    }
    
    public void loadTable(String xmlFile){
       
    }
            
    public void createConstraint (Constraint constraint, Table referencedTable) throws Exception
    {
        ForeignKey temporalConstraint = (ForeignKey) constraint;
        /* Revisa que la columna sobre la cual queremos aplicar el constrint exista */
        if (!columnNames.contains(temporalConstraint.column))
        {
            throw new exceptions.ConstraintColumnDoesntExistsException();
        }
        /* Revisa que la columna a la cual queremos referenciar exista en la tabla a la que queremos referenciar */
        if (!referencedTable.columnNames.contains(temporalConstraint.referencedColumn))
        {
            throw new exceptions.ReferencedColumnDoesntExistsException();
        }
        
        /* indice de la columna que buscamos en esta tabla */
        int indexhere = columnNames.indexOf(temporalConstraint.column);
        
        /* indice de la columna que queremos referenciar en la otra tabla */
        int indexthere = referencedTable.columnNames.indexOf(temporalConstraint.referencedColumn);
        
        /* Revisamos los tipos de las tablas para saber que calzan */
        if (columnTypes.get(indexhere).type != referencedTable.columnTypes.get(indexthere).type)
        {
            throw new exceptions.DifferentTypesConstraintException();
        }
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
    
    @Override
    public int compareTo(Table o) {
        return this.name.compareTo(o.name);
    }
    
    
    @Override
    public boolean equals (Object o)
    {
        return this.name.equals( ((Table)o).name );
    }
    
}
