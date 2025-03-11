package example02;

public  abstract  class TaxDecorator implements TaxStrategy {
    protected TaxStrategy decoratedTax;

    public TaxDecorator(TaxStrategy decoratedTax) {
        this.decoratedTax = decoratedTax;
    }

    public double calculateTax(double price) {
        return decoratedTax.calculateTax(price);
    }
}