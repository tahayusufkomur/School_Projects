
public class Chicken extends Bird {

	private static int count = 0;

	public Chicken(String name, int age) {
		super(name, age);
		count += 1;
		// TODO Auto-generated constructor stub
		setLegNumber(2);
		setNumberOfOffSprings(1);
		setPregnancyPerYear(200);
		
		
	}

	@Override
	public void sayGreeting() {
		System.out.println("I have nothing to say other than I am against Pigs!");

	}

	public static int getCount() {

		return count;
	}

	public static void decrementCount() {

		count -= 1;
	}

}
