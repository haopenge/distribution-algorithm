package com.uu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

@SpringBootTest
class HuskyDistributeDbApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private DataSource dataSource;

    @Test
    public void test(){
        String sql = "insert into t_order values (11,11)";
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
