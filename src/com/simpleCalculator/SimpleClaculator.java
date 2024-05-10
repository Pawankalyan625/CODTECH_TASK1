package com.simpleCalculator;

import java.util.Scanner;

class Rainbow {

	// ANSI escape codes for colors
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_PRUPLE = "\u001B[35m";
	public static final String ANSI_BLUE = "\u001B[36m";
	public static final String ANSI_BOLD = "\u001B[1m"; // Bold text
	public static final String ANSI_BG_BLUE = "\u001B[48;5;12m"; // Background color blue

}

class MathOperations {

	Rainbow r = new Rainbow();
	Scanner sc = new Scanner(System.in);

	public void mathOperation(int operation) {
		boolean flag = true;
		while (flag) {
			try {
				System.out.print(r.ANSI_YELLOW + "\nEnter Number_1: " + r.ANSI_RESET);
				int num1 = sc.nextInt();
				System.out.print(r.ANSI_YELLOW + "Enter Number_2: " + r.ANSI_RESET);
				int num2 = sc.nextInt();

				double result;
				String operationName = "";

				switch (operation) {
				case 1:
					result = num1 + num2;
					operationName = "Addition";
					break;
				case 2:
					result = num1 - num2;
					operationName = "Subtraction";
					break;
				case 3:
					result = num1 * num2;
					operationName = "Multiplication";
					break;
				case 4:
					if (num2 == 0) {
						System.out.println(r.ANSI_RED + "Error: Division by zero!" + r.ANSI_RESET);
						continue;
					}
					result = num1 / (double) num2;
					operationName = "Division";
					break;
				default:
					System.out.println("Invalid Operation");
					return;
				}

				String box = operationName + " Result: " + result;
				String border = "+";
				for (int i = 0; i < box.length() + 2; i++) {
					border += "-";
				}
				border += "+";

				// Print the result box
				System.out.println(border);
				System.out.println("| " + r.ANSI_GREEN + r.ANSI_BOLD + box + r.ANSI_RESET + " |");
				System.out.println(border);
				System.out.println();
				System.out.println(r.ANSI_YELLOW + "Do you want to perform another " + operationName.toLowerCase() + " "
						+ r.ANSI_GREEN + "YES" + r.ANSI_RESET + "/" + r.ANSI_RED + "NO" + r.ANSI_RESET);
				String input = sc.next();
				if (!input.equalsIgnoreCase("yes")) {
					flag = false;
				}
			} catch (Exception e) {
				System.out.println(r.ANSI_RED + "Invalid Input, please try again." + r.ANSI_RESET);
				sc.nextLine(); // Consume the invalid input
			}
		}
	}

}


class SimpleCalculator {

	private static void advancedCalculator() {

		Rainbow r = new Rainbow();
		boolean flag = true;
		while (flag) {
			Scanner sc = new Scanner(System.in);
			MathOperations operation = new MathOperations();

			System.out.println("1." + r.ANSI_YELLOW + "ADDITION" + r.ANSI_RESET);
			System.out.println("2." + r.ANSI_GREEN + "SUBTRACTION" + r.ANSI_RESET);
			System.out.println("3." + r.ANSI_BLUE + "MULTIPLICATION" + r.ANSI_RESET);
			System.out.println("4." + r.ANSI_PRUPLE + "DIVISION" + r.ANSI_RESET);
			System.out.println("5." + r.ANSI_RED + "EXIT" + r.ANSI_RESET);
			System.out.println(r.ANSI_BG_BLUE + "Enter Your choice :" + r.ANSI_RESET);
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				operation.mathOperation(choice);
				break;
			}
			case 2: {

				operation.mathOperation(choice);
				break;
			}
			case 3: {
				operation.mathOperation(choice);
				break;
			}
			case 4: {
				operation.mathOperation(choice);
				break;
			}

			case 5: {
				System.out.println(r.ANSI_YELLOW + "Do you want to close the Application " + r.ANSI_GREEN + r.ANSI_BOLD
						+ "Yes" + r.ANSI_RESET + r.ANSI_BOLD + "/" + r.ANSI_RED + "No" + r.ANSI_RESET);
				String s = sc.next().toLowerCase();
				System.out.println();
				if (s.equals("no")) {
					advancedCalculator();
				} else {
					flag = false;
					System.out.println(r.ANSI_BLUE + "Happy Coding\nConnection closed restart again." + r.ANSI_RESET);
					System.exit(0);
				}
			}
			default:
				System.out.println(r.ANSI_RED + "Selected option is not available please select again." + r.ANSI_RESET);

			}
		}
		System.exit(0);
	}

	public static void main(String[] args) {
		Rainbow r = new Rainbow();
		System.out.println(r.ANSI_BG_BLUE + r.ANSI_BOLD + "WElCOME TO ADVANCED CALCULATOR..." + r.ANSI_RESET);
		advancedCalculator();
	}

}