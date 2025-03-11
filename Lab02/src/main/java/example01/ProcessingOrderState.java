package example01;

public class ProcessingOrderState implements OrderState {
    public void handle(OrderContext context) {
        System.out.println("Đóng gói và vận chuyển.");
        context.setState(new DeliveredOrderState());
    }
}
