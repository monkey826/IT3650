package samsung.java.inclass;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Stringtokenizer {
	public static void main(String[] args) {
		int seqArr[] = {1,2,3};
		String nameArr[] = {"Nguyen Van A", "Tr:an Thi B",
		"Le Van C"};
		double markArr[] = {7.0, 8.0, 9.5};
		try(PrintWriter writer = new PrintWriter(new
		FileWriter("E:\\data.txt",true),true)
		){
		for(int i = 0; i < 3; i++)
		writer.println(seqArr[i] + "|" + nameArr[i] + ":" 
		+ markArr[i]);
		}catch(FileNotFoundException e){
		System.out.println(e.getMessage());
		}catch(IOException e){
		System.out.println(e.getMessage());
		}
		try(BufferedReader reader = new BufferedReader(
				new FileReader("E:\\data.txt"))
				){
				String line;
				StringTokenizer readData;
				while((line = reader.readLine()) != null){
				readData = new StringTokenizer(line,":");
				while(readData.hasMoreTokens())
				System.out.printf("%s ", readData.nextToken());
				System.out.println();
				}
				}catch(FileNotFoundException e){
				System.out.println(e.getMessage());
				}catch(IOException e){
				System.out.println(e.getMessage());
				}
				}
}
