//150114064
// Taha Yusuf Kömür
//HW 2
public class Top extends Clothing {
	//Default Constructor
	public Top() {
Top(20.0);

	}//basePrice setter
double Top(double basePrice) {
	
	this.setBasePrice(basePrice);
	return this.getBasePrice();
}//Abstract method

	@Override
	public void howToWash() {
		System.out.println("Wash Top at 40 degrees");
	}
	//Abstract method

	
	
	//Calculating method
	@Override
	public double calculatePrice() {
		// TODO Auto-generated method stub
		return (((getBasePrice()*getVat())+getBasePrice()*1.20));		
		
	}

}
