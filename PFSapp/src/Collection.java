import java.util.HashMap;
import java.util.Map;

public class Collection {
	
	private Map<String, Entry> map;
	private double total;
	
	public Collection() {
		this.map = new HashMap<>();
		this.total = 0;
	}
	
	public void addEntry(Entry e) {
		this.map.put(e.getTitle(), e);
		total += e.getAmount();
	}
	
	public void addEntry(String title, double amount) {
		addEntry(new Entry(title, amount));
	}
	
	public void printCollection() {
		System.out.println("Collection:");
		System.out.println("Total Costs: " + this.total);
		for(String s : map.keySet()) {
			System.out.println(map.get(s));
		}
	}

}
