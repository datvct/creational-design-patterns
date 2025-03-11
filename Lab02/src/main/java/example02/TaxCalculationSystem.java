package example02;

public class TaxCalculationSystem {
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 1000, new VATTax());
        product1.displayPrice();

        Product product2 = new Product("Đồng hồ xa xỉ", 5000, new LuxuryTax());
        product2.displayPrice();

        // Thêm phí dịch vụ với Decorator
        Product product3 = new Product("Điện thoại", 800, new ServiceFeeDecorator(new VATTax()));
        product3.displayPrice();

        // State Pattern áp dụng thuế trong kỳ nghỉ lễ
        TaxContext taxContext = new TaxContext();
        taxContext.applyTax(product1);
        taxContext.setState(new HolidayTaxState());
        taxContext.applyTax(product2);
    }
}
