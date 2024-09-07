public class ObserverMain {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        WeatherObserver observer = new WeatherObserver();
        WeatherObserver observer2 = new WeatherObserver();
        WeatherObserver observer3 = new WeatherObserver();
        station.addObserver(observer);
        station.addObserver(observer2);
        station.addObserver(observer3);
        station.start();
    }
}