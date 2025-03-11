package example03;

public class CanceledState implements PaymentState {
    public void processPayment(PaymentContext context, double amount) {
        System.out.println("Thanh toán đã bị hủy.");
    }
}