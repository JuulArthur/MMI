package JList_Examples;

/**
 * Write a description of class MyListModel_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import javax.swing.ListModel;
import javax.swing.AbstractListModel;

public class MyListModel_1 extends AbstractListModel
{
    private String[] myElements = new String[4];
    /**
     * Constructor for objects of class PersonListModel
     */
    public MyListModel_1() {
      myElements[0] = "Linje 1";
      myElements[1] = "Linje 2";
      myElements[2] = "Linje 3";
      myElements[3] = "Linje 4";
    }

    public int getSize() {
        return (myElements.length);
    }
    
    public Object getElementAt(int i) {
        return (myElements[i]);
    }
}
