package br.com.bb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.bb.domain.Product;
import br.com.bb.services.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductResource {

	@Autowired
	private ProductService service;
	
	@RequestMapping(value = "/listByCategory/{categoryId}", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> listByCategory(@PathVariable Integer categoryId){
		List<Product> products = service.findByCategory(categoryId);
		return ResponseEntity.ok().body(products);
	}
}
