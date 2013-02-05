package oving4;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import oving2.Person;
import oving2.PersonPanel;

public class PersonListPanel extends JPanel{
	private JList myList;
	private DefaultListModel model;
	private DefaultListSelectionModel myListSelectionModel;
	private PersonPanel personPanel;
	private JToggleButton createPerson, deletePerson;
	
	public PersonListPanel(){
		model = new DefaultListModel();
		myList = new JList(model);
		Person olav = new Person("Olav");
		olav.setHeight(182);
		olav.setEmail("nice");
		
		model.addElement(olav);
		model.addElement(new Person("Peter"));
		model.addElement(new Person("Kari"));
		
		myListSelectionModel = new DefaultListSelectionModel();
		myListSelectionModel.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
		
		myList.setSelectionModel(myListSelectionModel);
		myList.addListSelectionListener(new listSelectionAction());
		myList.setName("PersonList");
		
		personPanel = new PersonPanel();
		personPanel.setName("PersonPanel");
		
		createPerson = new JToggleButton("Create person");
		createPerson.addActionListener(new CreateNewPerson());
		createPerson.setName("NewPersonButton");
		
		deletePerson = new JToggleButton("Delete Person");
		deletePerson.addActionListener(new DeletePerson());
		deletePerson.setName("DeletePersonButton");
		
		setLayout(new BorderLayout());
		add(myList,BorderLayout.WEST);
		add(personPanel,BorderLayout.CENTER);
		add(createPerson,BorderLayout.AFTER_LINE_ENDS);
		add(deletePerson,BorderLayout.AFTER_LAST_LINE);
	}
	
	public class listSelectionAction implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			if(!myListSelectionModel.isSelectionEmpty()){
				int i = myListSelectionModel.getAnchorSelectionIndex();
				personPanel.getModel((Person)model.elementAt(i));
			}
			
		}
	}
	
	public class CreateNewPerson implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Person person = new Person(personPanel.getName());
			personPanel.setModel(person);
			model.addElement(person);
			myList.setSelectedValue(person, false);
		}
	}
	
	public class DeletePerson implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
//			if(!myListSelectionModel.isSelectionEmpty()){
//				int i = myListSelectionModel.getAnchorSelectionIndex();
//				model.remove(i);
//				if(!model.isEmpty()){
//					myList.setSelectedValue((Person)model.elementAt(0), false);
//				}
//			}
			personPanel.setNameField("h");
		}
	}
	
	public void setModel(DefaultListModel model){
		this.model=model;
		myList.setModel(this.model);
	}
	
	public DefaultListModel getModel(){
		return this.model;
	}
	
    public static void main (String args[]) {
        JFrame frame = new JFrame("Oving4");
        frame.getContentPane().add(new PersonListPanel());
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
