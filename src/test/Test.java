package test;

import java.io.File;

public class Test {

	public static void  main(String[] args){
		File folder = new File("/Users/andrewgotama/Dropbox/Apairl/Slideshow/");
		File[] listOfFiles = folder.listFiles();

	    for (int i = 0; i < listOfFiles.length; i++) {
	      if (listOfFiles[i].isFile()) {
	        System.out.println("img/slides/" + listOfFiles[i].getName());
	      } else if (listOfFiles[i].isDirectory()) {
	        System.out.println("Directory " + listOfFiles[i].getName());
	      }
	    }
	}
}
