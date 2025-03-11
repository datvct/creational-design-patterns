package example02;

public class TaxContext {
    private TaxState state;

    public TaxContext() {
        this.state = new NormalTaxState();
    }

    public void setState(TaxState state) {
        this.state = state;
    }

    public void applyTax(Product product) {
        state.applyTax(product);
    }
}