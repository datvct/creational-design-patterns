package example03;

public interface PaymentState {
    void processPayment(PaymentContext context, double amount);

}
