package factorymethod.before;

public class Grandeur {

    private String type = "GRANDEUR";
    private String owner;

    public Grandeur(String owner){
        this.owner = owner;
    }

    public String toString(){
        return owner + "님의 차는 " + type + "입니다.";
    }
}
