/*
 * Main.java
 */

/**
 * Main file that runs all the methods from FileFunctions.java and HashMapFunctions.java
 * @author qbend
 */
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        //Initialize multiple maps and classes and total words  
        HashMap<String, Integer> map = new HashMap<>();
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        FileFunctions ff = new FileFunctions();
        HashMapFunctions hmf = new HashMapFunctions();
        //Call openFile from FileFunctions to determine the file to run program on
        File inFile = ff.openFile(args);
        //Call readFileAndSetHashMap from FileFunctions to put words and word count in
        //HashMap and create the file to write to
        File outFile = ff.readFileAndSetHashMap(inFile, map);
        // Sort the HashMap by Value
        lhm = hmf.sortByCount(map);
        // Write the Sorted LinkedHashMap to the designated file
        ff.writeFile(outFile, lhm);
        //Print the name of outFile
        System.out.println("File written to " + outFile.getName());
        //Print the total words of inFile
        System.out.println("Total count: " + hmf.getCount(map));
        //Print the top 5 values in terms of word count
        System.out.println("Top 5 words are: ");
        hmf.getTop5(lhm);
        //Print the bottom 5 values in terms of word count
        System.out.println("Bottom 5 words are: ");
        hmf.getBottom5(lhm);
    }
}
    
    