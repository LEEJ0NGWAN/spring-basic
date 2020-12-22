package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    // 싱글톤 객체 조회
    public static SingletonService getInstance() {
        return instance;
    }

    // private 키워드를 통해 외부 new 를 방지
    private SingletonService() {
    }

    public void logic() {
        System.out.println("YEE");
    }
}
