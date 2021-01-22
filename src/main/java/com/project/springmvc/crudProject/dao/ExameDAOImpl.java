package com.project.springmvc.crudProject.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.project.springmvc.crudProject.model.Exame;

public class ExameDAOImpl implements ExameDAO {
	 
    private JdbcTemplate jdbcTemplate;
 
    public ExameDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
 
    @Override
    public void saveOrUpdate(Exame exame) {
    	 if (exame.getId() > 0) {
    	        // update
    	        String sql = "UPDATE Exame SET paciente=?, exame=?, data_exame=?, "
    	                    + "observacao_resultado=? WHERE id=?";
    	        jdbcTemplate.update(sql, exame.getPaciente(), exame.getExame(),
    	                exame.getDataExame(), exame.getObservacaoResultado(), exame.getId());
    	    } else {
    	        // insert
    	        String sql = "INSERT INTO Exame (paciente, exame, data_exame, observacao_resultado)"
    	                    + " VALUES (?, ?, ?, ?)";
    	        jdbcTemplate.update(sql, exame.getPaciente(), exame.getExame(),
    	                exame.getDataExame(), exame.getObservacaoResultado());
    	    }
    }
 
    @Override
    public void delete(int exameId) {
    	 String sql = "DELETE FROM Exame WHERE id=?";
    	    jdbcTemplate.update(sql, exameId);
    }
 
    @Override
    public List<Exame> list() {
    	 String sql = "SELECT * FROM Exame";
    	 return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Exame.class));
    }
    
    @Override
    public List<Exame> listOrderBy(String atributo) {
    	 String sql = "SELECT * FROM Exame ORDER BY " + atributo;
    	 return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Exame.class));
    }
    
   
 
    @Override
    public Exame get(int exameId) {
        String sql = "SELECT * FROM Exame WHERE id=" + exameId;
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Exame.class));
    }
 
}