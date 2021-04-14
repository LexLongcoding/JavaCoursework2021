public class Pizza {
    //Pizza Attributes
    private String name;
    private String[] toppings;
    private char size;
    private int slices;

    public Pizza(String name, String[] toppings, char size, int slices){
        this.name = name;
        this.toppings = toppings;
        this.size = size;
        this.slices = slices;


    }
// getter and setter methods
public String getName(){
    return this.name;
}
public String[] getToppings(){
    return this.toppings;
}
public char getSize(){
    return this.size;
}
public int getSlices(){
    return this.slices;
}
public void setName(String name){
    this.name = name;

}
public void setToppings(String[] toppings){
    this.toppings = toppings;

}
public void setSize(char size){
    this.size = size;

}
public void setSlices(int slices){
    this.slices = slices;

}
    // Things you can do w pizza object
    // Advertise()
    // East()
public void displayPizza(){
    System.out.printf("This is a %s pizza with %s slices", this.name, this.slices);

}
    
}
