package hellow.world;

import java.util.*;

class Product implements Comparable<Product> {
    private Integer id;
    private String name;
    private double price;
    private int stock;

    public Product(Integer id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }


    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }

    @Override
    public int compareTo(Product other) {
        return Double.compare(this.price, other.price);
    }

    public static Comparator<Product> compareByName = new Comparator<Product>() {
        @Override
        public int compare(Product p1, Product p2) {
            return p1.getName().compareTo(p2.getName());
        }
        public  Comparator<Product> compareByName = new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getName().compareTo(p2.getName());
            }
        };

        public  Comparator<Product> compareByStock = new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return Integer.compare(p1.getStock(), p2.getStock());
            }
        };

    };


    public static Comparator<Product> compareByStock = new Comparator<Product>() {
        @Override
        public int compare(Product p1, Product p2) {
            return Integer.compare(p1.getStock(), p2.getStock());
        }
    };
}

class User {
    private Integer id;
    private String username;
    private Map<Product, Integer> cart;

    public User(Integer id, String username) {
        this.id = id;
        this.username = username;
        this.cart = new HashMap<>();
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public Map<Product, Integer> getCart() { return cart; }
    public void setCart(Map<Product, Integer> cart) { this.cart = cart; }

    public void addToCart(Product product, Integer quantity) {
        this.cart.put(product, this.cart.getOrDefault(product, 0) + quantity);
    }

    public void removeFromCart(Product product) {
        this.cart.remove(product);
    }

    public void updateCart(Product product, Integer quantity) {
        this.cart.put(product, quantity);
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", cart=" + cart +
                '}';
    }
}

class Order {
    private Integer id;
    private Integer userId;
    private Map<Product, Integer> orderDetails;
    private double totalPrice;

    public Order(Integer id, Integer userId, Map<Product, Integer> orderDetails) {
        this.id = id;
        this.userId = userId;
        this.orderDetails = orderDetails;
        this.totalPrice = calculateTotalPrice();

    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }
    public Map<Product, Integer> getOrderDetails() { return orderDetails; }
    public void setOrderDetails(Map<Product, Integer> orderDetails) { this.orderDetails = orderDetails; }
    public double getTotalPrice() { return totalPrice; }

    private double calculateTotalPrice() {
        double total = 0.0;
        for (Map.Entry<Product, Integer> entry : this.orderDetails.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", orderDetails=" + orderDetails +
                ", totalPrice=" + totalPrice +
                '}';
    }

}

class ECommercePlatform {
    private Map<Integer, User> users;
    private Map<Integer, Product> products;
    private Map<Integer, Order> orders;

    public ECommercePlatform() {
        this.users = new HashMap<>();
        this.products = new HashMap<>();
        this.orders = new HashMap<>();
    }

    public Map<Integer, User> getUsers() { return users; }
    public Map<Integer, Product> getProducts() { return products; }
    public Map<Integer, Order> getOrders() { return orders; }

    public void addUser(User user) {
        this.users.put(user.getId(), user);
    }

    public void addProduct(Product product) {
        this.products.put(product.getId(), product);
    }

    public void createOrder(Order order) {
        this.orders.put(order.getId(), order);
    }



    public void listUsers() {
        for (User user : this.users.values()) {
            System.out.println(user);
        }
    }

    public void listOrders() {
        for (Order order : this.orders.values()) {
            System.out.println(order);
        }
    }

    public void updateProductStock(Product product, int stock) {
        product.setStock(stock);
    }
    public void processOrder(Order order) {
        for (Map.Entry<Product, Integer> entry : order.getOrderDetails().entrySet()) {
            Product product = entry.getKey();
            Integer quantity = entry.getValue();
            int newStock = product.getStock() - quantity;
            updateProductStock(product, newStock);
        }
    }
    public void listAvailableProducts() {
        List<Product> productList = new ArrayList<>(this.products.values());

        System.out.println("Products by name:");
        Collections.sort(productList, Product.compareByName);
        for (Product product : productList) {
            System.out.println(product);
        }

        System.out.println("Products by stock:");
        Collections.sort(productList, Product.compareByStock);
        for (Product product : productList) {
            System.out.println(product);
        }
    }

}

class ECommerceDemo {
    public static void main(String[] args) {
        ECommercePlatform platform = new ECommercePlatform();

        // Add users
        User user1 = new User(1, "Петро");
        User user2 = new User(2, "User2");
        User user3 = new User(3, "Сергій");
        User user4 = new User(4, "Василь");
        platform.addUser(user1);
        platform.addUser(user2);
        platform.addUser(user3);
        platform.addUser(user4);

        // Add products
        Product product1 = new Product(1, "A_Product1", 100.0, 10);
        Product product2 = new Product(2, "B_Product2", 200.0, 20);
        Product product3 = new Product(3, "H_Product3", 300.0, 15);
        Product product4 = new Product(4, "C_Product4", 400.0, 40);
        //out print
        platform.addProduct(product1);
        platform.addProduct(product2);
        platform.addProduct(product3);
        platform.addProduct(product4);

        // Simulate user's   cart
        user1.addToCart(product1, 1);
        //user1.addToCart(product1, 1);


        user2.addToCart(product2, 2);

        user3.addToCart(product4, 2);

        user4.addToCart(product3, 2);

        // Simulate order creation
        Order order1 = new Order(1, user1.getId(), user1.getCart());
        Order order2 = new Order(2, user2.getId(), user2.getCart());
        Order order3 = new Order(3, user3.getId(), user3.getCart());
        Order order4 = new Order(4, user4.getId(), user4.getCart());
        platform.createOrder(order1);
        platform.createOrder(order2);
        platform.createOrder(order3);
        platform.createOrder(order4);
        //UpdateStock
        platform.processOrder(order1);
        platform.processOrder(order2);
        platform.processOrder(order3);
        platform.processOrder(order4);


        // Display the final state of users, products, and orders
        System.out.println("Users: ");
        platform.listUsers();
        System.out.println("Products: ");
        platform.listAvailableProducts();
        System.out.println("Orders: ");
        platform.listOrders();
    }
}
