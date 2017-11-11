import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Symulator_LOTTO {

	public static void main(String[] args) {
		simulator();
		
	}
	static void simulator() {
		
//-------------wprowadzenie liczb----------------------------
		Scanner sc = new Scanner(System.in); 
		Integer[] input = {0,0,0,0,0,0};
		int counter2 = 0;
		
		while (counter2 < 6) {
			System.out.println("Wprowadź liczbę");
			try {
				int number = sc.nextInt();
			
				if ((number > 49) || (number < 1)) {
					System.out.println("Liczba spoza zakresu!");
				} else if (contains(input, number)) {
					System.out.println("Ta liczba już została wybrana!");
				} else {
					input[counter2] = number;
					counter2++;
				}
			
			} catch (InputMismatchException e) {
				System.out.println("To nie jest liczba!");
				sc.next();
			}
		}
		sc.close();
		Arrays.sort(input);
		System.out.print("Liczby, które wybrałeś: ");
		System.out.println(Arrays.toString(input));
		
//------------------losowanie numerów------------------------
		Integer[] arr = new Integer[49];
		for (int j = 0; j < arr.length; j++) {
			arr[j] = j + 1;
		}
		Collections.shuffle(Arrays.asList(arr));
		Integer[] results = Arrays.copyOf(arr, 6);
		System.out.print("Wylosowane liczby: ");
		System.out.println(Arrays.toString(results));
		
		
//----------------porównanie wyników------------------------- WYDARZENIA REGULARNE samouczek jezyka java
		int counter = 0;
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < results.length; j++) {
				if (input[i] == results[j]) {
					counter++;
				}
			}
		}
		switch (counter) {
		case 3:
			System.out.println("Trafiłeś trójkę!");
			break;
		case 4:
			System.out.println("Trafiłeś czwórkę!");
			break;
		case 5:
			System.out.println("Trafiłeś piątkę!");
			break;
		case 6:
			System.out.println("Trafiłeś szóstkę!");
			break;
		default:
			System.out.println("Nic nie trafiłeś, powodzenia następnym razem!");
		}
	}

	static boolean contains(Integer[] tab, int number) {

		for (int elem : tab) {
			if (elem == number) {
				return true;
			}
		}
		return false;
	}
}

//import java.util.Arrays;
//import java.util.InputMismatchException;
//import java.util.Random;
//import java.util.Scanner;
//
//public class Test1 {
//
//	public static void main(String[] args) {
//		System.out.println(Arrays.toString(readNumbers()));
//		System.out.println(Arrays.toString(generateNumbers()));
//		checkResult(readNumbers(), generateNumbers());
//
//	}
//
//	static int[] readNumbers() {
//		int[] nums = new int[6];
//		int counter = 0;
//		int num;
//		Scanner scan = new Scanner(System.in);
//		while (counter < 6) {
//			System.out.println("podaj kolejna liczbe");
//			try {
//				num = scan.nextInt();
//				if ((num < 1) || (num > 49)) {
//					System.out.println("musisz podać liczbę z zakresu 1-49");
//				} else if (contains(nums, num)) {
//					System.out.println("ta liczba już istnieje, podaj inną");
//				} else {
//					nums[counter] = num;
//					counter++;
//				}
//			} catch (InputMismatchException e) {
//				System.out.println("to nie jest liczba");
//				scan.nextLine();
//			}
//		}
//		Arrays.sort(nums);
//		scan.close();
//		return nums;
//	}
//
//	static int[] generateNumbers() {
//		int[] nums = new int[6];
//		int counter = 0;
//		int num = 0;
//		Random random = new Random();
//		while (counter < 6) {
//			num = random.nextInt(49) + 1;
//			if (!Arrays.asList(nums).contains(nums)) {
//				nums[counter] = num;
//				counter++;
//			}
//		}
//		Arrays.sort(nums);
//		return nums;
//	}
//
//	static void checkResult(int[] numbers, int[] generated) {
//		int result = 0;
//		for (int el : numbers) {
//			if (contains(generated, el)) {
//				result++;
//			}
//		}
//		switch(result) {
//			case 3:
//				System.out.println("trafiłeś 3");
//				break;
//			case 4:
//				System.out.println("trafiłeś 3");
//				break;
//			case 5:
//				System.out.println("trafiłeś 5");
//				break;
//			case 6:
//				System.out.println("trafiłeś 6");
//				break;
//			default:
//				System.out.println("nic nie wygrałeś");
//		}
//	}	
//	
//	static boolean contains(int[] tab, int elem) {
//		for (int el : tab) {
//			if (el == elem) {
//				return true;
//			}
//		}
//		return false;
//	}
//
//}

		