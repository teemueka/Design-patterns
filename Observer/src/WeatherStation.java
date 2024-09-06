import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation extends Thread implements Subject {

    private int temperature;
    boolean running = true;
    private final List<Observer> observers = new ArrayList<>();
    Random rand = new Random();

    public WeatherStation() {
        this.temperature = rand.nextInt(51);
    }

    public void run() {
        try {
            while (running) {
                changeTemperature();
                Thread.sleep(2000);
                notifyObservers();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }

    public void changeTemperature() {
        int tempChange = rand.nextInt(2);

        if (tempChange == 0) {
            if (this.temperature != 0) {
                this.temperature -= 1;
            } else {
                this.temperature += 1;
            }
        }
        if (tempChange == 1) {
            if (this.temperature != 50) {
                this.temperature += 1;
            } else {
                this.temperature -= 1;
            }
        }
    }
}
