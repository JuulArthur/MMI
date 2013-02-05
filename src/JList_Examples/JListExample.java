package JList_Examples;

/**
 * Write a description of class JListExample_1 here.
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

public class JListExample extends JPanel
{ 
    private JList myJList;
 
    /**
     * Constructor for objects of class GroupPanel
     */
    public JListExample()
    {
        myJList = new JList();
        add(myJList);
    }

    public static void main (String args[]) {
        JFrame frame = new JFrame("JList example");
        frame.getContentPane().add(new JListExample());
        frame.pack();
        frame.setSize (300,300);
        frame.setVisible(true);
    }
}
