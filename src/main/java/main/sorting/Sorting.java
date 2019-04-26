package main.sorting;

import java.util.ArrayList;

import main.item.Item;

public interface Sorting {
	
	public ArrayList<Item> ascendingOrder(ArrayList<Item> productList);
	public ArrayList<Item> descendingOrder(ArrayList<Item> productList);

}
