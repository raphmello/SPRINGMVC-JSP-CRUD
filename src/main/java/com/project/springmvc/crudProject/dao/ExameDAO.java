package com.project.springmvc.crudProject.dao;

import java.util.List;

import com.project.springmvc.crudProject.model.Exame;

public interface ExameDAO {
    
    public void saveOrUpdate(Exame exame);
     
    public void delete(int exameId);
     
    public Exame get(int exameId);
     
    public List<Exame> list();
    
    public List<Exame> listOrderBy(String atributo);
}
