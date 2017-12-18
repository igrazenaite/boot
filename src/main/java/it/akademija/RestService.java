package it.akademija;

import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestService {

	@Autowired
	private List<Product> productsList; 
	
	@RequestMapping("/productsCollection")
	public List<Product> getProductsCollection(){
		return productsList;
	}
	@RequestMapping(value="/api/users")
	public class UserController{
		@RequestMapping (method=RequestMethod.GET)
		public List<User> getUsers(){
			return Collections.emptyList();
		}
	
		@RequestMapping (method=RequestMethod.POST)
		@ResponseStatus (HttpStatus.CREATED)
		public void createUser(@RequestBody final CreateUserCommand cmd) {
			System.out.println(cmd);
		}
	}
}
