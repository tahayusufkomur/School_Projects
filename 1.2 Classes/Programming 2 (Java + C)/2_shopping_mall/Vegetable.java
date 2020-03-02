
public class Vegetable extends Food implements Vegan, Washable {
//defult constructor
	public Vegetable() {

		Vegetable(10.0);

	}
//setter
	double Vegetable(double basePrice) {

		this.setBasePrice(basePrice);

		return this.getBasePrice();

	}
	//Abstract method


	@Override
	public void howToWash() {
		System.out.println("Wash vegetables with warm water.");
	}
	//Abstract method

	@Override
	public void madeOf() {

		System.out.println("It is made only of vegetables");

	}
//Calculating Mthod
	@Override
	public double calculatePrice() {
		// TODO Auto-generated method stub
		return (((getBasePrice()*getVat())+getBasePrice()*1.25));		
		
	}

}
