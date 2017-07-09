
public class Volunteer extends Employee {
    //Methods
    public Volunteer(String id) {
        super(id);
    }

    @Override
    public boolean isPayday(int dayOfMonth) {
        return false;
    }

    @Override
    public double calculatePay() throws UnpayableEmployeeException {
        throw new UnpayableEmployeeException("Volunteers dont get paid");
    }

    @Override
    public double calculateDeductions(){
        return 0.0;
    }
}
