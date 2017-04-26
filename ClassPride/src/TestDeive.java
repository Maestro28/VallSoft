
public class TestDeive {
	
	public static void main(String[] args) {

		System.out.println("And now we start test aour cars !!!");
		
		System.out.println("Start test cabriolet impala:"); 
		Cabriolet impala = new Cabriolet("Impala", 120, 1500, 2, 4);
		 
		 impala.setSeason("Summer");
		 impala.setWeather("Sunny");
		 impala.travel();
		 
		 impala.setWeather("Rain");
		 impala.travel();
		 
		 
		 System.out.println("---------------------------------------------------");
		 
		 System.out.println("Start test pickup ford");
		 
		 Pickup ford = new Pickup("Ford", 90, 4000, 4, 4);
		 
		 ford.setBasketHeight(1);
		 ford.setBasketLength(3);
		 ford.setBasketWidth(2);
		 
		 ford.takeBaggage(1, 1, 1);
		 ford.takeBaggage(2, 2, 2);
		 
		 System.out.println("----------------------------------------------------");
		 
		 System.out.println("Start test KV1C");
		 
		 Tank KV1C = new Tank("KV1C", 30, 15000, 3, 2);
		 
		 KV1C.setCalibr(120);
		 
		 KV1C.gunCheck();
		 
		 System.out.println("----------------------------------------------------");
		 
		 System.out.println("Start test armyTransporter");
		 
		 BTR soldierTransporter = new BTR("armyTransporter", 60, 8000, 15, 6);
		 
		 soldierTransporter.setGunAvailability(false);
		 
		 soldierTransporter.checkFunction();
		 
		 System.out.println("-----------------------------------------------------");
		 		
	}

}
