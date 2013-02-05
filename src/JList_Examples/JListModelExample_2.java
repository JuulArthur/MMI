package JList_Examples;

/**
 * Write a description of class JListSelectionExample_2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class JListModelExample_2 extends JPanel
{ 
    private JList myJList;
    private MyListModel_2 model;
    private JTextField myTextField;
    private DefaultListSelectionModel myListSelectionModel;
    /**
     * Constructor for objects of class JListModelExample_1
     */
    public JListModelExample_2()
    {
        model = new MyListModel_2();
        myJList = new JList(model);

        myListSelectionModel = new DefaultListSelectionModel();
        myListSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        myJList.setSelectionModel(myListSelectionModel);
        myListSelectionModel.addListSelectionListener(new MyListSelectionListener());
        
        myTextField = new JTextField(20);
        myTextField.addActionListener(new MyActionListener());  // .....
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
    }
    
    class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
           if (!myListSelectionModel.isSelectionEmpty()){
               int i = myListSelectionModel.getAnchorSelectionIndex();
               model.setElement(i,myTextField.getText());}
        };
    }
       
   
   
    public static void main (String args[]) {
        JFrame frame = new JFrame("JList example");
        frame.getContentPane().add(new JListModelExample_2());
        frame.pack();
        frame.setVisible(true);
    }
}
