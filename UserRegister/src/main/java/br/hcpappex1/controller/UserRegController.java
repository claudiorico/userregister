package br.hcpappex1.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.hcpappex1.dao.UserRegisterManager;
import br.hcpappex1.model.UserRegister;

@Transactional
@Controller
public class UserRegController {

	@Autowired
	UserRegisterManager manager;

	@Autowired
	public UserRegController(UserRegisterManager manager) {
		this.manager = manager;
	}

	@RequestMapping("insertUser")
	public String insert(HttpServletRequest request) {

		try {

			UserRegister newrecord = new UserRegister();

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date d = sdf.parse("01/04/1982");

			Calendar birthdate = Calendar.getInstance();
			birthdate.setTime(d);
			;

			newrecord.setFirst_name("Jose");
			newrecord.setLast_name("Silva");
			newrecord.setPhone_number("11867668777");
			newrecord.setBirth_date(birthdate);

			if (manager.insertRegister(newrecord)) {

				request.setAttribute("first_name", newrecord.getFirst_name());
				return "sucess";

			}

		} catch (Exception e) {

			System.out.printf(e.getMessage());
			e.printStackTrace();

		}
		return null;

	}

	@RequestMapping("insert")
	public ModelAndView insert_new() {
		ModelAndView mv = new ModelAndView("register");
		UserRegister newuser = new UserRegister();
		mv.addObject("newuser", newuser);
		return mv;
	}

	@RequestMapping("recordNew")
	public String record_new(UserRegister newuser, HttpServletRequest request) {
		if (newuser != null) {
			if (manager.insertRegister(newuser) == true) {
				request.setAttribute("first_name", newuser.getFirst_name());
				return "sucess";
			}
		}
		return "redirect:insert";
	}

}
