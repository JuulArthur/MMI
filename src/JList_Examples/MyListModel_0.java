package JList_Examples;

/**

 */

import javax.swing.AbstractListModel;

public class MyListModel_0 extends AbstractListModel
{
    /**
     * Constructor for objects of class PersonListModel
     */
    public MyListModel_0() {
    }

    public int getSize() {
        return 100;
    }
    
    public Object getElementAt(int i) {
        return ((i+1)+"*"+(i+1)+"="+(i+1)*(i+1));
    }
}
