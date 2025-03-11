package example03;

public class ProcessingFeeDecorator extends PaymentDecorator {
    public ProcessingFeeDecorator(PaymentStrategy decoratedPayment) {
        super(decoratedPayment);
    }

    public void pay(double amount) {
        double fee = amount * 0.02; // 2% phí xử lý
        System.out.println("Thêm phí xử lý: " + fee);
        super.pay(amount + fee);
    }
}
