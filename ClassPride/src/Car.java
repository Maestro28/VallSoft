
public class Car extends Mashine {
	
	protected int mass;
	protected int numberOfPassangers;
	protected int countOfWhils;
	
	Car(String name, int speed, int mass, int numberOfPassangers, int countOfWhils) {
		super(name, speed);
		this.mass = mass;
		this.numberOfPassangers = numberOfPassangers;
		this.countOfWhils = countOfWhils;
	}

	@Override
	public void printTransportName() {
		System.out.println("Transport name: "+transportName);
	}

	@Override
	public int getSpeed() {
		return speedInMoment;
	}

	@Override
	public int getMass() {
		return mass;
	}

	@Override
	public int getPassengerNumber() {
		return numberOfPassangers;
	}

	@Override
	public int getWheelsNumber() {
		return countOfWhils;
	}

}
