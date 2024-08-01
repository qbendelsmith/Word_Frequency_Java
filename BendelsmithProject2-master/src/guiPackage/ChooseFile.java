/*
 * ChooseFile.java
 */

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.awt.event.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * File Chooser and carry out functions from CLI implementation
 * @author Quinn Bendelsmith
 */
public class ChooseFile implements ActionListener {

    //Initialize all of these
    static File chosenFile;
    private final FileFunctions ff = new FileFunctions();
    private final HashMap<String, Integer> map = new HashMap<>();
    private final HashMapFunctions hmf = new HashMapFunctions();
    private LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
    private int counter = 0;
    private static ChooserFrame view;
    private File outFile;
    /**
     * @param args the command line arguments
     */

     /**
      * Constructer Class
      * Creates ChooserFrame and makes it visible
      */
     public ChooseFile(){
        view = new ChooserFrame(this);
        view.setVisible( true);
     }
    
    
    /**
     * Make an action event for ActionListener in ChooserFrame
     */
    @Override
    public void actionPerformed( ActionEvent ae){
        System.out.println("Pushed the button");
        
        // Make File Chooser
        JFileChooser chooser = new JFileChooser();
        //Filter to .txt files only
        chooser.setFileFilter( new FileNameExtensionFilter( "Text Files", "txt", "text"));
        //Make sure it is successfully chosen
        int chooserSuccess = chooser.showOpenDialog(null);
        if( chooserSuccess == JFileChooser.APPROVE_OPTION ) {
            // Make the file the selected file
            chosenFile = chooser.getSelectedFile();
            //Avoid errors by making sure the file is not null
            if (chosenFile != null){
                // Was having errors with selected File, but getAbsoluteFile() worked
                chosenFile = chosenFile.getAbsoluteFile();
                // Need a try/catch for whether the file is null
                try {
                    //Make this the same as Main.java but add it to the JFrame
                    outFile = ff.readFileAndSetHashMap(chosenFile, map);
                    this.view.outputFile.setText(outFile.getName());
                    lhm = hmf.sortByCount(map);
                    ff.writeFile(outFile, lhm);
                    counter = hmf.getCount(map);
                    String countAsString = String.valueOf(counter);
                    String top5String = hmf.getTop5(lhm);
                    String bottom5String = hmf.getBottom5(lhm);
                    this.view.count.setText(countAsString);
                    this.view.top5.setText(top5String);
                    this.view.bottom5.setText(bottom5String);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        else {
            System.out.println("The user must have cancelled");
        }
    }
}
