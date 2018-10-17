package employee.entities;

import javax.persistence.*;

@Entity
@Table(name="positions")
public class Position {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @Column(name="id")
    private int positionId;
    @Column(name="position")
    private String positionName;
    @Column(name="salary")
    private int salary;

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String position) {
        this.positionName = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
