Car Rental Simulation
This project entails the development of a "Car Rental Simulation" in Java, aimed at emulating the operations of a car rental system utilizing waiting lists for both customers and cars.

Project Overview
The Car Rental Simulation simulates a scenario where customers apply to rent cars, and cars are allocated to customers based on certain criteria, with waiting lists being maintained for both customers and cars. The simulation adheres to a rental policy where potential matches between customers and cars are identified, and customers are given the option to accept or reject the offered car. If a customer rejects a car, they are placed back at the beginning of the waiting list and must wait for the next available car.

In this system, cars are rented out based on their quality rating, rather than their specific features. Each customer has a quality threshold, and cars are allocated to customers whose quality rating exceeds their threshold. Once accepted, each car remains occupied for a random number of days between 1 and 5.

Implementation Details
Customer and Car Generation: The simulation begins by generating a set of customers and cars. Each customer is assigned a randomly generated quality threshold (a random double between 1 and 3) and a unique identifier. Cars are represented by a list, with each car storing its ID, quality score, and remaining occupancy days.

Renting Process: The renting process involves dequeuing a car and a customer alternately and checking if the customer accepts the offered car based on its quality rating. If accepted, the car is set to rent for a random period between 1 and 5 days, and the customer is removed from the waiting list. If rejected, the customer is enqueued back to the waiting list, and the next customer is dequeued and processed. If all customers reject a car, it is moved to the end of the car queue.

Simulation Continuity: The renting process continues until either all customers rent a car or there are no available cars. At the end of each day, the number of remaining days for rented cars is decremented, and the renting process is run for each available car. Newly available cars are inserted back into the car queue.

Customer Desperation Factor: Each time a customer is put back on the waiting list, their quality threshold is multiplied by 0.9 to simulate growing desperation as they wait for a car.

Simulation Termination: The simulation stops when all customers have rented a car.

Output Statistics
After each day, the simulation outputs statistics including the available cars for that day and the number of newly rented cars. This information provides insights into the rental process and the dynamics of car availability throughout the simulation.

Conclusion
The Car Rental Simulation project offers a comprehensive simulation of a car rental system, providing insights into the rental process dynamics and customer-car matching strategies. By analyzing the output statistics, users can gain a deeper understanding of the efficiency and effectiveness of the rental system.

For any inquiries or feedback, please contact the project maintainers.

Contact Information
For inquiries, feedback, or collaboration opportunities, please reach out to the project maintainers:

Project Maintainer: Mustafa Sahin
Email: dantatsus@gmail.com or mustafasahin@std.iyte.edu.tr