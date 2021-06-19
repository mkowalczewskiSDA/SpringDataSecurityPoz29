package com.example.SpringDataSecurity.controller;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/admin/page")
    public String adminPage() {
        return "admin";
    }

    @GetMapping("/logout")
    public String logoutPage(HttpServletRequest request
            , HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder
                .getContext().getAuthentication();
        if (authentication.isAuthenticated()) {
            new SecurityContextLogoutHandler()
                    .logout(request, response, authentication);
        }
        return "redirect:/login?logout";
    }

    @GetMapping("/user")
    //@PostAuthorize("hasAuthority('ADMIN')")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public String userPage(Authentication authentication) {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        if(authorities.contains(new SimpleGrantedAuthority("ADMIN"))) {
            return "userPage";
        } else {
            return "home";
        }
        /*System.out.println("ten kod działa");
        return "userPage";*/
    }
}
