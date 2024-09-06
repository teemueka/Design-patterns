public class WeatherObserver implements Observer {
    private static int idCounter = 0;
    private final int id;

    public WeatherObserver() {
        this.id = ++idCounter;
    }

    @Override
    public void update(int temperature) {
        System.out.println("WeatherObserver " + this.id + " updated to " + temperature);
    }
}
