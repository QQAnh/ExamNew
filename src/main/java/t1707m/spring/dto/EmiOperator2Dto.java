package t1707m.spring.dto;

public class EmiOperator2Dto {
    private int month;
    private int fee;

    public EmiOperator2Dto() {
    }

    public EmiOperator2Dto(int month, int fee) {
        this.month = month;
        this.fee = fee;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }
}