package employee.dto;


public class EmployeeDto {
    private int id;
    private String name;
    private String surname;
    private int salary;
    private String positionName;
    private int positionId;

    public EmployeeDto() {
    }

    public EmployeeDto(String name, String surname, int salary, String positionName, int positionId) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.positionName = positionName;
        this.positionId = positionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }
}
