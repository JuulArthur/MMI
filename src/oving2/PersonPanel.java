package oving2;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import oving2.Person.Gender;

public class PersonPanel extends JPanel implements ChangeListener{
	
	private JTextField fieldName, fieldEmail, fieldBirthday;
	private JComboBox fieldGender;
	private JSlider fieldHeight;
	private JLabel name, email, birthday, gender, height;
	private Person model;
	
	public PersonPanel(){
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		model = new Person("test");
		
		name = new JLabel("Name: ");
		fieldName = new JTextField("");
		fieldName.setName("NamePropertyComponent");
		fieldName.addKeyListener(new MyKeyAction());
		fieldName.setColumns(20);
		
		email = new JLabel("Email: ");
		fieldEmail = new JTextField();
		fieldEmail.setName("EmailPropertyComponent");
		fieldEmail.addKeyListener(new MyKeyAction());
		fieldEmail.setColumns(20);
		
		birthday = new JLabel("Birthday: ");
		fieldBirthday = new JTextField();
		fieldBirthday.setName("DateOfBirthPropertyComponent");
		fieldBirthday.addKeyListener(new MyKeyAction());
		fieldBirthday.setColumns(20);
		
		gender = new JLabel("Gender: ");
		fieldGender = new JComboBox();
		fieldGender.setName("GenderPropertyComponent");
		fieldGender.addItem(Gender.male);
		fieldGender.addItem(Gender.female);
		fieldGender.addActionListener(new MyAction());
		
		height = new JLabel("Height: ");
		fieldHeight = new JSlider();
		fieldHeight.setName("HeightPropertyComponent");
	    fieldHeight.setMaximum(220);
	    fieldHeight.setMinimum(120);
	    fieldHeight.setValue(170);
	    fieldHeight.setMajorTickSpacing(20);
	    fieldHeight.setMinorTickSpacing(10);
	    fieldHeight.setPaintTicks(true);
	    fieldHeight.setPaintLabels(true);
	    fieldHeight.addChangeListener(this);
		
		c.gridx=0;
		c.gridy=0;
		add(name,c);
		c.gridy=1;
		add(email,c);
		c.gridy=2;
		add(birthday,c);
		c.gridy=3;
		add(gender,c);
		c.gridy=4;
		add(height,c);
		
		c.gridx=1;
		c.gridy=0;
		add(fieldName,c);
		c.gridy=1;
		add(fieldEmail,c);
		c.gridy=2;
		add(fieldBirthday,c);
		c.gridy=3;
		add(fieldGender,c);
		c.gridy=4;
		add(fieldHeight,c);
	}
	
	public void stateChanged(ChangeEvent e){
		setModel(model);
	}
	
	class MyKeyAction implements KeyListener {
        public void keyTyped(KeyEvent e) {
        }

		public void keyPressed(KeyEvent e) {
		}

		public void keyReleased(KeyEvent e) {
			setModel(model);
		}
		
		}
	
	class MyAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setModel(model);
		}
	}
	public void setNameField(String name){
		fieldName.setText(name);
	}
	
	public String getNameField(){
		return fieldName.getText();
	}
	
	public void setModel(Person model){
		this.model=model;
		model.setName(fieldName.getText());
		model.setEmail(fieldEmail.getText());
		model.setDateOfBirth(fieldBirthday.getText());
		model.setGender((Gender)fieldGender.getSelectedItem());
		model.setHeight(fieldHeight.getValue());
	}
	
	public void getFields(){
		fieldName.setText(this.model.getName());
		fieldEmail.setText(this.model.getEmail());
		fieldBirthday.setText(this.model.getDateOfBirth());
		fieldGender.setSelectedItem(this.model.getGender());
		fieldHeight.setValue(this.model.getHeight());
	}
	
	public Person getModel(){
		return this.model;
	}
	
	public void getFields(Person model){
		this.model=model;
		fieldName.setText(model.getName());
		fieldEmail.setText(model.getEmail());
		fieldBirthday.setText(model.getDateOfBirth());
		fieldGender.setSelectedItem(model.getGender());
		fieldHeight.setValue(model.getHeight());
	}
}
