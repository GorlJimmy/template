package org.linuxkernel.template.cv.controller;

import org.linuxkernel.template.cv.util.ParseUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Scope("prototype")
public class SystemController extends BaseController {

	@RequestMapping(value = "/#contact", method = RequestMethod.GET)
	private String contactLogic() {
		return "contact_us";
	}

	@RequestMapping(value = "/#about", method = RequestMethod.GET)
	private String aboutLogic() {
		return "about_us";
	}

	@RequestMapping(value = "/system", method = RequestMethod.GET)
	public String system(Model model, String requestType) {
		model.addAttribute("view", ParseUtil.Parse2Request(requestType));
		return "frontPage/template";
	}

}
