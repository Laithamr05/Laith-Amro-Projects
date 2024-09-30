
import java.io.*;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Train train = new Train();
		Seat seat = new Seat();

		while (true) {
			System.out.println("Welcome to the main menu");
			System.out.println("1 Read passengers file");
			System.out.println("2 Reserve a new empty seat");
			System.out.println("3 Delete a reserved seat");
			System.out.println("4 Delete all reserved seats");
			System.out.println("5 Update passengers file");
			System.out.println("6 Print all seats");
			System.out.println("7 Quit");
			System.out.print("Please enter your choice: ");

			if (!scanner.hasNextInt()) {
				System.out.println("Invalid input Please enter a valid number");
				scanner.next();
				continue;
			}

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				try (BufferedReader reader = new BufferedReader(new FileReader("Seats.txt"))) {
					String line;

					while ((line = reader.readLine()) != null) {
						System.out.println(line);
					}
					System.out.println();
					System.out.println("Passenger file printed successfully.");
				} catch (IOException e) {
					System.out.println("Error reading passengers file");
				}

				break;

			case 2:
				System.out.print("Enter seat number to reserve: ");
				int seatNumber = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter passenger name: ");
				String passengerName = scanner.nextLine();

				if (train.reserveSeat(seatNumber, passengerName)) {
					System.out.println("Seat reserved successfully");
				} else {
					System.out.println("Seat reservation failed Seat may be reserved or invalid");
				}
				break;

			case 3:
				System.out.print("Enter seat number to delete reservation: ");
				seatNumber = scanner.nextInt();

				if (train.deleteSeat(seatNumber)) {
					System.out.println("Seat reservation deleted successfully");
				} else {
					System.out.println("Failed to delete reservation Seat may already be empty or invalid");
				}
				break;

			case 4:
				train.deleteAll();
				System.out.println("All reserved seats deleted");
				break;

			case 5:
				try (BufferedWriter writer = new BufferedWriter(new FileWriter("Seats.txt"))) {
					for (int seatNum = 1; seatNum <= 92; seatNum++) {
						if (!seat.isEmpty(train.passengerName(seatNum))) {
							passengerName = train.passengerName(seatNum);
							if (passengerName != null && !seat.isEmpty(passengerName)) {
								writer.write("Seat Number: " + seatNum + "  " + passengerName);
								writer.newLine();
							}
						}
					}
					System.out.println("Passengers file updated successfully");
				} catch (IOException e) {
					System.out.println("Error updating passengers file");
				}
				break;

			case 6:
				train.print();
				break;

			case 7:
				System.out.println("Exiting the program");
				scanner.close();
				return;
			default:
				System.out.println("Invalid choice Please select a valid option");
			}
		}
	}
}
