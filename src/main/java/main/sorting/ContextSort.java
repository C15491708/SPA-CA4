package main.sorting;

import java.util.ArrayList;

import main.item.Item;

public class ContextSort {
	
	private Sorting sorting;
	
	public void setSortingMethod(Sorting sorting) {
		this.sorting = sorting;
	}
	
	public Sorting getsorting() {
		return sorting;
	}
	
	public ArrayList<Item> sortAscending(ArrayList<Item> p){
		return sorting.ascendingOrder(p);	
	}

	public ArrayList<Item> sortDescending(ArrayList<Item> p){
		return sorting.descendingOrder(p);	
	}

}
