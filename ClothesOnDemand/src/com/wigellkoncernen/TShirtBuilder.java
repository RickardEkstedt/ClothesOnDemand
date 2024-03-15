package com.wigellkoncernen;

import java.util.Scanner;

public class TShirtBuilder {

    private TShirt tShirt = new TShirt();
    private Scanner scanner = new Scanner(System.in);
    private CommandPipeline pipeline = new CommandPipeline();


    public TShirtBuilder setSize() {
        System.out.println("Välj storlek:");
        System.out.println("1. Small");
        System.out.println("2. Medium");

        int sizeChoice = getIntInput();

        if (sizeChoice == 1) {
            tShirt.setSize("small");
        } else if (sizeChoice == 2) {
            tShirt.setSize("medium");
        } else {
            System.out.println("Ogiltigt val. Storlek kommer att sättas till standardalternativ.");
        }

        return this;
    }

    public TShirtBuilder setMaterial() {
        System.out.println("Välj material:");
        System.out.println("1. Cotton");
        System.out.println("2. Denim");

        int materialChoice = getIntInput();

        if (materialChoice == 1) {
            tShirt.setMaterial("cotton");
        } else if (materialChoice == 2) {
            tShirt.setMaterial("denim");
        } else {
            System.out.println("Ogiltigt val. Material kommer att sättas till standardalternativ.");
        }

        return this;
    }

    public TShirtBuilder setColor() {
        System.out.println("Välj färg:");
        System.out.println("1. Blue");
        System.out.println("2. Black");

        int colorChoice = getIntInput();

        if (colorChoice == 1) {
            tShirt.setColor("blue");
        } else if (colorChoice == 2) {
            tShirt.setColor("black");
        } else {
            System.out.println("Ogiltigt val. Färg kommer att sättas till standardalternativ.");
        }

        return this;
    }


    public TShirtBuilder setShortSleeves() {
        pipeline.addCommand(new ShortSleevesCommand());
        return this;
    }

    public TShirtBuilder setHalfSleeves() {
        pipeline.addCommand(new HalfSleevesCommand());
        return this;
    }

    public TShirtBuilder setLongSleeves() {
        pipeline.addCommand(new LongSleevesCommand());
        return this;
    }

    public TShirtBuilder setRoundNeck() {
        pipeline.addCommand(new RoundNeckCommand());
        return this;
    }

    public TShirtBuilder setVNeck() {
        pipeline.addCommand(new VNeckCommand());
        return this;
    }

    public TShirtBuilder setPoloNeck() {
        pipeline.addCommand(new PoloNeckCommand());
        return this;
    }


    public TShirt build() {
        pipeline.executeAll();
        OrderService orderService = OrderService.getInstance();

        // Plagg tillverkas när byxorna har lagts till i kundens beställning
        orderService.placeOrder(tShirt, true, false); // isManufacturingComplete = true, isReadyForDelivery = false


        return tShirt;
    }

    private int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Vänligen ange ett heltal.");
            scanner.next(); // Fångar upp oönskade inmatningar
        }
        return scanner.nextInt();
    }


    // Kommandoklasser för TShirtBuilder
    private class ShortSleevesCommand implements ClothingCommand {
        @Override
        public void execute() {
            tShirt.setSleeves("Short sleeves");
        }
    }

    private class HalfSleevesCommand implements ClothingCommand {
        @Override
        public void execute() {
            tShirt.setSleeves("Half sleeves");
        }
    }

    private class LongSleevesCommand implements ClothingCommand {
        @Override
        public void execute() {
            tShirt.setSleeves("Long sleeves");
        }
    }

    private class RoundNeckCommand implements ClothingCommand {
        @Override
        public void execute() {
            tShirt.setNeck("Round neck");
        }
    }

    private class VNeckCommand implements ClothingCommand {
        @Override
        public void execute() {
            tShirt.setNeck("V-Neck");
        }
    }

    private class PoloNeckCommand implements ClothingCommand {
        @Override
        public void execute() {
            tShirt.setNeck("Polo Neck");
        }
    }
}