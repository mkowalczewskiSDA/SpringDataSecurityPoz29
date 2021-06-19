package com.example.SpringDataSecurity.controller;

import com.example.SpringDataSecurity.model.PortalUser;
import com.example.SpringDataSecurity.service.PortalUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class PortalUserController {

    private final PortalUserService portalUserService;

    public PortalUserController(PortalUserService portalUserService) {
        this.portalUserService = portalUserService;
    }

    @GetMapping("/list")
    public String usersList(Model model,
                            @RequestParam("page")Optional<Integer> page,
                            @RequestParam("size")Optional<Integer> size
                            ) {

        int currentPage = page.orElse(1);
        int currentSize = size.orElse(5);

        Page<PortalUser> portalUserPage = portalUserService.findAllPaginated(
                PageRequest.of(currentPage, currentSize)
        );

        model.addAttribute("size", currentSize);
        model.addAttribute("portalUserPage", portalUserPage);

        int totalPages = portalUserPage.getTotalPages();
        if (totalPages>0) {
            List<Integer> pageNumbers = new ArrayList<>();
            for (int i = 1; i <= totalPages; i++) {
                pageNumbers.add(i);
            }
            model.addAttribute("pageNumbers", pageNumbers);
        }
            return "users";
    }
}