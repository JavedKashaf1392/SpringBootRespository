package in.nit.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import in.nit.model.Product;
import in.nit.repo.ProductRepository;
@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	private ProductRepository repo;

	@Override
	public Integer saveProduct(Product product) {
		Integer id=repo.save(product).getProdId();
		return id;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> list=repo.findAll();
		Collections.sort(list,(p1,p2)->p1.getProdId()-p2.getProdId()); //ASC Order
		//Collections.sort(list, (p1,p2)->p2.getProdId()-p1.getProdId()); //DESC Order
		return list;
	}

	@Override
	public void deleteById(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public Product fetchOneProduct(Integer id) {
		Product prod=null;
		Optional<Product> opt=repo.findById(id);
		if(opt.isPresent()) {
			prod=opt.get();
		}
		return prod;
	}

	@Override
	public void updateProduct(Product product) {
		repo.save(product);

	}

	@Override
	public boolean isExist(Integer id) {
		boolean exist=repo.existsById(id);
		return exist;
	}

	@Override
	public Page<Product> getProductPage(Pageable p) {
		         
		return repo.findAll(p);
	}

	@Override
	public Integer countProductCode(String prodCode) {
		return repo.countProductCode(prodCode);
	}

}
