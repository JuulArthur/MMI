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

public class JListModelExample_1 extends JPanel
{ 
    private JList myJList;
    private MyListModel_1 model;
    private JTextField myTextField;
    private DefaultListSelectionModel myListSelectionModel;
    /**
     * Constructor for objects of class JListModelExample_1
     */
    public JListModelExample_1()
    {
        model = new MyListModel_1();
        myJList = new JList(model);

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
               myTextField.setText(model.getElementAt(i).toString());
            };

        }
    };
    
    
    public static void main (String args[]) {
        JFrame frame = new JFrame("JList example");
        frame.getContentPane().add(new JListModelExample_1());
        frame.pack();
        frame.setVisible(true);
    }
}
