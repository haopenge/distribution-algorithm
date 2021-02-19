package com.gupaoedu.service;

import com.gupaoedu.dao.DictionaryDao;
import com.gupaoedu.entity.Dictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: qingshan
 * @Description: 咕泡学院，只为更好的你
 */
@Service
public class DictionaryService {

    @Autowired
    private DictionaryDao dictionaryDao;

    public long addOne(Dictionary dictionary) {
        this.dictionaryDao.addOne(dictionary);
        return dictionary.getDictionaryId();
    }
}
