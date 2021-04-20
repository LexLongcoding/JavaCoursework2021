public class Galaxy extends Phone implements Ringable {
    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String Ring() {
        return this.getRingTone();
        // your code here
    }
    @Override
    public String unlock() {
        return "Unlocked with facial recognition";
        // your code here
    }
    @Override
    public void displayInfo() {
    System.out.println("Version Number: " + this.getVersionNumber());
    System.out.println("Batter Percentage: " + this.getBatteryPercentage());
    System.out.println("Carrier: " + this.getCarrier());
    System.out.println("RingTone: " + this.getRingTone());
        // your code here            
    }
}