package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.MailService;

@Controller
public class MailController {
	
	@Inject
	private MailService mailService;
	
	@RequestMapping("/mail")
	public ModelAndView irAMail() {
		return new ModelAndView("mail");
	}
	
	@RequestMapping(path = "/enviarMail", method = RequestMethod.POST)
	public ModelAndView enviarMail(@RequestParam("email") String destinatario) {
		if (mailService.enviarMail(destinatario)) {
			return new ModelAndView("redirect:/restaurantes");	
		} else {
			return new ModelAndView("redirect:/mail");	
		}
			
	}
}
