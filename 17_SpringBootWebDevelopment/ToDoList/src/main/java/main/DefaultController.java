package main;

import main.model.Do;
import main.model.DoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DefaultController {

    @Autowired
    private DoRepository doRepository;

    @RequestMapping("/")
    public String index(Model model) {
        Iterable<Do> iterable = doRepository.findAll();
        List<Do> todolist = new ArrayList<>();
        iterable.forEach(e -> todolist.add(e));
        model.addAttribute("todolist", todolist);

        return "index";
    }
}
