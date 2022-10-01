package test;

public class DVD {
	
	private int dvdItem;
	private String dvdTitle;
	private int dvdStock;
	private double dvdPrice;
	private double total;

	public DVD(int item, String title, int stock, double price) {
	dvdItem = item;
	dvdTitle = title;
	dvdStock = stock;
	dvdPrice = price;

	} //end four-argument constructor

	//default constructor
     // public DVD(){}

	// total value
		public double total(){
	return dvdPrice*dvdStock;
	}

	// getters and setters

	// set DVD Item
	public void setDvdItem(int item) {
	this.dvdItem = item;
	}

	//return DVD Item
	public int getDvdItem() {
	return dvdItem;
	}

	//set DVD Title
	public void setDvdTitle(String title) {
	this.dvdTitle = title;
	}

	//return Dvd Title
	public String getDvdTitle() {
	return dvdTitle;
	} //end method get Dvd Title

	public void setDvdStock(int stock) {
	this.dvdStock = stock;
	} //end method set Dvd Stock

	//return dvd Stock
	public int getDvdStock() {
	return dvdStock;
	} //end method get Dvd Stock

	public void setDvdPrice(double price) {
	this.dvdPrice = price;
	} //end method setdvdPrice

	//return DVD Price
	public double getDvdPrice() {
	return dvdPrice;
	} //end method get Dvd Price
	
} //end class DVD
