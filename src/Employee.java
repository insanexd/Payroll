public abstract class Employee {
    //Attributes
    private String id;

    //Methods
    public Employee(String id) throws IllegalArgumentException, NullPointerException {
        if(id == "") throw new IllegalArgumentException();
        if(id == null) throw new NullPointerException();
        this.id = id;
    }
    public String getId() {
        return this.id;
    }
    public abstract boolean isPayday(int dayOfMonth);
    public abstract double calculatePay() throws UnpayableEmployeeException;
    public abstract double calculateDeductions() throws UnpayableEmployeeException;

}
