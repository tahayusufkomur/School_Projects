
public class Bank {

    private int bankAmount = 5000;

    public void setBankAmount(int price) {
    	bankAmount+= price;
    }
    
    public int getBankAmount() {
    	return this.bankAmount;
    }
}
