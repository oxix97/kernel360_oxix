package factorymethod.before;

public class Genesis {
    private String type = "GENESIS";
    private String owner;

    public Genesis(String owner){
        this.owner = owner;
    }

    public String toString(){
        return owner + "님의 차는 " + type + "입니다.";
    }
}
