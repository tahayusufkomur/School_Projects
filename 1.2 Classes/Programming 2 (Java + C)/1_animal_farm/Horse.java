
public class Horse extends Mammal {

	private static int count = 0;

	public Horse(String name, int age) {
		super(name, age);
		count += 1;

		setLegNumber(4);
		setNumberOfOffSprings(1);
		setPregnancyPerYear(1);

	}

	@Override
	public void sayGreeting() {

		System.out.println("I will work harder!");
	}

	public static int getCount() {

		return count;
	}

	public static int decrementCount() {

		return count -= 1;
	}

}
