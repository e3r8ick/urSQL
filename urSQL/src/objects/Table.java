package objects;

import bplustree.*;
import exceptions.*;
import interpreter.objects.ColumnDefinition;
import objects.datatypes.*;
import objects.constraints.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import objects.select.*;
import org.jdom2.*;
import ursql.ResultSetNode;
import utils.Constants;

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
    
    protected String dataFile;
    
    protected String metadataFile;
    
    protected String indexesFile;
    
    protected bplustree.BTree<String, Register> registerTree;
    
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
        
        registerTree = new BTree<>();
        
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

    /**
     * @return the registerTree
     */
    public bplustree.BTree<String, Register> getRegisterTree() {
        return registerTree;
    }

    /**
     * @param registerTree the registerTree to set
     */
    public void setRegisterTree(bplustree.BTree<String, Register> registerTree) {
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
    
    public void insertRegister (List<String> columns, List<String> values) throws Exception
    {
        List<String> orderedValues = new ArrayList<>();
        String primaryKey = "";
        for (Constraint constraint : constraints)
        {
            if (constraint.type==Constants.PRIMARY_KEY)
                primaryKey = ((PrimaryKey)constraint).primaryKey;
        }
        for (String column : columnNames)
        {
            for (int index=0; index<columns.size(); index++)
            {
                if (columns.get(index).equals(primaryKey))
                    primaryKey = values.get(index);
                if ( columns.get(index).equals(column) )
                    orderedValues.add(values.get(index));
            }
        }
        
        if (registerTree.search(primaryKey)!=null)
        {
            throw new exceptions.PrimaryKeyAlreadyExists();
        } 
        else 
        {
            Register registro = new Register(orderedValues, this, primaryKey);
            registerTree.insert(registro.primaryKey, registro);
        }

    }
    
    /**
     * SELECT solamente con los nombres de las columnas que se desean mostrar y 
     * el nombre de la tabla ej: SELECT * FROM tableName
     * @param selectionList columnas que deseamos mostrar en la respuesta del 
     * SELECT
     */
    public void select (List<SelectColumn> selectionList)
    {
        if (selectionList.isEmpty())
        {
            ursql.ResultSet rs = new ursql.ResultSet(columnNames);
            List<Register> whereResult = selectAll();
            for (Register registro : whereResult)
            {
                ursql.ResultSetNode rsn = new ResultSetNode(registro.atributeValues);
                rs.addValue(rsn);
            }
            rs.printResult();
        }
        else
        {
            List<String> selectColumnNames = new ArrayList<>();
            for (SelectColumn selectColumn : selectionList) // Construimos el título del ResultSet
            {
                if (selectColumn.type == Constants.COLUMN)
                    selectColumnNames.add(((Column) selectColumn).column);
                else if (selectColumn.type == Constants.AGGREGATEFUNCTION)
                    selectColumnNames.add(((AggregateFunction) selectColumn).column);
            }
            ursql.ResultSet rs = new ursql.ResultSet(selectColumnNames);
            List<Register> whereResult = selectAll();
            List<ResultSetNode> resultSetValues = registerListToResultSetNodeList(whereResult,selectionList);
            for (ResultSetNode node : resultSetValues)
            {
                rs.addValue(node);
            }
            rs.printResult();
        }
    }
    
    private List<ResultSetNode> registerListToResultSetNodeList (   List<Register> registerList,
                                                                    List<SelectColumn> selectionList)
    {
        List<ResultSetNode> result = new ArrayList<>();
        for (Register registro : registerList)
        {
            List<String> temporalValue = new ArrayList<>();
            for (SelectColumn selectColumn : selectionList)
            {
                if (selectColumn.type == Constants.COLUMN)
                {
                    for (int i=0;i<columnNames.size();i++)
                    {
                        if ( ((Column) selectColumn).column.equals(columnNames.get(i)))
                            temporalValue.add(registro.atributeValues.get(i));
                    }
                }
                else if (selectColumn.type == Constants.AGGREGATEFUNCTION)
                {
                    /* NOT IMPLEMENTED YET */
                }
            }
            result.add(new ResultSetNode(temporalValue));
        }
        return result;
    }
    
    public void select (List<SelectColumn> selectionList,
                        String column, String operator, String value // WHERE statment
                        ) throws Exception
    {
        if (selectionList.isEmpty())
        {
            ursql.ResultSet rs = new ursql.ResultSet(columnNames);
            List<Register> whereResult = whereStatment(column, operator, value);
            for (Register registro : whereResult)
            {
                ursql.ResultSetNode rsn = new ResultSetNode(registro.atributeValues);
                rs.addValue(rsn);
            }
            rs.printResult();
        }
        else
        {
            List<String> selectColumnNames = new ArrayList<>();
            for (SelectColumn selectColumn : selectionList) // Construimos el título del ResultSet
            {
                if (selectColumn.type == Constants.COLUMN)
                    selectColumnNames.add(((Column) selectColumn).column);
                else if (selectColumn.type == Constants.AGGREGATEFUNCTION)
                    selectColumnNames.add(((AggregateFunction) selectColumn).column);
            }
            ursql.ResultSet rs = new ursql.ResultSet(selectColumnNames);
            List<Register> whereResult = whereStatment(column, operator, value);
            List<ResultSetNode> resultSetValues = registerListToResultSetNodeList(whereResult,selectionList);
            for (ResultSetNode node : resultSetValues)
            {
                rs.addValue(node);
            }
            rs.printResult();
        }
    }
    
    private List<Register> selectAll ()
    {
        List<Register> respuesta = new ArrayList<>();
        bplustree.BTreeLeafNode<String, Register> firstLeaf = registerTree.getFirstLeaf();
        while (firstLeaf != null)
        {
            for (Object registro : firstLeaf.values)
            {
                if (registro != null)
                {
                    Register registroTemporal = (Register) registro;
                    respuesta.add(registroTemporal);
                }
            }
            firstLeaf = (BTreeLeafNode<String, Register>) firstLeaf.getRightSibling();
        }
        return respuesta;
    }
    
    private List<Register> whereStatment (
        String column, String operator, String value) throws Exception
    {
        List<Register> respuesta = 
                new ArrayList<>();
        
        int numColumn = 0;
        for (int index = 0;index<columnNames.size();index++)
        {
            if (columnNames.get(index).equals(column))
            {
                numColumn = index;
                break;
            }
        }
        
        bplustree.BTreeLeafNode<String, Register> firstLeaf = registerTree.getFirstLeaf();
        while (firstLeaf != null)
        {
            for (Object registro : firstLeaf.values)
            {
                if (registro != null)
                {
                    Register registroTemporal = (Register) registro;
                    if (operator.equals("=") || operator.equals(">") || operator.equals("<"))
                    {
                        if (utils.Convert.compare(registroTemporal.atributeValues.get(numColumn), 
                                operator, value, columnTypes.get(numColumn).type))
                        {
                            respuesta.add(registroTemporal);
                        }
                    }
                    else if (operator.equals("like"))
                    {
                        if (utils.Convert.like(registroTemporal.atributeValues.get(numColumn), value))
                        {
                            respuesta.add(registroTemporal);
                        }
                    }
                    else if (operator.equals("not"))
                    {
                        if (!utils.Convert.like(registroTemporal.atributeValues.get(numColumn), value))
                        {
                            respuesta.add(registroTemporal);
                        }
                    }
                    else if (operator.equals("is null") || operator.equals("is not null"))
                    {
                        /* ´por implementar */
                    }
                }
            }
            firstLeaf = (BTreeLeafNode<String, Register>) firstLeaf.getRightSibling();
        }
        return respuesta;
    }
    
    public void deleteRegister (String column, String operator, String value) throws Exception
    {
        List<Register> porBorrar = 
                whereStatment(column, operator, value);
        
        for (Register registro : porBorrar)
        {
            registerTree.delete(registro.primaryKey);
        }
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
