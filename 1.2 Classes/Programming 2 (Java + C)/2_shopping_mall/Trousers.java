//150114064
// Taha Yusuf Kömür
//HW 2
public class Trousers extends Clothing {
//Default Constructor
	public Trousers() {
		Trousers(40.00);

	}
	
	//Setting base price inside contsructors method
	double Trousers(double basePrice) {
		
		this.setBasePrice(basePrice);
		return this.getBasePrice();
		
	}
	//Abstract method

	@Override
	public void howToWash() {
		System.out.println("Wash Trousers at 30 degrees");

	}
//calculating the last price
	@Override
	public double calculatePrice() {
		// TODO Auto-generated method stub
		return (((getBasePrice()*getVat())+getBasePrice()*1.20));		
	}
}
