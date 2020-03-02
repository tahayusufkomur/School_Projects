//150114064
// Taha Yusuf Kömür
//HW 2
abstract public class Item {
	private double vat;
	private double basePrice;
	
	//Contructors for item

	
	//getVat method
	public double getVat() {
		return vat;
	}
	//setVatMethod
	
	public void setVat(double vat) {
		this.vat = vat;
	}

	public double getBasePrice() {
		return (double)basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	//Abstract calculatemethod
	public abstract double calculatePrice();
	
	public void madeOf() {
		
	}

}
