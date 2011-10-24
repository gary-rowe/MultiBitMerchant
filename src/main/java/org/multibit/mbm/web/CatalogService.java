package org.multibit.mbm.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CatalogService {

  @RequestMapping("/authenticate.html")
  public ModelAndView authenticate() {

    return new ModelAndView("authenticate");
  }

  @RequestMapping("/index.html")
  public ModelAndView index() {

    // TODO Add a model
    return new ModelAndView("index");
  }
}