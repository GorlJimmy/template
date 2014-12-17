package org.linuxkernel.template.cv.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Scope("prototype")
public class LoginController extends BaseController {

	@RequestMapping(value = { "/login", "/" }, method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String template(Model model) {
		model.addAttribute("view", "/login");
		return "template";
	}

	@RequestMapping(value = "/header", method = RequestMethod.GET)
	public String header() {
		return "header";
	}

	@RequestMapping(value = "/panel", method = RequestMethod.GET)
	public String panel() {
		return "panel";
	}

	@RequestMapping(value = "/config", method = RequestMethod.GET)
	public String config() {
		return "configuration";
	}
}
