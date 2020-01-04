
enum PayrollDay{
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
    
    private static final int MINS_PER_SHIFT = 8 * 60;
    
    int pay(int minutesWorked, int payRate){
        int basePay = minutesWorked * payRate;
        int overtimePay;
        switch(this){
            case SATURDAY: case SUNDAY:
                overtimePay = basePay / 2;
                break;
            default:
                overtimePay = minutesWorked <= MINS_PER_SHIFT ? 0 : (minutesWorked - MINS_PER_SHIFT) * payRate / 2;
        }
        return basePay + overtimePay;
    }
}


enum PayrollDayNew{
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY(PayType.WEEKEND), SUNDAY(PayType.WEEKEND);

    private final PayType payType;

    PayrollDayNew(PayType payType) { this.payType = payType; }
    PayrollDayNew() { this(PayType.WEEKDAY); }
    private static final int MINS_PER_SHIFT = 8 * 60;
    int pay(int minutesWorked, int payRate){
        return payType.pay(minutesWorked, payRate);
    }
// strategy enum
    private enum PayType{
        WEEKDAY{
            int overtimePay(int minsWorked, int payRate){
                return minsWorked <= MINS_PER_SHIFT ? 0 : (minsWorked - MINS_PER_SHIFT) * payRate / 2;
            }
        },
        WEEKEND{
            int overtimePay(int minsWorked, int payRate){
                return minsWorked * payRate / 2;
            }
        };
        abstract int overtimePay(int mins, int payRate);

        int pay(int minutesWorked, int payRate){
            int basePay = minutesWorked * payRate;
            return basePay + overtimePay(minutesWorked, payRate);
        }
    }
}

public class rule34cont {
    
}
