package vn.minxi.repository;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import vn.minxi.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	@Query("""
			 select p from Product p join fetch p.user u
			 where lower(p.name) like lower(concat('%', :keyword, '%'))
			 or lower(coalesce(p.description, '')) like lower(concat('%', :keyword,
			'%'))
			 """)
	Page<Product> search(@Param("keyword") String keyword, Pageable pageable);

	Page<Product> findByUserId(Long userId, Pageable pageable);

	long countByUserId(Long userId);
}