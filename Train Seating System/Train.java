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

		if (seats[row][column].isEmpty(seats[row][column].getPassengerName())) {
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

		if (!seats[row][column].isEmpty(seats[row][column].getPassengerName())) {
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
		for (int seatNumber = 1; seatNumber <= 92; seatNumber++) {
			if (seatNumber == 3 || seatNumber == 4 || seatNumber == 89 || seatNumber == 90)
				continue;

			int row1 = Seat.getRow(seatNumber);
			int column1 = Seat.getColoumn(seatNumber);

			if (row1 < 0 || row1 >= seats.length || column1 < 0 || column1 >= seats[row1].length)
				continue;

			Seat seatSide1 = seats[row1][column1];
			String seatSide1Status;

			if (seatSide1.getPassengerName() == null || seatSide1.getPassengerName().isEmpty())
				seatSide1Status = "O";
			else
				seatSide1Status = "X";

			int seatNumber2 = seatNumber + 46;

			if (seatNumber2 == 89 || seatNumber2 == 90)
				continue;

			int row2 = Seat.getRow(seatNumber2);
			int column2 = Seat.getColoumn(seatNumber2);

			if (row2 < 0 || row2 >= seats.length || column2 < 0 || column2 >= seats[row2].length)
				continue;

			Seat seatSide2 = seats[row2][column2];
			String seat2Status;

			if (seatSide2.getPassengerName() == null || seatSide2.getPassengerName().isEmpty())
				seat2Status = "O";
			else
				seat2Status = "X";

			System.out.printf("Seat %-3d %s    Seat %-3d %s\n", seatNumber, seatSide1Status, seatNumber2, seat2Status);
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
