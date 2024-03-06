package Customer_and_Car_Package;

import java.util.Random;

import Interface_Package.ICar;

public class Car implements ICar {
	
	private String ID;
	private double quality_score;
	private int occupancy;
	private boolean rented;
	
	private Random random = new Random();
	
	public Car(String id) {
		this.ID = id;
		
		quality_score = random.nextDouble(1, 3);
		
		occupancy = 0;
		rented = false;
	}
	
	public void Rent() {
		rented = true;
		occupancy = random.nextInt(1, 6);
	}

	public String getID() {
		return ID;
	}

	public double getQuality_score() {
		return quality_score;
	}

	public int getOccupancy() {
		return occupancy;
	}

	public boolean isRented() {
		return rented;
	}
	
	public int updateOccupancy() {
		occupancy--;
		if (occupancy == 0) {rented = false;}
		return occupancy;
	}
	
	public String toString() {
		return ID + ", " + quality_score;
	}
	
	public boolean equals(Car car) {
		if (car == null) {return false;}
		else {
			return(ID.equals(car.getID()) && quality_score == car.getQuality_score());
		}
	}
	
}
