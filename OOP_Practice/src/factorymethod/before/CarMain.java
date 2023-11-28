package factorymethod.before;

public class CarMain {

    public static void main(String[] args){

        // 차주의 이름을 생성자의 매개변수로 받습니다.
        Sonata sonata = new Sonata("종찬");
        Grandeur grandeur = new Grandeur("소현");
        Genesis genesis = new Genesis("승규");

        System.out.println(sonata);
        System.out.println(grandeur);
        System.out.println(genesis);

    }
}
