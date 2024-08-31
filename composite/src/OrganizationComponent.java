import java.util.List;

public interface OrganizationComponent {
    String getName();
    double getSalary();
    void add(OrganizationComponent organizationComponent);
    void remove(OrganizationComponent organizationComponent);
    List<OrganizationComponent> getChildren();
    String getDetails();
}
