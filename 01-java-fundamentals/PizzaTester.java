public class PizzaTester {
    public static void main(String[] args){
        Pizza cheesePizza = new Pizza("Cheese Pizza", 
        new String[] {"cheese"},'L',10);
        //cheesePizza.name="Cheese Pizza";
        ///cheesePizza.toppings = new String[] {"cheese"};
        ///cheesePizza.size = 'L';
        cheesePizza.setSlices(8);
        System.out.println(cheesePizza.getSlices());



    }
    
}
