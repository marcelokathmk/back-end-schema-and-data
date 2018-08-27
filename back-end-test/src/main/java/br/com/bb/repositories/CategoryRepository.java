package br.com.bb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.bb.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

	@Query(value = "SELECT 	C.* "
				 + "FROM 	Category C "
				 + "WHERE	lower(C.NAME) LIKE CONCAT('%',:letterLike,'%') "
				 + "ORDER BY length(lower(C.NAME)) - (length(replace(lower(C.NAME),lower(:letter),''))) DESC LIMIT 1",
		   nativeQuery = true)
	public Category findByNameWithOccurrenceOfLetter(@Param("letterLike") String letterLike, @Param("letter") String letter);
}
