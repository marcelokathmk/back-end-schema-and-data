package br.com.bb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bb.domain.Category;
import br.com.bb.domain.Product;
import br.com.bb.repositories.CategoryRepository;
import br.com.bb.repositories.ProductRepository;
import br.com.bb.services.exception.EntityNotFoundException;

@Service
public class ProductService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findByCategory(Integer categoryId){
		Category category = categoryRepository.findOne(categoryId);
		if	(category == null) {
			throw new EntityNotFoundException("Categoria "+ categoryId + " não encontrada.");
		}
		return repository.findByCategory(category);
	}
}
