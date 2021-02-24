package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
  /* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	
	HashMap <Integer, String> hm = new HashMap<Integer, String>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton add = new JButton("ADD ENTRY");
	JButton search = new JButton("SEARCH BY ID");
	JButton view = new JButton("VIEW LIST");
	JButton remove = new JButton("REMOVE ENTRY");
	
	void setup() {
		HashMap <Integer, String> hm = new HashMap<Integer, String>();
		frame.setVisible(true);
		panel.add(add);
		panel.add(search);
		panel.add(view);
		panel.add(remove);
		frame.add(panel);
		add.addActionListener(this);
		search.addActionListener(this);
		view.addActionListener(this);
		remove.addActionListener(this);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource().equals(add)) {
			String ID = JOptionPane.showInputDialog("Please enter the ID of this guest: ");
			int id = Integer.parseInt(ID);
			String name = JOptionPane.showInputDialog("Please enter the name of this guest: ");
			hm.entrySet();
			hm.put(id, name);
		}
		if(arg0.getSource().equals(search)) {
			String searched = JOptionPane.showInputDialog("Please enter the ID of the guest you are searching up: ");
			int searching = Integer.parseInt(searched);
			if(hm.get(searching) == null) {
				JOptionPane.showMessageDialog(null, "There is no guest with that ID.");
			}
			else {
				JOptionPane.showMessageDialog(null, "Guest Name: " + hm.get(searching));
			}
		}
		if(arg0.getSource().equals(view)) {
			for(int i = 0; i<hm.size(); i++) {
				JOptionPane.showMessageDialog(null, "ID: " + hm.get(i) + " Guest Name: " + hm.get(i));
			}
		}
		if(arg0.getSource().equals(remove)) {
			String removed = JOptionPane.showInputDialog("Please enter the ID of the guest you would like to remove: ");
			int removing = Integer.parseInt(removed);
			if(hm.get(removing) == null) {
				JOptionPane.showMessageDialog(null, "There is no guest with that ID.");
			}
			else {
				hm.remove(removing);
			}
		}
	}
	
}
