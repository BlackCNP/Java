package hello.world.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ShoppingCartTest {
    private Cart cart;
    private Product product1;
    private Product product2;

    @BeforeEach
    public void setUp() {
        cart = new Cart();
        product1 = new Product(1, "Щось", 100);
        product2 = new Product(2, "Product 2", 200);
    }

    @Test
    public void testAddProduct() {
        cart.addProduct(product1);
        assertTrue(cart.getProducts().contains(product1));
    }

    @Test
    public void testRemoveProduct() {
        cart.addProduct(product1);
        cart.removeProduct(product1);
        assertTrue(!cart.getProducts().contains(product1));
    }

    @Test
    public void testPlaceOrder() {
        cart.addProduct(product1);
        cart.addProduct(product2);
        Order order = new Order(1, cart.getProducts(), "pending");
        assertEquals(order.getProducts().size(), 2);
    }

    @Test
    public void testGetOrderStatus() {
        Order order = new Order(1, cart.getProducts(), "pending");
        assertEquals(order.getStatus(), "pending");
    }
}