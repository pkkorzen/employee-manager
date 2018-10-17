package employee.services;

import employee.entities.Position;

import java.util.List;

public interface PositionService {
    List<Position> getPositions();
    Position getPositionByID(int id);
    Position getPositionByName(String name);
    void savePosition(Position position);
    void removePosition(int id);
}
