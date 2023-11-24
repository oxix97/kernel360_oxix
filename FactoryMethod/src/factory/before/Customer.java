package factory.before;

public class Customer {

    private int customerType;
    private String customerName;
    private String customerGrade;
    private int bonusPoint;

    public static final int BRONZE_CUSTOMER = 0;
    public static final int SILVER_CUSTOMER = 1;
    public static final int GOLD_CUSTOMER = 2;

    Customer( int customerType, String customerName){
        this.customerType = customerType;
        this.customerName = customerName;
    }

    public String getCustomerGrade() {

        switch(customerType) {
            case BRONZE_CUSTOMER : return "BRONZE";
            case SILVER_CUSTOMER : return "SILVER";
            case GOLD_CUSTOMER : return "GOLD";
            default : return null;
        }
    }

    public int calcPrice(int price) {
        switch(customerType) {
            case BRONZE_CUSTOMER :
                return price;
            case SILVER_CUSTOMER :
                return price - (int)(price * 0.05);
            case GOLD_CUSTOMER :
                return price - (int)(price * 0.1);
            default : return price;

        }
    }

    public int calcBonusPoint(int price) {
        switch(customerType) {
            case BRONZE_CUSTOMER :
                return bonusPoint += (price * 0.01);
            case SILVER_CUSTOMER :
                return bonusPoint += (price * 0.05);
            case GOLD_CUSTOMER :
                return bonusPoint += (price * 0.1);
            default : return price;

        }
    }

    public String getCustomerName() {
        return customerName;
    }

    public String toString() {
        return customerName + "님의 멤버십 등급은 " + getCustomerGrade() + "입니다.";
    }
}
