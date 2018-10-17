package employee.services;

import employee.dao.PositionDao;
import employee.dao.PositionDaoImpl;
import employee.entities.Position;

import java.util.List;

public class PositionServiceImpl implements PositionService {
    PositionDao positionDao = new PositionDaoImpl();
    @Override
    public List<Position> getPositions() {
        return positionDao.getPositions();
    }

    @Override
    public Position getPositionByID(int id) {
        return positionDao.getPositionById(id);
    }

    @Override
    public Position getPositionByName(String name) {
        return positionDao.getPositionByName(name);
    }

    @Override
    public void savePosition(Position position) {
        if(position.getPositionId()==0) {
            positionDao.addPosition(position);
        } else {
            positionDao.editPosition(position);
        }
    }

    @Override
    public void removePosition(int id) {
        positionDao.removePosition(id);
    }
}
