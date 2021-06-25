import java.awt.*;
import java.io.File;
import java.util.Scanner;

import javax.swing.*;

public class Main {
	
	static PaymentTracker c;
	static File[] files;
	
	public static void main(String[] args) {
		System.out.println("Hello! Welcome to PFS App");
		
		File folder = new File("Secret");
		files = folder.listFiles();
		
		initialUI();
		/*
		createUI();
		
		Scanner in = new Scanner(System.in);
		PaymentTracker c = null;
		
		System.out.println("Do you want to select a file (y/n)?");
		String response = in.nextLine().trim();
		if(response.equals("n") || response.equals("N")) {
			c = new PaymentTracker();
		} else {
			System.out.println("Select Which File You Want:");
			printAvailableFiles();
			
			response = in.nextLine().trim();
			c = PaymentTracker.readCollection("Secret/" + response);
		}
		
		c.printCollection();
		
		
		
		/*
		Collection c = new Collection();
		c.printCollection();
		c.addEntry("Test1", 10.0);
		c.addEntry("Test2", 6.50);
		c.printCollection();
		
		c.saveCollection();
		printAvailableFiles();
		*/
	}
	
	private static void printAvailableFiles() {
		File folder = new File("Secret");
		File[] listOfFiles = folder.listFiles();
		
		if(listOfFiles.length == 0) {
			System.out.println("No Files Available");
		} else {
			for (int i = 0; i < listOfFiles.length; i++) {
			    System.out.println(listOfFiles[i].getName());
			}
		}
	}
	
	private static void addEntry(PaymentTracker c, String title, Double amount) {
		c.addEntry(title, amount);
		c.printCollection();
	}
	
	private static void createUI() {
		JFrame frame = new JFrame(); 
		frame.setTitle("PFSapp");
		frame.setSize(new Dimension(800, 650));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		JPanel list = new JPanel();
		JList list1 = new JList();
		
		JButton addButton = new JButton("+ Add Button");
		JPanel mainPanel = new JPanel();
		mainPanel.add(addButton);
		
	
		
		frame.add(mainPanel, BorderLayout.CENTER);
	}
	
	private static void initialUI() {
		JLabel label = new JLabel("Select a File:");
		JComboBox cl = new JComboBox(files);
		JButton goButton = new JButton("Go");
		JLabel label1 = new JLabel("OR");
		JButton addButton = new JButton("Start Fresh");
		
		JFrame frame = new JFrame(); 
		
		goButton.addActionListener((e) -> {
			String fileChoice = String.valueOf(cl.getSelectedItem());
			c = PaymentTracker.readCollection(fileChoice);
			c.printCollection();
			mainUI();
        });
		
		addButton.addActionListener((e) -> {
            c = new PaymentTracker();
            c.printCollection();
            mainUI();
        });
		
		JPanel mainPanel = new JPanel();
		mainPanel.add(label);
		mainPanel.add(cl);
		mainPanel.add(goButton);
		mainPanel.add(label1);
		mainPanel.add(addButton);
		
		frame.setTitle("PFSapp");
		frame.setSize(new Dimension(800, 650));
		frame.add(mainPanel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private static void mainUI() {
		
		JLabel label = new JLabel("Total Monthly Payments:");
		JLabel value = new JLabel("$" + c.getTotal());
		value.setFont(new Font("Serif", Font.PLAIN, 30));
		
		JPanel total = new JPanel();
		total.add(label);
		total.add(value);
		
		JPanel paymentList = new JPanel();
		paymentList.setLayout(new BoxLayout(paymentList, BoxLayout.Y_AXIS));
		
		for(Payment p : c.getAllEntries()) {
			JLabel temp = new JLabel(p.toString());
			paymentList.add(temp);
		}
		
		JPanel addPayment = new JPanel();
		TextField tf1 = new TextField("Payment Title");
		JLabel dollar = new JLabel(": $");
		TextField tf2 = new TextField("Price");
		
		JButton addButton = new JButton("Add");
		addButton.addActionListener((e) -> {
            //System.out.println();
            //System.out.println();
        });
		
		
		addPayment.add(tf1);
		addPayment.add(dollar);
		addPayment.add(tf2);
		addPayment.add(addButton);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(addPayment);
		mainPanel.add(total);
		mainPanel.add(paymentList);
		
		JFrame frame = new JFrame(); 
		frame.setTitle("PFSapp");
		frame.setSize(new Dimension(800, 650));
		frame.add(mainPanel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	
}
