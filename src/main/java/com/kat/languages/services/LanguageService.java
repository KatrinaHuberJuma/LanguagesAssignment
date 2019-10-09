package com.kat.languages.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kat.languages.models.Language;
import com.kat.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	final private LanguageRepository langRepo;
	
	public LanguageService(LanguageRepository langRepo) {
		this.langRepo = langRepo;
	}
	
	public List<Language> allLanguages() {
		return langRepo.findAll();
	}
	
	public Language createLanguage(Language lang) {
		return langRepo.save(lang);
	}
}
