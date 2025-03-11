package example01;

public class CanceledOrderState implements OrderState {
    public void handle(OrderContext context) {
        System.out.println("Hủy đơn hàng và hoàn tiền.");
    }
}