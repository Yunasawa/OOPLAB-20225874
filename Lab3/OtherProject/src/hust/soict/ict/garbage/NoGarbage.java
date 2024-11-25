package hust.soict.ict.garbage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage 
{
	public static void main(String[] args) 
	{
    	String fileName = "Result/garbage.txt";
    	byte[] inputBytes = {0};
    	long startTime, endTime;
    	
    	try { inputBytes = Files.readAllBytes(Paths.get(fileName)); }
		catch (IOException e) { e.printStackTrace(); }

    	startTime = System.currentTimeMillis();
    	
    	//String outputString = "";
    	//for (byte b : inputBytes) outputString += (char)b;
    	
    	StringBuilder outputStringBuilder = new StringBuilder();
    	for (byte b : inputBytes) outputStringBuilder.append((char)b);
    	
    	endTime = System.currentTimeMillis();
    	System.out.println(endTime - startTime);
	}
}
