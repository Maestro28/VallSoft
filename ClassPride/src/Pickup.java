
public class Pickup extends Car {

	private int BasketLength;
	private int BasketWidth;
	private int BasketHeight;
	
	Pickup(String name, int speed, int mass, int numberOfPassangers, int countOfWhils) {
		super(name, speed, mass, numberOfPassangers, countOfWhils);
	}

	public int getBasketLength() {
		return BasketLength;
	}

	public void setBasketLength(int basketLength) {
		BasketLength = basketLength;
	}

	public int getBasketWidth() {
		return BasketWidth;
	}

	public void setBasketWidth(int basketWidth) {
		BasketWidth = basketWidth;
	}

	public int getBasketHeight() {
		return BasketHeight;
	}

	public void setBasketHeight(int basketHeight) {
		BasketHeight = basketHeight;
	}
	
	public void takeBaggage(int height, int weight, int lenght){
		if(BasketLength >= lenght && BasketWidth >= weight && BasketHeight >= height){
			System.out.println("We can keep it");
		}else System.out.println("not today");
	}
	
	
}
