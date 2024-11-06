package builder;

public class GamingComputerBuilder implements ComputerBuilder {

    private Computer computer;

    public GamingComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.addComponent(new Component("Gaming Processor"));
    }

    @Override
    public void buildRAM() {
        computer.addComponent(new Component("Gaming RAM"));
    }

    @Override
    public void buildHardDrive() {
        computer.addComponent(new Component("Gaming HD"));
    }

    @Override
    public void buildGraphicsCard() {
        computer.addComponent(new Component("Gaming GPU"));
    }

    @Override
    public void buildOperatingSystem() {
        computer.addComponent(new Component("Gaming OS"));
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
