package adapter;
import java.util.Calendar;

public class CalendarToNewDateAdapter implements NewDateInterface {

    private final Calendar calendar;

    public CalendarToNewDateAdapter() {
        calendar = Calendar.getInstance();
    }


    @Override
    public void setDay(int day) {
        System.out.println("Setting day to " + day);
        calendar.set(Calendar.DAY_OF_MONTH, day);
    }

    @Override
    public void setMonth(int month) {
        System.out.println("Setting month to " + month);
        calendar.set(Calendar.MONTH, month);
    }

    @Override
    public void setYear(int year) {
        System.out.println("Setting year to " + year);
        calendar.set(Calendar.YEAR, year);
    }

    @Override
    public int getDay() {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public int getMonth() {
        return calendar.get(Calendar.MONTH);
    }

    @Override
    public int getYear() {
        return calendar.get(Calendar.YEAR);
    }

    @Override
    public void advanceDays(int days) {
        System.out.println("Advancing " + days + " days");
        calendar.add(Calendar.DAY_OF_MONTH, days);
    }
}
