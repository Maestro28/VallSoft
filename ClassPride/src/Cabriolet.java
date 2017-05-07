
public class Cabriolet extends Car {
	
	private String Season;
	private String Weather;
	
	Cabriolet(String name, int speed, int mass, int numberOfPassangers, int countOfWhils) {
		super(name, speed, mass, numberOfPassangers, countOfWhils);
	}	

	public String getSeason() {
		return Season;
	}

	public void setSeason(String season) {
		Season = season;
	}

	public String getWeather() {
		return Weather;
	}

	public void setWeather(String weather) {
		Weather = weather;
	}
	
	public void travel(){
		if ( Season=="Winter" || Weather =="Rain" ) System.out.println("We stay at home !!!");
		else System.out.println("Let's go !");
	}

}
