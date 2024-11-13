package adapter;

public class Main {
    public static void main(String[] args) {

        CalendarToNewDateAdapter adapter = new CalendarToNewDateAdapter();

        adapter.setYear(1900);
        adapter.setMonth(11);
        adapter.setDay(20);

        adapter.advanceDays(10);
        System.out.println("Day " + adapter.getDay());
        System.out.println("Month " + adapter.getMonth());
        System.out.println("Year " + adapter.getYear());

    }
}
