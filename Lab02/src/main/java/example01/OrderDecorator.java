package example01;

// Decorator Pattern để mở rộng chức năng của đơn hàng
public abstract class OrderDecorator implements OrderState {
    protected OrderState decoratedOrder;

    public OrderDecorator(OrderState decoratedOrder) {
        this.decoratedOrder = decoratedOrder;
    }

    public void handle(OrderContext context) {
        decoratedOrder.handle(context);
    }
}
