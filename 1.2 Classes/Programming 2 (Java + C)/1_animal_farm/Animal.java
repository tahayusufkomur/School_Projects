
public class Animal {
//Constructors
	private String name;
	private int legNumber, age, pregnancyPerYear, numberOfOffSprings;

	public Animal(String name, int age) {

		this.name = name;
		this.age = age;
	}
	
	public void movements() {
		System.out.println("");
	}
	public void sayGreeting() {

		System.out.println("Have nothing to say!");

	}

	public void reProduce() {
		System.out.println("None of your businnes!");

	}

	// Getters
	public String getName() {
		return name;
	}

	public int getLegNumber() {

		return legNumber;
	}

	public int getAge() {
		return age;

	}

	public int getPregnancyPerYear() {

		return pregnancyPerYear;
	}

	public int getNumberOfOffSprings() {

		return numberOfOffSprings;
	}

	
	//Setters
	
	public void setLegNumber(int legNumber) {

		this.legNumber = legNumber;
	}

	public void setPregnancyPerYear(int PregnancyPerYear) {

		this.pregnancyPerYear = PregnancyPerYear;
	}

	public void setNumberOfOffSprings(int OffSprings) {

		this.numberOfOffSprings = OffSprings;
	}
	
	public void eatinghabits() {
		
	}

	@Override
	public String toString() {

		return "My name is " + this.name + "		" + "I'm " + this.age + " years old!" + "I have " + this.legNumber
				+ " legs!";
	}
}
