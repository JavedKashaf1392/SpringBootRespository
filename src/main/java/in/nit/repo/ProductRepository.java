package in.nit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.nit.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
	
	@Query("select count(prodCode) from Product where prodCode=:prodCode")
	Integer countProductCode(String prodCode);

}
