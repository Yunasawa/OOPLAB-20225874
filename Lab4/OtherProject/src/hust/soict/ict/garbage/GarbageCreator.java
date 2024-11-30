package hust.soict.ict.garbage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GarbageCreator 
{
    public static void main(String[] args) 
    {
    	String fileName = "Result/garbage.txt";
        int length = 100000;
        try 
        {
            generateGarbageTextToFile(fileName, length);
            System.out.println("Garbage text has been written to " + fileName);
        } 
        catch (IOException e) 
        {
            System.err.println("Error writing garbage text to file: " + e.getMessage());
        }
    }

    public static void generateGarbageTextToFile(String fileName, int length) throws IOException 
    {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+-=,./<>?;:[]{}|";
        
        FileWriter writer = new FileWriter(fileName);
        
        Random random = new Random();
        
        for (int i = 0; i < length; i++) 
        {
            char randomChar = characters.charAt(random.nextInt(characters.length()));
            writer.write(randomChar);
        }
        
        writer.close();
    }
}
