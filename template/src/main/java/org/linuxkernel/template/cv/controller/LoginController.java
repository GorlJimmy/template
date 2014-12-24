package org.linuxkernel.template.cv.controller;

import org.linuxkernel.template.cv.util.ParseUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Scope("prototype")
public class LoginController extends BaseController {

	@RequestMapping(value = { "/#login", }, method = RequestMethod.GET)
	private String loginLogic() {
		return "frontPage/login";
	}

	@RequestMapping(value = "/#index")
	private String indexLogic() {
		return "frontPage/index";
	}

	@RequestMapping(value = "/#regist")
	private String registLogic() {
		return "frontPage/regist";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String template(Model model) {
		model.addAttribute("view", "/#login");
		return "template";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model, String requestType) {
		model.addAttribute("view", ParseUtil.Parse2Request(requestType));

		return "template";
	}

}
