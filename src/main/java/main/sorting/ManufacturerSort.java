package main.sorting;

import java.util.ArrayList;
import java.util.Collections;

import main.item.Item;

public class ManufacturerSort implements Sorting  {

	@Override
	public ArrayList<Item> ascendingOrder(ArrayList<Item> productList) {
		Collections.sort(productList, (p1, p2) -> p1.getManufacturer().compareTo(p2.getManufacturer()));

		return productList;
	}

	@Override
	public ArrayList<Item> descendingOrder(ArrayList<Item> productList) {
		Collections.sort(productList, (p1, p2) ->p1.getManufacturer().compareTo(p2.getManufacturer()));
		Collections.reverse(productList);
		return null;
	}

}
