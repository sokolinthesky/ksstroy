package ua.ksstroy.web;



import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.ksstroy.logic.project.ProjectManager;





@Controller
public class WelcomeControllerForTest {
	
	@Resource
	private ProjectManager projectService;


	private final Logger logger = LoggerFactory.getLogger(WelcomeControllerForTest.class);

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String testRootPage() {
		return "index";
	}

//	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
//	public ModelAndView hello(@PathVariable("name") String name) {
//
//		logger.debug("hello() is executed - $name {}", name);
//
//		ModelAndView model = new ModelAndView();
//		model.setViewName("index");
//		
//		model.addObject("title", helloWorldService.getTitle(name));
//		model.addObject("msg", helloWorldService.getDesc());
//
//		return model;
//
//	}
	

}