package spring.example.service;

import spring.example.model.Box;
import spring.example.model.Info;

import java.util.List;

public interface BoxService {

    void insertBoxDefaultEntity();

    void add(Info info);

    void delete(Long id);

    void edit(Info info);

    void addBox(Box box);

    List<Box> getBoxesById(Long id);

    List<Box> getBoxInfo();


}

