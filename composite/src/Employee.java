import java.util.List;

public class Employee implements OrganizationComponent{

    private String name;
    private double salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public void add(OrganizationComponent organizationComponent) {

    }

    @Override
    public void remove(OrganizationComponent organizationComponent) {

    }

    @Override
    public List<OrganizationComponent> getChildren() {
        return null;
    }

    @Override
    public String getDetails() {
        return "<Employee name=\"" + name + "\" salary=\"" + salary + "\"/>";
    }

}