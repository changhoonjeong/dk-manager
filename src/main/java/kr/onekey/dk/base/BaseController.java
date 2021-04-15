package kr.onekey.dk.base;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/{version}"})
public class BaseController {

  @Autowired
  public HttpServletRequest request;

    public Locale getLocale() {
      return Locale.forLanguageTag(request.getHeader("Accept-Language").replace("_", "-"));
    }
}
