package se.lexicon;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

String[] items = {"Espresso", "Cappuccino" , "Latte", "Croissant","Sandwich"};
double[] price = {25.0, 35.0, 40.0, 30.0, 55.0};
    public static String greetCustomer(){
        String name = IO.readln("Welcome! What is your name?");
        IO.println("Hi " +name +" ! Here is our menu:");
        return name;
    }
    public void showMenu(){
        IO.println("================================");
        IO.println("        Lexicon Cafe");
        IO.println("================================");
        for(int i=0;i < items.length;i++){
            //IO.println((i+1) + "." +items[i] +"\t\t\t" +price[i] + " SEK");
            IO.print(String.format("%-3d %-15s %6.2f SEK%n",i+1,items[i], price[i]));
        }
        IO.println("================================");
    }

    public void takeOrder(){
        int itemNumber = Integer.parseInt(IO.readln("Enter item number (1-5): "));
        if(itemNumber<0 || itemNumber>5){
            IO.println("THis number is not in the list");
        }
        else {
            int quantity = Integer.parseInt(IO.readln("How many? "));
            double unitPrice= price[itemNumber-1];
            double subTotal = unitPrice*quantity;
            IO.println("Subtotal: " +subTotal +" SEK");
            String loyalty = IO.readln("Loyalty member? (yes/no): ");
            if(loyalty.equalsIgnoreCase("yes")||loyalty.equalsIgnoreCase("no")){
                double discount=calculateDiscount(subTotal, loyalty);
                double totalAfterDiscount = subTotal - discount;
                IO.println(discount);
                IO.println(totalAfterDiscount);
            }
            else{
                IO.println("Invalid Input!");
            }
        }
    }
    public double calculateDiscount(double subTotal, String loyalty){
        if (loyalty.equalsIgnoreCase("yes")) {
            return subTotal * 0.15;
        }
        else if(subTotal>150){
            return subTotal * 0.10;
        }
        else{
            return 0;
        }
    }
     void main() {

     String name = Main.greetCustomer()    ;
     showMenu();
     takeOrder();
    }
}
