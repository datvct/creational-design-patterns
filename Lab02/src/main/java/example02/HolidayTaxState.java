package example02;

public class HolidayTaxState implements TaxState {
    public void applyTax(Product product) {
        System.out.println("Giảm thuế trong kỳ nghỉ lễ!");
    }
}