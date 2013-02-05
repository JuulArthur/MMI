package JList_Examples;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class JList_CellRenderExample_1 extends JPanel	
{ 
   private JList myJList;
   private DefaultListModel model;

   /**
    * Constructor for objects of class JListScrollExample
    */
   public JList_CellRenderExample_1()
   {
       model = new DefaultListModel();
       myJList = new JList(model);
       model.addElement("Linje 1");
       model.addElement("Linje 2");
       model.addElement("Linje 3 er veldig lang");  
       myJList.setCellRenderer(new MyCellRenderer_1());
       JScrollPane myJScrollPane = new JScrollPane(myJList);
       myJScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
       setLayout(new BorderLayout());
       add(myJScrollPane,BorderLayout.NORTH);
   }

   public static void main (String args[]) {
       JFrame frame = new JFrame("JList example");
       frame.getContentPane().add(new JList_CellRenderExample_1());
       frame.pack();
       frame.setVisible(true);
   }
}

