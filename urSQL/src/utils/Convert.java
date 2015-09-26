package utils;

import exceptions.DecimalTooBigException;
import exceptions.DiferentTypesComparationException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Convierte cualquier tipo de dato a un arreglo de bytes y viceversa
 * @author maikol_beto
 * @version 2.0
 */
public class Convert {
    
    public static byte[] integerToBytes (int value)
    {
        byte[] buffer;
        ByteBuffer b = ByteBuffer.allocate(4);
        b.putInt(value);
        buffer = b.array();
        return buffer;
    }
    
    public static byte[] charToBytes (String value, int length)
    {
        byte[] buffer = new byte[length];
        byte[] valueInBytes = value.getBytes();
        for (int pos=0;pos<length;pos++)
        {
            if (pos<valueInBytes.length)
                buffer[pos]=valueInBytes[pos];
            else
                buffer[pos]=(byte)0;
        }
        return buffer;
    }
    
    public static byte[] decimalToBytes (String decimal) throws Exception
    {
        long digits = 0;
        long decimals = 0;
	StringTokenizer tokens = new StringTokenizer(decimal, ".");
        int part = 0;
        while(tokens.hasMoreTokens()) {
            String token = tokens.nextToken();
            if (token.length()>18)
                throw new exceptions.DecimalTooBigException();
            else if (part==0)
                digits = Long.parseLong(tokens.nextToken());
            else if (part==1)
                decimals = Long.parseLong(tokens.nextToken());             
            part++;
        }
        byte[] buffer;
        ByteBuffer b = ByteBuffer.allocate(16);
        ByteBuffer b2 = ByteBuffer.allocate(8);
        b.putLong(digits);
        b.putLong(8,decimals);
        buffer = b.array();
        return buffer;
    }
    
    public static byte[] varcharToBytes (String value)
    {
        byte[] buffer = new byte[25];
        byte[] valueInBytes = value.getBytes();
        for (int pos=0;pos<25;pos++)
        {
            if (pos<valueInBytes.length)
                buffer[pos]=valueInBytes[pos];
            else
                buffer[pos]=(byte)0;
        }
        return buffer;
    }
    
    /**
     * Formato dd/mm/yy hh:mm:ss
     * @param date
     * @return 
     */
    public static byte[] dateTimeToBytes (java.util.Date date)
    {
        byte[] buffer;
        ByteBuffer b = ByteBuffer.allocate(12);
        b.putShort((short)date.getYear());
        b.putShort(2,(short)date.getMonth());
        b.putShort(4,(short)date.getDate());
        b.putShort(6,(short)date.getHours());
        b.putShort(8,(short)date.getMinutes());
        b.putShort(10,(short)date.getSeconds());
        buffer = b.array();
        return buffer;
    }
    
    public static int bytesToInteger (byte[] bytes)
    {
        return ByteBuffer.wrap(bytes).getInt();
    }
    
    public static String bytesToChar (byte[] bytes) throws UnsupportedEncodingException
    {
        return new String(bytes, "UTF-8");
    }
    
    /* IMPORTANTE: REVISAR */
    public static String bytesToDecimal (byte[] bytes)
    {
        byte[] digitsArray = Arrays.copyOfRange(bytes,0, 8);
        byte[] decimalsArray = Arrays.copyOfRange(bytes,8, 16);
        long digits = ByteBuffer.wrap(digitsArray).getLong();
        long decimals = ByteBuffer.wrap(decimalsArray).getLong();
        String answer = Long.toString(digits);
        answer = answer.concat(".");
        answer = answer.concat(Long.toString(decimals));
        return answer;
    }
    
    public static java.util.Date bytesToDateTime (byte[] bytes)
    {
        short year = ByteBuffer.wrap(bytes,0,2).getShort();
        short month = ByteBuffer.wrap(bytes,2,2).getShort();
        short date = ByteBuffer.wrap(bytes,4,2).getShort();
        short hours = ByteBuffer.wrap(bytes,6,2).getShort();
        short minutes = ByteBuffer.wrap(bytes,8,2).getShort();
        short seconds = ByteBuffer.wrap(bytes,10,2).getShort();
        return new java.util.Date(year, month, date, hours, minutes, seconds);
    }
    
