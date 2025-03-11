package example03;

public class PaymentSystem {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();

        paymentContext.setPaymentStrategy(new CreditCardPayment());
        paymentContext.executePayment(1000);

        PaymentStrategy enhancedPayment = new DiscountDecorator(new ProcessingFeeDecorator(new PayPalPayment()));
        enhancedPayment.pay(500);

        PaymentState pendingState = new PendingState();
        pendingState.processPayment(paymentContext, 750);
    }
}
