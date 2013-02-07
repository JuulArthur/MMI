package oving4;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class PersonRenderer implements ListCellRenderer{

	@Override
	public Component getListCellRendererComponent(JList arg0, Object arg1,
			int arg2, boolean arg3, boolean arg4) {
		JLabel test = new JLabel("wut");
		return test;
	}

}
