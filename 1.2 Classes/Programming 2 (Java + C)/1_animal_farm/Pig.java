
public class Pig extends Mammal {
	private static int count = 0;

	public Pig(String name, int age) {
		super(name, age);
		count += 1;
		setLegNumber(4);
		setNumberOfOffSprings(12);
		setPregnancyPerYear(2);
	}

	@Override
	public void sayGreeting() {

		System.out.println("All animals are equal, but some animals are more equal than others!");
	}

	public static int getCount() {

		return count;
	}

	public static int decrementCount() {

		return count -= 1;
	}
}
