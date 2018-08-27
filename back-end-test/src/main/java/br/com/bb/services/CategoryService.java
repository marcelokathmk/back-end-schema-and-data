package br.com.bb.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.bb.domain.Category;
import br.com.bb.repositories.CategoryRepository;
import br.com.bb.services.exception.EntityNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findByOccurrences(String letter) {
		Category cateogry = repository.findByNameWithOccurrenceOfLetter(letter);
		if	(cateogry == null) {
			throw new EntityNotFoundException("Categoria com a letra "+ letter +" não encontrada.");
		}
		return cateogry; 
	}
}
