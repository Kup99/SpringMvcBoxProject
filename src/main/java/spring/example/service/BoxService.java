package spring.example.service;

import spring.example.model.Box;
import spring.example.model.Info;

import java.util.List;

public interface BoxService {

    void insertBoxDefaultEntity();

    void add(Long boxId, Info info);

    void delete(Long id);

    void edit(Info info);

    void addBox(Box box);

    Box getBoxesById(Long id);

    List<Box> getBoxInfo();


}

