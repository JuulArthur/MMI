package oving3;

import javax.swing.JPanel;
import javax.swing.JFrame;

public class PersonPanelExample extends JPanel{
	private PersonPanel personPanelA, personPanelB;

	private Person model;

	public PersonPanelExample() {
		model = new Person("");
		personPanelA = new PersonPanel();
		personPanelA.setModel(model);
		add(personPanelA);
		personPanelB = new PassivePersonPanel();
		personPanelB.setModel(model);
		add(personPanelB);
	}

	
	
	public static void main (String args[]) {
        JFrame frame = new JFrame("Oving2");
        frame.getContentPane().add(new PersonPanelExample());
        frame.pack(); 
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
