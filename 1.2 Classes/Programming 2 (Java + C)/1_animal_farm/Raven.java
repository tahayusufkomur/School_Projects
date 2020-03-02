
public class Raven extends Bird {
	private static int count = 0;
	

	public Raven(String name, int age) {
		super(name, age);
		count += 1;
		setNumberOfOffSprings(5);
		setPregnancyPerYear(1);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sayGreeting() {

		System.out.println("A happy country where\r\n" + "we poor animals shall rest forever!");
	}

	public static int getCount() {

		return count;
	}

	public static int decrementCount() {

		return count -= 1;
	}
}
