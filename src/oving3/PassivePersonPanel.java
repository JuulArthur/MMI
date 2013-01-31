package oving3;

import java.beans.PropertyChangeEvent;

import javax.swing.JTextField;

import oving3.Person.Gender;

public class PassivePersonPanel extends PersonPanel{
	
	private JTextField fieldHeight, fieldGender;
	
	public PassivePersonPanel(){
//		super();
//		
//		fieldName.setEditable(false);
//		fieldEmail.setEditable(false);
//		fieldBirthday.setEditable(false);
//		
//		remove(fieldGender);
//		remove(fieldHeight);
//		
		makeNotEditable();
		
		fieldGender = new JTextField("Male");
		fieldGender.setName("GenderPropertyComponent");
		fieldGender.addKeyListener(new MyKeyAction());
		fieldGender.setColumns(20);
		fieldGender.setEditable(false);
		c.gridx=1;
		c.gridy=3;
		add(fieldGender,c);
		
		fieldHeight= new JTextField("170");
		fieldHeight.setName("HeightPropertyComponent");
		fieldHeight.addKeyListener(new MyKeyAction());
		fieldHeight.setColumns(20);
		fieldHeight.setEditable(false);
		c.gridy=4;
		add(fieldHeight,c);
	}
	
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName() == Person.GENDER_PROPERTY) {
			if (model.getGender()==Gender.male){
				fieldGender.setText("Male");
			}
			else {
				fieldGender.setText("Female");
			}
		}
		else if (evt.getPropertyName() == Person.HEIGHT_PROPERTY) {
			fieldHeight.setText(Integer.toString(model.getHeight()));
		}
		else {
			super.propertyChange(evt);
		}
	}

}
