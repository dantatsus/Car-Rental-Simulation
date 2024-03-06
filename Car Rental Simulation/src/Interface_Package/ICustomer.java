package Interface_Package;

import Customer_and_Car_Package.Customer;

public interface ICustomer {
	
	/**
	 * Returns the ID of the customer.
	 * 
	 * @return the ID of the customer
	 */
	public String getID();

	/**
	 * Returns the threshold of the customer.
	 * 
	 * @return the threshold of the customer
	 */
	public double getThreshold();
	
	/**
	 * Updates the threshold of the customer by multiplying it with 0.9.
	 */
	public void updateThreshold();
	
	/**
	 * Returns a string representation of the customer object.
	 * 
	 * @return a string representation of the customer object
	 */
	public String toString();
	
	/**
	 * Compares the current customer object to the specified customer object for equality.
	 * 
	 * @param customer the customer object to be compared
	 * @return true if the specified object is equal to the current object, false otherwise
	 */
	public boolean equals(Customer customer);
	
}
