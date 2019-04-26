package main.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.usertype.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import main.card.AbstractValidator;
import main.card.AmericanExpress;
import main.card.MasterCard;
import main.card.Visa;
import main.item.Item;
import main.item.ItemService;
import main.orders.ProductOrders;
import main.orders.ProductOrdersService;
import main.sorting.CategorySort;
import main.sorting.ContextSort;
import main.sorting.ManufacturerSort;
import main.sorting.NameSort;
import main.sorting.PriceSort;
import main.stock.InStock;
import main.stock.OutStock;
import main.stock.StockState;
import main.user.User;
import main.user.UserService;

@Controller
public class ApplicationController {

	@Autowired
	private UserService userService;

	@Autowired
	private ItemService itemService;

	@Autowired
	private ProductOrdersService productOrderService;

	private ArrayList<Item> shoppingCart = new ArrayList<Item>();

	@PostMapping("/addItem")
	public String addStock(HttpServletRequest request, HttpSession session) {
		String title = request.getParameter("title");
		String manu = request.getParameter("manufacturer");
		double price = Double.parseDouble(request.getParameter("price"));
		String category = request.getParameter("category");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String photo = request.getParameter("photo");

		boolean state;
		StockState noStock = new OutStock();
		StockState inStock = new InStock();

		if (quantity <= 0) {
			state = noStock.stateOfStock();
		} else {
			state = inStock.stateOfStock();
		}

		Item i = new Item(title, manu, category, photo, price, quantity, state);
		itemService.addItem(i);

		return "admin";
	}

	@PostMapping("/cardPurchase")
	public String cardPurchase(@SessionAttribute("user") User u, HttpServletRequest request, HttpSession session) {

		String cardName = request.getParameter("cardName");
		String LongCardNum = request.getParameter("LongCardNum");
		int expiryDateMonth = Integer.parseInt(request.getParameter("expiryDateMonth"));
		int expiryDateYear = Integer.parseInt(request.getParameter("expiryDateYear"));
		String cvv = request.getParameter("cvv");
		boolean Cardresult = false;
		AbstractValidator validator = null;

		String cardType = request.getParameter("cardType");
		if (cardType.equals("Visa Card")) {
			validator = new Visa(ApplicationController.this, cardName, LongCardNum, expiryDateMonth, expiryDateYear,
					cvv);

		} else if (cardType.equals("MasterCard")) {
			validator = new MasterCard(ApplicationController.this, cardName, LongCardNum, expiryDateMonth,
					expiryDateYear, cvv);

		} else if (cardType.equals("American Express")) {
			validator = new AmericanExpress(ApplicationController.this, cardName, LongCardNum, expiryDateMonth,
					expiryDateYear, cvv);

		}

		Cardresult = validator.validate();

		if (!Cardresult) {

			request.setAttribute("Error", "Invalid Card Details");
			return "PurchasePage";
		} else {
			double Fullprice = Double.parseDouble(request.getParameter("p"));
			ProductOrders O = new ProductOrders(Fullprice);
			productOrderService.addOrder(O);

			ProductOrders O1 = productOrderService.getOrderById(O.getProductId());
			for (Item i : shoppingCart) {
				O1.getProducts().add(i);
			}
			productOrderService.updateOrder(O1.getProductId(), O1);

			int userId = u.getCustomerId();
			User newUser = userService.getUserById(userId);
			newUser.getUserOrders().add(O1);
			userService.updateUser(userId, u);

			shoppingCart.clear();
			return "home";
		}
	}

	@RequestMapping("/index")
	public String welcome() {
		return "index";
	}

	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@RequestMapping("/Aitem")
	public String addItemAdmin() {
		return "Aitem";
	}

	@RequestMapping("/Asearch")
	public String searchItemAdmin() {
		return "Asearch";
	}

	@RequestMapping("/searchProducts")
	public String searchProducts() {
		return "search";
	}

	@RequestMapping("/search")
	public String search() {
		return "search";
	}

	@PostMapping("/addUser")
	public String registerUser(HttpServletRequest request, HttpSession session) {
		String first = request.getParameter("firstName");
		String last = request.getParameter("lastName");
		String date = request.getParameter("dob");
		String uname = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("shippingAddress");
		String method = request.getParameter("paymentMethod");

		User u = new User(first, last, date, uname, password, address, method);
		userService.addUser(u);
		session.setAttribute("user", u);

		return "home";
	}

	@RequestMapping("/UserSearch")
	public String searchUser(@RequestParam("search") String search, HttpServletRequest request, HttpSession session) {

		ArrayList<Item> items = (ArrayList<Item>) itemService.getAllItems();
		ArrayList<Item> searchStock = new ArrayList<Item>();
		if (request.getParameter("category") != null) {
			for (Item i : items) {
				if (i.getCategory().contains(search)) {
					searchStock.add(i);
				}
			}
			session.setAttribute("searchResult", searchStock);
			return "results";

		} else if (request.getParameter("manufacturer") != null) {
			for (Item i : items) {
				if (i.getManufacturer().equalsIgnoreCase(search)) {
					searchStock.add(i);
				}
			}

			session.setAttribute("searchResult", searchStock);
			return "results";

		} else if (request.getParameter("title") != null) {
			for (Item i : items) {
				if (i.getTitle().contains(search)) {
					searchStock.add(i);
				}
			}

			session.setAttribute("searchResult", searchStock);
			return "results";

		} else {
			return "search";
		}
	}

