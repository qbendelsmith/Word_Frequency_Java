/*
 *ChooserFrame.java
 */

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * Uses JFrame to create a file chooser window and displays the counts of the file chosen
 * Used the TempGui example code from Professor Steinmetz as framework for how I would approach it.
 * Also used the ChooseSomething.java and OurWindow.java also provided from the Professor Steinmetz.
 * @author Quinn
 */
public class ChooserFrame extends JFrame { 
    //Create Labels for the counts I want to display 
    private final JLabel outFileLabel = new JLabel( "OutFile is: ");
    private final JLabel totalCount = new JLabel( "Total words: ");
    private final JLabel top5Label = new JLabel("Top 5 Words: ");
    private final JLabel bottom5Label = new JLabel("Bottom 5 Words: ");

    //Create the TextFields for the counts to be displayed.
    protected final JTextField outputFile = new JTextField(10);
    protected final JTextField count = new JTextField( 10);
    protected final JTextField top5 = new JTextField(10);
    protected final JTextField bottom5 = new JTextField(10);
        
        /**
         * Creates a ChooserFrame application.
         * Sets the components and their positions in the gui.
         * Sets the 
         */
        public ChooserFrame( ChooseFile control) {
            //Call MainGUI
            super( "MainGUI");
            // Set Title
            this.setTitle("Choose Something");
            this.setSize( 200, 150);
            this.setLocation(100, 100);
            this.getContentPane().setLayout( null);
        
            //Set the button for the file chooser.
            JButton button = new JButton( "Push Me");
            button.setLocation(100, 400);
            button.setSize( 100, 50);
            button.addActionListener(control);
            this.getContentPane().add( button);
        
            //Make it visible, close when exited
            this.setVisible(true);
            this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
            this.setResizable( false);
            
            //Big window to contain all the counts and the button
            this.setSize( 750, 500);
            this.getContentPane().setLayout( null);
            
            this.outFileLabel.setBounds( 20, 20, 80, 30);
            this.getContentPane().add( this.outFileLabel);
            
            this.outputFile.setBounds(150, 20, 200, 30);
            this.getContentPane().add( outputFile);
            
            this.totalCount.setBounds( 20, 60, 80, 30);
            this.getContentPane().add( this.totalCount);
            
            this.count.setBounds(150, 60, 80, 30);
            this.getContentPane().add( this.count);
            
            this.top5Label.setBounds( 20, 100, 120, 30);
            this.getContentPane().add( this.top5Label);
            
            this.top5.setBounds( 150, 100, 300, 30);
            this.getContentPane().add( this.top5);

            this.bottom5Label.setBounds( 20, 140, 150, 30);
            this.getContentPane().add( this.bottom5Label);
            
            this.bottom5.setBounds( 150, 140, 300, 30);
            this.getContentPane().add( this.bottom5);
            
        }
        
}