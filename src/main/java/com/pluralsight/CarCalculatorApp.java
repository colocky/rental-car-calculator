package com.pluralsight;

import java.util.Scanner;

public class CarCalculatorApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String pickupDate = getPickupDate(scanner);

        int rentalDays = getRentalDays(scanner);
        scanner.nextLine();

        boolean tollTag = getYesNo(scanner, "Electronic toll tag ($3.95/day)? (yes/no): ");
        boolean gps = getYesNo(scanner, "GPS ($2.95/day)? (yes/no): ");
        boolean roadside = getYesNo(scanner, "Roadside assistance ($3.95/day)? (yes/no): ");

        int age = getAge(scanner);
        scanner.nextLine();

        double basic = calculateBasic(rentalDays);
        double options = calculateOptions(rentalDays, tollTag, gps, roadside);
        double surcharge = calculateSurcharge(age, basic);
        double total = basic + options + surcharge;

        receipt(pickupDate, basic, options, surcharge, total);

        scanner.close();
    }

    public static String getPickupDate(Scanner scanner) {
        System.out.println("Pickup date:");
        return scanner.nextLine();
    }

    public static int getRentalDays(Scanner scanner) {
        System.out.println("Rental days:");
        return scanner.nextInt();
    }

    public static boolean getYesNo(Scanner scanner, String message) {
        System.out.println(message);
        return scanner.nextLine().trim().equalsIgnoreCase("yes");
    }

    public static int getAge(Scanner scanner) {
        System.out.println("Age:");
        return scanner.nextInt();
    }

    public static double calculateBasic(int days) {
        return days * 29.99;
    }

    public static double calculateOptions(int days, boolean toll, boolean gps, boolean roadside) {
        double cost = 0;
        if (toll) cost += 3.95 * days;
        if (gps) cost += 2.95 * days;
        if (roadside) cost += 3.95 * days;
        return cost;
    }

    public static double calculateSurcharge(int age, double basic) {
        return age < 25 ? basic * 0.30 : 0;
    }

    public static void receipt(String date, double basic, double options, double surcharge, double total) {
        System.out.println("\n--- Rental Summary ---");
        System.out.println("Date: " + date);
        System.out.println("Basic: $" + basic);
        System.out.println("Options: $" + options);
        System.out.println("Surcharge: $" + surcharge);
        System.out.println("Total: $" + total);
    }
}