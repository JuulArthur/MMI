package JList_Examples;

/**
 * Write a description of class JListScrollExample here.
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

public class JListScrollExample extends JPanel
{ 
    private JList myJList;
    private DefaultListModel model;
 
    /**
     * Constructor for objects of class JListScrollExample
     */
    public JListScrollExample()
    {
        model = new DefaultListModel();
        myJList = new JList(model);
        model.addElement("Linje 1");
        model.addElement("Linje 2");
        model.addElement("Linje 3");  
        JScrollPane myJScrollPane = new JScrollPane(myJList);
        myJScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        setLayout(new BorderLayout());
        add(myJScrollPane,BorderLayout.NORTH);
    }

    public static void main (String args[]) {
        JFrame frame = new JFrame("JList example");
        frame.getContentPane().add(new JListScrollExample());
        frame.pack();
        frame.setVisible(true);
    }
}
