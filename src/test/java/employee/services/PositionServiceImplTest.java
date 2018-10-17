package employee.services;

import employee.entities.Position;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PositionServiceImplTest {

    PositionService positionService = new PositionServiceImpl();

    @Test
    public void shouldFindAllPositions() {
        List<Position> postions = positionService.getPositions();
        assertEquals(5, postions.size());
    }

    @Test
    public void shouldFindPositionByID() {
        Position position = positionService.getPositionByID(1);
        assertEquals("clerk", position.getPositionName());
    }

    @Test
    public void getPositionByName() {
        Position position = positionService.getPositionByName("clerk");
        assertEquals(1, position.getPositionId());
    }

    @Test
    public void shouldUpdatePosition() {
        Position position = positionService.getPositionByID(2);
        position.setSalary(1600);
        positionService.savePosition(position);
        assertEquals(1600, positionService.getPositionByID(2).getSalary());
    }

    @Test
    public void shouldAddPosition() {
        Position position = new Position();
        position.setPositionName("Analyst");
        position.setSalary(3600);
        positionService.savePosition(position);
        assertEquals(3600, positionService.getPositionByName("Analyst").getSalary());
    }

    @Test
    public void removePosition() {
        int before = positionService.getPositions().size();
        Position position = positionService.getPositionByName("Analyst");
        positionService.removePosition(position.getPositionId());
        int after = positionService.getPositions().size();
        assertEquals(before, after+1);
    }
}