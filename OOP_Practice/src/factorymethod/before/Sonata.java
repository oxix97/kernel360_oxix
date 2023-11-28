package factorymethod.before;

public class Sonata {

    private String type = "SONATA";
    private String owner;

    public Sonata(String owner){
        this.owner = owner;
    }

    public String toString(){
        return owner + "님의 차는 " + type + "입니다.";
    }
}
