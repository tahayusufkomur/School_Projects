
public class Donkey extends Mammal {
	
	
    private static int count = 0;
    
    
	public Donkey(String name, int age) {
		super(name, age);
		count += 1;
		setLegNumber(4);
		setNumberOfOffSprings(1);
		setPregnancyPerYear(1);
		
	}
	@Override
	public void sayGreeting() {
		
		System.out.println("Life will go on as it has always gone –that is, badly!");
	}
    public static int getCount() {
    	
    	return count;
    }
    
    
    public static int decrementCount() {
    	
    	return count -= 1;
    }
}
