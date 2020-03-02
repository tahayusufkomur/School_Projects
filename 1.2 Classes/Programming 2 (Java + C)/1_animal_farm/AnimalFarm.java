//Taha Yusuf Kömür 150114064
//Its where we all save our array datas, animals.
import java.util.*;

public class AnimalFarm {

	public ArrayList<Animal> animalList = new ArrayList<Animal>();
	private ArrayList<String> animalNames = new ArrayList<String>();
	int CAPACITY;
	private static int numberOfAnimals = 0;

	public AnimalFarm(int capacity) {
		this.CAPACITY = capacity;
	}

	public int getNumberOfAnimals() {
		return numberOfAnimals;

	}

	public boolean addAnimal(Animal animal) throws IllegalNameException {
		boolean equaler = true;
		
		//I'm checking if there is an animal whose name is same with input

		for (int i = 0; i < animalList.size(); i++) {
			if (animalList.get(i).getName().equals(animal.getName()) || CAPACITY <= animalList.size()) {
				equaler = false;

				throw new IllegalNameException("You can't add an animal with this name which already exists");

			}

		}
		if (equaler)
			return animalList.add(animal) && animalNames.add(animal.getName());
		return equaler;

	}

	public boolean removeAnimal(String name) {

		for (int i = 0; i < animalList.size(); i++) {

			if (animalList.get(i).getName().equals(name)) {
				animalList.remove(i);

				break;
			}

		}
		return false;

	}

	public void printAllAnimalGreetings() {
//Taking all animals of the list and methoding them
		for (int i = 0; i < animalNames.size(); i++) {

			printOneAnimalGreeting(animalList.get(i));

		}

	}

	
	public void printOneAnimalGreeting(Animal animal) {
		animal.sayGreeting();
	}

	public void printAllAnimalNames() {

		System.out.println(animalNames);
	}

	public void printOneAnimalName(Animal animal) {
		System.out.println(animal.getName());
	}

	public void printAllAnimals() {
//Taking animals from animallist and tostringing them
		System.out.println(animalList.toString());
	}

	public int nextYearPopulationForecast() {
	
		return 0; // Calculations
	}

	public void animalMovements() {
//using for loop to take all animals from the list		
		for(int i=0; i<animalList.size(); i++) {
			
			animalList.get(i).movements();
			
		}
		
	}

	public void eatingHabits() {
		
		
		for(int i=0; i<animalList.size(); i++) {
			animalList.get(i).toString();          
			animalList.get(i).eatinghabits();
	 
		}
	}

	public void sortAlphabetically() {

		java.util.Collections.sort(animalNames);
	}

	public void sortBasedOnLegNumber() {

		for (int i = 1; i < animalList.size(); i++) {

			if(animalList.get(i).getLegNumber()>animalList.get(i-1).getLegNumber()) { 
				
				System.out.println(animalList.get(i));
				
			}

		}

	}
	
	

	public void sortBasedOnAge() {

	}

	public void searchBasedOnName(String name) {

		for (int i = 0; i < animalList.size(); i++) {

			if (animalNames.get(i).equals(name)) {

				System.out.println(animalList.get(i).toString());
			}
		}

	}

	public void searchBasedOnAge(int age) {
		for (int i = 0; i < animalList.size(); i++) {
			 int a = animalList.get(i).getAge();
			 
			 if(a == age) {
				 
				 System.out.println(animalList.get(i));
			 }
			

			

		}
	}
	
}