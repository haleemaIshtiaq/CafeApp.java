package se.lexicon;
import java.util.ArrayList;
public class Order {
    ArrayList<LineItem> items = new ArrayList<>();
    String name;
    String loyalty;
    double subTotal;
    double discount;
    double vat;
    double total;

    public void addItem(LineItem item){
        items.add(item);
    }

    public void calculateSubTotal() {
         subTotal = 0;
         for(LineItem item : items){
             subTotal +=item.lineTotal();
         }

    }

    public void calculateDiscount() {
        if (loyalty.equalsIgnoreCase("yes")) {
            discount = subTotal * 0.15;
        } else if (subTotal > 150) {
            discount =  subTotal * 0.10;
        } else {
            discount = 0;
        }
    }

    public void calculateVAT() {
        vat = (subTotal - discount) * 0.12;

    }
    public void calculateTotal(){
        total = subTotal - discount + vat;
    }


    public void printReceipt() {
        IO.println("================================");
        IO.println("        Lexicon Cafe");
        IO.println("================================");
        IO.println(String.format("%-10s : %s", "Customer", name));
        IO.println("--------------------------------");

        for(LineItem item : items){
            IO.println(String.format(" %-17s x%-3d %6.2f SEK", item.itemName, item.quantity,item.lineTotal() ));
        }
        IO.println("--------------------------------");

       IO.println(String.format("%-10s : %.2f SEK", "Subtotal", subTotal));

        if (discount > 0) {
            IO.println(String.format("%-10s : %.2f SEK", "Discount", -discount));
        }
        IO.println(String.format("%-10s : %.2f SEK", "VAT", vat));


        IO.println("--------------------------------");
        IO.println(String.format("%-10s : %.2f SEK", "TOTAL", total));
        IO.println("================================");
        IO.println("   Thank you, " + name + "!");
        IO.println("   See you next time.");
        IO.println("================================");
    }
}
