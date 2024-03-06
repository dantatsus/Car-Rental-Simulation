package ListADT_Package;

import Customer_and_Car_Package.Car;

public class CarList<T extends Car> extends List<T> {
	
	public CarList() {this(10);}
	
	@SuppressWarnings("unchecked")
	public CarList(int size) {
		super();
		list = (T[]) new Car[size + 1];
	}
	
	@Override
	public T[] toArray(){
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Car[numberOfEntries];
		for (int index = 0; index < numberOfEntries; index++) {
			result[index] = list[index+1];
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public void clear() {
		int size = list.length;
		list = (T[]) new Car[size + 1];
		numberOfEntries = 0;
	}
	
}
