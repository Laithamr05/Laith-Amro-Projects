public class Train {

	private static Seat seats[][] = new Seat[23][];
	Seat seat = new Seat();

	public Train() {
		seats = new Seat[23][];

		for (int row = 0; row < seats.length; row++) {
			if (row == 0)
				seats[row] = new Seat[2];
			else if (row == seats.length - 1)
				seats[row] = new Seat[2];
			else
				seats[row] = new Seat[4];

			for (int col = 0; col < seats[row].length; col++) {
				seats[row][col] = new Seat();
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
		System.out.print("R\\C ");
		for (int column = 1; column <= 4; column++)
			System.out.printf("%-3d", column);
		System.out.println();

		for (int row = 0; row < seats.length; row++) {
			System.out.printf("%-3d ", row + 1);

			if (row == 0) {
				for (int column = 0; column < 2; column++) {
					if (column < seats[row].length) {
						Seat seat = seats[row][column];
						if (seat.isEmpty(seat.getPassengerName()))
							System.out.printf("%-3s", "X");
						else
							System.out.printf("%-3s", "O");
					}
				}
				System.out.printf("%-3s%-3s", " ", " ");
			} else if (row == seats.length - 1) {
				System.out.printf("%-3s%-3s", " ", " ");
				for (int column = 2; column < 4; column++) {
					if (column - 2 < seats[row].length) {
						Seat seat = seats[row][column - 2];
						if (seat.isEmpty(seat.getPassengerName()))
							System.out.printf("%-3s", "X");
						else
							System.out.printf("%-3s", "O");
					}
				}
			} else {
				for (int column = 0; column < 4; column++) {
					if (column < seats[row].length) {
						Seat seat = seats[row][column];
						if (seat.isEmpty(seat.getPassengerName()))
							System.out.printf("%-3s", "X");
						else
							System.out.printf("%-3s", "O");
					}
				}
			}
			System.out.println();
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
