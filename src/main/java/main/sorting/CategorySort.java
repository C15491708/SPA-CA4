package main.sorting;

import java.util.ArrayList;
import java.util.Collections;

import main.item.Item;

public class CategorySort implements Sorting {

	@Override
	public ArrayList<Item> ascendingOrder(ArrayList<Item> productList) {
		Collections.sort(productList, (p1, p2) -> p1.getCategory().compareTo(p2.getCategory()));

		return productList;
	}

	@Override
	public ArrayList<Item> descendingOrder(ArrayList<Item> productList) {
		Collections.sort(productList, (p1, p2) -> p1.getCategory().compareTo(p2.getCategory()));
		Collections.reverse(productList);
	
		return productList;
	}



}
