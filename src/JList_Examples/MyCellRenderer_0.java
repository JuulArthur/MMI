package JList_Examples;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class MyCellRenderer_0 extends JLabel implements ListCellRenderer {


	     // This is the only method defined by ListCellRenderer.
	     // We just reconfigure the JLabel each time we're called.

	     public Component getListCellRendererComponent(
	       JList list,
	       Object value,            // value to display
	       int index,               // cell index
	       boolean isSelected,      // is the cell selected
	       boolean cellHasFocus)    // the list and the cell have the focus
	     {
	         String s = value.toString();
	         setText(s);
	         return this;
	     }
	 }

