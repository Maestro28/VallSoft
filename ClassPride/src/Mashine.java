
public abstract class Mashine implements Run {
	
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
	
	public void PrintTransportName(){
		System.out.println("Transport name: " + transportName);
	}
	
}
