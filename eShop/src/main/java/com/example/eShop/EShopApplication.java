package com.example.eShop;

import com.example.eShop.dao.CustomerDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class EShopApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(EShopApplication.class, args);
    }

}
