package com.keyin.User;

import com.keyin.BinarySearchTree.BinarySearchTree;
import com.keyin.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public ModelAndView showHomePage(){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;

    }
    @GetMapping("/user-input")
    public String showUserInput(){
        return "user-input";
    }

    @PostMapping("/process-number")
    public String processUserInput(@RequestParam("numbers")String numbers, Model model){
        System.out.println("User input: " + numbers);

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        String[] numberArray = numbers.split(("\\s+"));
        for (String number: numberArray){
            try {
                int value = Integer.parseInt(number);
                binarySearchTree.insert(value);
            }catch(NumberFormatException e){
            }
        }
        String jsonTree = binarySearchTree.toJson();

        User user1 = new User();
        user1.setUserInput(numbers);
        user1.setTree(jsonTree);
        userRepository.save(user1);

        model.addAttribute("jsonData", jsonTree);

        return "process-number";
    }
    @GetMapping("/previous-trees")
    public String showPreviousTrees(Model model){
        List<User> userInputList = userRepository.findAll();
        List<String> jsonTreeList = new ArrayList<>();

        for(User userInput:userInputList){
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            String[] numberArray = userInput.getUserInput().split("\\s+");
            for(String number:numberArray){
                try{
                    int value = Integer.parseInt(number);
                    binarySearchTree.insert(value);
                }catch(NumberFormatException e){}}
            String jsonTree = binarySearchTree.toJson();
            jsonTreeList.add(jsonTree);

        }
        model.addAttribute("jsonTreeList",jsonTreeList);
        return "previous-Trees";
    }
}
