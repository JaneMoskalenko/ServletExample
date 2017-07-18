package Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @RequestMapping(value = {"/login"},
            method = RequestMethod.GET)

    public String login() {
        return "jsp_login";
    }

    @RequestMapping(value = {"/login"},
            method = RequestMethod.POST)
    public ModelAndView logon() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("jsp_dashboard");
        modelAndView.addObject("parameter", "hello");

        return modelAndView;
    }

    @RequestMapping("/redirect")
    public ModelAndView redirect() {
        return new ModelAndView("redirect:next");
    }

}
