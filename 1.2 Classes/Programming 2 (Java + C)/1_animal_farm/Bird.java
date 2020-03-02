//Taha Yusuf Kömür 150114064

public class Bird extends Animal {
	
	
	

	public Bird(String name, int age) {
		super(name, age);
		setLegNumber(2);
	
		
	} 

	
	public void movements() {	
		
		System.out.println("I can fly to the endless skies!");
		
		
	}
	public void reProduce() {
		
		System.out.println("I lay eggs");
		
	}
	
	public void eatinghabits() {
		
		
		System.out.println("I can eat everything!");
		
	}
}
