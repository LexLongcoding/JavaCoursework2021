public class Bat extends Mammal {
    public Bat() {
		super(300);
	}
	public void fly() {
		System.out.println("bat is flying");
		energyLevel -= 50;
	}
	public void eatHumans() {
		System.out.println("eating humans");
		energyLevel += 25;
	}
	public void attackTown() {
		System.out.println("attacking a town");
		energyLevel -= 100;
	}
    
}
