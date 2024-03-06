package App_Package;


/*
 * @Authors
 * Mustafa Şahin - 280201026
 * Masud Guluyev - 290201111
 */

import App_Initilizer_Package.AppInitilizer;

public class App {
	
	public static void main(String[] args) throws Exception {
		
		
		System.out.println("Welcome to Car Rental Simulation.");
		AppInitilizer initilizer = new AppInitilizer();
		initilizer.initializeTheApp();
	}
}	
