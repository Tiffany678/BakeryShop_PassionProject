package com.Yingjie.springboot.repository;

import com.Yingjie.springboot.model.Cake;
import com.Yingjie.springboot.repository.util.CakeRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
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
 //       jdbcTemplate.update("INSERT INTO cake(title,price,limitedNum,information) value(?,?,?,?)",cake.getTitle());
//        KeyHolder keyHolder = new GeneratedKeyHolder();
//        jdbcTemplate.update(new PreparedStatementCreator() {
//            @Override
//            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//                PreparedStatement ps = con.prepareStatement("INSERT INTO cake(title,price,limitedNum,information) value(?,?,?,?)", new String[] {"id"});
//                ps.setString(1, cake.getTitle());
//                return ps;
//            }
//        }, keyHolder);
//
//        Number id = keyHolder.getKey();
    //    return null;
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
        insert.setTableName("cake");
        List<String> columns = new ArrayList<>();
        columns.add("title");
        columns.add("price");
        columns.add("limitedNum");
        columns.add("information");

        Map<String, Object> data= new HashMap<>();
        data.put("title", cake.getTitle());
        data.put("price", cake.getPrice());
        data.put("limitedNum", cake.getLimitedNum());
        data.put("information", cake.getInformation());

        insert.setGeneratedKeyName("id");
        Number key = insert.executeAndReturnKey(data);
        System.out.println(key);
        return null;

    }
    @Override
    public List<Cake> findAll() {
        List<Cake> cakes =jdbcTemplate.query("select * from cake", new CakeRowMapper());
        return cakes;
    }



    @Override
    public Cake getCake(int id) {
        return jdbcTemplate.queryForObject("select * from cake where id=?",
                new CakeRowMapper(), id);
    }

    @Override
    public Cake update(Cake cake) {
        String sql= "UPDATE cake SET title=? "+
                "SET price=? "+
                "SET limitedNum=? "+
                "SET information=? "+
                "WHERE id=? ";
        jdbcTemplate.update(sql,
                cake.getTitle(),
                cake.getPrice(),
                cake.getLimitedNum(),
                cake.getInformation());
        return cake;
    }

    @Override
    public void update(List<Object[]> pairs) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Cake findByTitle(String title) {
        return null;
    }
}
