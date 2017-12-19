package lt.turgus;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<ProductForClient> receiveAllProducts(){
		List<Product> productsFromDatabase = getProductRepository().findAll();
		List<ProductForClient> productsForClient =
				productsFromDatabase
				.stream()
				.map((product)->{ProductForClient pfc = new ProductForClient();
				pfc.setName(product.getName());
				pfc.setPrice(product.getPrice());
				pfc.setQuantity(product.getQuantity());
				pfc.setDescription(product.getDescription());
				return pfc;
				})
				.collect(Collectors.toList());
		return productsForClient;
	}

	public ProductRepository getProductRepository() {
		return productRepository;
	}

	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
}
