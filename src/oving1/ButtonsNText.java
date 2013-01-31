package oving1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class ButtonsNText extends JPanel{
	
	private JTextField TextLine;
	private JToggleButton UpperCaseButton, LowerCaseButton, SelectedButton;
	private JCheckBox ContinuosButton;
	private int caretPos;
	
	public ButtonsNText(){
		
		TextLine = new JTextField();
		TextLine.setName("TextLine");
		TextLine.setColumns(20);
		//TextLine.setText("Type here");
		TextLine.addKeyListener(new MyKeyAction());
		UpperCaseButton = new JToggleButton("To uppercase");
		UpperCaseButton.setName("UpperCaseButton");
		UpperCaseButton.addActionListener(new UpperCaseAction());
		LowerCaseButton = new JToggleButton("To lowercase");
		LowerCaseButton.setName("LowerCaseButton");
		LowerCaseButton.addActionListener(new LowerCaseAction());
		ContinuosButton = new JCheckBox("Continuos");
		ContinuosButton.setName("ContinuousButton");
		
		ButtonGroup group = new ButtonGroup();
		group.add(UpperCaseButton);
		group.add(LowerCaseButton);

		add(TextLine);
		add(UpperCaseButton);
		add(LowerCaseButton);
		add(ContinuosButton);
		
		
	}
	
    class MyKeyAction implements KeyListener {
        public void keyTyped(KeyEvent e) {
        }

		public void keyPressed(KeyEvent e) {
			
		}

		public void keyReleased(KeyEvent e) {
			caretPos = TextLine.getCaretPosition();
        	if (e.getKeyCode()==10){
        		if (SelectedButton == UpperCaseButton){
        			TextLine.setText(TextLine.getText().toUpperCase());
        			TextLine.setCaretPosition(caretPos);
        			//TextLine.setText(UpperCaseButton.getLabel());
        		}
        		if (SelectedButton == LowerCaseButton){
        			TextLine.setText(TextLine.getText().toLowerCase());
        			TextLine.setCaretPosition(caretPos);
        			//TextLine.setText(LowerCaseButton.getLabel());
        		}
        	}
			if (ContinuosButton.isSelected()) {
        		if (SelectedButton == UpperCaseButton) {
        			TextLine.setText(TextLine.getText().toUpperCase());
        			TextLine.setCaretPosition(caretPos);
        		}
        		else if (SelectedButton == LowerCaseButton){
        			TextLine.setText(TextLine.getText().toLowerCase());
        			TextLine.setCaretPosition(caretPos);
        		}
        	}
		}
    }
	
	
    class UpperCaseAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	SelectedButton = UpperCaseButton;
            TextLine.setText(TextLine.getText().toUpperCase());
        }
    }
	
    class LowerCaseAction implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		SelectedButton = LowerCaseButton;
    		TextLine.setText(TextLine.getText().toLowerCase());
    	}
    }
    
    public static void main (String args[]) {
        JFrame frame = new JFrame("Lexical events example");
        frame.getContentPane().add(new ButtonsNText());
        frame.pack(); 
        frame.setVisible(true);  
    }

}
	