	@RequestMapping("adminSearch")
	public String adminSearch(@RequestParam("search") String search, HttpServletRequest request, HttpSession session) {

		ArrayList<Item> items = (ArrayList<Item>) itemService.getAllItems();
		ArrayList<Item> AdminSearchProducts = new ArrayList<Item>();
		if (request.getParameter("category") != null) {
			for (Item i : items) {
				if (i.getCategory().contains(search)) {
					AdminSearchProducts.add(i);
				}
			}

			session.setAttribute("adminSearch", AdminSearchProducts);

			return "Aresults";

		} else if (request.getParameter("manufacturer") != null) {
			for (Item i : items) {
				if (i.getManufacturer().equalsIgnoreCase(search)) {
					AdminSearchProducts.add(i);
				}
			}

			session.setAttribute("adminSearch", AdminSearchProducts);
			return "Aresults";

		} else if (request.getParameter("title") != null) {
			for (Item i : items) {
				if (i.getTitle().contains(search)) {
					AdminSearchProducts.add(i);
				}
			}

			session.setAttribute("adminSearch", AdminSearchProducts);
			return "Aresults";

		} else {
			return "Asearch";
		}
	}

	@RequestMapping("/login")
	public String loginUser(@ModelAttribute User u, HttpServletRequest request, HttpSession session) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (userService.getUserByUsernameAndPassword(username, password) != null) {
			u = userService.getUserByUsernameAndPassword(username, password);
			session.setAttribute("user", u);

			return "home";

		} else if (username.equalsIgnoreCase("Admin") && password.equalsIgnoreCase("Admin123")) {
			session.setAttribute("admin", username);
			return "admin";

		} else {
			request.setAttribute("error", "Invalid Username or Password");
			return "index";
		}
	}

	@RequestMapping("/purchase")
	public String purchase() {
		return "purchase";
	}

	@RequestMapping("/userCart")
	public String userShoppingshoppingCart(HttpSession session) {
		int count = 0;
		double price = 0.0;
		for (Item currentItem : shoppingCart) {
			count = count + 1;
			double prodPrice = currentItem.getPrice();
			price = price + prodPrice;
		}
		session.setAttribute("fullPrice", price);
		session.setAttribute("quantity", count);
		return "userCart";
	}

	@RequestMapping("/updateShoppingCart")
	public String addProduct(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("goodId"));
		Item newItem = itemService.getItemById(id);

		shoppingCart.add(newItem);
		
		newItem.setQuantity(newItem.getQuantity() -1);

		boolean state;
		StockState noStock = new OutStock();
		StockState inStock = new InStock();
		
		if (newItem.getQuantity() <= 0) {
			state = noStock.stateOfStock();
		}
		else {
			state = inStock.stateOfStock();
		}
		newItem.setState(state);

		HttpSession session = request.getSession();
		session.setAttribute("list", shoppingCart);

		return "home";
	}

	@RequestMapping("/adminResults")
	public String sortResults(@SessionAttribute("AdminSearchResult") ArrayList<Item> searchStock,
			HttpServletRequest request, HttpSession session) {
		String sortBy = request.getParameter("sortBy");
		String order = request.getParameter("orderList");

		ContextSort context = new ContextSort();
		if (sortBy.equals("Title")) {
			context.setSortingMethod(new NameSort());
			if (order.equals("Ascending Order")) {
				context.sortAscending(searchStock);
			} else if (order.equals("Descending Order")) {
				context.sortDescending(searchStock);
			}
		} else if (sortBy.equals("Price")) {
			context.setSortingMethod(new PriceSort());
			if (order.equals("Ascending Order")) {
				context.sortAscending(searchStock);
			} else if (order.equals("Descending Order")) {
				context.sortDescending(searchStock);
			}
		} else if (sortBy.equals("Manufacturer")) {
			context.setSortingMethod(new ManufacturerSort());
			if (order.equals("Ascending Order")) {
				context.sortAscending(searchStock);
			} else if (order.equals("Descending Order")) {
				context.sortDescending(searchStock);
			}
		} else if (sortBy.equals("Category")) {
			context.setSortingMethod(new CategorySort());
			if (order.equals("Ascending Order")) {
				context.sortAscending(searchStock);
			} else if (order.equals("Descending Order")) {
				context.sortDescending(searchStock);
			}
		}

		return "Aresults";
	}

	@RequestMapping("/userResults")
	public String userResults(@SessionAttribute("searchResult") ArrayList<Item> searchStock, HttpServletRequest request,
			HttpSession session) {
		String sortBy = request.getParameter("sortBy");
		String order = request.getParameter("orderList");

		ContextSort context = new ContextSort();
		if (sortBy.equals("Title")) {
			context.setSortingMethod(new NameSort());
			if (order.equals("Ascending Order")) {
				context.sortAscending(searchStock);
			} else if (order.equals("Descending Order")) {
				context.sortDescending(searchStock);
			}
		} else if (sortBy.equals("Price")) {
			context.setSortingMethod(new PriceSort());
			if (order.equals("Ascending Order")) {
				context.sortAscending(searchStock);
			} else if (order.equals("Descending Order")) {
				context.sortDescending(searchStock);
			}
		} else if (sortBy.equals("Manufacturer")) {
			context.setSortingMethod(new ManufacturerSort());
			if (order.equals("Ascending Order")) {
				context.sortAscending(searchStock);
			} else if (order.equals("Descending Order")) {
				context.sortDescending(searchStock);
			}
		} else if (sortBy.equals("Category")) {
			context.setSortingMethod(new CategorySort());
			if (order.equals("Ascending Order")) {
				context.sortAscending(searchStock);
			} else if (order.equals("Descending Order")) {
				context.sortDescending(searchStock);
			}
		}

		return "results";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		shoppingCart.clear();
		session.invalidate();
		return "index";
	}
}
