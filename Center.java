import java.util.*;

public class Center{
	private List<Customer> customers = new ArrayList<>();
    private List<Vehicle> vehicles = new ArrayList<>();
    private Queue<ServiceRequest> serviceQueue = new LinkedList<>();
    private Set<Mechanic> mechanics = new HashSet<>();
    private TreeSet<ServiceRecord> serviceHistory = new TreeSet<>();
	
	Scanner sc = new Scanner(System.in);
	public void start(){
		while(true){
			System.out.println("=========Mechanic Shop=========");
			System.out.println("1. Register Customer");
			System.out.println("2. Add Vehicle");
			System.out.println("3. Book Service");
			System.out.println("4. Assign Mechanic");
			System.out.println("5. View Service History");
			System.out.println("6. Search Vehicle");
			System.out.println("7. View Pending Services");
			System.out.println("8. Mark Service as Completed");
			System.out.println("9. Exit");
			System.out.println("Enter your choice number");
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice){
				case 1 -> register();
				case 2 -> addVehicle();
				case 3 -> bookService();
				case 4 -> assignMech();
				case 5 -> history();
				case 6 -> searchVehicle();
				case 7 -> viewPendingServices();
				case 8 -> markServiceCompleted();
				case 9 -> {
					System.out.println("Exiting.....");
					return;
				}
				default -> {
					System.out.println("Invalid Choice");
				}
			}
		}
	}
	
	private void register(){
		System.out.println("Enter Customer ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Customer Name: ");
		String name = sc.nextLine();
		System.out.println("Enter Customer Mobile: ");
		String number = sc.nextLine();
		customers.add(new Customer(id, name, number));
		System.out.println("Customer Registered successfully.....");
	}
	
	private void addVehicle(){
		System.out.println("Enter Customer ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Vehicle Registration number: ");
		String regnum = sc.nextLine();
		System.out.println("Enter Vehicle Model: ");
		String model = sc.nextLine();
		vehicles.add(new Vehicle(id, regnum, model));
		System.out.println("Vehicle added.");
	}
	
    private void bookService(){
        System.out.print("Enter Registration number: ");
        String regNum = sc.nextLine();
        System.out.print("Enter Issue: ");
        String issue = sc.nextLine();
        serviceQueue.add(new ServiceRequest(regNum, issue));
        System.out.println("Service booked.");
    }
	
	private void assignMech(){
			if (serviceQueue.isEmpty()) {
				System.out.println("No service requests pending.");
				return;
			}

			System.out.print("Enter Mechanic ID: ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.print("Enter Mechanic Name: ");
			String name = sc.nextLine();
			Mechanic mech = new Mechanic(id, name);
			mechanics.add(mech);

			ServiceRequest request = serviceQueue.poll();
			serviceHistory.add(new ServiceRecord(request.getRegNum(), request.getIssue(), mech.getName(), new Date()));
			System.out.println("Mechanic assigned and service recorded.");
	}
	
		private void history() {
			if (serviceHistory.isEmpty()) {
				System.out.println("No Service history found.");
				return;
			}

			System.out.println("===== Service History =====");
			for (ServiceRecord record : serviceHistory) {
				System.out.println(record);
			}
		}

	
	private void searchVehicle() {
		System.out.println("Enter Vehicle Registration Number: ");
		String regnum = sc.nextLine();
		for (Vehicle v : vehicles) {
			if (v.getRegNum().equalsIgnoreCase(regnum)) {
				System.out.println("Vehicle found:");
				System.out.println("Registration Number: " + v.getRegNum());
				System.out.println("Model: " + v.getModel());

				for (Customer c : customers) {
					if (c.getId() == v.getId()) {
						System.out.println("Owner Details:");
						System.out.println("ID: " + c.getId());
						System.out.println("Name: " + c.getName());
						System.out.println("Mobile: " + c.getNumber());
						return;
					}
				}
				System.out.println("Owner not found.");
				return;
			}
		}
		System.out.println("Vehicle Not Found");
	}
		
	private void viewPendingServices() {
		boolean found = false;
		System.out.println("===== Pending Services =====");
		for (ServiceRecord record : serviceHistory) {
			if (!record.isCompleted()) {
				System.out.println(record);
				found = true;
			}
		}
		if (!found) {
			System.out.println("No pending services.");
		}
	}
		
	private void markServiceCompleted() {
		System.out.print("Enter Registration number to mark as completed: ");
		String regNum = sc.nextLine();

		boolean found = false;
		for (ServiceRecord record : serviceHistory) {
			if (record.getRegNum().equalsIgnoreCase(regNum) && !record.isCompleted()) {
				record.markCompleted();
				System.out.println("Service marked as completed.");
				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("No pending service found for this registration number.");
		}
	}



}