package oving4;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import com.sun.jmx.interceptor.DefaultMBeanServerInterceptor;

import oving3.Person;
import oving3.PersonPanel;
import oving3.PersonPanelExample;

public class PersonListPanela extends JPanel{
	
	private JList personList;
	private DefaultListModel listModel = new DefaultListModel();
	private PersonPanel personPanel = new PersonPanel();
	private GridBagConstraints c;
	
	public PersonListPanela(){
		this.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		
		personPanel.setModel(new Person("Olav"));
		
		personList.setModel(listModel);
		personList.setName("PersonList");
		personList.setSize(60000,30000);
		//personList.addListSelectionListener(new listSelectionAction());
		personList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		setLayout(new BorderLayout());
		add(personList,BorderLayout.WEST);
		
		
//		c.gridx=0;
//		c.gridy=0;
//		c.gridwidth=30;
//		c.anchor=c.NORTHWEST;
//		add(personList,c);
//		c.gridx=1;
//		c.gridy=0;
//		c.anchor=c.NORTHEAST;
//		add(personPanel,c);
	}
	
	public class listSelectionAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
//			setFields(model);
		}
	}
	
	public void setModel(DefaultListModel model){
		this.listModel=model;
		personList.setModel(this.listModel);
	}
	
	public DefaultListModel getModel(){
		return this.listModel;
	}
	
	public static void main (String args[]) {
		DefaultListModel dlModel = new DefaultListModel();
		PersonListPanela plp = new PersonListPanela();
        JFrame frame = new JFrame("Oving2");
        frame.getContentPane().add(plp);
        frame.pack();
        frame.setSize(600, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Person test = new Person("test");
        Person kul = new Person("kul");
        Person hei = new Person("hei");
        dlModel.addElement(test);
        dlModel.addElement(kul);
        dlModel.addElement(hei);
        plp.setModel(dlModel);
    }
}
