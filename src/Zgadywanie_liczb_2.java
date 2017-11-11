import java.util.Scanner;

public class Zgadywanie_liczb_2 {

	public static void main(String[] args) {
		guessNumber();
	}

	static void guessNumber() {
		System.out.println("Pomyśl liczbę od 0 do 1000,\na ja ją zgadnę w max. 10 próbach.");
		int min = 0;
		int max = 1000;
		Scanner sc = new Scanner(System.in);
		String result = "";
		int counter = 0;
				
		do {
		
			int guess = ((max - min) / 2) + min;
			System.out.println("Zgaduję " + guess + ". Jaki wynik?");
			
			result = sc.nextLine();
			if (result.equals("Za dużo")) {
				max = guess;
			}
			if (result.equals("Za mało")) {
				min = guess;
			}
			if (counter >= 10) {
				System.out.println("Nie oszukuj!");
			}
			counter++;
				
		} while (!result.equals("Zgadłeś!")); {
			System.out.println("Wygrałem!");
			sc.close();
			return;
		
	}
}
}
