package builder;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nGAMING PC \n");
        ComputerBuilder builder = new GamingComputerBuilder();
        ComputerDirector director = new ComputerDirector(builder);
        director.constructComputer();
        builder.getComputer().getComponents();

        System.out.println("\nOFFICE PC \n");
        ComputerBuilder builder2 = new OfficeComputerBuilder();
        ComputerDirector director2 = new ComputerDirector(builder2);
        director2.constructComputer();
        builder2.getComputer().getComponents();

    }
}
