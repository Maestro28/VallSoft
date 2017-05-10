import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
//import org.json.simple.parser.JSONParser;

public class TestDrive {
	
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
		 
		 
		 List<Mashine>listMashine = new ArrayList<>();
		 
		 List<String> carsParameters = new ArrayList<String>();
		 
		 
		 FileInputStream fstream_cars = null;
		 DataInputStream data_input = null;
		 BufferedReader buffer = null;
		 
		 try 
		    { 
		         fstream_cars = new FileInputStream("cars.txt"); 
		         data_input = new DataInputStream(fstream_cars); 
		         buffer = new BufferedReader(new InputStreamReader(data_input)); 
		        String str_line; 

		        while ((str_line = buffer.readLine()) != null) 
		        { 
		            str_line = str_line.trim(); 
		            if ((str_line.length()!=0))  
		            { 
		            	carsParameters.add(str_line);
		            } 
		        }

		    } catch(IOException e){
		    	System.out.println("Error");
		    	e.printStackTrace();
		    } finally {
		    	try{
		    		
		    		buffer.close();
		    		
		    	}catch(IOException e){
		    		e.printStackTrace();
		    	}
		    }
		    	
		    
		    
		 
		 for (String str : carsParameters){
			 System.out.print("From text file - ");System.out.println(str);
			 
			 String[] parameter = str.split("\\s+");
			 
			 if(parameter[0].equals("Car:")){
				 listMashine.add(new Car(parameter[1], Integer.parseInt(parameter[2]), Integer.parseInt(parameter[3]), Integer.parseInt(parameter[4]), Integer.parseInt(parameter[5])));
			 }else if (parameter[0].equals("ArmyCar:")){
				 listMashine.add(new ArmyCar(parameter[1], Integer.parseInt(parameter[2]), Integer.parseInt(parameter[3]), Integer.parseInt(parameter[4]), Integer.parseInt(parameter[5])));
			 }
			 
			 
			 /*for(int i=0 ; i<parameter.length; i++){
					 System.out.println(parameter[i]);
				 }*/
			
		 }		 
		 
		 
		 listMashine.add(impala);
		 listMashine.add(ford);
		 listMashine.add(soldierTransporter);
		 listMashine.add(KV1C);
		 
		 
		 //JSONParser parser;
		 
		 
		 
		 
		 System.out.println("\nSort mashines by speed: ");
		 listMashine.sort(null);
		 
		 // check sorted array of Mashines
		 for (Mashine mash : listMashine){
			 mash.printTransportName();
		 }
		 
		 
		 FileWriter myFile = null;
			BufferedWriter buff = null;
		 
		 try{
			 myFile = new FileWriter("sortedCars.txt"); 
			 buff = new BufferedWriter(myFile);; 
			     
			 for(Mashine mash : listMashine){
				 buff.write(mash.getTransportName()+", "+mash.getSpeed()+", "+ mash.getMass()+", "+ mash.getPassengerNumber()+", "+mash.getWheelsNumber()+";");
				 buff.newLine();
			 }
		 }catch(IOException e1){
			 e1.printStackTrace();
		 }finally {
			 
			 try {
				
				 buff.flush();
				 buff.close();
				 myFile.close();
				 
			 }catch(IOException e1){
				 e1.printStackTrace();
			 }
			 
		 }
		 
	}

}
