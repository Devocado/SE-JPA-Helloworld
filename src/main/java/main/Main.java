package main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import entity.Customer;
import entity.Item;
import persistence.PersistenceService;

public class Main {

	public static void main(String[] args) {
		PersistenceService persistenceService = new PersistenceService();
		persistenceService.createEntityManager();
		
		List<Item> items = new ArrayList<>();
		
		items.add(new Item("Ice cream maker", BigDecimal.valueOf(6_999.99)));
		items.add(new Item("Microwave oven", BigDecimal.valueOf(7_599.99)));
		items.add(new Item("Automatic peeler", BigDecimal.valueOf(300.00)));
		items.add(new Item("Candyfloss maker", BigDecimal.valueOf(750.99)));
		
		items.forEach(persistenceService::persist);
		
		Customer customer = new Customer("Jane", "Everns", "jeverns@gmail.com");
		
		persistenceService.persist(customer);
		
		persistenceService.closeEntityManager();
		

	}

}
