package objects;

import exceptions.ColumnDoestExistsInJoinException;
import exceptions.TableAlreadyExistsException;
import exceptions.TableDoesntExistsException;
import interpreter.objects.ColumnDefinition;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import objects.constraints.Constraint;
import objects.constraints.ForeignKey;
import objects.select.JoinObject;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import utils.Constants;

/**
 * Representación en caliente de un esquema, de una base de datos en el motor
 * de base de datos
 * @author maikol_beto
 * @version 1.0
 */
public class Schema implements Comparable<Schema> {
    
    protected List<Table> tables;  /* cambiar por una estructura mas eficiente */
    
    protected String name;
    
    protected String tablesFile;
    
    /**
     * Crea un esquema que ya existia
     */
    public Schema()
    {
        tables = new ArrayList<>();
        /* crear archivo de las tablas */
        //loadTables();
    }
    
    /**
     * Crea un esquema por primera vez
     * @param name 
     */
    public Schema(String name){
        this.name = name;
        tables = new ArrayList<>();
        tablesFile = Constants.SCHEMA_PATH+name+".xml";
    }
    
    /**
     * Carga un objeto de tipo Schema que ya existe en disco, y sus columnas que 
     * están en el archivo tablesFile
     * @param name Nombre de la base de datos (Schema)
     * @param tablesFile Archivo con referencias a las tablas que perteneces a
     * ésta base de datos (Schema)
     */
    public Schema (String name, String tablesFile)
    {
        this.name = name;
        this.tablesFile = tablesFile;
        tables = new ArrayList<>();
        loadTables();
        
    }
    
    /**
     * Crea una tabla nueva en ésta base de datos (Schema)
     * @param name Nombre de la tabla
     * @param columnNames Nombres de las columnas de la tabla
     * @param columnTypes Tipos de datos de las columnas de la tabla
     * @param columnSizes Tamaño de cada una de las columnas de la tabla
     * @param constraints Constraints iniciales de la tabla
     */
    public void createTable (   String name, 
                                String primaryKey, 
                                List<ColumnDefinition> columns) throws Exception
    {
        Table newTable = new Table(name, primaryKey, columns);
        newTable.dataFile = utils.Constants.DATOS + this.name + File.separator + name;
        if (tables.contains(newTable))
        {
            throw new exceptions.TableAlreadyExistsException();
        }
        else
        {
            tables.add(newTable);
        }
    }
    
    public void deleteTable (String name) throws Exception
    {
        Table newTable = new Table(name);
        if (!tables.contains(newTable))
        {
            throw new exceptions.TableDoesntExistsException();
        }
        else
        {
            for (Table tabla : tables)
            {
                for (Constraint constraint : tabla.constraints)
                {
                    if (constraint.type == Constants.FOREIGN_KEY)
                    {
                        /* Revisamos que ninguna otra tabla haga refeencia a la que queremos borrar */
                        if ( ((ForeignKey) constraint).referencedTable.equalsIgnoreCase(name) )
                        {
                            throw new exceptions.ForeignKeyExistsException(tabla.name);
                        }
                    }
                }
            }
            tables.remove(newTable);
        }
    }
    
    /**
     * Retorna una tabla que pertenezca a éste schema 
     * @param name Nombre de la tabla que se busca
     * @return Tabla que se busca
     */
    public Table getTable (String name) throws Exception
    {
        Table newTable = new Table(name);
        if (!tables.contains(newTable))
        {
            throw new exceptions.TableDoesntExistsException();
        }
        else
        {
            int index = tables.indexOf(newTable);
            return tables.get(index);
        }
    }
    
    public List<Table> getTables ()
    {
        return tables;
    }
    
