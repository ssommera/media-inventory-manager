package test;

public class DVDRuntime extends DVD{

    private double runtime = 0;

	 public DVDRuntime(int item, String title, int stock, double price, double runtime)
    {
        super( item,  title,  stock,  price);
		 this.runtime = runtime;
    }

    public double getRuntime() {
        return runtime;
    }

    public void setRuntime(double runtime) {
        this.runtime = runtime;
    }

	/*// Total value
	public double value() {
		return 1.05*getDvdPrice()*getDvdStock();
	}
	// fee
	public double fee() {
		return 0.05*getDvdPrice()*getDvdStock();
	}*/
}//end class DVDRuntime
