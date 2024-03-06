package App_Initilizer_Package;

import java.util.Scanner;

import Customer_and_Car_Package.Car;
import Customer_and_Car_Package.Customer;
import DequeADT_Package.Deque;
import QueueADT_Package.Queue;

public class AppInitilizer {
	
	private ArrayInitilizer AInitilizer = new ArrayInitilizer(); 
	private Queue<Customer> customerQ;
	private Deque<Car> carDq;
	Scanner scan = new Scanner(System.in);
	
	public void initializeTheApp() throws Exception {
		
		System.out.println("Enter available car count, N="); 
		int N = scan.nextInt(); 
		System.out.println("Enter costumer count, k=");
		int k = scan.nextInt();
		
		customerQ = new Queue<Customer>(k);
		carDq = new Deque<Car>(); 
		
		// add Car objects from the CustCarArray instance to the car deque
		for (Car car : AInitilizer.carArray(N)) {
			carDq.addLast(car);
		}
		
		// add Customer objects from the CustCarArray instance to the customer queue
		for (Customer cust : AInitilizer.customerArray(k)) {
			customerQ.enqueue(cust);
		}

		Day day = new Day(customerQ, carDq, k, N);
		day.Start();
	}
	
}
