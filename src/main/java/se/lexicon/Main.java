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
     void main() {

     String name = Main.greetCustomer()    ;
     showMenu();
    }
}
