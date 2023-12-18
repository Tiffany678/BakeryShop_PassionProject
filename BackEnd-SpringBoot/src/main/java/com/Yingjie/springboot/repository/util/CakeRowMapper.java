package com.Yingjie.springboot.repository.util;

import com.Yingjie.springboot.model.Cake;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CakeRowMapper implements RowMapper<Cake> {

    public CakeRowMapper() {
    }

    @Override
    public Cake mapRow(ResultSet rs, int rowNum) throws SQLException{
        Cake cake = new Cake();
        cake.setId(rs.getInt("id"));
        cake.setTitle(rs.getString("title"));
        cake.setPrice(rs.getDouble("price"));
        cake.setInformation(rs.getString("information"));
        cake.setInventory(rs.getInt("inventory"));
        cake.setImageUrl(rs.getString("imageUrl"));
        cake.setCategory(rs.getString("category"));
        return cake;
    }
}
