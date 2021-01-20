package _04_HangMan;

import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan{
	
	void setup() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JLabel label = new JLabel();
		JButton button1 = new JButton("");
		JButton button2 = new JButton("");
		panel.add(label);
		panel.add(button1);
		panel.add(button2);
		frame.setVisible(true);
		frame.add(panel);
		frame.pack();
	}
	
	public static void main(String[] args) {
		HangMan hm = new HangMan();
		hm.setup();
		String answer = JOptionPane.showInputDialog("Enter a number.");
		int number = Integer.parseInt(answer);
		Stack<String> words = new Stack<String>();
		Utilities u = new Utilities();
		for(int i = 0; i<number; i++) {
			String word = u.readRandomLineFromFile("dictionary.txt");
			words.push(word);
			word.to
		}
		words.pop();
	}
	
}
