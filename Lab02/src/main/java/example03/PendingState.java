package example03;

public class PendingState implements PaymentState {
    public void processPayment(PaymentContext context, double amount) {
        System.out.println("Thanh toán đang chờ xử lý...");
        context.executePayment(amount);
        context.setPaymentStrategy(null); // Reset phương thức thanh toán
    }
}