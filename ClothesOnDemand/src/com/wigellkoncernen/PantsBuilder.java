package com.wigellkoncernen;

import java.util.Scanner;

public class PantsBuilder {

    private Pants pants = new Pants();
    private Scanner scanner = new Scanner(System.in);
    private CommandPipeline pipeline = new CommandPipeline();


    public PantsBuilder setSize() {
        System.out.println("Välj storlek:");
        System.out.println("1. Small");
        System.out.println("2. Medium");

        int sizeChoice = getIntInput();

        if (sizeChoice == 1) {
            pants.setSize("small");
        } else if (sizeChoice == 2) {
            pants.setSize("medium");
        } else {
            System.out.println("Ogiltigt val. Storlek kommer att sättas till standardalternativ.");
        }

        return this;
    }

    public PantsBuilder setMaterial() {
        System.out.println("Välj material:");
        System.out.println("1. Cotton");
        System.out.println("2. Denim");

        int materialChoice = getIntInput();

        if (materialChoice == 1) {
            pants.setMaterial("cotton");
        } else if (materialChoice == 2) {
            pants.setMaterial("denim");
        } else {
            System.out.println("Ogiltigt val. Material kommer att sättas till standardalternativ.");
        }

        return this;
    }

    public PantsBuilder setColor() {
        System.out.println("Välj färg:");
        System.out.println("1. Blue");
        System.out.println("2. Black");

        int colorChoice = getIntInput();

        if (colorChoice == 1) {
            pants.setColor("blue");
        } else if (colorChoice == 2) {
            pants.setColor("black");
        } else {
            System.out.println("Ogiltigt val. Färg kommer att sättas till standardalternativ.");
        }

        return this;
    }

    public PantsBuilder setSlimFit() {
        pipeline.addCommand(new SlimFitCommand());
        return this;
    }

    public PantsBuilder setRegularFit() {
        pipeline.addCommand(new RegularFitCommand());
        return this;
    }

    public PantsBuilder setLooseFit() {
        pipeline.addCommand(new LooseFitCommand());
        return this;
    }

    public PantsBuilder setShortLength() {
        pipeline.addCommand(new ShortLengthCommand());
        return this;
    }

    public PantsBuilder setRegularLength() {
        pipeline.addCommand(new RegularLengthCommand());
        return this;
    }

    public PantsBuilder setLongLength() {
        pipeline.addCommand(new LongLengthCommand());
        return this;
    }


    public Pants build() {
        pipeline.executeAll(); // Execute commands for fit and length
        OrderService orderService = OrderService.getInstance();

        // Plagg tillverkas när byxorna har skapats
        orderService.placeOrder(pants, true, false); // Tillverkningen är klar, men inte redo för leverans

        return pants;
    }

    private int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Vänligen ange ett heltal.");
            scanner.next(); // Fångar upp oönskade inmatningar
        }
        return scanner.nextInt();
    }

    private class SlimFitCommand implements ClothingCommand {
        @Override
        public void execute() {
            pants.setFit("Slim Fit");
        }
    }

    private class RegularFitCommand implements ClothingCommand {
        @Override
        public void execute() {
            pants.setFit("Regular Fit");
        }
    }

    private class LooseFitCommand implements ClothingCommand {
        @Override
        public void execute() {
            pants.setFit("Loose Fit");
        }
    }

    private class ShortLengthCommand implements ClothingCommand {
        @Override
        public void execute() {
            pants.setLength("Short");
        }
    }

    private class RegularLengthCommand implements ClothingCommand {
        @Override
        public void execute() {
            pants.setLength("Regular");
        }
    }

    private class LongLengthCommand implements ClothingCommand {
        @Override
        public void execute() {
            pants.setLength("Long");
        }
    }
}