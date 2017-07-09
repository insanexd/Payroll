public class Appointee extends Employee {
    //Attributes
    private int dayOfMonth;
    private int hoursPerMonth;
    private double payPerHour;

    //Methods
    public Appointee(String id, int dayOfMonth, int hoursPerMonth, double payPerHour)
            throws IllegalArgumentException, NullPointerException {
        super(id);
        if(dayOfMonth < 1 || dayOfMonth > 31) {
            throw new IllegalArgumentException("day of the month out of bounds");
        }
        if(hoursPerMonth <= 0 || hoursPerMonth > 24*31) {
            throw new IllegalArgumentException("worked hours per month should be between 0 and 744");
        }
        if(payPerHour <= 0 ) {
            throw new IllegalArgumentException("amount of money paid per hour should be greater than 0");
        }
        if(id == "") throw new IllegalArgumentException("invalid id");
        if(id == null) throw new NullPointerException("String cannot be null");

        this.dayOfMonth = dayOfMonth;
        this.hoursPerMonth = hoursPerMonth;
        this.payPerHour = payPerHour;

    }
    @Override
    public boolean isPayday(int dayOfMonth) {
        if(dayOfMonth == this.dayOfMonth) return true;
        return false;
    }

    @Override
    public double calculatePay() throws UnpayableEmployeeException{
        return hoursPerMonth * payPerHour;

    }

    @Override
    public double calculateDeductions() {
        try {
            return this.calculatePay() * .4;
        } catch (UnpayableEmployeeException e) {
            e.printStackTrace();
            return 0.0;
        }

    }
}
