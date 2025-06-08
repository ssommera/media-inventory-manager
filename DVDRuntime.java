package test;

//Extends the DVD class to include runtime information for a DVD.

public class DVDRuntime extends DVD{

    /**
     * Constructs a DVDRuntime object with specified details and runtime.
     *
     * @param item    the DVD item number
     * @param title   the title of the DVD
     * @param stock   the number of items in stock
     * @param price   the price of each DVD
     * @param runtime the runtime of the DVD in minutes
     */

	 public DVDRuntime(int item, String title, int stock, double price, double runtime) {
        super( item,  title,  stock,  price);
		this.runtime = runtime;
    }

    //Gets and sets the runtime of the DVD.
    public double getRuntime() {
        return runtime;
    }
    public void setRuntime(double runtime) {
        this.runtime = runtime;
    }

	//Calculates the total value.
    public double value() {
        totalValue = getDvdPrice() * getDvdStock();
        return totalValue;
    }

    //Calculates the 5% fee on the total price.
    public double fee() {
        totalWithFee = 0.05 * getDvdPrice() * getDvdStock();
        return totalWithFee;
    }

}