    /**
     * Carga desde disco todas las tablas que se encuentren referenciadas en 
     * el archivo tablesFile
     */
    public void loadTables ()
    {
        for(int i = 0; i<tables.size();i++){
            //Se crea un SAXBuilder para poder parsear el archivo
           SAXBuilder builder = new SAXBuilder();
           File File = new File( tables.get(i).getMetadataFile());
           try
           {
               //Se crea el documento a traves del archivo
               Document document = (Document) builder.build( File );
               //Se obtiene la raiz 
               Element rootNode = document.getRootElement();
                setName(rootNode.getName());
               System.out.println("Tabla: "+tables.get(i).name+" cargada");
               //Se obtiene la lista de hijos de la raiz 
               List list = rootNode.getChildren();
               //Se recorre la lista de hijos
               for ( int j = 0; j < list.size(); j++ )
               {
                   //Se obtiene el elemento 
                   Element tabla = (Element) list.get(i);
                   //Se obtiene el atributo que esta en el tag 
                  // List list2 = tabla.getChildren();
                   //for(int k = 0; k < list2.size();k++){
                       System.out.println( "TablaInfo: "+tabla.getValue());
                       //Se obtiene la lista de hijos del tag 
                       List lista_campos = tabla.getChildren();
                       //Se recorre la lista de campos
                      /*for ( int j = 0; j < lista_campos.size(); j++ )
                       {
                           System.out.print( "\t"+((Element)lista_campos.get(j)).getName()
                           +": ");
                           //Se obtiene el elemento 
                           Element campo = (Element)lista_campos.get( j );
                           String valor = campo.getValue();
                           System.out.print(valor);
                           System.out.println("");
                   }*/
               }
           }catch ( IOException | JDOMException io ) {
               System.out.println( io.getMessage() );
           }
        }
    }
    
    
     /**
     * Guarda el esquema en disco 
     */
    public void saveTables(){
        for(int i = 0; i<tables.size();i++){
            try {
            Element tabla = new Element(tables.get(i).name);
            Document doc = new Document(tabla);


            tabla.addContent(new Element("DataFile").setText(tables.get(i).getDataFile()));
            tabla.addContent(new Element("MetaDataFile").setText(tables.get(i).getMetadataFile()));


            XMLOutputter xmlOutput = new XMLOutputter();

            // display nice nice
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(doc, new FileWriter(Constants.TABLES_PATH+getName()+".xml"));

            System.out.println("Tabla "+getName()+" salvada");
          } catch (IOException io) {
            System.out.println(io.getMessage());
          }
        }
    }

    /**
     * 
     * @param table 
     */
    public void addTable(Table table){
        tables.add(table);
    }
    
    public void dropSchema(){
        File xmlFile = new File( tablesFile );
        xmlFile.delete();
        System.out.println("Esquema Borrado");
    }

    public List<Register> applyJoin (String table, List<JoinObject> joinList) throws Exception
    {
        Table tablaOriginal = tables.get(tables.indexOf(new Table (table)));
        List<Register> listaOriginal = tablaOriginal.selectAll();
        List<Register> respuesta = new ArrayList<>();
        for (JoinObject joinObject : joinList)
        {
            Table tablaTemporal = tables.get(tables.indexOf(new Table (joinObject.tableForJoin))); // verificar que la tabla exista
            List<Register> listaTemporal = tablaTemporal.selectAll();
            
            /* Calculamos cual es el´numero de columna de los datos que vamos a comparar */
            int columnIndex1 = -1;
            for (int index = 0; index < tablaOriginal.columnNames.size(); index++)
            {
                if (tablaOriginal.columnNames.get(index).equals(joinObject.columnFirstTable))
                {
                    columnIndex1 = index;
                    break;
                }
            }
            if (columnIndex1 == -1)
                throw new exceptions.ColumnDoestExistsInJoinException();
            
            int columnIndex2 = -1;
            for (int index = 0; index < tablaTemporal.columnNames.size(); index++)
            {
                if (tablaTemporal.columnNames.get(index).equals(joinObject.columnSecondTable))
                {
                    columnIndex2 = index;
                    break;
                }
            }
            if (columnIndex2 == -1)
                throw new exceptions.ColumnDoestExistsInJoinException();
            
            for (Register registro : listaOriginal)
            {
                for (Register registro2 : listaTemporal)
                {
                    String value1 = registro.atributeValues.get(columnIndex1);
                    String value2 = registro2.atributeValues.get(columnIndex2);
                    if (value1.equals(value2))
                    {
                        if (!respuesta.contains(registro))
                        {
                            respuesta.add(registro);
                        }
                    }
                }
            }
            listaOriginal = respuesta;
            respuesta = new ArrayList<>();
        }
        return listaOriginal;
    }
    
    @Override
    public int compareTo(Schema o) {
        return this.getName().compareTo(o.getName());
    }
        
    @Override
    public boolean equals (Object o)
    {
        return this.getName().equals( ((Schema)o).getName());
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
