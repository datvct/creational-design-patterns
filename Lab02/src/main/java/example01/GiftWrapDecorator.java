package example01;

public class GiftWrapDecorator extends OrderDecorator {
    public GiftWrapDecorator(OrderState decoratedOrder) {
        super(decoratedOrder);
    }

    public void handle(OrderContext context) {
        System.out.println("Gói quà cho đơn hàng.");
        super.handle(context);
    }
}
