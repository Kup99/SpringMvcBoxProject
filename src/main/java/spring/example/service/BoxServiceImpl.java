package spring.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.example.dao.BoxDao;
import spring.example.model.Box;
import spring.example.model.Info;

import java.util.List;

@Service
public class BoxServiceImpl implements BoxService {

    @Autowired
    public BoxDao boxDao;

    @Transactional
    public void add(Info info) {
        boxDao.add(info);

    }

    @Transactional
    public void delete(Long id) {
        boxDao.delete(id);
    }

    @Transactional
    public void edit(Info info) {
        boxDao.edit(info);
    }

    @Transactional
    public List<Info> getInfoById(Long id) {
        return boxDao.getInfoById(id);
    }

    @Transactional
    public List<Info> getInfoByType(String type) {
        return boxDao.getInfoByType(type);
    }

    public void addBox(Box box) {
        boxDao.addBox(box);
    }

    @Transactional
    public List<Box> getBoxesById(Long id) {
        return boxDao.getBoxesById(id);
    }

    public List<Box> getBoxInfo() {
        return boxDao.getBoxInfo();
    }

}







