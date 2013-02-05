package JList_Examples;

/**
 * Write a description of class MyListModel_3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import javax.swing.ListModel;
import javax.swing.AbstractListModel;

public class MyListModel_3 extends AbstractListModel
{
    private String[] myElements = new String[100];
    private int length;
    /**
     * Constructor for objects of class PersonListModel
     */
    public MyListModel_3() {
        length = 1;
        myElements[0] = "Linje 1";
    }

    public int getSize() {
        return (length);
    }
    
    public Object getElementAt(int i) {
        return (myElements[i]);
    }
    
    public void setElement(int i, String s) {
        myElements[i] = s;
        fireContentsChanged(this, i, i);
    }
    
     public void addElement(String s) {
        length = length + 1;
        myElements[length-1] = s;
        fireIntervalAdded(this, 0, length-1);
    }   
}
