package oving3;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Person {
	
	public Person(String name){
		this.name = name;
		pcs = new PropertyChangeSupport(this);
	}
	
	public enum Gender { 
		male, female; 
		}
	
	public static String NAME_PROPERTY = "Name";
	public static String EMAIL_PROPERTY = "Email";
	public static String BIRTH_PROPERTY = "Birth";
	public static String HEIGHT_PROPERTY = "Height";
	public static String GENDER_PROPERTY = "GENDER";
	
	private PropertyChangeSupport pcs;
	private String name;
	private String DateOfBirth;
	private Gender gender;
	private String email;
	private int height;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		String oldName = this.name;
		this.name = name;
		pcs.firePropertyChange(NAME_PROPERTY,oldName,name);
	}
	public String getDateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		String oldDateOfBirth = this.DateOfBirth;
		this.DateOfBirth = dateOfBirth;
		pcs.firePropertyChange(BIRTH_PROPERTY,oldDateOfBirth,DateOfBirth);
	}
	public Enum getGender() {
		return this.gender;
	}
	public void setGender(Gender gender) {
		Gender oldGender = this.gender;
		this.gender = gender;
		pcs.firePropertyChange(GENDER_PROPERTY,oldGender,gender);
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		String oldEmail = this.email;
		this.email = email;
		pcs.firePropertyChange(EMAIL_PROPERTY,oldEmail,email);
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		int oldHeight = this.height;
		this.height = height;
		pcs.firePropertyChange(HEIGHT_PROPERTY,oldHeight,height);
	}
	
	public void addChangePropertyListener(PropertyChangeListener listener){
		pcs.addPropertyChangeListener(listener);
	}
	
	@Override
	public String toString() {
		return name;
//		return "Person [name=" + name + ", DateOfBirth=" + DateOfBirth
//				+ ", gender=" + gender + ", email=" + email + ", height="
//				+ height + "]";
	}
}
