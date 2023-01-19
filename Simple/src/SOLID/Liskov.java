package SOLID;

public class Liskov {
    void execute(){
        DeliveryProcessor dp=new DeliveryProcessor();
        ShippingWeight shippingWeight=new Book();
        dp.calculateMaximumNumberOfItemsAllowed(shippingWeight);
    }
}
