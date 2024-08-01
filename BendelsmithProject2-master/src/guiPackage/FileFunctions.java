/**
 * FileFunctions.Java
 */
/**
 * This file contains methods carried out in Main.java to specifically with reading files
 * adding words and their counts to Hashmaps and Maps of all kinds to a file
 * @author qbend
 */
import java.io.*;
import java.util.*;
class FileFunctions {
    public static File inFile;
    public static File outFile;
    /** This function takes a string name and opens a file with same name and outputs it as
     * type File, necessary function to convert string to File for a functioning GUI implementation
     * @param args user input string of a file name from command line, if argument is not
     * 1 string, will return an error 
     * @return returns a File object to be used in supplementary functions
     */
    public File openFile(String[] args){
        //Return an error if the argument is not a singular string with the file name
        if (args.length != 1) {
            System.out.println("Error: Enter as follows: java Main filename");
            System.exit(1);
        }
            //set inFile to the inputted string
            inFile = new File(args[0]);
            return inFile;
    }
    
    /**
     * Takes a file and converts it to a HashMap of the words and their counts
     * @param in File that is intended to be read
     * @param map Empty HashMap to be filled with words and count
     * @return Returns the output File where the HashMap will be written
     * @throws FileNotFoundException If file doesn't exist, throw exception
     * @throws IOException If there is an IO exception, throw error
     */
    public File readFileAndSetHashMap(File in, HashMap<String, Integer> map) throws FileNotFoundException, IOException{
        //Create BufferedReader object
        BufferedReader brIn = new BufferedReader(new FileReader(in));
        //Read file line by line
        String line = brIn.readLine();
        //when the end of the file is reached, line will == null
        while(line != null){
            //If the line is not empty
            if (!line.trim().equals("")){
                // make a list of strings splitting at spaces.
                String [] lineWords = line.split(" ");
                //Go through the list
                for(String word: lineWords) {
                    // if nothing there, move on
                    if (word == null || word.trim().equals("")){
                        continue;
                    }
                    // convert word to lower case
                    String read = word.toLowerCase();
                    // get rid of all special symbols, if there are no spaces, however, it will
                    // read it as though it one word. Hyphens, websites, typos cannot be accounted for.
                    read = read.replaceAll("[^a-zA-Z]", "");
                    // If the HashMap already contains word, increment the value.
                    if(map.containsKey(read)){
                        map.put(read, map.get(read)+1);
                    }
                    // If not, add to HashMap and make value 1
                    else{
                        map.put(read, 1);
                    }
                }
            }
            // next line
            line = brIn.readLine();
        }
        //Close BufferedReader
        brIn.close();
        //Create the new outfile with count.txt added to the end
        outFile = new File(in.toString() + "count.txt");
        return outFile;
    }
    
    /**
     * Takes a filename and HashMap and writes the HashMap to the file
     * good for unordered writing to the file
     * @param out File that will be written to.
     * @param map HashMap that will write to the out File above
     * @throws IOException If there is an IOException, throw an error
     */
    public void writeFile(File out, HashMap<String, Integer> map) throws IOException{
        //Create a BufferedWriter object
        BufferedWriter bfOut = new BufferedWriter(new FileWriter(out));
        //Loop through HashMap to add to file, use generic Map as that is what entrySet returns
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            // Write to file as "word : word count"
            bfOut.write(entry.getKey() + ":" + entry.getValue());
            // create a new line
            bfOut.newLine();
        }
        //Close BufferedWriter
        bfOut.close();
    }

    /**
     * Takes a filename and TreeMap and writes the HashMap to the file, same as above but for TreeMap
     * good for ordering alphabetically
     * @param out File that will be written to.
     * @param map TreeMap that will write to the out File above
     * @throws IOException If there is an IOException, throw an error
     */
    public void writeFile(File out, TreeMap<String, Integer> map) throws IOException{
        //Create a BufferedWriter object
        BufferedWriter bfOut = new BufferedWriter(new FileWriter(out));
        //Loop through TreeMap to add to file, use generic Map as that is what entrySet returns
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            // Write to file as "word : word count"
            bfOut.write(entry.getKey() + ":" + entry.getValue());
            // create a new line
            bfOut.newLine();
        }
        //Close BufferedWriter
        bfOut.close();
    }

    /**
     * Takes a filename and LinkedHashMap and writes the LinkedHashMap to the file
     * same as above but for LinkedHashMap, good for ordering by count.
     * @param out File that will be written to.
     * @param map LinkedHashMap that will write to the out File above
     * @throws IOException If there is an IOException, throw an error
     */
    public void writeFile(File out, LinkedHashMap<String, Integer> map) throws IOException{
        //Create a BufferedWriter object
        BufferedWriter bfOut = new BufferedWriter(new FileWriter(out));
        //Loop through LinkedHashMap to add to file, use generic Map as that is what entrySet returns
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            // Write to file as "word : word count"
            bfOut.write(entry.getKey() + ":" + entry.getValue());
            // create a new line
            bfOut.newLine();
        }
        //Close BufferedWriter
        bfOut.close();
    }

}
