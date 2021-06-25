
public class Payment 
{
	private double amount;
	private String title;
	//private String id;
	
	public Payment(String title, double amount) {
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
		return this.title + ": $" + this.amount;
	}
}
