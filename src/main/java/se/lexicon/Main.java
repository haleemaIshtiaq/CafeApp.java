package se.lexicon;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    String[] items = {"Espresso", "Cappuccino", "Latte", "Croissant", "Sandwich"};
    double[] price = {25.0, 35.0, 40.0, 30.0, 55.0};
    String name;

    public static String greetCustomer() {
        String name = IO.readln("Welcome! What is your name?");
        while(name.isEmpty()){
            IO.println("write your name");
            name = IO.readln("Welcome! What is your name?");
        }
        IO.println("Hi " + name + " ! Here is our menu:");
        return name;
    }


    public void showMenu() {
        IO.println("================================");
        IO.println("        Lexicon Cafe");
        IO.println("================================");
        for (int i = 0; i < items.length; i++) {
            //IO.println((i+1) + "." +items[i] +"\t\t\t" +price[i] + " SEK");
            IO.print(String.format("%-3d %-15s %6.2f SEK%n", i + 1, items[i], price[i]));
        }
        IO.println("================================");
    }


    public void takeOrder(Order order) {

        String loyalty = IO.readln("Loyalty member? (yes/no): ");
        while (!(loyalty.equalsIgnoreCase("yes")) && !(loyalty.equalsIgnoreCase("no"))) {
            IO.println("Invalid Input ! Kindly enter yes or no");
            loyalty = IO.readln("Loyalty member? (yes/no): ");
        }
        order.loyalty = loyalty;
        while (true) {
            int itemNumber = readInteger("Enter item number (1-5, or 0 to finish): ");


        while (itemNumber < 0 || itemNumber > 5) {
            IO.println("This number is not in the list");
            itemNumber = readInteger("Enter item number (1-5, or 0 to finish): ");
        }
            if (itemNumber == 0) {
                break;
            }
        int quantity = readInteger("How many? ");
        while (quantity <= 0) {
            IO.println("Quantity must be greater than zero. Try again");
            quantity = readInteger("How many? ");
        }

        order.name = name;
        LineItem item = new LineItem();
        item.itemName = items[itemNumber - 1];
        item.unitPrice = price[itemNumber - 1];
        item.quantity = quantity;
        order.addItem(item);
        IO.println(item.itemName + " added.");
    }
    }


    public int readInteger(String message) {
        while (true) {
            try {
                int number = Integer.parseInt(IO.readln(message));
                return number;
            } catch (NumberFormatException e) {
                IO.println("Invalid Input! Try again");
            }
        }
    }


    public void multipleCustomers(double firstCustomerBill) {
        int customersServed = 1;
        double totalRevenue = firstCustomerBill;
        while (true) {
            name = IO.readln("Next customer name (or 'done' to close): ");
            if (name.equalsIgnoreCase("done")) {
                break;
            }
            IO.println("Hi " + name + " ! Here is our menu:");
            showMenu();
            Order order = new Order();
            order.name = name;
            takeOrder(order);
            order.calculateSubTotal();
            order.calculateDiscount();
            order.calculateVAT();
            order.calculateTotal();
            order.printReceipt();
            double customerBill = order.total;
            totalRevenue = totalRevenue + customerBill;
            customersServed++;
        }
        IO.println("==================================");
        IO.println("      End of day report");
        IO.println("==================================");
        IO.println(String.format("%-17s : %s", "Customers served", +customersServed));
        //IO.println("Customers served: "+customersServed);
        IO.println(String.format("%-17s : %.2f SEK", "Total revenue", +totalRevenue));
        //IO.println(String.format("Total revenue: %.2f SEK", +totalRevenue));
        IO.println("==================================");

    }



    void main() {
        name = Main.greetCustomer();
        showMenu();

        Order order = new Order();
        order.name=name;
      takeOrder(order);

        order.calculateSubTotal();
        order.calculateDiscount();
        order.calculateVAT();
        order.calculateTotal();
        order.printReceipt();

        double firstCustomerBill = order.total;
     multipleCustomers(firstCustomerBill);
    }
}
