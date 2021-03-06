package com.codesquad.baseball07.controller;

import com.codesquad.baseball07.service.LoginService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/github-login")
    public RedirectView githubLogin() {
        String redirectUri = loginService.getRedirectUri();
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(redirectUri);
        return redirectView;
    }

    @GetMapping("/login")
    public RedirectView login(@RequestParam String code, HttpServletResponse httpServletResponse) {
        String jws = this.loginService.authenticate(code);
        Cookie cookie = new Cookie(loginService.getCookieName(), jws);
        httpServletResponse.addCookie(cookie);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(loginService.getFrontMainUri());
        return redirectView;
    }
}
