package Customer_and_Car_Package;

import java.util.Random;

import Interface_Package.ICustomer;

public class Customer implements ICustomer{
	
	private String ID;
	private double threshold;
	
	public Customer(String id) {
		this.ID = id;
		
		Random random = new Random();
		threshold = random.nextDouble(1, 3);
	}

	public String getID() {
		return ID;
	}

	public double getThreshold() {
		return threshold;
	}
	
	public void updateThreshold() {
		threshold *= 0.9;
	}
	
	public String toString() {
		return ID + ", " + threshold; 
	}
	
	public boolean equals(Customer customer) {
		if (customer == null) {return false;}
		else {
			return(ID.equals(customer.getID()) && (threshold == customer.getThreshold()));
		}
	}
}
