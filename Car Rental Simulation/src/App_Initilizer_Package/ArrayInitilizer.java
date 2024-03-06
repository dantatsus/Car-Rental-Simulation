package App_Initilizer_Package;

import Customer_and_Car_Package.Car;
import Customer_and_Car_Package.Customer;

public class ArrayInitilizer {
	
	public Customer[] customerArray(int k) {
		
		Customer[] returnArray = new Customer[k];
		
		for (int index = 0; index < k; index++) {
			String customerID = "cust" + index;
			returnArray[index] = new Customer(customerID);
		}
		
		return returnArray;
	}
	
	public Car[] carArray(int N) {
		
		Car[] returnArray = new Car[N];
		
		for (int index = 0; index < N; index++) {
			String carID =  "car" + index;
			returnArray[index] = new Car(carID);
		}
		
		return returnArray;
	}
	
}
