package main.orders;

import org.springframework.data.repository.CrudRepository;

public interface ProductOrdersRepository extends CrudRepository<ProductOrders, Integer> {

}
