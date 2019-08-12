package spring.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.example.dao.BoxDao;
import spring.example.model.Box;
import spring.example.model.Info;

import java.util.List;

@Service
@Transactional
public class BoxServiceImpl implements BoxService {

    @Autowired
    public BoxDao boxDao;

    public void add(Long boxId, Info info) {
        info.setBox(new Box(boxId));
        boxDao.add(info);
    }

    public void delete(Long id) {
        boxDao.delete(id);
    }

    public void edit(Info info) {
        boxDao.edit(info);
    }

    public void addBox(Box box) {
        boxDao.addBox(box);
    }

    public Box getBoxesById(Long id) {
        return boxDao.getBoxesById(id);
    }

    public List<Box> getBoxInfo() {
        return boxDao.getBoxInfo();
    }

    public void insertBoxDefaultEntity() {
        boxDao.insertBoxDefaultEntity();
    }
}







