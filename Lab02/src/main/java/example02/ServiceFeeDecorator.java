package example02;

public class ServiceFeeDecorator  extends TaxDecorator {
    public ServiceFeeDecorator(TaxStrategy decoratedTax) {
        super(decoratedTax);
    }

    public double calculateTax(double price) {
        return super.calculateTax(price) + price * 0.02; // Thêm 2% phí dịch vụ
    }
}