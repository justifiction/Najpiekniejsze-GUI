package GUI;

import wszystko.FulfillmentCenterContainer;
import wszystko.Item;
import wszystko.FulfillmentCenter;


import static wszystko.SaleState.*;

public class DataGenerator {
    public static Fasada getMagazyny() {


        FulfillmentCenterContainer magazyny=new FulfillmentCenterContainer();


        FulfillmentCenter magazyn1=new FulfillmentCenter( "Jedzenie","Warszawa",20 );
        FulfillmentCenter magazyn2=new FulfillmentCenter( "Ubrania","Kraków",40);
        FulfillmentCenter magazyn3=new FulfillmentCenter( "Państwa","Łódź",70);
        FulfillmentCenter magazyn4=new FulfillmentCenter( "Książki","Bydgoszcz",50);

        Item przed1=new Item("Bułki", SPRZEDANY,3);
        Item przed2=new Item("Zupa",W_MAGAZYNIE, 4);
        Item przed3=new Item("Spodnie",ZAMOWIONY,2);
        Item przed4=new Item("Spódnica",SPRZEDANY,3);
        Item przed5=new Item("Turcja",W_MAGAZYNIE,5);
        Item przed6=new Item("Rosja",SPRZEDANY,1);
        Item przed7=new Item("Buszujacy w zbozu",ZAMOWIONY,4);
        Item przed8=new Item("Cien wiatru",SPRZEDANY,3);


        magazyn1.addProduct(przed1);
        magazyn1.addProduct(przed2);
        magazyn2.addProduct(przed3);
        magazyn2.addProduct(przed4);
        magazyn3.addProduct(przed5);
        magazyn3.addProduct(przed6);
        magazyn4.addProduct(przed7);
        magazyn4.addProduct(przed8);


        magazyny.addCenter(magazyn1);
        magazyny.addCenter(magazyn2);
        magazyny.addCenter(magazyn3);
        magazyny.addCenter(magazyn4);




        Fasada magazynyFasada=new Fasada(magazyny);



        return magazynyFasada;
    }
}

