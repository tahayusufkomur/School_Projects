//150114064
// Taha Yusuf Kömür
//HW 2
public class Fruit extends Food implements Vegan, Washable {
//constructor with basePrice
	public Fruit() {
		
		Fruit(6.0);
		
	}
	//Base Price Process
	double Fruit(double basePrice) {
		this.setBasePrice(basePrice);
		
		return this.getBasePrice();
	}
//Abstract method
	@Override
	public void howToWash() {
		
		System.out.println("Wash Fruit with cold water");
	}
	//Abstract method

	@Override
	public void madeOf() {
		System.out.println("It is made only of fruits");

	}
//Method to calculate last price
	@Override
	public double calculatePrice() {
		// TODO Auto-generated method stub
		return (((getBasePrice()*getVat())+getBasePrice()*1.20));			}

}
