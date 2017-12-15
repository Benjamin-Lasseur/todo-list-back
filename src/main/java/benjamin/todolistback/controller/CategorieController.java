package benjamin.todolistback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import benjamin.todolistback.entity.Categorie;
import benjamin.todolistback.repository.CategorieRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/categories")
public class CategorieController {
	
	@Autowired
	private CategorieRepository categorieRepository;

	@GetMapping
	public List<Categorie> listerCategories(){
		return this.categorieRepository.findAll();
	}
}
