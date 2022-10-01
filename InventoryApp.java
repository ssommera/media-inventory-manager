package test;

import java.awt.event.*;
import javax.swing.*;
import java.io.*;


public class InventoryApp extends JFrame{

	private JTextArea txt;
	private Inventory inv;
	private int currentDisplay = 0;

	public InventoryApp() {
		super ( "DVD Inventory Program" );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		init();
	}

	private void init(){
	
		// create a default starter object
		DVDRuntime p1 = new DVDRuntime(0, " ", 0, 0, 0);

		//create an inventory and load the object
		inv = new Inventory();
		inv.add(p1);

		// graphical interface
		JPanel panel = new JPanel();
		txt = new JTextArea( 15,20 );
		txt.setEditable( false );//this is a display area so user should not change
		panel.add(txt);

		JPanel buttonpanel = new JPanel();
		buttonpanel.setLayout(new BoxLayout(buttonpanel,BoxLayout.Y_AXIS));


		JPanel anotherbuttonpanel = new JPanel();
		anotherbuttonpanel.setLayout(new BoxLayout(anotherbuttonpanel,BoxLayout.Y_AXIS));

		JButton first = new JButton("First");
		first.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDisplay = 0;// go to the beginning
				displayDVD();
			}
		});
		buttonpanel.add(first);
		JButton previous = new JButton("Previous");
		previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentDisplay > 0) currentDisplay--;
				else currentDisplay = inv.size()-1;
				displayDVD();
			}
		});
		buttonpanel.add(previous);
		JButton next = new JButton("Next");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentDisplay < inv.size()-1) currentDisplay++; //advance to the end
				else currentDisplay = 0;
				displayDVD();
			}
		});
		buttonpanel.add(next);
		JButton last = new JButton("Last");
		last.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDisplay = inv.size()-1;
				displayDVD();
			}
		});
		buttonpanel.add(last);

		JButton save = new JButton("Save");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inv.save();
			}
		});
		anotherbuttonpanel.add(save);

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
		anotherbuttonpanel.add(search);

		JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog(InventoryApp.this,
				"Enter the DVD's Title");
				int units = Integer.parseInt(JOptionPane.showInputDialog(InventoryApp.this,
				"Enter the units in stock"));
				double price = Double.parseDouble(JOptionPane.showInputDialog(InventoryApp.this,
				"Enter the price of each item"));
				double runtime = Double.parseDouble(JOptionPane.showInputDialog(InventoryApp.this,
				"Enter the Runtime in minutes"));

				// make the object
				DVDRuntime dvd = new DVDRuntime(inv.highestNumber()+1, name, units, price, runtime);

				// put it in the inv, at the very end
				inv.addNewDVDRuntime(dvd);

				currentDisplay = inv.size()-1;
				displayDVD();
			}
		});
		anotherbuttonpanel.add(add);

		JButton modify = new JButton("Modify");
		modify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// get new values and set them
				DVDRuntime dvd = inv.get(currentDisplay);
				dvd.setDvdItem(Integer.parseInt(
						JOptionPane.showInputDialog(InventoryApp.this,"Enter new item number",dvd.getDvdItem())));
				dvd.setDvdTitle(
						JOptionPane.showInputDialog(InventoryApp.this,"Enter new item name",dvd.getDvdTitle()));
				dvd.setDvdStock(Integer.parseInt(
						JOptionPane.showInputDialog(InventoryApp.this,"Enter new units in stock",dvd.getDvdStock())));
				dvd.setDvdPrice(Double.parseDouble(
						JOptionPane.showInputDialog(InventoryApp.this,"Enter new price of each item",dvd.getDvdPrice())));
				dvd.setRuntime(Double.parseDouble(
						JOptionPane.showInputDialog(InventoryApp.this,"Enter new Runtime in minutes",dvd.getRuntime())));

				// show it
				displayDVD();
			}
		});
		anotherbuttonpanel.add(modify);

		JButton delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (inv.size() > 0) { // else there is nothing to delete
					inv.deleteDVDRuntime(inv.get(currentDisplay));
					currentDisplay--;
					if (currentDisplay < 0) currentDisplay = 0;
					displayDVD();
				}
			}
		});
		anotherbuttonpanel.add(delete);

		//buttonpanel.add(new Logo());

		panel.add(buttonpanel);
		panel.add(anotherbuttonpanel);

		getContentPane().add(panel);

		displayDVD();

	} // end init

	//display
	public void displayDVD() {
		txt.setText("*********DVD Details**********\n");
		txt.append("Item number: " + inv.get(currentDisplay).getDvdItem() + "\n");
		txt.append("DVD name: " + inv.get(currentDisplay).getDvdTitle() + "\n");
		txt.append("Units in stock: " + inv.get(currentDisplay).getDvdStock() + "\n");
		txt.append("Price: $" + String.format("%.2f",inv.get(currentDisplay).getDvdPrice()) + "\n");
		txt.append( "Runtime in minutes: " + inv.get(currentDisplay).getRuntime() + "\n");
		//txt.append("Total value: $" + String.format("%.2f",inv.get(currentDisplay).value()) + "\n");
		//txt.append("Fee: $" + String.format("%.2f",inv.get(currentDisplay).fee()) + "\n\n");
		//txt.append("Total value: $" + String.format("%.2f",inv.value()));

    }



	public static void main(String args []){
		InventoryApp gui = new InventoryApp();
		gui.pack();
		gui.setVisible(true);
		} // end main

} // ends InventoryApp Class
