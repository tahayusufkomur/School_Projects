
public class Mammal extends Animal {

	public Mammal(String name, int age) {
		super(name, age);
		// TODO Auto-generated constructor stub
		setLegNumber(4);
	}
	
	public void movements() {
		System.out.println("I can walk to the far away lands!");
		
	}

	
	public void reproduce() {
		
		System.out.println("I give birth!");
		
		
	}
	
	
	public void eatinghabits() {
		
		System.out.println("I eat plants only!	");
		
		
	}
	
	
}
