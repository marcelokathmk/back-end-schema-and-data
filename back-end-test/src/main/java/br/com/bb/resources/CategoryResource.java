package br.com.bb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bb.domain.Category;
import br.com.bb.services.CategoryService;

@RestController
@RequestMapping(value = "/category")
public class CategoryResource {

	@Autowired
	private CategoryService service;
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public ResponseEntity<List<Category>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@RequestMapping(value = "/findByNameContaining/{letter}", method = RequestMethod.GET)
	public ResponseEntity<Category> findByNameContaining(@PathVariable String letter){
		return ResponseEntity.ok().body(service.findByOccurrences(letter));
	}
}
