package JList_Examples;

/**
    A JList with a self made model.
 */

import javax.swing.*;
import java.awt.*;

public class JListModelExample_0 extends JPanel
{ 
    private JList myJList;
    private MyListModel_0 model;

    /**
     * Constructor for objects of class JListModelExample_1
     */
    public JListModelExample_0()
    {
        model = new MyListModel_0();
        myJList = new JList(model);

        JScrollPane myJScrollPane = new JScrollPane(myJList);
        myJScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        setLayout(new BorderLayout());
        add(myJScrollPane,BorderLayout.NORTH);
    }

    public static void main (String args[]) {
        JFrame frame = new JFrame("JList example");
        frame.getContentPane().add(new JListModelExample_0());
        frame.pack();
        frame.setVisible(true);
    }
}
