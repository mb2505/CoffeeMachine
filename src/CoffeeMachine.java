import java.util.Scanner;

public class CoffeeMachine {

    private static int water = 400;
    private static int milk = 540;
    private static int coffeeBeans = 120;
    private static int cups = 9;
    private static int dollar = 550;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        enterAction();
    }

    private static void coffeeMachine() {
        System.out
                .printf("%nThe coffee machine has:%n")
                .printf("%d ml of water%n", water)
                .printf("%d ml of milk%n", milk)
                .printf("%d g of coffee beans%n", coffeeBeans)
                .printf("%d disposable cups%n", cups)
                .printf("$%d of money%n%n", dollar);
        enterAction();
    }

    private static void enterAction() {
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        String action = scanner.next();
        if ("buy".equals(action)) {
            System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
            String choice = scanner.next();
            if ("back".equals(choice)) {
                enterAction();
            } else {
                if (Integer.parseInt(choice) == 1) {
                    makeEspresso();
                    enterAction();
                } else if (Integer.parseInt(choice)  == 2) {
                    makeLatte();
                    enterAction();
                } else if (Integer.parseInt(choice)  == 3) {
                    makeCappuccino();
                    enterAction();
                }
            }
        } else if ("fill".equals(action)) {
            addIngredients();
            enterAction();
        } else if ("take".equals(action)) {
            giveMoney();
            enterAction();
        } else if ("remaining".equals(action)) {
            coffeeMachine();
        } else if ("exit".equals(action)) {
            System.exit(0);
        }
    }

    private static void makeEspresso() {
        if (water >= 250 && coffeeBeans >= 16 && cups >= 1) {
            System.out.println("I have enough resources, making you a espresso!\n");
            water -= 250;
            coffeeBeans -= 16;
            cups -= 1;
            dollar += 4;
        } else {
            System.out.println("I cant make you a espresso!\n");
            enterAction();
        }

    }

    private static void makeLatte() {
        if (water >= 350 && milk >= 75 && coffeeBeans >= 20  && cups >= 1) {
            System.out.println("I have enough resources, making you a latte!\n");
            water -= 350;
            milk -= 75;
            coffeeBeans -= 20;
            cups -= 1;
            dollar += 7;
        } else {
            System.out.println("I cant make you a latte!\n");
            enterAction();
        }
    }

    private static void makeCappuccino() {
        if (water >= 200 && milk >= 100 && coffeeBeans >= 12  && cups >= 1) {
            System.out.println("I have enough resources, making you a cappucino!\n");
            water -= 200;
            milk -= 100;
            coffeeBeans -= 12;
            cups -= 1;
            dollar += 6;
        } else {
            System.out.println("I cant make you a cappucino!\n");
            enterAction();
        }
    }

    private static void giveMoney() {
        System.out.printf("I gave you $%d%n%n", dollar);
        dollar = 0;
    }

    private static void addIngredients() {
        System.out.println("Write how many ml of water you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        coffeeBeans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        cups += scanner.nextInt();
    }
}
