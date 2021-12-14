package com.gyapeee.learnuml.controller;

import com.gyapeee.learnuml.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @Autowired
    private UserRepository userRepository;

    private static final String codeBlock = "/**\n" +
            "* Copy reference when passing-by-value\n" +
            "*/\n" +
            "class Apple {\n" +
            "    public String color = \"red\";\n" +
            "}\n" +
            "\n" +
            "public class Main {\n" +
            "    public static void main(String[] args) {\n" +
            "        // the Original reference\n" +
            "        Apple apple = new Apple();\n" +
            "        System.out.println(apple.color);\n" +
            "\n" +
            "        // Copied reference\n" +
            "        changeApple(apple);\n" +
            "        System.out.println(apple.color);\n" +
            "    }\n" +
            "\n" +
            "    public static void changeApple(Apple apple) {\n" +
            "        apple.color = \"green\";\n" +
            "    }\n" +
            "}";

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("code", codeBlock);
        return "index";
    }
}
