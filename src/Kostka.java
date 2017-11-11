import java.util.Random;

public class Kostka {

	public static void main(String[] args) {
		String roll = "4D100+10";
		diceRoll(roll);
	}
	
	static void diceRoll (String str) {
		int number = Integer.parseInt(Character.toString(str.charAt(0)));
		
		int diceKind = 0;
		int plus = 0;
		if (str.length() == 5) {
			diceKind = Integer.parseInt(Character.toString(str.charAt(2)));
			plus = Integer.parseInt(Character.toString(str.charAt(4)));
		} else if (str.length() == 6) {
			diceKind = Integer.parseInt(str.substring(2, 4));
			plus = Integer.parseInt(Character.toString(str.charAt(5)));
		} else {
			diceKind = Integer.parseInt(str.substring(2, 5));
			plus = Integer.parseInt(Character.toString(str.charAt(6)));
		}
		
		int sum = 0;
		Random r = new Random();
		for (int i = 1; i <= number; i++) {
			int result = (r.nextInt(diceKind + 1) + 1) + plus;
			System.out.println("Wynik " + i + " rzutu to: " + result + ".");
			sum += result;
		}
		System.out.println("Suma wszystkich rzutów to " + sum + ".");
	}
}
