package oving4;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

import com.sun.jmx.interceptor.DefaultMBeanServerInterceptor;

import oving3.PersonPanelExample;

public class PersonListPanel extends JPanel{
	
	private JList personList;
	private DefaultListModel dlModel;
	
	public PersonListPanel(){
		dlModel = new DefaultListModel();
		
		personList = new JList();
		personList.setModel(dlModel);
		personList.setName("PersonList");
	}
	
	public void setModel(DefaultListModel model){
		personList.setModel(model);
		this.dlModel=model;
	}
	
	public DefaultListModel getModel(){
		return this.dlModel;
	}
	
	public static void main (String args[]) {
        JFrame frame = new JFrame("Oving2");
        frame.getContentPane().add(new PersonPanelExample());
        frame.pack(); 
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
