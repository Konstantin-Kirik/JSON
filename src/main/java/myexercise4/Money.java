package myexercise4;

public class Money {

    private String chang;
    private String get;
    private String operation;
    private double sum;

    public Money() {
    }

    public Money(String chang, String get, String operation, double sum) {
        this.chang = chang;
        this.get = get;
        this.operation = operation;
        this.sum = sum;
    }

    public Money(String chang, String get, double sum) {
        this.chang = chang;
        this.get = get;
        this.sum = sum;
    }

    public String getChang() {
        return chang;
    }

    public void setChang(String chang) {
        this.chang = chang;
    }

    public String getGet() {
        return get;
    }

    public void setGet(String get) {
        this.get = get;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return chang + " <--> " + get + " " + "получаю = " + sum;
    }
}
