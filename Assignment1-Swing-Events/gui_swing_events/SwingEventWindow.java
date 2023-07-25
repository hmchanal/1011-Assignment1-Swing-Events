package gui_swing_events; // Package statement

import javax.swing.*; // Import the required swing classes
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; // Import the two required interfaces

    public class SwingEventWindow extends JFrame implements ActionListener { // Extending the JFrame and implementing the ActionListener interface
        // Declare the checked radio button variable flag:
        // this global and private variable is set to an initial value of 1
        // which refers to the first radio button to be selected by default
        private int rdoChecked = 1; // You can name "rdoChecked"
    
        // Create JPanel main container object:
        JPanel mainPanel; // You create JPanel sub-containers objects for each section of the GUI:
    
        // Create JComponents Items based on the assignment requirements:
        JLabel lblMain, lblRequest;
        JTextField txtNum, txtResult;
        JRadioButton rdoTotal, rdoAverage, rdoMax, rdoMin;
        ButtonGroup radioGroup;
        JButton btnCalculate;
    
        // Class Constructor:
        public SwingEventWindow() {
            // Setting Windows Title by targeting the method from the super class:
            super("Excel Functionality");
            
            // Setting Window (JFrame) Size:
            setSize(400, 300);
            
            // Set the Window (JFrame) visibility to true to make it visible
            setVisible(true);
            
            // Setting the default operation for the close button to Exit the JFrame
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // (Stopping the application)
            
            // No need to assign/set any value to the JComponents
            // It's already done when they are all declared above
            
            // Just group the four related JRadioButton components:
            // by adding them to the ButtonGroup object that you declared earlier
            radioGroup = new ButtonGroup();
            radioGroup.add(rdoTotal);
            radioGroup.add(rdoAverage);
            radioGroup.add(rdoMax);
            radioGroup.add(rdoMin);
    
            // Adding the components to their panels:
            /*
            * IMPORTANT Note:
            * For a quick demo, I used different and multiple JPanels objects
            * to layout the GUI components.
            * It's better to use the "GridLayout" based on the instructions
            */
            // Panel#1 for lblMain - Panel#2 for lblRequest - Panel#3 for txtNum
            // Panel#4 for the 4 radio buttons
            // Panel#5 for the calculate button
            // Panel#6 for the result label and the result output text field
            // Adding all the 6 sub panels to the main panel (the main container):
    
            // Adding the main panel "mainPanel" (JPanel object) to the JFrame:
            add(mainPanel);
            
            // Adding/attaching the required Events to some components:
            rdoTotal.addActionListener(this);
            rdoAverage.addActionListener(this);
            rdoMax.addActionListener(this);
            rdoMin.addActionListener(this);
            btnCalculate.addActionListener(this);
        } // end constructor
    
        // Implementing the two required methods (event-handler)
        // for each interface:
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == rdoTotal) {
                // set the value of the flag variable "rdoChecked" to 1
                rdoChecked = 1;
            } else if (e.getSource() == rdoAverage) {
                // set the value of the flag variable "rdoChecked" to 2
                rdoChecked = 2;
            } else if (e.getSource() == rdoMax) {
                // set the value of the flag variable "rdoChecked" to 3
                rdoChecked = 3;
            } else if (e.getSource() == rdoMin) {
                // set the value of the flag variable "rdoChecked" to 4
                rdoChecked = 4;
            } else if (e.getSource() == btnCalculate) {
                // Getting the user's input string from the first text field:
                String userInput = txtNum.getText();
    
                // Save it into a variable of String data type:
    
                // Initialize our "Excel" class object:
                Excel excel = new Excel(userInput);
    
                /*
                * Passing the String value of the user's input to the constructor
                * Java will pick the second constructor from the Excel class
                * based on the passing data type of the argument which is "String"
                */
    
                // Run the if condition for checking the value of the flag variable "rdoChecked"
                if (rdoChecked == 1) {
                    // call the findTotal() method
                    double total = excel.findTotal();
                    // output/Print the result (value) in the result's text field
                    txtResult.setText(Double.toString(total));
                } else if (rdoChecked == 2) {
                    // call the findAvg() method
                    double avg = excel.findAvg();
                    // output/Print the result (value) in the result's text field
                    txtResult.setText(Double.toString(avg));
                } else if (rdoChecked == 3) {
                    // call the findMax() method
                    double max = excel.findMax();
                    // output/Print the result (value) in the result's text field
                    txtResult.setText(Double.toString(max));
                } else if (rdoChecked == 4) {
                    // call the findMin() method
                    double min = excel.findMin();
                    // output/Print the result (value) in the result's text field
                    txtResult.setText(Double.toString(min));
                }
            }
        } // end Event-Handler method for the calculate button
    } // end class file

