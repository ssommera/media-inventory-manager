package test;

import java.awt.event.*;
import javax.swing.*;
import java.io.*;

// A Swing GUI application to manage an Inventory of DVDs (DVDRuntime objects)

public class InventoryApp extends JFrame{

	private JTextArea txt;
	private Inventory inv;
	private int currentDisplay = 0;

	public InventoryApp() {
		super ("DVD Inventory Program");
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		init();
	}

	private void init(){
	
		// Create a default starter DVD to avoid empty list issues
		DVDRuntime defaultDVD = new DVDRuntime(0, " ", 0, 0, 0);

		// Initialize inventory and add starter DVD
		inv = new Inventory();
		inv.add(defaultDVD);


		/* 
 		* Panels:
 		* 	mainPanel         The main container panel that holds the text area and sub-panels
 		* 	navigationPanel   Contains navigation buttons: First, Previous, Next, Last
 		* 	actionsPanel      Contains action buttons: Save, Search, Add, Modify, Delete
 		*/

		// Main panel and text area setup
		JPanel panel = new JPanel();
		txt = new JTextArea(15,20);
		txt.setEditable( false ); // Display only 
		panel.add(txt);

		// Navigation buttons panel (vertical)
		JPanel navigationPanel = new JPanel();
		navigationPanel.setLayout(new BoxLayout(navigationPanel,BoxLayout.Y_AXIS));

		// Action buttons panel (vertical)
		JPanel actionsPanel = new JPanel();
		actionsPanel.setLayout(new BoxLayout(actionsPanel,BoxLayout.Y_AXIS));


		/*
 		* navigationPanel   
		*	Contains navigation buttons:
 		*		- First: Go to the first DVD in the inventory
 		*       - Previous: Go to the previous DVD (wraps to end if at the beginning)
 		*       - Next: Go to the next DVD (wraps to start if at the end)
 		*       - Last: Go to the last DVD in the inventory
 		*/


		// Navigation Button: "First":
		JButton first = new JButton("First");
		first.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDisplay = 0;// go to the beginning
				displayDVD();
			}
		});
		navigationPanel.add(first);

		// Navigation Button: "Previous":
		JButton previous = new JButton("Previous");
		previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentDisplay > 0) currentDisplay--;
				else currentDisplay = inv.size()-1;
				displayDVD();
			}
		});
		navigationPanel.add(previous);

		// Navigation Button: "Next":
		JButton next = new JButton("Next");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentDisplay < inv.size()-1) currentDisplay++; //advance to the end
				else currentDisplay = 0;
				displayDVD();
			}
		});
		navigationPanel.add(next);

		// Navigation Button: "Last":
		JButton last = new JButton("Last");
		last.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDisplay = inv.size()-1;
				displayDVD();
			}
		});
		navigationPanel.add(last);


		/*
 		* actionsPanel   
 		*	Contains action buttons:
 		*		- Save: Save the inventory to a file
 		*		- Search: Find a DVD by title and display it
 		*		- Add: Create a new DVD entry and add it to the inventory
 		*		- Modify: Edit the currently displayed DVD's details
 		*		- Delete: Remove the currently displayed DVD from the inventory
 		*/


		// Action Button: "Save":
		JButton save = new JButton("Save");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inv.save();
			}
		});
		actionsPanel.add(save);

		// Action Button: "Search":
		JButton search = new JButton("Search");
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = JOptionPane.showInputDialog(InventoryApp.this,
				"Enter the name to search for");
				int result = inv.searchForDVDRuntime(str);
				if (result == -1) JOptionPane.showMessageDialog(InventoryApp.this,
				"Item Not found"); // do nothing
				else { // show the item
					currentDisplay = result;
					displayDVD();
				}
			}
		});
		actionsPanel.add(search);

		// Action Button: "Add":
        JButton add = new JButton("Add");
        add.addActionListener(e -> {
            try {
                String name = JOptionPane.showInputDialog(InventoryApp.this, "Enter the DVD's Title");
                if (name == null) return;

                int units = Integer.parseInt(JOptionPane.showInputDialog(InventoryApp.this, "Enter the units in stock"));
                double price = Double.parseDouble(JOptionPane.showInputDialog(InventoryApp.this, "Enter the price of each item"));
                double runtime = Double.parseDouble(JOptionPane.showInputDialog(InventoryApp.this, "Enter the Runtime in minutes"));

                DVDRuntime dvd = new DVDRuntime(inv.highestNumber() + 1, name, units, price, runtime);
                inv.addNewDVDRuntime(dvd);

                currentDisplay = inv.size() - 1;
                displayDVD();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(InventoryApp.this, "Invalid number format entered.");
            }
        });
        anotherbuttonpanel.add(add);

		// Action Button: "Modify":
		JButton modify = new JButton("Modify");
        modify.addActionListener(e -> {
            try {
                DVDRuntime dvd = inv.get(currentDisplay);
                dvd.setDvdItem(Integer.parseInt(JOptionPane.showInputDialog(InventoryApp.this, "Enter new item number", dvd.getDvdItem())));
                String newTitle = JOptionPane.showInputDialog(InventoryApp.this, "Enter new item name", dvd.getDvdTitle());
                if (newTitle != null) dvd.setDvdTitle(newTitle);
                dvd.setDvdStock(Integer.parseInt(JOptionPane.showInputDialog(InventoryApp.this, "Enter new units in stock", dvd.getDvdStock())));
                dvd.setDvdPrice(Double.parseDouble(JOptionPane.showInputDialog(InventoryApp.this, "Enter new price of each item", dvd.getDvdPrice())));
                dvd.setRuntime(Double.parseDouble(JOptionPane.showInputDialog(InventoryApp.this, "Enter new Runtime in minutes", dvd.getRuntime())));

                displayDVD();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(InventoryApp.this, "Invalid number format entered.");
            }
        });
        anotherbuttonpanel.add(modify);

		// Action Button: "Delete":
		 JButton delete = new JButton("Delete");
        delete.addActionListener(e -> {
            if (inv.size() > 0) {
                inv.deleteDVDRuntime(inv.get(currentDisplay));
                currentDisplay--;
                if (currentDisplay < 0) currentDisplay = 0;
                displayDVD();
            }
        });
        anotherbuttonpanel.add(delete);


		/*
 		* mainPanel (panel)
 		*	Adds sub-panels to the main interface:
 		*		- navigationPanel: Contains navigation buttons (First, Previous, Next, Last)
 		*		- actionsPanel: Contains action buttons (Save, Search, Add, Modify, Delete)
 		*/


		panel.add(navigationPanel);
		panel.add(actionsPanel);
		getContentPane().add(panel);
		displayDVD();

	}

	// Displays the details of the current DVD in the text area
	public void displayDVD() {
		txt.setText("*********DVD Details**********\n");
		txt.append("Item number: " + inv.get(currentDisplay).getDvdItem() + "\n");
		txt.append("DVD name: " + inv.get(currentDisplay).getDvdTitle() + "\n");
		txt.append("Units in stock: " + inv.get(currentDisplay).getDvdStock() + "\n");
		txt.append("Price: $" + String.format("%.2f",inv.get(currentDisplay).getDvdPrice()) + "\n");
		txt.append( "Runtime in minutes: " + inv.get(currentDisplay).getRuntime() + "\n");
		txt.append("Total value: $" + String.format("%.2f",inv.get(currentDisplay).value()) + "\n");
		txt.append("Fee: $" + String.format("%.2f",inv.get(currentDisplay).fee()) + "\n\n");
		txt.append("Total value: $" + String.format("%.2f",inv.value()));

    }

	public static void main(String args []){
		InventoryApp gui = new InventoryApp();
		gui.pack();
		gui.setVisible(true);
	}
}
