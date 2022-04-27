package MyTi;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

public class MyTi {

	private static double credit = 0.0;
	private static int choose;
	static Collection<String> purchasesCollection = new ArrayList<String>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		do {

			menu();
			if (choose == 1) {
				Buypass();
			} else if (choose == 2) {
				Charge();

			} else if (choose == 3) {
				Show_credit();

			} else if (choose == 4) {
				Output_purchases();
			} else if (choose == 0) {
				System.out.println("Quit");
			} else {
				System.out.println("Sorry, that is an invalid option!");
			}
		} while (choose != 0);

	}

	public static void menu() {

		Scanner input = new Scanner(System.in);

		System.out.println("1: Buy a travel pass");
		System.out.println("2: Charge my MyTi");
		System.out.println("3: Show remaining credit");
		System.out.println("4: Print purchases");
		System.out.println("0: Quit");
		System.out.print("Please make a selection:");

		choose = input.nextInt();

	}

	public static void Buypass() throws IOException {
		double Hour_Zone = 2.5;
		double Day_Zone = 4.9;
		double price = 0;
		double addprice = 0;
		double balance = 0;
		String timeString = null;
		String zoneString = null;
		String selecttime = null;
		String selectzone = null;
		boolean judgement = true;

		do {
			Scanner inselect = new Scanner(System.in);
			System.out.println("What time period:");
			System.out.println("a) 2 Hours");
			System.out.println("b) All Day");
			System.out.println("c) cancel");
			System.out.println("Your selection:");
			selecttime = inselect.next().toString();
			System.out.println(selecttime);
			if (selecttime.equals("a")) {
				price = Hour_Zone;
				timeString = "2 Hours";
				addprice = 1.0;
			} else if (selecttime.equals("b")) {
				price = Day_Zone;
				timeString = "All Day";
				addprice = 1.9;
			} else if (selecttime.equals("c")) {
				System.out.println("Cancel!");
				timeString = null;
				zoneString = null;
				selecttime = null;
				selectzone = null;
				judgement = true;
				break;
			} else {
				judgement = false;
				System.out.println("Sorry, that is an invalid option!");

			}
		} while (judgement == false);

		if (timeString != null) {
			do {
				Scanner iselect = new Scanner(System.in);
				System.out.println("What time period:");
				System.out.println("a) Zone 1");
				System.out.println("b) Zone 1 and 2");
				System.out.println("c) cancel");
				System.out.println("Your selection:");
				selectzone = iselect.next().toString();
				System.out.println(selecttime);

				if (selectzone.equals("a")) {
					zoneString = "Zone 1";
				} else if (selectzone.equals("b")) {
					price = addtion(price, addprice);
					zoneString = "Zone 1 and 2";
				} else if (selectzone.equals("c")) {
					System.out.println("Cancel!");
					timeString = null;
					zoneString = null;
					selecttime = null;
					selectzone = null;
					judgement = true;
					break;
				} else {
					System.out.println("Sorry, that is an invalid option!");
					judgement = false;
				}
			} while (judgement == false);

			BigDecimal creditBigDecimal = new BigDecimal(Double.toString(credit));
			BigDecimal priceBigDecimal = new BigDecimal(Double.toString(price));
			balance = creditBigDecimal.subtract(priceBigDecimal).doubleValue();
			if (balance >= 0 & timeString != null & zoneString != null) {
				String wordString = "You Purchased " + timeString + " pass for " + zoneString + ", cast $ " + price;
				System.out.println(wordString);
				System.out.println("Your remaining credit is $ " + balance);
				purchasesCollection.add(wordString);
				credit = balance;
				timeString = null;
				zoneString = null;
				selecttime = null;
				selectzone = null;
				judgement = true;
			} else if (balance < 0 & zoneString != null) {
				System.out.println(zoneString != null);
				System.out.println("Sorry, you don't have enough credit for that selection.");
			}
		}

	}
	
	public static double addtion(double num1, double num2) {
		BigDecimal firstBigDecimal = new BigDecimal(Double.toString(num1));
		BigDecimal secondBigDecimal = new BigDecimal(Double.toString(num2));
		double result = firstBigDecimal.add(secondBigDecimal).doubleValue();
		return result;
	}

	public static void Charge() {
		double incredit = 0;
		do {
			System.out.println("How much do you want to add:");
			Scanner inputnumber = new Scanner(System.in);
			incredit = inputnumber.nextDouble();
			if (incredit > 100) {
				System.out.println("Sorry, the max amount of credit allowed is $100.00");
			} else if (incredit % 5 != 0) {
				System.out.println("Sorry, you can only add multiples of $5.00");
			} else {
				credit = credit + incredit;
			}

		} while (incredit > 100 | incredit % 5 != 0);
	}

	public static void Show_credit() {
		System.out.println(credit);

	}

	public static void Output_purchases() {
		for (Iterator iterator = purchasesCollection.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
	}

}
