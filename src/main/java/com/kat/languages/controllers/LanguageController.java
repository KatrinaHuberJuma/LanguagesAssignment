package com.kat.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;


import com.kat.languages.models.Language;
import com.kat.languages.services.LanguageService;

@Controller
public class LanguageController {
	private final LanguageService langServ;
	
	public LanguageController(LanguageService langServ) {
		this.langServ = langServ;
	}
	
	@RequestMapping("/languages")
	public String index(Model model) {
		List<Language> languages = langServ.allLanguages();
		model.addAttribute("languages", languages);
		return "/languages/index.jsp";
	}
	
	@RequestMapping(value="/languages", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("language") Language lang, BindingResult result) {
        if (result.hasErrors()) {
            return "/language/newLanguage.jsp";
        } else {
            langServ.createLanguage(lang);
            return "redirect:/languages";
        }
    }
//	@RequestMapping(value="/api/languages", method=RequestMethod.POST)
//    public Language create(@RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="currentVersion") String version) {
//        Language language = new Language(name, creator, version);
//        return langServ.createLanguage(language);
//    }
	@RequestMapping("/languages/new")
    public String newLanguage(@ModelAttribute("language") Language language) {
        return "/languages/newLanguage.jsp";
    }
}
