import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PaymentTracker {
	
	private static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	private Map<String, Payment> map;
	private double total;
	
	public PaymentTracker() {
		this.map = new HashMap<>();
		this.total = 0;
	}
	
	public void addEntry(Payment e) {
		this.map.put(e.getTitle(), e);
		total += e.getAmount();
	}
	
	public void addEntry(String title, double amount) {
		addEntry(new Payment(title, amount));
	}
	
	public void printCollection() {
		System.out.println("Collection:");
		System.out.println("Total Costs: " + this.total);
		for(String s : map.keySet()) {
			System.out.println(map.get(s));
		}
	}
	
	public void saveCollection() {
		System.out.println("Saving Collection...");
		String name = "collection_" + sdf1.format(new Timestamp(System.currentTimeMillis())) + ".csv";
		try (PrintWriter writer = new PrintWriter(new File("Secret/" + name))) {
			StringBuilder sb = new StringBuilder();  
		    for(String s : map.keySet()) {
		    	sb.append(s);
			    sb.append(',');
			    sb.append(map.get(s).getAmount());
			    sb.append('\n');
		    }

		    writer.write(sb.toString());

		    System.out.println("done!");

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static PaymentTracker readCollection(String filename) {
		File file = new File(filename);
		PaymentTracker output = new PaymentTracker();
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String s = scanner.nextLine();
				System.out.println(s);
				String[] temp = s.split(",");
				output.addEntry(temp[0], Double.valueOf(temp[1]));
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return output;
	}
	
	public java.util.Collection<Payment> getAllEntries() {
		return this.map.values();
	}
	
	public double getTotal() {
		return this.total;
	}

}
