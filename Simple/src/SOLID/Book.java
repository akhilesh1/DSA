package SOLID;

public class Book implements Product,ShippingWeight {

    public int getShippingWeightInGrams() {
        return 100;
    }
}


