package lt.turgus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/rest/product", method = RequestMethod.GET)
	public List<ProductForClient> giveAllProducts(){
		return getProductService().receiveAllProducts();
	}

	@RequestMapping(value = "/rest/product", method = RequestMethod.POST)
	public void createProduct(CreateProductCommand cmd){
	}
	
	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
}
