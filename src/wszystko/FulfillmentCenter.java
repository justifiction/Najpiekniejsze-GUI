package wszystko;

import java.util.ArrayList;
import java.util.List;

public class FulfillmentCenter {
    String storage_name;
    String storage_place;
    List<Item> lista;
    double storage_capacity;
    public double temp_capacity;
    double current_fill;

    public List<Item> getLista() {
        return lista;
    }

    public FulfillmentCenter(String storage_name, String storage_place, double storage_capacity) {
        this.storage_capacity=storage_capacity;
        this.storage_place=storage_place;
        this.storage_name=storage_name;
        lista=new ArrayList<>();
    }
    public String getStorage_name() {
        return storage_name;
    }
    public String getStorage_place() {
        return storage_place;
    }
    public double getStorage_capacity() {
        return storage_capacity;
    }

    public void setStorage_name(String storage_name) {
        this.storage_name = storage_name;
    }

    public void setStorage_place(String storage_place) {
        this.storage_place = storage_place;
    }

    public void setStorage_capacity(double storage_capacity) {
        this.storage_capacity = storage_capacity;
    }


    public void addProduct(Item product) {
        System.out.println("capacity1:" + storage_capacity + "temp1:" +temp_capacity);
        assert product != null;
        if (temp_capacity + product.mass > storage_capacity)
            System.err.println("Nie ma miejsca w magazynie");
         else {
            lista.add(product);
            temp_capacity +=product.mass;
            current_fill=(temp_capacity/storage_capacity)*100;
        }
        System.out.println("capacity:" + storage_capacity + "temp:"+temp_capacity);
    }

    public void removeProduct(Item product){
        if(product!=null){
            System.out.println("usuwaniecapacity1:" + storage_capacity + "temp1:" +temp_capacity);
            lista.remove(product);
            temp_capacity-=product.mass;
            current_fill=(temp_capacity/storage_capacity)*100;
            System.out.println("Product deleted");
            System.out.println("pousunieciucapacity1:" + storage_capacity + "temp1:" +temp_capacity);
        }
    }
    public List<Item> filterByState(SaleState state){
        List<Item> newlist=new ArrayList();
        for(Item item: lista){
            if(item.getState().equals(state))
                newlist.add(item);
        }
        System.out.println(newlist);
        if(newlist.isEmpty())
            System.out.println("Nie ma takich produktow");
        return newlist;
    }




    public List<Item> filterByProduct(String name){
        List<Item> newlist=new ArrayList();
        for(Item item: lista){
            if(item.getName().equals(name))
                newlist.add(item);
        }
        System.out.println(newlist);
        if(newlist.isEmpty())
            System.out.println("Nie ma takiego produktu");
        return newlist;
    }

     //   double current_fill=(temp_capacity/storage_capacity)*100;


    public void summary(){
        System.out.println("Name of the magazine: "+storage_name);
        System.out.println("Place of the magazine: "+storage_place);
        System.out.println("Max capacity of the magazine: "+storage_capacity);
        System.out.println("How full is the magazine right now: "+ current_fill +" %");
    }


}
