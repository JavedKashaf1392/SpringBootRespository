package in.nit.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import in.nit.model.Product;

public interface IProductService {
	//pagination
	public Page<Product> getProductPage(Pageable p);
	
	//save product
	public Integer saveProduct(Product product);
	//fetch all records 
	public List<Product> getAllProducts();
	//delete product 
	public void deleteById(Integer id);
	//fetch one product 
	public Product fetchOneProduct(Integer id);
	//update product 
	public void updateProduct(Product product);
	//is record exist by given id
	public boolean isExist(Integer id);
	//for ajax 
	public Integer countProductCode(String prodCode);
	
	

}
