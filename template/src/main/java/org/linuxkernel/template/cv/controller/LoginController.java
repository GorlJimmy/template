package org.linuxkernel.template.cv.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Scope("prototype")
public class LoginController extends BaseController {

	@RequestMapping(value = { "/#login", }, method = RequestMethod.GET)
	public String loginLogic() {
		return "frontPage/login";
	}

	@RequestMapping(value = "/#index")
	public String indexLogic() {
		return "frontPage/index";
	}

	@RequestMapping(value = "/#regist")
	public String registLogic() {
		return "frontPage/regist";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String template(Model model) {
		model.addAttribute("view", "/#login");
		return "frontPage/template";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(
			Model model,
			@RequestParam(value = "action", required = true, defaultValue = "index") String action) {
		switch (action) {
		case "regist":
			model.addAttribute("view", "/#regist");
			break;
		default:
			model.addAttribute("view", "/#index");
			break;
		}

		return "frontPage/template";
	}

}
