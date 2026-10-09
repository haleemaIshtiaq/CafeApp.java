package se.lexicon;

public class Order {
    String name;
    String itemName;
    int quantity;
    double unitPrice;
    String loyalty;

    double subTotal;
    double discount;
    double vat;
    double total;

    public void calculateSubTotal() {
         subTotal = unitPrice * quantity;
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
        IO.println(String.format("%-10s : %s x %d", "Item", itemName, quantity));
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
