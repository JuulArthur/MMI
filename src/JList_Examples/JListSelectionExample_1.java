package JList_Examples;

/**
 * Write a description of class JListSelectionExample_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class JListSelectionExample_1 extends JPanel
{ 
    private JList myJList;
    private DefaultListModel model;
    private JTextField myTextField;
    private DefaultListSelectionModel myListSelectionModel;
    /**
     * Constructor for objects of class JListSelectionExample_1
     */
    public JListSelectionExample_1()
    {
        model = new DefaultListModel();
        myJList = new JList(model);
        model.addElement("Linje 1");
        model.addElement("Linje 2");
        model.addElement("Linje 3");  
        
        myListSelectionModel = new DefaultListSelectionModel();
        myListSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        myJList.setSelectionModel(myListSelectionModel);
        myListSelectionModel.addListSelectionListener(new MyListSelectionListener());
        
        myTextField = new JTextField(20);
        JScrollPane myJScrollPane = new JScrollPane(myJList);
        myJScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        setLayout(new BorderLayout());
        add(myJScrollPane,BorderLayout.NORTH);
        add(myTextField,BorderLayout.SOUTH);
    }

    class MyListSelectionListener implements ListSelectionListener
    {   public void valueChanged(ListSelectionEvent e){
           if (!myListSelectionModel.isSelectionEmpty()){
               int i = myListSelectionModel.getAnchorSelectionIndex();
               myTextField.setText(model.elementAt(i).toString());
            };

        }
    };
    
    
    public static void main (String args[]) {
        JFrame frame = new JFrame("JList example");
        frame.getContentPane().add(new JListSelectionExample_1());
        frame.pack();
        frame.setVisible(true);
    }
}