    public static String dateToString (java.util.Date date)
    {
        String datetime =   String.valueOf(date.getDate()) + "/" +
                            String.valueOf(date.getMonth()) + "/" + 
                            String.valueOf(date.getYear()) + " " + 
                            String.valueOf(date.getHours()) + ":" + 
                            String.valueOf(date.getMinutes()) + ":" +
                            String.valueOf(date.getSeconds());
        return datetime;
    }
    
    public static java.util.Date stringToDate (String date)
    {
        int day=0,month=0,year=0,hours=0,minutes=0,seconds=0;
        StringTokenizer tokens = new StringTokenizer(date, " ");
        int part = 0;
        while(tokens.hasMoreTokens()) {
            if (part == 0)
            {
                StringTokenizer tokens1 = new StringTokenizer(tokens.nextToken(), "/");
                day = Integer.parseInt(tokens1.nextToken());
                month = Integer.parseInt(tokens1.nextToken());
                year = Integer.parseInt(tokens1.nextToken());
            }
            else if (part == 1)
            {
                StringTokenizer tokens1 = new StringTokenizer(tokens.nextToken(), ":");
                hours = Integer.parseInt(tokens1.nextToken());
                minutes = Integer.parseInt(tokens1.nextToken());
                seconds = Integer.parseInt(tokens1.nextToken());
            }
            part++;
        }
        return new java.util.Date(year, month, day, hours, minutes, seconds);
    }
    
    public static boolean compare (   String value1, 
                                String comparator, 
                                String value2, 
                                int type) throws Exception
    {
        try 
        {
            if (type == Constants.INTEGER)
            {
                int integer1 = Integer.parseInt(value1);
                int integer2 = Integer.parseInt(value2);
                if (comparator.equals("="))
                    return integer1 == integer2;
                else if (comparator.equals(">"))
                    return integer1 > integer2;
                else if (comparator.equals("<"))
                    return integer1 < integer2;
            }
            else if (type == Constants.DECIMAL)
            {
                java.math.BigDecimal decimal1 = new java.math.BigDecimal(value1);
                java.math.BigDecimal decimal2 = new java.math.BigDecimal(value1);
                if (comparator.equals("="))
                    return decimal1.equals(decimal2);
                else if (comparator.equals(">"))
                    return decimal1.compareTo(decimal2) > 0;
                else if (comparator.equals("<"))
                    return decimal1.compareTo(decimal2) < 0;
            }
            else if (type == Constants.DATETIME)
            {
                java.util.Date datetime1 = stringToDate(value1);
                java.util.Date datetime2 = stringToDate(value2);
                if (comparator.equals("="))
                    return datetime1.equals(datetime2);
                else if (comparator.equals(">"))
                    return datetime1.compareTo(datetime2) > 0;
                else if (comparator.equals("<"))
                    return datetime1.compareTo(datetime2) < 0;
            }
            else 
            {
                if (comparator.equals("="))
                    return value1.equals(value2);
                else if (comparator.equals(">"))
                    return value1.compareTo(value2) > 0;
                else if (comparator.equals("<"))
                    return value1.compareTo(value2) < 0;
            }
        }
        catch (Exception e)
        {
            throw new exceptions.DiferentTypesComparationException();
        }
        System.out.println("hubo un error en la comparación");
        return false;
    }
    
    public static boolean like (String value, String like)
    {
        return value.contains(like);
    }
    
    /**
     * Imprime un arreglo de bytes en hexadecimal (cuestiones de debug)
     * @param buffer arreglo para imprimir
     */
    public static void printByteArray (byte[] buffer)
    {
        StringBuilder sb = new StringBuilder();
        for (byte by : buffer) {
            sb.append(String.format("%02X ", by));
        }
        System.out.println(sb.toString());
    }
    
}
