final class Employee {
    private final String name;
    private final String department;
    private final double salary;

    private Employee(EmployeeBuilder builder) {
        this.name = builder.name;
        this.department = builder.department;
        this.salary = builder.salary;
    }

    public void showEmployeeDetails() {
        System.out.println("Employee: " + name + ", Department: " + department + ", Salary: " + salary);
    }

    public static class EmployeeBuilder {
        private String name;
        private String department;
        private double salary;

        public EmployeeBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public EmployeeBuilder setDepartment(String department) {
            this.department = department;
            return this;
        }

        public EmployeeBuilder setSalary(double salary) {
            this.salary = salary;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }

    public static void main(String[] args) {
        Employee employee = new Employee.EmployeeBuilder()
                .setName("Selva")
                .setDepartment("IT")
                .setSalary(50000)
                .build();

        employee.showEmployeeDetails();
    }
}
