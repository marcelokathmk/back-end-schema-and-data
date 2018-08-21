package br.com.bb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bb.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
