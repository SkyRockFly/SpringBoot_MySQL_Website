package com.skyrockfly.spring.security.security.controller;


import com.skyrockfly.spring.security.security.dto.ProtossUnitDto;
import com.skyrockfly.spring.security.security.dto.UserDto;
import com.skyrockfly.spring.security.security.entity.User;
import com.skyrockfly.spring.security.security.service.ProtossUnitService;
import com.skyrockfly.spring.security.security.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProtossUnitService unitService;

    @GetMapping("/login")
    public String loginPage() {
        if (isAuthenticated()) {
            return "redirect:/";
        }
        return "login";
    }

    @GetMapping("/")
    public String homePage(Model model) {
        UserDto user = getAuthenticatedUser();

        model.addAttribute("user",user);
        return "home";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register/save")
    public String registrationPage(@Valid @ModelAttribute("user") UserDto userDto,
                                   BindingResult result, Model model) {
        User existingUser = userService.findUserByEmail(userDto.getEmail());
        if (existingUser != null && existingUser.getEmail() != null
                && !existingUser.getRoles().isEmpty()) {
            result.rejectValue("email", null,
                    "There is already an account registered with the same email ");
        }

        if (result.hasErrors()) {
            model.addAttribute("user", userDto);
            return "/register";
        }

        userService.saveUser(userDto);
        return "redirect:/register?success";
    }

    @GetMapping("/users")
    public String usersPage(Model model) {
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/store")
    public String storePage(Model model) {
        ProtossUnitDto unitDto = new ProtossUnitDto();
        model.addAttribute("unit", unitDto);
        UserDto authUser = getAuthenticatedUser();
        model.addAttribute("user",authUser);
        return "store";
    }

    @PostMapping("/store")
    public String storeAccept(@Valid @ModelAttribute("unit") ProtossUnitDto unitDto, BindingResult result, Model model,
                           RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("error","error");
            return "store";
        }


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        redirectAttributes.addFlashAttribute("success","success");

        unitService.saveUnit(unitDto, username);


        return "redirect:/store";

    }

    @GetMapping("/users/{id}")
    public String userPage(@ModelAttribute("user") UserDto currentUserDto, Model model) {
        UserDto user = getAuthenticatedUser();
        model.addAttribute("user",user);


        if(user.getId() != currentUserDto.getId()){
            throw new AccessDeniedException("403 Forbidden");
        }

        List<ProtossUnitDto> units= unitService.findAllByUserId(currentUserDto.getId());
        model.addAttribute("units", units);

        return "userpage";
    }

    private boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || AnonymousAuthenticationToken.class
                .isAssignableFrom(authentication.getClass())) {
            return false;
        }
        return authentication.isAuthenticated();

    }

    private UserDto getAuthenticatedUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User authUser = userService.findUserByEmail(username);
        UserDto authUserDto = new UserDto();

        String[] str = authUser.getName().split(" ");

        authUserDto.setId(authUser.getId());
        authUserDto.setFirstName(str[0]);
        authUserDto.setLastName(str[1]);

        return authUserDto;
    }


}
