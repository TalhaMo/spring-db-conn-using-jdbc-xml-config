package org.studyeasy.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.studyeasy.spring.DAO.AppDAOImpl;
import org.studyeasy.spring.model.User;

@Controller
public class AppController {

	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView modelAndView=new ModelAndView("home");
		List<User> users = new ArrayList<User>();
		ClassPathXmlApplicationContext context
		= new ClassPathXmlApplicationContext("/org/studyeasy/spring/DAO/Spring-AppDAOConfig.xml");
	
		AppDAOImpl DAO = context.getBean("DAOBean", AppDAOImpl.class);
		
		users = DAO.listUsers();
        modelAndView.addObject("users", users);
		context.close();
		return modelAndView;
	}
}
