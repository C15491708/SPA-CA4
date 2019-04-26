package main.orders;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import main.item.Item;

@Entity
public class ProductOrders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	private double Fullprice;

	@ManyToMany(targetEntity = Item.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Item> products = new HashSet<Item>();

	public ProductOrders() {

	}
	public ProductOrders(double Fullprice) {
		this.Fullprice = Fullprice;
	}

	public ProductOrders(int productId, double fullprice) {
		this.productId = productId;
		this.Fullprice = fullprice;

	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public double getFullprice() {
		return Fullprice;
	}

	public void setFullprice(double fullprice) {
		Fullprice = fullprice;
	}

	public Set<Item> getProducts() {
		return products;
	}

	public void setProducts(Set<Item> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "ItemOrders [productId=" + productId + ", FullPrice=" + Fullprice + ", products=" + products + "]";
	}
}
