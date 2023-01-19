package SOLID;

public class DeliveryProcessor {

    private static final int MAX_WEIGHT = 10;

    public int calculateMaximumNumberOfItemsAllowed(ShippingWeight shippingWeight) {


        return MAX_WEIGHT / shippingWeight.getShippingWeightInGrams();
    }
}
