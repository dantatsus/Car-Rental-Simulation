package ListADT_Package;

import Customer_and_Car_Package.Customer;

public class CustomerList<T extends Customer> extends List<T> {
	
	public CustomerList() {this(10);}
	
	@SuppressWarnings("unchecked")
	public CustomerList(int size) {
		super();
		list = (T[]) new Customer[size + 1];
	}
	
	@Override
	public T[] toArray(){
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Customer[numberOfEntries];
		for (int index = 0; index < numberOfEntries; index++) {
			result[index] = list[index+1];
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public void clear() {
		int size = list.length;
		list = (T[]) new Customer[size + 1];
		numberOfEntries = 0;
	}
}
