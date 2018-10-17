package employee.dao;

import employee.entities.Position;

import java.util.List;

public interface PositionDao {
    Position getPositionById(int id);
    Position getPositionByName(String name);
    List<Position> getPositions();
    void addPosition(Position position);
    void editPosition(Position position);
    void removePosition(int id);
}
