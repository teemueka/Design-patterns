public class Main {
    public static void main(String[] args) {

        Department humanResources = new Department("Human Resources");
        Department finance = new Department("Finance");

        Employee employee1 = new Employee("Employee 1", 1500);
        Employee employee2 = new Employee("Employee 2", 2000);
        Employee employee3 = new Employee("Employee 3", 3000);

        humanResources.add(employee1);
        humanResources.add(employee2);
        finance.add(employee3);

        Department mainDepartment = new Department("Main Department");
        mainDepartment.add(humanResources);
        mainDepartment.add(finance);
        System.out.println("Salary: " + mainDepartment.getSalary());
        System.out.println(mainDepartment.getDetails());

        System.out.println(" -------------------- ");

        finance.remove(employee3);
        mainDepartment.remove(humanResources);
        System.out.println("Salary: " + mainDepartment.getSalary());
        System.out.println(mainDepartment.getDetails());

    }
}