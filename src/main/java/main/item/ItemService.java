package main.item;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;
		
	public List<Item> getAllItems(){
		List<Item> items = new ArrayList<Item>();
		for(Item i: itemRepository.findAll()) {
			items.add(i);
		}
		return items;
	}
	
	public Item getItemById(int id) {
		return itemRepository.findOne(id);
	}
	
	
	public void addItem(Item item) {
		itemRepository.save(item);
	}
	
	public void updateItem(int id, Item item) {
		itemRepository.save(item);
	}
	
	public void deleteItem(int id) {
		itemRepository.delete(id);
	}

}