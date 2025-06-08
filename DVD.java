package test;

// Represents a DVD item with details such as item number, title, stock, and price.

public class DVD {
	
	private int dvdItem;
	private String dvdTitle;
	private int dvdStock;
	private double dvdPrice;
	private double total;

	/**
     * Constructs a DVD object with specified item number, title, stock quantity, and price.
     *
     * @param item  the DVD item number
     * @param title the title of the DVD
     * @param stock the number of items in stock
     * @param price the price of each DVD
     */

	public DVD(int item, String title, int stock, double price) {
	dvdItem = item;
	dvdTitle = title;
	dvdStock = stock;
	dvdPrice = price;

	}

	// Calculates the total value of this DVD stock.
	public double total() {
    	double totalValue = dvdPrice * dvdStock;
    return totalValue;
}

	// Getters and Setters

	public void setDvdItem(int item) {
		this.dvdItem = item;
	}
	public int getDvdItem() {
		return dvdItem;
	}


	public void setDvdTitle(String title) {
		this.dvdTitle = title;
	}
	public String getDvdTitle() {
		return dvdTitle;
	}


	public void setDvdStock(int stock) {
		this.dvdStock = stock;
	}
	public int getDvdStock() {
		return dvdStock;
	}


	public double getDvdPrice() {
		return dvdPrice;
	}
	public void setDvdPrice(double price) {
		this.dvdPrice = price;
	}

}
