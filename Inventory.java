package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

/** The Inventory class manages a collection of DVDRuntime objects, 
 * providing functionalities to add, retrieve, sort, save, search, and delete DVDs. */

public class Inventory {
	private ArrayList<DVDRuntime> dvdlist;

	// Constructs an empty Inventory.
	public Inventory() {
		dvdlist = new ArrayList<DVDRuntime>();
	}

	// Adds a DVDRuntime object (dvd) to the inventory.
	public void add(DVDRuntime dvd) {
		dvdlist.add(dvd);
	}

	// Finds and returns the highest DVD item number in the inventory, or 0 if inventory is empty.
	public int highestNumber() {
		int numb = 0;
		for (int i = 0; i < dvdlist.size(); i++) {
			if (get(i).getDvdItem() > numb) {
				numb = get(i).getDvdItem();
			}
		}
		return numb;
	}

	// Retrieves the DVDRuntime object at the specified index.
	public DVDRuntime get(int index) {
    	return dvdlist.get(index);
	}

	// Gets the number of DVDs in the inventory and returns the size of the inventory list.
	public int size() {
		return dvdlist.size();
	}

	// Sorts the inventory list alphabetically by DVD title using bubble sort.
	public void sort() {
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

	// Calculates and returns the total value of all DVDs in inventory.
    public double value() {
        double total = 0.0;
        for (int i = 0; i < dvdlist.size(); i++) {
            total += get(i).value();
        }
        return total;
    }

	// Saves the inventory to a default file path.
	public void save() {
		save(true);
	}

	/** Saves the inventory data to the file path "Add path here".
     * 	- If the directory does not exist, it will attempt to create it and retry saving once.
     * 	- @param saveagain indicates if this is the first attempt (true) or retry (false) 
	*/
    public void save(boolean saveagain) {
        String filePath = "Add path here"; // Update this to your desired file path
        try {
            BufferedWriter w = new BufferedWriter(new FileWriter(filePath));
            for (int i = 0; i < size(); i++) {
                DVDRuntime dvd = get(i);
                w.write("Item number: " + dvd.getDvdItem() + "\n");
                w.write("Item name: " + dvd.getDvdTitle() + "\n");
                w.write("Items in stock: " + dvd.getDvdStock() + "\n");
                w.write("Runtime: " + dvd.getRuntime() + "\n");
                w.write("Price: $" + dvd.getDvdPrice() + "\n");
                w.write("Fee: $" + dvd.fee() + "\n");
                w.write("Value (including the fee): $" + dvd.value() + "\n");
                w.newLine();
            }
            w.write("Total fee: $" + (value() - value() / 1.05) + "\n");
            w.write("Total value (including the fee): $" + value() + "\n");
            w.close();
        } catch (Exception ex) {
            if (saveagain) {
                File f = new File(filePath);
                File dir = f.getParentFile();
                if (dir != null) {
                    dir.mkdirs();
                }
                save(false);
            }
        }
    }

	// Searches for a DVD by its title, ignoring case and return the index of the matching DVD, or -1 if not found
	public int searchForDVDRuntime(String title) {
		for (int i = 0; i < size(); i++) {
			if (get(i).getDvdTitle().equalsIgnoreCase(title)) return i;
		}
		return -1;
	}

	// Adds a new DVDRuntime object to the inventory.
	public void addNewDVDRuntime(DVDRuntime dvd) {
		dvdlist.add(dvd);
	}

	//Removes the specified DVDRuntime object from the inventory.
	public void deleteDVDRuntime(DVDRuntime dvd) {
		dvdlist.remove(dvd);
	}
}
