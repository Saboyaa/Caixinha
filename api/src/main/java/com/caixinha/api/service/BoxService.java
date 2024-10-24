package com.caixinha.api.service;

import java.util.List;

import com.caixinha.api.entity.Box;
import com.caixinha.api.entity.BoxInterface;

public interface BoxService {
    List<BoxInterface> findByUserId(int userId);
    
    Box findByBoxNumber(String boxNumber);

    Box save(Box box);

    void deleteByBoxNumber(String boxNumber);

    Box update(Box box);
}
