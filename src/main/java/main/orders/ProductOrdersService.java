package main.orders;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductOrdersService {
	
	@Autowired
	private ProductOrdersRepository productRepository;
	
	public List<ProductOrders> getAllOrders(){
		List<ProductOrders> allOrders = new ArrayList<ProductOrders>();
		for(ProductOrders PurchaseHistory: productRepository.findAll()) {
			allOrders.add(PurchaseHistory);
		}
		return allOrders;
	}
	
	public ProductOrders getOrderById(int id) {
		return productRepository.findOne(id);
	}
	
	public void addOrder(ProductOrders item) {
		productRepository.save(item);
	}
	
	public void updateOrder(int id, ProductOrders item) {
		productRepository.save(item);
	}
	
	public void deleteOrder(int id) {
		productRepository.delete(id);
	}

}
