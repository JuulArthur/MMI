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

public class JListSelectionExample_2 extends JPanel
{ 
    private JList myJList1, myJList2;
    private DefaultListModel model;
    private JTextField myTextField;
    private DefaultListSelectionModel myListSelectionModel;
    /**
     * Constructor for objects of class JListSelectionExample_1
     */
    public JListSelectionExample_2()
    {
        model = new DefaultListModel();
        myJList1 = new JList(model);
        myJList2 = new JList(model);
        model.addElement("Linje 1");
        model.addElement("Linje 2");
        model.addElement("Linje 3");  
        
        myListSelectionModel = new DefaultListSelectionModel();
        myListSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        myJList1.setSelectionModel(myListSelectionModel);
        myJList2.setSelectionModel(myListSelectionModel);
        myListSelectionModel.addListSelectionListener(new MyListSelectionListener());
        
        myTextField = new JTextField(10);
        JScrollPane myJScrollPane1 = new JScrollPane(myJList1);
        JScrollPane myJScrollPane2 = new JScrollPane(myJList2);
        myJScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        myJScrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        setLayout(new BorderLayout());
        add(myJScrollPane1,BorderLayout.WEST);
        add(myJScrollPane2,BorderLayout.EAST);
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
        frame.getContentPane().add(new JListSelectionExample_2());
        frame.pack();
        frame.setVisible(true);
    }
}
