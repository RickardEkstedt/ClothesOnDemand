package com.wigellkoncernen;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static OrderService orderService = OrderService.getInstance();

    public static void main(String[] args) {
        CEO ceo = new CEO(1, "Wigell");
        orderService.addObserver(ceo);


        Customer customer = new Customer();

        System.out.print("Vänligen ange ditt namn: ");
        String customerName = scanner.nextLine();
        customer.setName(customerName);

        boolean shopping = true;

        while (shopping) {
            System.out.println("\nVälkommen till Wigellkoncernens klädshop, " + customer.getName() + "!");
            System.out.println("Välj ett plagg att beställa:");
            System.out.println("1. Byxor");
            System.out.println("2. T-shirt");
            System.out.println("3. Kjol");
            System.out.println("4. Visa aktuella beställningar");
            System.out.println("5. Avsluta beställningen");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    orderPants(customer);
                    break;
                case 2:
                    orderTShirt(customer);
                    break;
                case 3:
                    orderSkirt(customer);
                    break;
                case 4:
                    displayCurrentOrders();
                    break;
                case 5:
                    shopping = false;
                    break;
                default:
                    System.out.println("Ogiltigt val. Vänligen välj igen.");
            }
        }

        System.out.println("\nTack för din beställning! Här är en sammanfattning av dina beställningar:");
        orderService.displayOrders();
    }

    private static void orderPants(Customer customer) {
        PantsBuilder pantsBuilder = new PantsBuilder();

        // Ställ in storlek, material och färg
        pantsBuilder.setSize()
                .setMaterial()
                .setColor();

        System.out.println("Välj passform:");
        System.out.println("1. Slim Fit");
        System.out.println("2. Regular Fit");
        System.out.println("3. Loose Fit");

        int fitChoice = getIntInput();

        switch (fitChoice) {
            case 1:
                pantsBuilder.setSlimFit();
                break;
            case 2:
                pantsBuilder.setRegularFit();
                break;
            case 3:
                pantsBuilder.setLooseFit();
                break;
            default:
                System.out.println("Ogiltigt val. Passform kommer att sättas till standardalternativ.");
        }

        System.out.println("Välj längd:");
        System.out.println("1. Short");
        System.out.println("2. Regular");
        System.out.println("3. Long");

        int lengthChoice = getIntInput();

        switch (lengthChoice) {
            case 1:
                pantsBuilder.setShortLength();
                break;
            case 2:
                pantsBuilder.setRegularLength();
                break;
            case 3:
                pantsBuilder.setLongLength();
                break;
            default:
                System.out.println("Ogiltigt val. Längd kommer att sättas till standardalternativ.");
        }

        // Byxorna skapas och läggs till i beställningen
        Pants pants = pantsBuilder.build();
        customer.addOrder(pants);

        // Därefter noteras att plagg är klart för leverans
        orderService.placeOrder(pants, true, true);


        // Skriv ut detaljerna för byxorna
        String orderDetails = pants.getDetails();
        System.out.println("Detaljer för byxor:\n" + orderDetails);

        System.out.println("Byxor har lagts till i din beställning.");
        scanner.nextLine();
    }


    private static void orderTShirt(Customer customer) {
        TShirtBuilder tShirtBuilder = new TShirtBuilder();

        tShirtBuilder.setSize()
                .setMaterial()
                .setColor();

        System.out.println("Välj ärmlängd:");
        System.out.println("1. Short Sleeves");
        System.out.println("2. Half Sleeves");
        System.out.println("3. Long Sleeves");

        int sleevesChoice = getIntInput();

        switch (sleevesChoice) {
            case 1:
                tShirtBuilder.setShortSleeves();
                break;
            case 2:
                tShirtBuilder.setHalfSleeves();
                break;
            case 3:
                tShirtBuilder.setLongSleeves();
                break;
            default:
                System.out.println("Ogiltigt val. Ärmlängd kommer att sättas till standardalternativ.");
        }

        System.out.println("Välj halsringning:");
        System.out.println("1. Round Neck");
        System.out.println("2. V-Neck");
        System.out.println("3. Polo Neck");

        int neckChoice = getIntInput();

        switch (neckChoice) {
            case 1:
                tShirtBuilder.setRoundNeck();
                break;
            case 2:
                tShirtBuilder.setVNeck();
                break;
            case 3:
                tShirtBuilder.setPoloNeck();
                break;
            default:
                System.out.println("Ogiltigt val. Halsringning kommer att sättas till standardalternativ.");
        }

        TShirt tShirt = tShirtBuilder.build();
        customer.addOrder(tShirt);

        // Därefter noteras att plagg är klart för leverans
        orderService.placeOrder(tShirt, true, true);

        String orderDetails = tShirt.getDetails();
        System.out.println("Detaljer för tshirt:\n" + orderDetails);

        System.out.println("T-Shirt har lagts till i din beställning.");
        scanner.nextLine();

    }

    private static void orderSkirt(Customer customer) {
        SkirtBuilder skirtBuilder = new SkirtBuilder();

        skirtBuilder.setSize()
                .setMaterial()
                .setColor();

        System.out.println("Välj midjelängd:");
        System.out.println("1. High Waist");
        System.out.println("2. Medium Waist");
        System.out.println("3. Low Waist");

        int waistlineChoice = getIntInput();

        switch (waistlineChoice) {
            case 1:
                skirtBuilder.setHighWaist();
                break;
            case 2:
                skirtBuilder.setMediumWaist();
                break;
            case 3:
                skirtBuilder.setLowWaist();
                break;
            default:
                System.out.println("Ogiltigt val. Midjelängd kommer att sättas till standardalternativ.");
        }

        System.out.println("Välj mönster:");
        System.out.println("1. Floral");
        System.out.println("2. Striped");
        System.out.println("3. Polka Dot");

        int patternChoice = getIntInput();

        switch (patternChoice) {
            case 1:
                skirtBuilder.setFloralPattern();
                break;
            case 2:
                skirtBuilder.setStripedPattern();
                break;
            case 3:
                skirtBuilder.setPolkaDotPattern();
                break;
            default:
                System.out.println("Ogiltigt val. Mönster kommer att sättas till standardalternativ.");
        }


        Skirt skirt = skirtBuilder.build();
        customer.addOrder(skirt);

        // Därefter noteras att plagg är klart för leverans
        orderService.placeOrder(skirt, true, true);


        String orderDetails = skirt.getDetails();
        System.out.println("Detaljer för kjol:\n" + orderDetails);

        System.out.println("Kjol har lagts till i din beställning.");
        scanner.nextLine();

    }

    private static void displayCurrentOrders() {
        orderService.displayOrders();
    }


    private static int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Vänligen ange ett heltal.");
            scanner.next(); // Fångar upp oönskade inmatningar
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // Konsumera radbrytning
        return input;
    }
}