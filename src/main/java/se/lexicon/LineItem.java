package se.lexicon;

public class LineItem {

    String itemName;
    double unitPrice;
    int quantity;

    public double lineTotal(){
        return unitPrice * quantity;
    }
}
