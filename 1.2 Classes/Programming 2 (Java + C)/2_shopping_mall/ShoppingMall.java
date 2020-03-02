import java.util.ArrayList; //importing


public class ShoppingMall {

	//Default ArrayList
	ArrayList<Item> itemList = new ArrayList<Item>();
	
	

	int x = 0;
	public Item getItems(int x) {
		
		return itemList.get(x);
		
	}	
	//Methods to add default
	public void addDairy() {
				
		
		itemList.add(new Dairy());
	}
	//Methods to add default

	public void addFruit() {
		
		itemList.add(new Fruit());

	}
	//Methods to add default

	public void addTop() {
		
		itemList.add(new Top());

	}
	//Methods to add default

	public void addTrousers() {
		
	   itemList.add(new Trousers());	
	}
	//Methods to add default

	public void addUnderWare() {
		
		itemList.add(new Underware());
	}
	//Methods to add default

	public void addVegetable() {
		
		itemList.add(new Vegetable());
		
	}
	//Methods to add default

	public void addArbitrary(Item item) {
		
		itemList.add(item);
	}
	//To get size of the list for loops
	public int getSize() {
		
		return itemList.size();
	}
	//Bill method
	public double bill() {
		double bill = 0;
		for(int x=0; x<itemList.size(); x++) {
			
			bill += itemList.get(x).calculatePrice();
	
		}
		
		
		
		return bill;

	}
	
	}
	


