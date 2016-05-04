package br.com.hcpsensor.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;

import br.com.hcpsensor.dao.CrudSensorData;
import br.com.hcpsensor.model.MasterData;

@Transactional
@Controller
public class SensorTagController {

	@Autowired
	CrudSensorData dao;

	@Autowired
	public SensorTagController(CrudSensorData dao) {
		this.dao = dao;

	}

	@RequestMapping("menu")
	public ModelAndView index(HttpServletRequest request) {
		//String user = request.getRemoteUser();
		//if (user != null) {
			ModelAndView mv = new ModelAndView("index");
			return mv;
		//}
		//return null;
	}

	@RequestMapping("apresentacao")
	public ModelAndView apresentacao(final RedirectAttributes redirectAttributes) {

		redirectAttributes.addFlashAttribute("msg", "Mensagem teste");

		ModelAndView mv = new ModelAndView("apresentacao");
		MasterData sensor = new MasterData();
		mv.addObject("sensor", sensor);
		mv.addObject("SensorData", this.dao);
		return mv;
	}

	@RequestMapping(value = "inserir", method = RequestMethod.GET)
	public ModelAndView inserir() {
		ModelAndView mv = new ModelAndView("inserir2", "sensor", new MasterData());
		return mv;
	}

	@RequestMapping("gravarSensorData")
	public String gravarSensorData(MasterData sensor) {

		// 1) create a java calendar instance
		Calendar calendar = Calendar.getInstance();

		// 2) get a java.util.Date from the calendar instance.
		// this date will represent the current instant, or "now".
		java.util.Date now = calendar.getTime();

		// 3) a java current time (now) instance
		java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());

		sensor.setG_device("b458ae4a-476a-408f-a855-cc0618887a5f");
		sensor.setG_created(currentTimestamp);

		if (true == this.dao.inserirSensor(sensor)) {
		}
		;
		return "redirect:inserir";

	}

	@RequestMapping("GetTemperatura")
	public void GetTemperatura(String obj, HttpServletResponse response) throws IOException {

		if (0 == obj.compareTo("objtemp")) {

			Map<String, Double> lista = new LinkedHashMap<String, Double>();
			List<Object[]> results = this.dao.getObjtemp();

			DateFormat hora = DateFormat.getTimeInstance();

			for (Object[] result : results) {
				Date data = (Date) result[0];
				lista.put(hora.format((Date) result[0]), (Double) result[1]);
			}
			;

			String json = new Gson().toJson(lista);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
		}
		;
	}

	@RequestMapping("GetSensor")
	public void GetOpt(String obj, HttpServletResponse response )//, final RedirectAttributes redirectAttributes)
			throws IOException {

		//redirectAttributes.addFlashAttribute("msg", "Mensagem teste");

		Map<String, Double> lista = new LinkedHashMap<String, Double>();

		Double optValue = this.dao.getOpt(obj);
		lista.put("1", optValue);
		String json = new Gson().toJson(lista);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);

	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
	  session.invalidate();
	  return "redirect:menu";
	}	

}
