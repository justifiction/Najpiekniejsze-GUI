package wszystko;

public class Item {
    String name;
    int mass;
    SaleState state;

    public Item(String name, SaleState state, int mass ){
        this.name=name;
        this.state=state;
        this.mass=mass;
    }
    public String getName() {
        return name;
    }
    public SaleState getState() {
        return state;
    }
    public double getMass() {
        return mass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setState(SaleState state) {
        this.state = state;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    @Override
    public String toString() {
        return "Name: " + name + ". State: " + state + ". Mass:" + mass;
    }
    public void summary(){
        System.out.println("Name: "+name);
        System.out.println("State: "+state);
        System.out.println("Mass: "+mass);
    }
}
