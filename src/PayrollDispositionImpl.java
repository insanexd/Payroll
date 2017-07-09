import java.util.HashMap;
import java.util.Map;

public class PayrollDispositionImpl implements PayrollDisposition{
    //Attributes
    private Map<Employee, Double> payments = new HashMap<>();

    //Methods
    public PayrollDispositionImpl(){}
    public double getTotal() {
        double total = 0;
        if(this.payments == null) return 0.0;
        for(Map.Entry<Employee, Double> entry : this.payments.entrySet()){
            total = total + entry.getValue();
        }
        return total;
    }
    public double getAverage(){
        int numberOfEmployees = 0;
        for(Map.Entry<Employee, Double> entry : payments.entrySet()) {
            numberOfEmployees++;
        }
        if(this.payments.entrySet().isEmpty()) return 0.0;
        return this.getTotal()/numberOfEmployees;
    }
    public Map<Employee, Double> getPayments() {
        return this.payments;
    }


    @Override
    public void sendPayment(Employee empl, double payment) throws NullPointerException, IllegalArgumentException {
        if(empl == null) throw new NullPointerException("Employee = null");
        if(payment <= 0) throw new IllegalArgumentException("Payment has to be greater than zero");
        this.payments.put(empl, payment);
        System.out.println(empl.toString() + " payed amout: " + this.payments.get(empl));

    }
}
