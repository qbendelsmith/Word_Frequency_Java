Project 2 - Prelim Word Frequency README
Quinn Bendelsmith

This project will use two implementations to take in a file and count the frequency
in which words appear. The first implementation will be done through the command
line and will write the data to a separate file sorted either alphabetically or
by the frequency. After the program is run, the command line will output the name
of the file with the frequency, as well as the total count of words and a brief
sample size of the document.

The second implementation will use a GUI to allow the user to choose the files
they want to be used and similarly output the new file, total count and brief 
sample of the document within the GUI window. This will be implemented using the
Java Swing library.

The files that implement these methods will be contained within the src folder, due
to starting on NetBeans and migrating over to VSC it is within a package called guiPackage
in the src folder.

Implementation 1 How-to: If it has yet to be compiled, start with: changing to
the directory containing the files, in our case that is JavaGUI/src/guiPackage. Then
individually compile each file with: javac (file).java. This will create a .class file
Then run the file you want with the necessary arguments such as:
java main *file you want to count*

CLI Implementation files and description:
This Implementation is broken into 3 files. Main.java, FileFunctions.java and
HashMapFunctions.java.

Main.java does not have any methods and it simply takes the input from command line
and uses the methods from other classes to output the pertinent information.

FileFunctions.java and its methods:
openFile opens the file and returns it as a File object, this will be more useful in the
second implementation.
readFileAndSetHashMap reads the File from openFile and it puts the words and their
respective counts in a HashMap and it also outputs a file to write to.
Lastly, there are 3 versions of writeFile, all of them write a map to the outfile
but it all depends on how you plan on writing to the file, either unordered,
ordered by count, or ordered alphabetically.

HashMapFunctions.java and its methods:
sortByCount sorts a HashMap by putting it into a LinkedList and sorting it by the word count,
then it puts it back into a LinkedHashMap, so that it can be written in order.
sortByAlpha sorts a HashMap by putting it into a TreeMap which automatically will order
the map alphabetically.
getTop5 makes use of the LinkedHashMap from sortByCount to grab the first 5 values.
getBottom5 makes use of the LinkedHashMap from sortByCount to grab the last 5 values.
getCount gets the total number of words in the file by summing the counts


Implementation 2 How-to: Same instructions as above however main should pull up
a window. Within this window you will be able to click on browse to choose the
file you want to run the word frequency on. This will complete the task for you.