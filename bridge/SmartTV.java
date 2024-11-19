package bridge;

public class SmartTV implements Device {
    private boolean on = false;
    private int volume = 30;
    private int channel = 1;

    public boolean isEnabled() {return on;}
    public void enable() {on = true;}
    public void disable() {on = false;}
    public int getVolume() {return volume;}
    public void setVolume(int percent) {volume = percent;}
    public int getChannel() {return channel;}
    public void setChannel(int channel) {this.channel = channel;}
    public void browseInternet() {System.out.println("Browsing internet");}
    @Override
    public void printStatus() {
        System.out.println("------------------------------------");
        System.out.println("| I'm SmartTV set.");
        System.out.println("| I'm " + (on ? "enabled" : "disabled"));
        System.out.println("| Current volume is " + volume + "%");
        System.out.println("| Current channel is " + channel);
        System.out.println("------------------------------------\n");
    }
}
