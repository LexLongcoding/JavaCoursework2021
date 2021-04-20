public class CalculatorTest {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        c.setNum1(10.5);
        c.setNum2(5.2);
        c.setOperator('+');
        c.performOperation();
        c.getResults();
    }
    
}
