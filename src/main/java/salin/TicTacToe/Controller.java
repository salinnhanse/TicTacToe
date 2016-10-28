package salin.TicTacToe;

import java.util.Scanner;

public class Controller {

	public static boolean isNumber(String s) {
		return s.matches("-?\\d+(\\.\\d+)?");
	}

	public static char getMenuCommand() {
		while (true) {
			Scanner reader = new Scanner(System.in);
			char input = reader.next().charAt(0);
			int key = Character.getNumericValue(input);	
			if (key > 0 && key < 4) {
				return input;
			}
			else {
				System.out.println("Thank you, come again.");
				break;
			}
		}
		return 'x';
	}

	public static String getGameCommand(Map map) {
		while (true) {
			Scanner reader = new Scanner(System.in);
			String input = reader.nextLine();
			if (input.equals("q") || input.equals("Q")) {
				return "Quit";
			}
			else if (isNumber(input)) {
				int key = Integer.parseInt(input);
				if (key > 0 && key < 10) {
					if (map.getCurrent(key) == "X" || map.getCurrent(key) == "O") {
						map.printMap();
						System.out.println("This space is occupied, please try again.");
						continue;
					}
					else {
						return input;
					}
				}
			}
			map.printMap();
			System.out.println("Oh no that's not what we are looking for.");
			System.out.println("Please try again.");
		}
	}
}