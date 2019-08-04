package spring.example.dao;

import spring.example.model.Box;
import spring.example.model.Info;

import java.util.List;

public interface BoxDao {


    void add(Info info);

    void delete(Long id);

    void edit(Info info);

    List<Info> getInfoById(Long id);

    List<Info> getInfoByType(String type);

    void addBox(Box box);

    List<Box> getBoxesById(Long id);

    List<Box> getBoxInfo();


}
