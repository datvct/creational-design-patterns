package ObserverPattern;

public class ObserverPatternExample {
    public static void main(String[] args) {
        // Đăng ký nhà đầu tư theo dõi cổ phiếu
        StockSubject stock = new StockSubject();
        Investor investor1 = new Investor("Alice");
        Investor investor2 = new Investor("Bob");

        stock.addObserver(investor1);
        stock.addObserver(investor2);

        // Thay đổi giá cổ phiếu
        stock.setPrice(100);
        stock.setPrice(120);

        // Đăng ký thành viên nhóm theo dõi task
        TaskSubject task = new TaskSubject();
        TeamMember member1 = new TeamMember("Charlie");
        TeamMember member2 = new TeamMember("David");

        task.addObserver(member1);
        task.addObserver(member2);

        // Thay đổi trạng thái công việc
        task.setStatus("In Progress");
        task.setStatus("Completed");
    }
}