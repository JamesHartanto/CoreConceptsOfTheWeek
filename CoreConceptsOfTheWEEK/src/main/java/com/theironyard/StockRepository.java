package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by JamesHartanto on 4/20/17.
 */
@Component
public class StockRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Stock> listVelocityStocks() {
//        return jdbcTemplate.query("SELECT ")
        return null;
    }
}
