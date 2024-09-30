
public class Train {

	private static Seat seats[][] = new Seat[23][];
	Seat seat = new Seat();

	public Train() {
		int seatNum = 1;
		for (int i = 0; i < seats.length; i++) {
			seats[i] = new Seat[i + 2];
			for (int j = 0; j < seats[i].length; j++) {
				while (!Seat.isValid(seatNum)) {
					seatNum++;
				}

				seats[i][j] = new Seat();
				seats[i][j].setSeatNumber(seatNum);
				seatNum++;
			}
		}
	}

	public boolean reserveSeat(int seatNumber, String passengerName) {
		if (!Seat.isValid(seatNumber)) {
			return false;
		}
		int row = Seat.getRow(seatNumber);
		int column = Seat.getColoumn(seatNumber);

		if (row >= seats.length || column >= seats[row].length) {
			return false;
		}

		if (seats[row][column].isEmpty(seat.getPassengerName())) {
			seats[row][column].setPassengerName(passengerName);
			return true;
		}
		return false;
	}

	public boolean deleteSeat(int seatNumber) {
		if (!Seat.isValid(seatNumber)) {
			return false;
		}
		int row = Seat.getRow(seatNumber);
		int column = Seat.getColoumn(seatNumber);

		if (row >= seats.length || column >= seats[row].length) {
			return false;
		}

		if (!seats[row][column].isEmpty(seat.getPassengerName())) {
			seats[row][column].setPassengerName(null);
			return true;
		}
		return false;
	}

	public void deleteAll() {
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[i].length; j++) {
				seats[i][j].setPassengerName(null);
			}
		}
	}

	public void print() {
		for (int seatNum = 1; seatNum <= 46; seatNum++) {
			if (seatNum == 3 || seatNum == 4)
				continue;

			int row1 = Seat.getRow(seatNum);
			int column1 = Seat.getColoumn(seatNum);
			if (row1 >= seats.length || column1 >= seats[row1].length)
				continue;

			Seat seat1 = seats[row1][column1];
			String seat1Status;
			if (seat1.getPassengerName() == null || seat1.getPassengerName().isEmpty())
				seat1Status = "true";
			else
				seat1Status = "false";

			int secondSeatNum = seatNum + 46;
			if (secondSeatNum == 89 || secondSeatNum == 90)
				continue;

			int row2 = Seat.getRow(secondSeatNum);
			int column2 = Seat.getColoumn(secondSeatNum);
			if (row2 >= seats.length || column2 >= seats[row2].length)
				continue;

			Seat seat2 = seats[row2][column2];
			String seat2Status;
			if (seat2.getPassengerName() == null || seat2.getPassengerName().isEmpty())
				seat2Status = "true";
			else
				seat2Status = "false";

			System.out.printf("Seat %-3d %s\tSeat %-3d %s\n", seatNum, seat1Status, secondSeatNum, seat2Status);
		}
	}

	public String passengerName(int seatNumber) {
		int row = Seat.getRow(seatNumber);
		int column = Seat.getColoumn(seatNumber);

		if (row < seats.length && column < seats[row].length) {
			Seat seat = seats[row][column];
			return seat.getPassengerName();
		}

		return null;
	}

}
