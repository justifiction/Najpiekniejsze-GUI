package wszystko;

import java.util.*;


public class FulfillmentCenterContainer {

    public List<FulfillmentCenter> Centers = new ArrayList(); //kluczem jest nazwa magazynu

    public List<FulfillmentCenter> getCenters() {
        return Centers;
    }

    public FulfillmentCenter addCenter(FulfillmentCenter f1){
        Centers.add(f1);
        System.out.println(" cneter added");
        return f1;
    }
    public void removeCenter(String storage_name){
        Centers.remove(storage_name);
        System.out.println(" cneter removed");
    }
    public void summary()   {
        System.out.println("List of all magazines:");
        for(FulfillmentCenter center : Centers)
            center.summary();
    }


    public void sort(){
        Centers.sort(Comparator.comparing(a -> a.current_fill));
        for(FulfillmentCenter center: Centers)
            center.summary();
    }

}
