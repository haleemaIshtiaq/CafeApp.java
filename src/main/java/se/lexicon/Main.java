package se.lexicon;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static String greetCustomer(){
        String name = IO.readln("Welcome! What is your name?");
        IO.println("Hi " +name +" ! Here is our menu:");
        return name;
    }
     void main() {

     String name = Main.greetCustomer()    ;

    }
}
