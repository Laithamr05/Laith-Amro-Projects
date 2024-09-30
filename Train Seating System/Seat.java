


public class Seat {

	private int seatNumber;
	private String passengerName;

	public Seat() {
		setSeatNumber(seatNumber);
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		if (isValid(seatNumber))
			this.seatNumber = seatNumber;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		if (isValid(seatNumber))
			this.passengerName = passengerName;
	}

	public boolean isEmpty(String passengerName) {
		return passengerName == null;

	}

	public String toString() {
		return "Seat Number = " + seatNumber + "Passenger Name = " + passengerName + "Ocuppience = "
				+ isEmpty(passengerName);
	}

	public static boolean isValid(int seatNumber) {
		if (seatNumber < 92 || seatNumber > 1 || seatNumber != 3 || seatNumber != 4 || seatNumber != 89
				|| seatNumber != 90)
			return true;
		return false;
	}

	public static int getRow(int seatNumber) {
		if (isValid(seatNumber))
			return (seatNumber-1) / 4;
		return -1;
	}

	public static int getColoumn(int seatNumber){
		if (isValid(seatNumber))
			return (seatNumber-1) % 4;
		return -1;
    }

}
