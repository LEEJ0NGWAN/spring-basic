package hello.core.singleton;

public class StatefulService {

    // stateful field
    private int price;

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price; // 문제되는 부분
    }

    public int getPrice() {
        return price;
    }
}
