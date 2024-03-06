package Interface_Package;

import Customer_and_Car_Package.Car;

/**
	 * Interface for a car object in a car rental system.
	 */
	public interface ICar {
	
	/**
	 * Rent the car, setting the rented status and occupancy.
	 */
		public void Rent();
	
	/**
	 * Get the ID of the car.
	 * 
	 * @return the ID of the car
	 */
		public String getID();
	
	/**
	 * Get the quality score of the car.
	 * 
	 * @return the quality score of the car
	 */
		public double getQuality_score();
	
	/**
	 * Get the occupancy of the car.
	 * 
	 * @return the occupancy of the car
	 */
		public int getOccupancy();
	
	/**
	 * Check if the car is currently rented.
	 * 
	 * @return true if the car is rented, false otherwise
	 */
		public boolean isRented();
	
	/**
	 * Update the occupancy of the car after a time period has passed.
	 * 
	 * @return the updated occupancy of the car
	 */
		public int updateOccupancy();
	
	/**
	 * Returns a string representation of the car, in the format "ID, quality_score".
	 * 
	 * @return a string representation of the car
	 */
		public String toString();
	
	/**
	 * Check if two car objects are equal.
	 * 
	 * @param car the car to compare to this car
	 * @return true if the cars are equal, false otherwise
	 */
		public boolean equals(Car car);
	
}
