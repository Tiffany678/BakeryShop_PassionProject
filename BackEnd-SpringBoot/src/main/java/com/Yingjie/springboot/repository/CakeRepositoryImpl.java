package com.Yingjie.springboot.repository;

import com.Yingjie.springboot.model.Cake;
import com.Yingjie.springboot.repository.util.CakeRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("cakeRepository")
public class CakeRepositoryImpl implements CakeRepository {
    private JdbcTemplate jdbcTemplate;

    public CakeRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Cake create(Cake cake) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
        insert.setTableName("cake");

        Map<String, Object> data= new HashMap<>();
        data.put("id",cake.getId());
        data.put("title", cake.getTitle());
        data.put("price", cake.getPrice());
        data.put("limitedNum", cake.getInventory());
        data.put("information", cake.getInformation());
        data.put("imageUrl", cake.getImageUrl());
        data.put("category", cake.getCategory());
        insert.setGeneratedKeyName("id");

        Number id = insert.executeAndReturnKey(data);

        return getCakeById(id.intValue());

    }
    @Override
    public List<Cake> findAll() {
        List<Cake> cakes =jdbcTemplate.query("select * from cake", new CakeRowMapper());
        return cakes;
    }



    @Override
    public Cake getCakeById(int id) {
        return jdbcTemplate.queryForObject("select * from cake where id=?",
                new CakeRowMapper(), id);
    }

    @Override
    public Cake update(Cake cake) {
        String sql= "UPDATE cake " +
                "SET title=?, "+
                "price=?, "+
                "limitedNum=?, "+
                "information=? "+
                "imageUrl=? "+
                "category=? "+
                "WHERE id=? ";
        jdbcTemplate.update(sql,
                cake.getTitle(),
                cake.getPrice(),
                cake.getInventory(),
                cake.getInformation(),
                cake.getImageUrl(),
                cake.getCategory(),
                cake.getId());

        return cake;
    }


    @Override
    public void delete(int id) {
        jdbcTemplate.update("delete from cake where id =?", id);
    }



}
