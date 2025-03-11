package example01;

public class OrderManagementSystem {
    public static void main(String[] args) {
        OrderContext order = new OrderContext();
        order.process();
        order.process();
        OrderState giftWrappedOrder = new GiftWrapDecorator(new ProcessingOrderState());
        giftWrappedOrder.handle(new OrderContext());

        ShippingStrategy shippingStrategy = new ExpressShipping();
        shippingStrategy.ship();
    }
}
