
public class BTR extends ArmyCar {

	private boolean gunAvailability;
	
	BTR(String name, int speed, int mass, int numberOfPassangers, int countOfWhils) {
		super(name, speed, mass, numberOfPassangers, countOfWhils);
	}

	public boolean isGunAvailability() {
		return gunAvailability;
	}

	public void setGunAvailability(boolean gunAvailability) {
		this.gunAvailability = gunAvailability;
	}
	
	public void checkFunction (){
		if(gunAvailability)System.out.println("For fight !");
		else System.out.println("For transport only");
	}

}
