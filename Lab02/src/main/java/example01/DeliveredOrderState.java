package example01;

public class DeliveredOrderState implements OrderState {
    public void handle(OrderContext context) {
        System.out.println("Cập nhật trạng thái đơn hàng là đã giao.");
    }
}
