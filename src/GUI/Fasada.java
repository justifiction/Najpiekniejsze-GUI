package GUI;

import wszystko.FulfillmentCenter;
import wszystko.FulfillmentCenterContainer;
import wszystko.Item;

import java.util.List;

public class Fasada {
    public FulfillmentCenterContainer magazines;

    public Fasada(FulfillmentCenterContainer magazines) {
        this.magazines=magazines;
    }

    public void addProduct(int magazineindex, Item product) {
        magazines.getCenters().get(magazineindex).addProduct(product);
    }
    public List<FulfillmentCenter> getMagazinelist(){
        return magazines.getCenters();
    }
    public List<Item> getProductlist(int magazineindex){
        return magazines.getCenters().get(magazineindex).getLista();
    }
    public void sortbycurrentload(){
        magazines.sort();
    }


    public Item getProductfromindex(int magazineindex, int productindex){
     return magazines.getCenters().get(magazineindex).getLista().get(productindex);
    }

    public void deleteProduct(int magazineindex, int productindex){
        magazines.getCenters().get(magazineindex).removeProduct(getProductfromindex(magazineindex,productindex));
    }

}





