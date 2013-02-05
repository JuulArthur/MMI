package oving2;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Person {
	
	public Person(String name){
		this.name = name;
	}
	
	public enum Gender { 
		male, female; 
		}
	
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
		this.name = name;
	}
	public String getDateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	public Enum getGender() {
		return this.gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
