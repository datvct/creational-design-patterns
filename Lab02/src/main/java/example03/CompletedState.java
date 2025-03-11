package example03;

public class CompletedState implements PaymentState {
    public void processPayment(PaymentContext context, double amount) {
        System.out.println("Thanh toán hoàn tất!");
    }
}