//150114064
// Taha Yusuf Kömür
//HW 2
public class Dairy extends Food {




//constructor with base Price

public Dairy() {
	
	Dairy(8.0);
	
}

//Default Base Price Process

double Dairy(double basePrice){
	this.setBasePrice(basePrice);	
	return this.getBasePrice();
}


	@Override
	public double calculatePrice() {
	
		return (((getBasePrice()*getVat())+getBasePrice()*1.30));	
		
	}

}
