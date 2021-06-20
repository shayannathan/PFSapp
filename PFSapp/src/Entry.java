
public class Entry 
{
	private double amount;
	private String title;
	//private String id;
	
	public Entry(String title, double amount) {
		this.title = title;
		this.amount = amount;
	}
	
	public double getAmount() {
		return this.amount;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	
	public String toString() {
		return this.title + ": " + this.amount;
	}
}
