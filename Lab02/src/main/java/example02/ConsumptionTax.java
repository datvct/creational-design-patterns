package example02;

public class ConsumptionTax implements TaxStrategy {
    public double calculateTax(double price) {
        return price * 0.05; // 5% thuế tiêu thụ đặc biệt
    }
}
