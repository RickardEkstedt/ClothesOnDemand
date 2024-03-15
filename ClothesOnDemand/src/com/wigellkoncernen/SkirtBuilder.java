package com.wigellkoncernen;
import java.util.Scanner;


public class SkirtBuilder  {

    private Skirt skirt = new Skirt();
    private Scanner scanner = new Scanner(System.in);
    private CommandPipeline pipeline = new CommandPipeline();



    public SkirtBuilder setSize() {
        System.out.println("Välj storlek:");
        System.out.println("1. Small");
        System.out.println("2. Medium");

        int sizeChoice = getIntInput();

        if (sizeChoice == 1) {
            skirt.setSize("small");
        } else if (sizeChoice == 2) {
            skirt.setSize("medium");
        } else {
            System.out.println("Ogiltigt val. Storlek kommer att sättas till standardalternativ.");
        }

        return this;
    }

    public SkirtBuilder setMaterial() {
        System.out.println("Välj material:");
        System.out.println("1. Cotton");
        System.out.println("2. Denim");

        int materialChoice = getIntInput();

        if (materialChoice == 1) {
            skirt.setMaterial("cotton");
        } else if (materialChoice == 2) {
            skirt.setMaterial("denim");
        } else {
            System.out.println("Ogiltigt val. Material kommer att sättas till standardalternativ.");
        }

        return this;
    }

    public SkirtBuilder setColor() {
        System.out.println("Välj färg:");
        System.out.println("1. Blue");
        System.out.println("2. Black");

        int colorChoice = getIntInput();

        if (colorChoice == 1) {
            skirt.setColor("blue");
        } else if (colorChoice == 2) {
            skirt.setColor("black");
        } else {
            System.out.println("Ogiltigt val. Färg kommer att sättas till standardalternativ.");
        }

        return this;
    }

    public SkirtBuilder setHighWaist() {
        pipeline.addCommand(new HighWaistCommand());
        return this;
    }

    public SkirtBuilder setMediumWaist() {
        pipeline.addCommand(new MediumWaistCommand());
        return this;
    }

    public SkirtBuilder setLowWaist() {
        pipeline.addCommand(new LowWaistCommand());
        return this;
    }

    public SkirtBuilder setFloralPattern() {
        pipeline.addCommand(new FloralPatternCommand());
        return this;
    }

    public SkirtBuilder setStripedPattern() {
        pipeline.addCommand(new StripedPatternCommand());
        return this;
    }

    public SkirtBuilder setPolkaDotPattern() {
        pipeline.addCommand(new PolkaDotPatternCommand());
        return this;
    }

    public Skirt build() {
        pipeline.executeAll();
        OrderService orderService = OrderService.getInstance();

        // Plagg tillverkas när byxorna har lagts till i kundens beställning
        orderService.placeOrder(skirt, true, false); // isManufacturingComplete = true, isReadyForDelivery = false


        return skirt;
    }

    private int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Vänligen ange ett heltal.");
            scanner.next(); // Fångar upp oönskade inmatningar
        }
        return scanner.nextInt();
    }

    private class HighWaistCommand implements ClothingCommand {
        @Override
        public void execute() {
            skirt.setWaistline("High Waist");
        }
    }

    private class MediumWaistCommand implements ClothingCommand {
        @Override
        public void execute() {
            skirt.setWaistline("Medium Waist");
        }
    }

    private class LowWaistCommand implements ClothingCommand {
        @Override
        public void execute() {
            skirt.setWaistline("Low Waist");
        }
    }

    private class FloralPatternCommand implements ClothingCommand {
        @Override
        public void execute() {
            skirt.setPattern("Floral");
        }
    }

    private class StripedPatternCommand implements ClothingCommand {
        @Override
        public void execute() {
            skirt.setPattern("Striped");
        }
    }

    private class PolkaDotPatternCommand implements ClothingCommand {
        @Override
        public void execute() {
            skirt.setPattern("Polka Dot");
        }
    }
}