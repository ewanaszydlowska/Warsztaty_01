import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Zgadywanie_liczb {
	public static void main(String[] args) {
		guessNumber_2();
	}

	static void guessNumber() {
		Random r = new Random();
		int number = r.nextInt(100) + 1;
		Scanner sc = new Scanner(System.in);
		int i = 1;
		while (i > 0) {
			System.out.println("Zgadnij liczbę");

			while (!sc.hasNextInt()) {
				System.out.println("To nie jest liczba!");
				sc.next();
			}
			int guess = sc.nextInt();

			if (guess > number) {
				System.out.println("Za dużo!");
				continue;
			}
			if (guess < number) {
				System.out.println("Za mało!");
				continue;
			}
			if (guess == number) {
				System.out.println("Zgadłeś!");
				sc.close();
				return;
			}
			i++;
		}
		sc.close();
	}

	static void guessNumber_2() {
		Random r = new Random();
		int number = r.nextInt(100)+1;
		Scanner sc = new Scanner(System.in);
		int guess = -1;
		
		while (guess != number) {
			System.out.println("Zgadnij liczbę!");
			try {
				guess = sc.nextInt();
				if (number > guess) {
					System.out.println("Za mało!");
				}
				if (number < guess) {
					System.out.println("Za dużo!");
				}
			} catch (InputMismatchException e) {
				System.out.println("To nie jest liczba!");
				sc.next();
			}
		}
		System.out.println("Zgadłeś!");
		sc.close();
	}
}
