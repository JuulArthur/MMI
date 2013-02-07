package oving4;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import oving2.Person;
import oving2.Person.Gender;

public class PersonRenderer implements ListCellRenderer{
		
	  ImageIcon ikon;
	
	  protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();

	  public Component getListCellRendererComponent(JList list, Object value, int index,
		      boolean isSelected, boolean cellHasFocus) {
		    JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index,
		        isSelected, cellHasFocus);
		    if (((Person) value).getGender() == Gender.male){
		    	ikon = createImageIcon("blue2.png","blue");
		    }
		    else {
		    	ikon = createImageIcon("red2.png","red");
		    }
		    renderer.setIcon(ikon);
		    renderer.setText(value.toString());
		    return renderer;
		  }

	  protected ImageIcon createImageIcon(String path,
			  String description) {
		  java.net.URL imgURL = getClass().getResource(path);
		  if (imgURL != null) {
			  return new ImageIcon(imgURL, description);
		  } else {
			  System.err.println("Couldn't find file: " + path);
			  return null;
		  }
	  }


}
