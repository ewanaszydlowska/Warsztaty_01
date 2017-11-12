import java.util.Random;

public class Kostka {

	public static void main(String[] args) {
		String roll = "4D6+10";
		diceRoll(roll);
	}

	static void diceRoll(String str) {

		int sum = 0;
		try {
			
			int diceKind = 0;
			int add = 0;
			
			String[] tab = str.split("D");
			int number = Integer.parseInt(tab[0]);
			String str2 = tab[1];
			
			if (str2.contains("\\+")) {					//znak specjalny nie działa
				String[] tab2 = str2.split("\\+");
				diceKind = Integer.parseInt(tab2[0]);
				add = Integer.parseInt(tab2[1]);
				
			}
			else if (str2.contains("-")) {
				String[] tab2 = str2.split("-");
				diceKind = Integer.parseInt(tab2[0]);
				add = - (Integer.parseInt(tab2[1]));
			}
			else {
				diceKind = Integer.parseInt(str2);
			}
			
			Random r = new Random();
			for (int i = 1; i <= number; i++) {
				int result = (r.nextInt(diceKind) + 1) + add;
				System.out.println("Wynik " + i + " rzutu to: " + result + ".");
				sum += result;
			}
			System.out.println("Suma wszystkich rzutów to " + sum + ".");
		} catch (NumberFormatException e) {
			System.out.println("Zły format wprowadzonego kodu!");
		}

	}
}
