
public abstract class Mashine implements Run, Comparable<Mashine> {
	
	 final int MAXSPEED = 180;
	 final int MINSPEED = 30;
	 final int MIN_PASSENGER_NUMBER = 1;
	 final int MIAX_PASSENGER_NUMBER = 5;
	 String transportName ;
	 int speedInMoment ;
	
	Mashine(String name, int speed){
		transportName = name;
		speedInMoment = speed;
	}
	
	public void printTransportName(){
		System.out.println("Transport name: " + transportName);
	}
	

	

	@Override
	public String getTransportName() {
		return transportName;
	}

	@Override
	public int getSpeed() {
		return speedInMoment;
	}

	@Override
	public int compareTo(Mashine compareMashine) {

		int compareSpeed = ((Mashine) compareMashine).getSpeed();
		
		return this.speedInMoment - compareSpeed;
	}

	
	
	
}
