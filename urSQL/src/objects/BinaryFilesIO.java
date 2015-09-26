package objects;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import objects.datatypes.DataType;
import utils.Constants;
import utils.Convert;

/**
 * @author maikol_beto
 */
public class BinaryFilesIO implements utils.Constants {
    
    private static int getRegisterSize (Table table)
    {
        int result = 0;
        for (Integer data : table.columnSizes)
        {
            result = result + data;
        }
        return result;
    }
    
    /**
     * Lee un registro dado un puntero y la metadata de una tabla específica 
     * (usamos la metadata para conocer el tamaño y el tipo de cada columna)
     * @param pointer posición dentro del archivo en la que se encuentra el 
     * registro que queremos leer
     * @param path ubicación en disco del archivo que vamos a leer
     * @param table referencia a una tabla con tipos de datos y tamaños 
     * previamente definidos
     * @return lista de Strings con valores para cada uno de los atributos de 
     * una tabla 
     */
    public static List<String> readRegister(long pointer, 
                                            String path,
                                            Table table) throws IOException
    {
        List<String> answer = new ArrayList<>();
        
        File file = new File(path);
        ByteBuffer buffer = ByteBuffer.allocate(getRegisterSize(table));
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        FileChannel fc = raf.getChannel();
        fc.position(pointer);
        fc.read(buffer);
        byte[] data = buffer.array();
        
        int arrayIndex = 0;
        int tableIndex = 0; /* indice para recorrer las columnas de la base de datos */
        for (DataType type : table.columnTypes)
        {
            if (type.type == Constants.INTEGER)
            {
                byte [] intArray = Arrays.copyOfRange(data, arrayIndex, arrayIndex + Constants.INTEGER_SIZE);
                int temporalData = utils.Convert.bytesToInteger(intArray);
                answer.add(String.valueOf(temporalData));
                arrayIndex += Constants.INTEGER_SIZE;
            }
            else if (type.type == Constants.CHAR)
            {
                byte [] charArray = Arrays.copyOfRange(data, arrayIndex, arrayIndex + 
                        table.columnSizes.get(tableIndex));
                answer.add(utils.Convert.bytesToChar(charArray));
                arrayIndex += table.columnSizes.get(tableIndex);
            }
            else if (type.type == Constants.DECIMAL)
            {
                byte [] decimalArray = Arrays.copyOfRange(data, arrayIndex, arrayIndex + Constants.DECIMAL_SIZE);
                answer.add(utils.Convert.bytesToDecimal(decimalArray));
                arrayIndex += Constants.DECIMAL_SIZE;
            }
            else if (type.type == Constants.VARCHAR)
            {
                byte [] varcharArray = Arrays.copyOfRange(data, arrayIndex, arrayIndex + Constants.VARCHAR_SIZE);
                answer.add(utils.Convert.bytesToChar(varcharArray));
                arrayIndex += Constants.VARCHAR_SIZE;
            }
            else if (type.type == Constants.DATETIME)
            {
                byte [] datetimeArray = Arrays.copyOfRange(data, arrayIndex, arrayIndex + Constants.DATETIME_SIZE);
                String date = utils.Convert.dateToString(utils.Convert.bytesToDateTime(datetimeArray));
                answer.add(date);
                arrayIndex += Constants.VARCHAR_SIZE;
            }
            tableIndex++;
        }
        
        return answer;
    }
    
    /**
     * Escribe un registro en disco
     * @param path Archivo en el cual vamos a escribir el registro
     * @param values Lista de valores que almacena el registro
     * @param table referencia a una tabla con tipos de datos y tamaños 
     * previamente definidos
     * @return posición en el archivo donde se escribió el registro
     */
    public static long writeRegister (  String path,
                                        List<String> values,
                                        Table table) throws Exception
    {
        long pos = -1;
        FileOutputStream os;
        try {
            
            os = new FileOutputStream(new File (path), true);
            
            FileChannel fileChannel = os.getChannel();         
            
            pos = fileChannel.position() - 1;
            
            int index = 0;
            for (String value : values)
            {
                if (table.columnTypes.get(index).type==Constants.INTEGER)
                {
                    int intValue = Integer.parseInt(value);
                    byte[] buffer = utils.Convert.integerToBytes(intValue);
                    os.write(buffer);
                }
                else if (table.columnTypes.get(index).type==Constants.CHAR)
                {
                    byte[] buffer = utils.Convert.charToBytes(value, table.columnSizes.get(index));
                    os.write(buffer);
                }
                else if (table.columnTypes.get(index).type==Constants.DECIMAL)
                {
                    byte[] buffer = utils.Convert.decimalToBytes(value);
                    os.write(buffer);
                }
                else if (table.columnTypes.get(index).type==Constants.VARCHAR)
                {
                    byte[] buffer = utils.Convert.varcharToBytes(value);
                    os.write(buffer);
                }
                else if (table.columnTypes.get(index).type==Constants.DATETIME)
                {
                    byte[] buffer = utils.Convert.dateTimeToBytes(utils.Convert.stringToDate(value));
                    os.write(buffer);
                }                
                index++;
            }       
            os.close();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
        return pos+1;
    }
    
    
}
