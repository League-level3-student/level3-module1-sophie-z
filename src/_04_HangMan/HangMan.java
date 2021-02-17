package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener{
	int score = 0;
	int round = 0;
	int number;
	static int lives = 10;
	static String text = "";
	Stack<String> words = new Stack<String>();
	Utilities u = new Utilities();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JLabel life = new JLabel();
	String current;
	
	void setup() {
		frame.addKeyListener(this);
		panel.add(life);
		panel.add(label);
		frame.setVisible(true);
		frame.add(panel);
		startGame();
		life.setText("LIVES: " + lives);
		frame.pack();
	}
	
	void getWord() {
		round = round + 1;
		if(round>number) {
			int replay = JOptionPane.showConfirmDialog(frame, "You have completed " + number + " round(s) of Hangman! Play again?", "Play Again?", JOptionPane.YES_NO_OPTION);
			if(JOptionPane.YES_OPTION==replay) {
				startGame();
			}
			else if(JOptionPane.NO_OPTION==replay) {
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}
		lives = 10;
		text = "";
		if(!words.isEmpty()) {
			current = words.pop();
		}
		System.out.println(current);
		for(int i = 0; i<current.length(); i++){
			text += "_ ";
		}
		label.setText(text);
		frame.pack();
	}
	
	void startGame() {
		round = 0;
		String answer = JOptionPane.showInputDialog("How many games would you like to play?");
		number = Integer.parseInt(answer);
		for(int i = 0; i<number; i++) {
		String word = u.readRandomLineFromFile("dictionary.txt");
		words.push(word);
		}
		getWord();
	}

	void gameOver() {
		if(lives<1) {
			int replay = JOptionPane.showConfirmDialog(frame, "GAME OVER. Try again?", "Try Again?", JOptionPane.YES_NO_OPTION);
			if(JOptionPane.YES_OPTION==replay) {
				startGame();
			}
			else if(JOptionPane.NO_OPTION==replay) {
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		String newLabel = "";
		char letter = arg0.getKeyChar();
		String done = label.getText();
		if(current.contains(String.valueOf(letter))) {
			for(int i = 0; i<current.length(); i++) {
				if(current.charAt(i)==letter) {
					newLabel += (letter + " ");
				}
				else {
					newLabel += text.substring(i*2, i*2 + 2);
				}
			}
			text = newLabel;
			label.setText("");
			label.setText(newLabel);
		}
		if(!current.contains(String.valueOf(letter))) {
			lives = lives - 1;
		}
		life.setText("LIVES: " + lives);
		if(!done.contains(String.valueOf('_'))) {
			getWord();
		}
		gameOver();
		frame.pack();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
