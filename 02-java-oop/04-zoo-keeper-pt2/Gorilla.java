public class Gorilla extends Mammal {
    public Gorilla() {
		super(100);
    }

	public void throwSomething() {
		System.out.println("throw");
		energyLevel -= 5;
	}
	public void eatBanana() {
		System.out.println("eating bananas");
		energyLevel += 10;
	}
	public void climb() {
		System.out.println("climb");
		energyLevel -= 10;
	}
}

