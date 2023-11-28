package solid.di.usercontrol;

public class UserServiceTest {
    public static boolean doTest(){

        return true;
    }

    public static void main(String[] args){
        if(doTest()){
            System.out.println("Test succeeded.");
        }
        else{
            System.out.println("Test failed");
        }
    }

}
