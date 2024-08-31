import java.util.ArrayList;
import java.util.List;

public class Department implements OrganizationComponent {

    String name;
    private List<OrganizationComponent> children = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getSalary() {
        double salary = 0;
        for (OrganizationComponent child : children) {
            salary += child.getSalary();
        }
        return salary;
    }

    @Override
    public void add(OrganizationComponent organizationComponent) {
        children.add(organizationComponent);
    }

    @Override
    public void remove(OrganizationComponent organizationComponent) {
        children.remove(organizationComponent);
    }

    @Override
    public List<OrganizationComponent> getChildren() {
        return children;
    }

    @Override
    public String getDetails() {
        StringBuilder details = new StringBuilder();
        details.append("<Department name=\"").append(name).append("\">\n");
        if (!children.isEmpty()) {
            for (OrganizationComponent child : children) {
                details.append(child.getDetails()).append("\n");
            }
        }
        details.append("</Department>");
        return details.toString();
    }
}