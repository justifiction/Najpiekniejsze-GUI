package wszystko;

public class Main {
    public static void main(String[] args) {
        Item i1 = new Item("ja", SaleState.SPRZEDANY, 1);
        Item i2 = new Item("ty", SaleState.SPRZEDANY, 3);
        Item i3 = new Item("on", SaleState.W_MAGAZYNIE, 2);
        Item i4 = new Item("ona", SaleState.ZAMOWIONY, 5);
        FulfillmentCenterContainer c1 = new FulfillmentCenterContainer();
      FulfillmentCenter f1 = (new FulfillmentCenter("ludzie", "Czarzyzna", 100));
        FulfillmentCenter f2 = (new FulfillmentCenter("ludziee", "Czarzyznaa", 100));
        c1.addCenter(f1);
        c1.addCenter(f2);
        f1.addProduct(i1);
        System.out.println("product added... ");
        f1.addProduct(i2);
        System.out.println("product added... ");
        f1.addProduct(i3);
        f2.addProduct(i4);
        f1.filterByState(SaleState.SPRZEDANY);
        c1.sort();


    }
}
