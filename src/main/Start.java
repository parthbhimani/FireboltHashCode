package main;

import java.io.File;
import java.util.Scanner;

import model.Library;

public class Start {

	static int numberOfBooks;
	static int numberOfLibraries;
	static int daysOfScanning;
	static Library[] libraries;
	public static int[] valueOfBooks;


	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("resources/a_example.txt"));
			numberOfBooks = sc.nextInt();
			numberOfLibraries = sc.nextInt();
			daysOfScanning = sc.nextInt();
			
			valueOfBooks = new int[numberOfBooks];
			for(int i =0;i<numberOfBooks;i++)
				valueOfBooks[i] = sc.nextInt();
			
			
			for(int i = 0 ;i< numberOfLibraries ; i++){
				libraries[i] = new Library(i,sc.nextLine());
				libraries[i].loadBooks(sc.nextLine());
			}
				
			sc.close();
			
			
			calculate(daysOfScanning);

			} catch (Exception e){
				System.out.println(e);
			}

}

	private static void calculate(int daysOfScanning) {
		Library MaxLib = libraries[0];
		
		for(Library l : libraries)
			if(null != l && l.getValueForDays(daysOfScanning)>MaxLib.getValueForDays(daysOfScanning))
				MaxLib = l;
		
		MaxLib.selectLibrary();
		libraries[MaxLib.id] = null;
		daysOfScanning =- MaxLib.daysToSignUp;
		if(daysOfScanning > 0)
			calculate(daysOfScanning);
	}
	
}
