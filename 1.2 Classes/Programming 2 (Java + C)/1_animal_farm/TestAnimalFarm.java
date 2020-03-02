//Taha Yusuf Kömür 150114064
// This is the program simulator, its allows you to create an animal farm and manage it.
import java.util.Scanner;

public class TestAnimalFarm {
//Ýllegal exception stuffs
	public static void main(String[] args) throws IllegalNameException {
		// TODO Auto-generated method stub

		System.out.println("Welcome to Animal Farm simulation program!");
		System.out.println("Please enter the capacity of the Animal Farm: ");

		Scanner input = new Scanner(System.in);
//Taking capacity as input
		int capacity = input.nextInt();
//creating an Animal Farm
		AnimalFarm AnimalFarm1 = new AnimalFarm(capacity);
//infinite for loop
		for (;;) {
//menu
			System.out.println("0 - Exit the program");
			System.out.println("1 - Add animal");
			System.out.println("2 - Remove animal");
			System.out.println("3 - Search animal");
			System.out.println("4 - Sort animals");
			System.out.println("5 - Calculate next year's population estimate");
			System.out.println("6 - Print all animals movements");
			System.out.println("7 - Print all animal's eating habits");
			System.out.println("8 - Print report");
			System.out.println("Please enter your choice");

			int choice = input.nextInt();

			switch (choice) {

			case 0:
				System.exit(0);

			case 1:
				System.out.println("Please enter your choice:");
				System.out.println("1 - Chicken");
				System.out.println("2 - Donkey");
				System.out.println("3 - Horse");
				System.out.println("4 - Pig");
				System.out.println("5 - Raven");
				System.out.println("6 - Sheep");

				int case1input = input.nextInt();
				switch (case1input) {

				case 1:
					System.out.println("Enter the name:");
					String nameofanimalincase1 = input.next();

					System.out.println("Enter the age:");
					int ageofanimalincase1 = input.nextInt();

					Animal nameofanimalincase11 = new Chicken(nameofanimalincase1, ageofanimalincase1);

					try {
						if (AnimalFarm1.addAnimal(nameofanimalincase11)) {
						}

					} catch (IllegalNameException ex) {
					}
					;

					break;

				case 2:
					System.out.println("Enter the name:");
					String nameofanimalincase2 = input.next();

					System.out.println("Enter the age:");
					int ageofanimalincase2 = input.nextInt();

					Animal nameofanimalincase22 = new Donkey(nameofanimalincase2, ageofanimalincase2);

					try {
						if (AnimalFarm1.addAnimal(nameofanimalincase22)) {
						}

					} catch (IllegalNameException ex) {
					}
					;
break;
				case 3: System.out.println("Enter the name:");
				String nameofanimalincase3 = input.next();

				System.out.println("Enter the age:");
				int ageofanimalincase3 = input.nextInt();

				Animal nameofanimalincase33 = new Horse(nameofanimalincase3, ageofanimalincase3);

				try {
					if (AnimalFarm1.addAnimal(nameofanimalincase33)) {
					}

				} catch (IllegalNameException ex) {
				}
				;
break;
				case 4: System.out.println("Enter the name:");
				String nameofanimalincase4 = input.next();

				System.out.println("Enter the age:");
				int ageofanimalincase4 = input.nextInt();

				Animal nameofanimalincase44 = new Pig(nameofanimalincase4, ageofanimalincase4);

				try {
					if (AnimalFarm1.addAnimal(nameofanimalincase44)) {
					}

				} catch (IllegalNameException ex) {
				}
				;
break;
				case 5:System.out.println("Enter the name:");
				String nameofanimalincase5 = input.next();

				System.out.println("Enter the age:");
				int ageofanimalincase5 = input.nextInt();

				Animal nameofanimalincase55 = new Raven(nameofanimalincase5, ageofanimalincase5);

				try {
					if (AnimalFarm1.addAnimal(nameofanimalincase55)) {
					}

				} catch (IllegalNameException ex) {
				}
				;
break;
				case 6: System.out.println("Enter the name:");
				String nameofanimalincase6 = input.next();

				System.out.println("Enter the age:");
				int ageofanimalincase6 = input.nextInt();

				Animal nameofanimalincase66 = new Sheep(nameofanimalincase6, ageofanimalincase6);

				try {
					if (AnimalFarm1.addAnimal(nameofanimalincase66)) {
					}

				} catch (IllegalNameException ex) {
				}
				;

				}

				break;
			case 2:

				String case2input = input.next();
				AnimalFarm1.removeAnimal(case2input);
				break;
			case 3:
				System.out.println("1 - Search based on name");
				System.out.println("2 - Search based on age");

				int case3choice = input.nextInt();
				String case3input = input.next();
				int case3intinput = input.nextInt();
				switch (case3choice) {

				case 1:
					System.out.println("Enter the name:");
					AnimalFarm1.searchBasedOnName(case3input);

					break;

				case 2:
					System.out.println("Enter the age:");
					AnimalFarm1.searchBasedOnAge(case3intinput);
				}
				break;

			case 4:
				System.out.println("1 - Sort based on name");
				System.out.println("2 - Sort based on leg number");
				System.out.println("3 - Sort based on age");
				System.out.println("4 - Sort based on addition date");
				
			int case4input = input.nextInt();
				
				switch(case4input) {
				case 1: AnimalFarm1.sortAlphabetically(); break;
				case 2: AnimalFarm1.sortBasedOnLegNumber();break;
				case 3: break;
				case 4: break;
				}
				break;

			case 5:
				//Calculating the estimated pop by manual ways . :)

				int ChickenPop;
				int DonkeyPop;
				int HorsePop;
				int PigPop;
				int RavenPop;
				int SheepPop;
				ChickenPop = (Chicken.getCount() * 200) + 1;
				DonkeyPop = (Donkey.getCount() * 1) + 1;
				HorsePop = (Horse.getCount() * 1) + 1;
				PigPop = (Pig.getCount() * 12 * 2) + 1;
				RavenPop = (Raven.getCount() * 5) + 1;
				SheepPop = (Sheep.getCount() * 1) + 1;

				int estimatedpop = ChickenPop + DonkeyPop + HorsePop + PigPop + RavenPop + SheepPop;

				System.out.println(estimatedpop);

				break;
			case 6: AnimalFarm1.animalMovements();

			case 7: AnimalFarm1.eatingHabits();

			case 8: break;

			}
		}
	}

}
