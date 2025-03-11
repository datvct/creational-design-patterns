package example01;

public class NewOrderState implements OrderState {
    public void handle(OrderContext context) {
        System.out.println("Kiểm tra thông tin đơn hàng.");
        context.setState(new ProcessingOrderState());
    }
}
