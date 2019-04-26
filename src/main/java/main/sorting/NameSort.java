package main.sorting;

import java.util.ArrayList;
import java.util.Collections;

import main.item.Item;

public class NameSort implements Sorting {

	@Override
	public ArrayList<Item> ascendingOrder(ArrayList<Item> productList) {
		Collections.sort(productList, (p1, p2) -> p1.getTitle().compareTo(p2.getTitle()));

		return productList;
	}

	@Override
	public ArrayList<Item> descendingOrder(ArrayList<Item> productList) {
		Collections.sort(productList, (p1, p2) -> p1.getTitle().compareTo(p2.getTitle()));
		Collections.reverse(productList);
		
		return productList;
	}

}
