package br.com.bb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bb.domain.Category;
import br.com.bb.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	public List<Product> findByCategory(Category category);
}
