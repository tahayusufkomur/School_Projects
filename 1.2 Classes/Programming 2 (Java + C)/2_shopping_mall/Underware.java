//150114064
// Taha Yusuf Kömür
//HW 2
public class Underware extends Clothing implements Washable {

	
	//Constructor with default Price
	public Underware() {

		Underware(30.0);

	}

	public double Underware(double basePrice) {

		this.setBasePrice(basePrice);

		return this.getBasePrice();
	}
	//Abstract method

	@Override
	public void howToWash() {
		System.out.println("Wash Underware at 60 degrees.");
	}
	
	//Calculating Price

	@Override
	public double calculatePrice() {
		// TODO Auto-generated method stub
		return (((getBasePrice() * getVat()) + getBasePrice() * 1.45));

	}

}
