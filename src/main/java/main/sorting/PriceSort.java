package main.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import main.item.Item;

public class PriceSort implements Sorting {

	@Override
	public ArrayList<Item> ascendingOrder(ArrayList<Item> productList) {
		Collections.sort(productList, new Comparator<Item>() {
			@Override
			public int compare(Item i1, Item i2) {
				return Double.compare(i1.getPrice(), i2.getPrice());
			}
		});

		return productList;
	}

	@Override
	public ArrayList<Item> descendingOrder(ArrayList<Item> productList) {
		Collections.sort(productList, new Comparator<Item>() {
			@Override
			public int compare(Item i1, Item i2) {
				return Double.compare(i1.getPrice(), i2.getPrice());
			}
		});
		Collections.reverse(productList);
		return productList;
	}

}
