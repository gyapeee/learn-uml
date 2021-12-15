package com.gyapeee.learnuml.controller;

import com.gyapeee.learnuml.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AppController {
    private static final Logger logger = LoggerFactory.getLogger(AppController.class);

    @Autowired
    private UserRepository userRepository;

    private static final String codeBlock =
            "/**\n" + "* Copy reference when passing-by-value\n" + "*/\n" + "class Apple {\n"
                    + "    public String color = \"red\";\n" + "}\n" + "\n" + "public class Main {\n"
                    + "    public static void main(String[] args) {\n" + "        // the Original reference\n"
                    + "        Apple apple = new Apple();\n" + "        System.out.println(apple.color);\n" + "\n"
                    + "        // Copied reference\n" + "        changeApple(apple);\n"
                    + "        System.out.println(apple.color);\n" + "    }\n" + "\n"
                    + "    public static void changeApple(Apple apple) {\n" + "        apple.color = \"green\";\n"
                    + "    }\n" + "}";

    private static final String output = "red\n" + "            green";

    @GetMapping("/")
    public String viewHomePage(Model model) {
//        model.addAttribute("dummy", "Justify that ThymeLeaf is working");
        model.addAttribute("code", codeBlock);
        model.addAttribute("output", output);
        logger.debug("Passing the model to the frontend: \n" + model);
//        logger.info("Passing the model to the frontend: \n" + model);
//        logger.trace("Passing the model to the frontend: \n" + model);
//        logger.warn("Passing the model to the frontend: \n" + model);
//        logger.error("Passing the model to the frontend: \n" + model);
        return "index";
    }
}
