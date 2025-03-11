package example02;

public class NormalTaxState implements TaxState {
    public void applyTax(Product product) {
        System.out.println("Áp dụng thuế bình thường.");
    }
}
