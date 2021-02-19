package com.gupaoedu;

import com.gupaoedu.dao.*;
import com.gupaoedu.entity.*;
import com.gupaoedu.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DictionaryTest {
    @Autowired
    private DictionaryDao dictionaryDao;

    @Test
    public void insertDictionary() {
        Dictionary dictionary = new Dictionary();
        dictionary.setName("key");
        dictionary.setValue("value");
        this.dictionaryDao.addOne(dictionary);
        log.info("字典表插入id为：{}", dictionary.getDictionaryId());
    }

}

