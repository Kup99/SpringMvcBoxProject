package spring.example.service;

import org.springframework.transaction.annotation.Transactional;
import spring.example.model.Info;

import java.util.List;

public interface BoxService {

    void add(Info info);

    void delete(Long id);

    void edit(Info info);

    List<Info> getInfoById(Long id);

    List<Info> getInfoByType(String type);





}

