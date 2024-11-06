package builder;

public class OfficeComputerBuilder implements ComputerBuilder {

    private Computer computer;

    public OfficeComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.addComponent(new Component("Office Processor"));
    }

    @Override
    public void buildRAM() {
        computer.addComponent(new Component("Office RAM"));
    }

    @Override
    public void buildHardDrive() {
        computer.addComponent(new Component("Office HD"));
    }

    @Override
    public void buildGraphicsCard() {
        computer.addComponent(new Component("Office GPU"));
    }

    @Override
    public void buildOperatingSystem() {
        computer.addComponent(new Component("Office OS"));
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
