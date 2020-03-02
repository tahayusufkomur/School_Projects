
public class Sheep extends Mammal {
	private static int count = 0;

	public Sheep(String name, int age) {
		super(name, age);
		count += 1;
		setNumberOfOffSprings(4);
		setPregnancyPerYear(1);
	}

	@Override
	public void sayGreeting() {

		System.out.println("Four legs good, two legs better!");
	}

	public static int getCount() {

		return count;
	}

	public static int decrementCount() {

		return count -= 1;
	}
}
