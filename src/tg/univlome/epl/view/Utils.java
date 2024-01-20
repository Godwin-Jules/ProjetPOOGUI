package tg.univlome.epl.view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Utils {

	public Utils() {
		
	}
	
	/*---------- Création des boutons -------------*/
	//Creation a button by default
	public JButton createBtn(String btnName) {
		JButton btn = new JButton(btnName);
		btn.setFont(new Font("Candara", Font.BOLD, 20));
		btn.setFocusable(false);
		btn.setBorder(null);
		return btn;
	}
	// Creating a button with its own font size
	public JButton createBtn(String btnName, int size) {
		JButton btn = new JButton(btnName);
		btn.setFont(new Font("Candara", Font.BOLD, size));
		btn.setFocusable(false);
		btn.setBorder(null);
		return btn;
	}
	// Creating a button with its own font
	public JButton createBtn(String btnName, String font_style, int size) {
		JButton btn = new JButton(btnName);
		btn.setFont(new Font(font_style, Font.BOLD, size));
		btn.setPreferredSize(new Dimension(80, 30));
		btn.setFocusable(false);
		btn.setBorder(null);
		return btn;
	}
	// Creating a button with its own font and own dimension
	public JButton createBtn(String btnName, int width, int heigh, String font_style, int size) {
		JButton btn = new JButton(btnName);
		btn.setFont(new Font(font_style, Font.BOLD,size));
		btn.setPreferredSize(new Dimension(width, heigh));
		btn.setFocusable(false);
		btn.setBorder(null);
		return btn;
	}
	
	/*----------- Création des labels -----------*/
	// Creating a label by default
	public JLabel createLab(String labName) {
		JLabel lab = new JLabel(labName);
		lab.setFont(new Font("Candara", Font.BOLD, 20));
		return lab;
	}
	// Creating a label with its own font size
	public JLabel createlab(String labName, int size) {
		JLabel lab = new JLabel(labName);
		lab.setFont(new Font("Candara", Font.BOLD, size));
		return lab;
	}
	// Creating a label with its own font
	public JLabel createLab(String labName, String font_style, int size) {
		JLabel lab = new JLabel(labName);
		lab.setFont(new Font(font_style, Font.BOLD, size));
		return lab;
	}
	// Creating a label with its own font and own dimension
	public JLabel createLab(String labName, int width, int heigh, String font_style, int size) {
		JLabel lab = new JLabel(labName);
		lab.setPreferredSize(new Dimension(width, heigh));
		lab.setFont(new Font(font_style, Font.BOLD, size));
		return lab;
	}
}
