package com.project.springmvc.crudProject.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.springmvc.crudProject.dao.ExameDAO;
import com.project.springmvc.crudProject.model.Exame;

@Controller
public class HomeController {

	 @Autowired
	 private ExameDAO exameDAO;
	
	 @RequestMapping(value="/", method = RequestMethod.GET)
	 public ModelAndView listExameOrderByPaciente(ModelAndView model, HttpServletRequest request) throws IOException{
		 String orderAtribute = request.getParameter("order");
	     List<Exame> listExame = exameDAO.listOrderBy(orderAtribute);
	     model.addObject("listExame", listExame);
	     model.setViewName("home");
	  
	     return model;
	 }
	 
	 
	 @RequestMapping(value = "/newExame", method = RequestMethod.GET)
	 public ModelAndView newExame(ModelAndView model) {
	     Exame newExame = new Exame();
	     model.addObject("exame", newExame);
	     model.setViewName("ExameForm");
	     return model;
	 }
	 
	 @RequestMapping(value = "/saveExame", method = RequestMethod.POST)
	 public ModelAndView saveContact(@Valid @ModelAttribute Exame exame, BindingResult bindingResult ) {
		 
		 System.out.println(bindingResult);
		 
		 if(bindingResult.hasErrors()) {
			 ModelAndView model = new ModelAndView("ExameForm");
			 return model;
		 }
	     exameDAO.saveOrUpdate(exame);
	     return new ModelAndView("redirect:/");
	 } 
	 
	 @RequestMapping(value = "/deleteExame", method = RequestMethod.GET)
	 public ModelAndView deleteExame(HttpServletRequest request) {
	     int exameId = Integer.parseInt(request.getParameter("id"));
	     exameDAO.delete(exameId);
	     return new ModelAndView("redirect:/");
	 }
	 
	 @RequestMapping(value = "/editExame", method = RequestMethod.GET)
	 public ModelAndView editExame(HttpServletRequest request) {
	     int exameId = Integer.parseInt(request.getParameter("id"));
	     Exame exame = exameDAO.get(exameId);
	     ModelAndView model = new ModelAndView("ExameForm");
	     model.addObject("exame", exame);
	  
	     return model;
	 }
	 
}
