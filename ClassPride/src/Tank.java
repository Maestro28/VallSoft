
public class Tank extends ArmyCar {

	private int calibr; 
	
	Tank(String name, int speed, int mass, int numberOfPassangers, int countOfWhils) {
		super(name, speed, mass, numberOfPassangers, countOfWhils);
	}

	public int getCalibr() {
		return calibr;
	}

	public void setCalibr(int calibr) {
		this.calibr = calibr;
	}
	
	public void gunCheck(){
		if (calibr >= 100) System.out.println("This tank has a big gun!");
		else System.out.println("It's not do big");
	}

}
