package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class Inventory {
	private ArrayList<DVDRuntime> dvdlist;

	public Inventory() {
		dvdlist = new ArrayList<DVDRuntime>();
	}

	// adding and getting items

	public void add(DVDRuntime p) {
		dvdlist.add(p);
	}

	public int highestNumber() {
		int numb = 0;
		for (int i = 0; i < dvdlist.size(); i++) {
			if (get(i).getDvdItem() > numb) {
				numb = get(i).getDvdItem();
			}
		}
		return numb;
	}

	public DVDRuntime get(int i) {
		return dvdlist.get(i);
	}

	public int size() {
		return dvdlist.size();
	}

	public void sort() {
		// bubble sort
		int n = dvdlist.size();
		for (int search = 1; search < n; search++) {
			for (int i = 0; i < n-search; i++) {
				if (dvdlist.get(i).getDvdTitle().compareToIgnoreCase(dvdlist.get(i+1).getDvdTitle()) > 0) {
					// swap
					DVDRuntime temp = dvdlist.get(i);
					dvdlist.set(i,dvdlist.get(i+1));
					dvdlist.set(i+1,temp);
				}
			}
		}
	}

//	value
	/*public double value() {
		double total = 0.0;
		for (int i = 0; i < dvdlist.size(); i++) {
			total += get(i).value();
		}
		return total;
	}*/


	public void save() {
		save(true);
	}

	// save it to C:\data\inventory.dat
	public void save(boolean saveagain) {
		try {
			BufferedWriter w = new BufferedWriter(new FileWriter("c:\\data\\inventory.dat"));
			for (int i = 0; i < size(); i++) {
				DVDRuntime dvd = get(i);
				w.write("Item number: " + dvd.getDvdItem() + "\n");
				w.write("Item name: " + dvd.getDvdTitle() + "\n");
				w.write("Items in stock: " + dvd.getDvdStock() + "\n");
				w.write("Runtime: " + dvd.getRuntime() + "\n");
				w.write("Price: $" + dvd.getDvdPrice() + "\n");
			/*	w.write("Fee: $" + dvd.fee() + "\n");
				w.write("Value (including the fee): $" + dvd.value() + "\n");*/
				w.newLine();
			}
			// total value of it
		/*	w.write("Total fee: $" + (value() - value()/1.05) + "\n");
			w.write("Total value (including the fee): $" + value() + "\n");*/
			w.close();
		} catch (Exception ex) {
			if (saveagain) {
				new File("c:\\data\\").mkdir(); // make it if it wasn't there!
				save(false); // if it doesn't work now, we have a big problem!
			}// end IF
		}// end catch
	}//end method save

	// search by name
	public int searchForDVDRuntime(String title) {
		for (int i = 0; i < size(); i++) { // go through all the records
			if (get(i).getDvdTitle().equalsIgnoreCase(title)) return i;
		}
		return -1; // we didn't find anything
	}

	// add a new dvd
	public void addNewDVDRuntime(DVDRuntime dvd) {
		dvdlist.add(dvd);
	}

	// remove a dvd
	public void deleteDVDRuntime(DVDRuntime dvd) {
		dvdlist.remove(dvd);
	}
}
