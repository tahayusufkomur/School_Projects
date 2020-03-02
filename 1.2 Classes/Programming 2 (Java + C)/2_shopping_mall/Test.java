//150114064
// Taha Yusuf Kömür
//HW 2
public class Test {

	public static void main(String[] args) {
//Creating Shopping Mall Obj with default arraylist
		ShoppingMall ShoppingMallObj = new ShoppingMall();
//creating top object with specialized price
		Top top = new Top();
		top.setBasePrice(100);
		//Adding default object to the list
		ShoppingMallObj.addDairy();
		ShoppingMallObj.addFruit();
		ShoppingMallObj.addTop();
		ShoppingMallObj.addTrousers();
		ShoppingMallObj.addUnderWare();
		ShoppingMallObj.addVegetable();
		ShoppingMallObj.addArbitrary(top);
		
		
		//printing the methods
		System.out.println("");
		printContent(ShoppingMallObj);
		System.out.println("");
		printWashingInstructions(ShoppingMallObj);
		System.out.println("");
		
		System.out.println("Total bill is  " + ShoppingMallObj.bill());
		
		

	}

//Print content method
	
	//Checking where the item belongs.
	public static void printContent(ShoppingMall ShoppingMallObj) {

		for (int x = 0; x < ShoppingMallObj.getSize(); x++) {

			if (ShoppingMallObj.getItems(x) instanceof Vegetable) {

				Vegan Fruit = (Vegan) (ShoppingMallObj.getItems(x));
				Fruit.madeOf();
			} else if (ShoppingMallObj.getItems(x) instanceof Fruit) {

				Vegan vegetables = (Vegan) (ShoppingMallObj.getItems(x));
				vegetables.madeOf();
			}
		}

	}
//print how to wash method 
	//Checking where the item is belong.
	public static void printWashingInstructions(ShoppingMall ShoppingMallObj) {
		for (int x = 0; x < ShoppingMallObj.getSize(); x++) {

			if (ShoppingMallObj.getItems(x) instanceof Vegetable) {

				Washable vegetables = (Washable) (ShoppingMallObj.getItems(x));
				((Vegetable) vegetables).howToWash();
			} else if (ShoppingMallObj.getItems(x) instanceof Fruit) {

				Washable fruit = (Washable) (ShoppingMallObj.getItems(x));
				fruit.howToWash();
			} else if (ShoppingMallObj.getItems(x) instanceof Top) {

				Washable top = (Washable) (ShoppingMallObj.getItems(x));
				top.howToWash();
			} else if (ShoppingMallObj.getItems(x) instanceof Trousers) {

				Clothing top = (Trousers) (ShoppingMallObj.getItems(x));
				top.howToWash();
			} else if (ShoppingMallObj.getItems(x) instanceof Underware) {

				Underware underware = (Underware) (ShoppingMallObj.getItems(x));
				underware.howToWash();

			}
		}

	}

}
