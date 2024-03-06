package App_Initilizer_Package;

import Customer_and_Car_Package.Car;
import Customer_and_Car_Package.Customer;
import DequeADT_Package.Deque;
import ListADT_Package.CarList;
import ListADT_Package.CustomerList;
import QueueADT_Package.Queue;

public class Day {
	
	private Queue<Customer> waitingList;
	private Deque<Car> carDq;
	private CustomerList<Customer> custRent;
	private CarList<Car> carRent;
	private CarList<Car> rejectCar;
	private CustomerList<Customer> rejectCust;
	private int day;
	
	public Day(Queue<Customer> customerQ, Deque<Car> carDq , int k, int N) {
		
		this.carDq = carDq;
		
		waitingList = customerQ;
		custRent = new CustomerList<Customer>(k);
		carRent = new CarList<Car>(N);
		
		rejectCar = new CarList<Car>(N);
		rejectCust = new CustomerList<Customer>(k);
		day = 0;
	}
	
	public void Start() throws Exception {
		
		day++; // New day
		
		System.out.println("*** Day" + day + " ***");
		
		while(!(carDq.isEmpty())) {
			
			Car currentCar = carDq.removeFirst();
			offeringMessage(currentCar);
			
			while(!(waitingList.getFront() == null)) {
				
				
				Customer currentCust = waitingList.dequeue();
				offeringMessage(currentCust);
				
				// If the customer rents the car, add them to the rented customers list
				// and add the car to the rented cars list
				if (thresholdCompare(currentCar, currentCust)) {
					currentCar.Rent();
					carRent.add(currentCar);
					custRent.add(currentCust);
					break;
				}
				
				// If the customer does not rent the car, add them to the rejected customers list
				else {
					rejectCust.add(currentCust);
				}
			}
			
			// ReInsert the waiting List.
			ReInsert(rejectCust);
			
			// If car didn't rented by any customer:
			if(!currentCar.isRented()) {
				System.out.println(" ** " + currentCar.getID() + " is not accepted by any customers. ** ");
				rejectCar.add(currentCar);
			}
		}
		
		// ReInsert the cars.
		ReInsert(rejectCar);
		
		System.out.println("All cars have seen");
		
		// If all customers have rented a car, finish the program.
		if (waitingList.isEmpty()) {finish();}
		
		// else
		else {
			System.out.println("But there are still customers waiting.");
			afterProcedure();
			Start();
		}
		
	}
	
	private void ReInsert(CustomerList<Customer> list) {
		if (!list.isEmpty()) {
			for (Customer cust: list.toArray()) {
				cust.updateThreshold();
				waitingList.enqueue(cust);
				list.clear();
			}
		}
	}
	
	private void ReInsert(CarList<Car> list) {
		if (!list.isEmpty()) {
			for (Car car: list.toArray()) {carDq.addLast(car);
				list.clear();
			}
		}
	}
	
	private void offeringMessage(Customer cust) {
		System.out.println("       Current " + cust.getID() + " threshold= " + cust.getThreshold());
	}
	
	private void offeringMessage(Car car) {
		System.out.println("Current " + car.getID() + " quality= " + car.getQuality_score() + " is offering to:");
	}
	
	// Check if the customer's threshold is higher than the car's quality score
	private boolean thresholdCompare(Car currentCar, Customer currentCust) {
		
		// Accept
		if (currentCar.getQuality_score() > currentCust.getThreshold()) {
			System.out.println("       " + currentCust.getID() + " accepted the " + currentCar.getID() + ".");
			System.out.println(" ");
			return true;
		}
		else {
			System.out.println("       " + currentCust.getID() + " rejected the " + currentCar.getID() + ".");
			return false;
		}
	}
	
	private void afterProcedure() {
		
		// Part I : List the rented cars.
		System.out.println(" -- Rented Cars -- ");
		// if there is no rented cars in the list:
		if (carRent.isEmpty()) {System.out.println("None of the customers rented a car.");}
		else {
			Car[] rentedCars = carRent.toArray();
			Customer[] rentedCusts = custRent.toArray();
			int length = rentedCars.length; // rentedCars.length == rentedCusts.length;
			
			for (int index = 0; index < length; index++) {
				System.out.println(rentedCars[index].getID() + " by " + rentedCusts[index].getID() + " occupancy= " 
						+ rentedCars[index].getOccupancy());
				
				// Part II : Occupancy check
				
				if (rentedCars[index].updateOccupancy() == 0) {
					carDq.addLast(carRent.remove(rentedCars[index]));
					custRent.remove(rentedCusts[index]);
				}
			}
		}
		
	}
	
	private void finish() {
		System.out.println("All customer rent a car.");
		System.out.println("End of the program.");
	}
	
}
