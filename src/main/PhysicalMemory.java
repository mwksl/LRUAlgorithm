package main;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;


public class PhysicalMemory {

	int frames = 4;
	int pages = 0;
	int faultCount = 0;
	Object[] frameArray = {" ", " ", " ", " "};
	static ArrayList<Integer> frameStream = new ArrayList<Integer>();
	
	PhysicalMemory(int frames) {
		this.frames = frames;
	}
	
	private void setFrames(int frames) {
		this.frames = frames;
	}
	
	void setPages(int pages) throws PagingSizeException {
		if (pages <= frames) {
			throw new PagingSizeException("The page size must be greater than frame size!");
		}
		else if (pages > frames) {
			this.pages = pages;
		}
	}//end method setPages()
	
	public void addFrameStream(int value) {
		frameStream.add(value);
	}//end method addFrameStream()
	
	public void printFrameStream() {
		for(Integer i: frameStream) {
			System.out.println(i);
		}
	}
	
	public void printFrame(Object[] a, boolean fault) {
		System.out.println("+---+---+---+---+");
		System.out.print("| " + a[0] + " | " + a[1] + " | " + a[2] + " | " + a[3] + " |");
		if (fault == true) {
			faultCount++;
			System.out.print(" *  \n");
		}
		else { System.out.print("\n"); }
		System.out.println("+---+---+---+---+");
	}
	
	
	public void LRU(ArrayList a){
		//frameArray[0] = a.get(0);
		//printFrame(frameArray, true);
		Object removed = 0;
		ArrayList lru = new ArrayList(3);
		//lru.add(a.get(0));
		int size = 0;
		
		for (int i = 0; i < a.size(); i++) {
			
			if (lru.contains(a.get(i))) {
				lru.remove(lru.indexOf(a.get(i)));
				lru.add(a.get(i));
				printFrame(frameArray, false);
			}
			
			else {
			
				if (size == 4) {
					removed = lru.remove(0);
					int index = -1;
					for(int j = 0; j < 4; j++) {
						if (frameArray[j] == removed) {
							index = j;
						}
					}//end for loop
					lru.add(a.get(i));
					frameArray[index] = a.get(i);
					printFrame(frameArray, true);
				} //end if lru is full
				
				else {
					lru.add(a.get(i));
					frameArray[size] = a.get(i);
					printFrame(frameArray, true);
					size++;
				}
					
			}
				
		}
			
		System.out.println("Faults: " + faultCount);
		
		}//end lru
			
		
		
}
