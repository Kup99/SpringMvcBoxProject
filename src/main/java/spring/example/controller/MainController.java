package spring.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.example.model.Box;
import spring.example.model.Info;
import spring.example.model.Type;
import spring.example.service.BoxService;

@Controller
class MainController {


    @Autowired
    public BoxService boxService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String openIndex(ModelMap model) {
        model.addAttribute("boxes", boxService.getBoxInfo());
        return "index";
    }


    @RequestMapping(value = "/getBoxEntity/{id}", method = RequestMethod.GET)
    public String getBoxInfo(@PathVariable("id") Long id, Model model) {
        model.addAttribute("boxInfo", boxService.getBoxesById(id));
        return "boxInfo";
    }


    @RequestMapping(value = "/addBox", method = RequestMethod.GET)
    public String getAddBoxPage() {
        return "addBox";
    }


    @RequestMapping(value = "/addBox", method = RequestMethod.POST)
    public String addBox(Box box) {
        boxService.addBox(box);
        return "redirect:/";
    }


    @RequestMapping(value = "/addBoxEntity/{boxId}", method = RequestMethod.POST)
    public String addBoxEntity(@PathVariable Long boxId, Info info) {
        System.out.println(info.toString());
        boxService.add(boxId, info);
        return "redirect:/";
    }


    @RequestMapping("/addBoxEntity/{id}")
    public String getAddBoxEntityPage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("entity", boxService.getBoxesById(id));
        model.addAttribute("type", Type.values());
        return "addBoxEntity";
    }
}






