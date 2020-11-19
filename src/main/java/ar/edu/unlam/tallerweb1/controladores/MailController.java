package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.MailService;

@Controller
public class MailController {
	
	private MailService mailService;
	
	@Inject
	public MailController(MailService mailService) {
		this.mailService = mailService;
	}
	
	@RequestMapping("/mail")
	public ModelAndView irAMail() {
		return new ModelAndView("mail");
	}
	
	@RequestMapping(path = "/enviarMail", method = RequestMethod.POST)
	public ModelAndView enviarMail(@RequestParam("email") String destinatario) {
		ModelMap modelo = new ModelMap();
		
		if (mailService.enviarMail(destinatario)) {
			modelo.put("resultadoMail", "El mail fue enviado exitosamente");
		} else {
			modelo.put("resultadoMail", "Ocurrio un error al enviar el mail. Intente nuevamente.");
		}
		
		return new ModelAndView("resultadoMail", modelo);
	}
}
