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
import spring.example.service.BoxService;

@Controller
class MainController {


    @Autowired
    public BoxService boxService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String openIndex(ModelMap model) {
        model.addAttribute("boxes", boxService.getBoxInfo());
        return "boxes";
    }


    @RequestMapping(value = " /showBoxInfo/{id}", method = RequestMethod.GET)
    public String showBoxInfo(@PathVariable("id") Long id, Model model) {
        model.addAttribute("info", boxService.getBoxesById(id));
        return "boxInfo";
    }


    @RequestMapping(value = "/addBox", method = RequestMethod.GET)
    public String getAddBoxPage() {
        return "addBox";
    }


    @RequestMapping(value = "/addBox", method = RequestMethod.POST)
    public String addBoxesEntity(Box box) {
        boxService.addBox(box);
        return "redirect:/";
    }


//
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String openIndex(ModelMap model) {
//        model.addAttribute("type", Type.values());
//        return "index";
//    }

    @RequestMapping("/showName/{id}")
    public String getNameById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("info", boxService.getInfoById(id));
        return "show";
    }


    @RequestMapping("/show/{type}")
    public String getBoxesName(@PathVariable("type") String type, Model model) {
        model.addAttribute("info", boxService.getInfoByType(type));
        return "showBoxesName";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddPage() {
        return "add";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addBoxesEntity(Info info) {
        boxService.add(info);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id) {
        boxService.delete(id);
        return "redirect:/";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(Info info) {
        boxService.edit(info);
        return "redirect:/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String getEditPage(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("info", boxService.getInfoById(id));
        return "edit";
    }
}







