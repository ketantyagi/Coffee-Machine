package machine;
import java.util.Scanner;

public class CoffeeMachine {
    public Scanner scanner = new Scanner(System.in);

    public enum CoffeeStates {
        BUY("buy"),
        FILL("fill"),
        TAKE("take"),
        REMAINING("remaining"),
        EXIT("exit"),
        ESPRESSO("1"),
        LATTE("2"),
        CAPPUCCINO("3"),
        BACK("back");

        String state;

        CoffeeStates(String state) {
            this.state = state;
        }
    }


    String userInput;
    int waterInMachine = waterLevel(400, 0);
    int milkInMachine = milkLevel(540, 0);
    int beansInMachine = coffeeLevel(120, 0);
    int cupsInMachine = cupLevel(9, 0);
    int moneyInMachine = money(550, 0);
    boolean exit = false;

    public static int waterLevel(int current, int outlet) {
        return current + outlet;
    }

    public static int milkLevel(int current, int outlet) {
        return current + outlet;
    }

    public static int coffeeLevel(int current, int outlet) {
        return current + outlet;
    }

    public static int cupLevel(int current, int outlet) {
        return current + outlet;
    }

    public static int money(int current, int outlet) {
        return current + outlet;
    }

    public void CoffeeFill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add");
        int addedWater = scanner.nextInt();
        waterInMachine = waterLevel(waterInMachine, addedWater);
        System.out.println("Write how many ml of milk do you want to add:");
        int addedMilk = scanner.nextInt();
        milkInMachine = milkLevel(milkInMachine, addedMilk);
        System.out.println("Write how many grams of coffee beans do you want to add:");
        int addedCoffee = scanner.nextInt();
        beansInMachine = coffeeLevel(beansInMachine, addedCoffee);
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int addedCups = scanner.nextInt();
        cupsInMachine = cupLevel(cupsInMachine, addedCups);
    }

    public void CurrentStateOfMachine() {
        System.out.println("The Coffee Machine has: ");
        System.out.println(waterInMachine + " of water");
        System.out.println(milkInMachine + " of milk");
        System.out.println(beansInMachine + " of coffee beans");
        System.out.println(cupsInMachine + " of disposable cups");
        System.out.println("$" + moneyInMachine + " of money");
    }

    public void TakeMoney() {
        System.out.println("I gave you $" + moneyInMachine);
        moneyInMachine = money(moneyInMachine, -moneyInMachine);
    }

    public void BuyCoffee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String userChoice = scanner.next();
        if (userChoice.equals(CoffeeStates.ESPRESSO.state)) {
            if (waterInMachine < 250) {
                System.out.println("Sorry, not enough water!");
            } else if (beansInMachine < 16) {
                System.out.println("Sorry, not enough coffee!");
            } else if (cupsInMachine == 0) {
                System.out.println("Sorry, not enough cups!");
            } else {
                System.out.println("I have enough resources, making you a coffee!");
                waterInMachine = waterLevel(waterInMachine, -250);
                beansInMachine = coffeeLevel(beansInMachine, -16);
                cupsInMachine = cupLevel(cupsInMachine, -1);
                moneyInMachine = money(moneyInMachine, 4);
            }
        } else if (userChoice.equals(CoffeeStates.LATTE.state)) {
            if (waterInMachine < 350) {
                System.out.println("Sorry, not enough water!");
            } else if (milkInMachine < 75) {
                System.out.println("Sorry, not enough milk!");
            } else if (beansInMachine < 20) {
                System.out.println("Sorry, not enough coffee!");
            } else if (cupsInMachine == 0) {
                System.out.println("Sorry, not enough cups!");
            } else {
                System.out.println("I have enough resources, making you a coffee!");
                waterInMachine = waterLevel(waterInMachine, -350);
                milkInMachine = milkLevel(milkInMachine, -75);
                beansInMachine = coffeeLevel(beansInMachine, -20);
                cupsInMachine = cupLevel(cupsInMachine, -1);
                moneyInMachine = money(moneyInMachine, 7);
            }
        } else if (userChoice.equals(CoffeeStates.CAPPUCCINO.state)) {
            if (waterInMachine < 200) {
                System.out.println("Sorry, not enough water!");
            } else if (milkInMachine < 100) {
                System.out.println("Sorry, not enough milk!");
            } else if (beansInMachine < 12) {
                System.out.println("Sorry, not enough coffee!");
            } else if (cupsInMachine == 0) {
                System.out.println("Sorry, not enough cups!");
            } else {
                System.out.println("I have enough resources, making you a coffee!");
                waterInMachine = waterLevel(waterInMachine, -200);
                milkInMachine = milkLevel(milkInMachine, -100);
                beansInMachine = coffeeLevel(beansInMachine, -12);
                cupsInMachine = cupLevel(cupsInMachine, -1);
                moneyInMachine = money(moneyInMachine, 6);
            }
        } else if (userChoice.equals(CoffeeStates.BACK.state)) {
            userInput();
        }

    }

    public void userInput() {
        System.out.println("\nWrite action (buy, fill, take, remaining, exit)");
        String userChoice = scanner.next();
        if (userChoice.equals(CoffeeStates.FILL.state)) {
            CoffeeFill();
        } else if (userChoice.equals(CoffeeStates.TAKE.state)) {
            TakeMoney();
        } else if (userChoice.equals(CoffeeStates.REMAINING.state)) {
            CurrentStateOfMachine();
        } else if (userChoice.equals(CoffeeStates.BUY.state)) {
            BuyCoffee();
        } else if (userChoice.equals(CoffeeStates.EXIT.state)) {
            exit = true;
        }
    }


    public static void main(String[] args) {
        CoffeeMachine coffee = new CoffeeMachine();
        while (!coffee.exit) {
            coffee.userInput();
        }
    }
}


