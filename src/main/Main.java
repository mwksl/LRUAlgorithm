package main;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) {
	String inputString;
	PhysicalMemory f = new PhysicalMemory(4);	
	
	Scanner in = new Scanner(System.in);
	
	
	System.out.println("Please request the page amount: ");
		f.setPages(in.nextInt()); //ask user for number of pages
		in.nextLine(); //Close off previous use of Scanner
		
	System.out.println("Please enter a series of 10 requests<separated by spaces>: ");
		inputString = in.nextLine();
		StringTokenizer st = new StringTokenizer(inputString);
		while(st.hasMoreTokens()) {
			f.addFrameStream(Integer.parseInt(st.nextToken()));
		}
		
		//f.printFrameStream();
		f.LRU(PhysicalMemory.frameStream);
	}
	
}
