package br.com.sgsistemas.udemyproject.config;

import br.com.sgsistemas.udemyproject.model.*;
import br.com.sgsistemas.udemyproject.model.enums.OrderStatus;
import br.com.sgsistemas.udemyproject.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public void run(String... args) throws Exception {
//        insert();
    }

    public void insert(){
        Category category1 = new Category(null, "Eletronics");
        Category category2 = new Category(null, "Books");
        Category category3 = new Category(null, "Computers");
        categoryRepository.saveAll(Arrays.asList(category1, category2, category3));

        Product p1 = new Product(null,"The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null,"Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null,"PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null,"Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
        p1.getCategory().add(category2);
        p2.getCategory().add(category1);
        p3.getCategory().add(category3);
        p4.getCategory().add(category3);
        p5.getCategory().add(category3);
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        User user1 = new User(null,  "Maria Brown", "maria@gmail.com", "9999-9999", "1234" );
        User user2 = new User(null,  "ALex Green", "alex@gmail.com", "8888-8888", "4321" );
        userRepository.saveAll(Arrays.asList(user1, user2));
        userRepository.saveAll(Arrays.asList(user1, user2));

        Order order1 = new Order(null, Instant.now(), user1, OrderStatus.WAITING_PAYMENT);
        Order order2 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), user2, OrderStatus.PAID);
        Order order3 = new Order(null, Instant.parse("2020-11-21T03:33:32Z"), user1, OrderStatus.SHIPPED);
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));

        OrderItem oi1 = new OrderItem(order1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(order1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(order2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(order3, p5, 2, p5.getPrice());
        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

        Payment payment = new Payment(null,Instant.parse("2020-11-21T03:33:32Z"),order2);
        Payment payment2 = new Payment(null,Instant.parse("2020-12-21T01:23:32Z"),order1);
        order1.setPayment(payment);
        order2.setPayment(payment2);
        orderRepository.saveAll(Arrays.asList(order1,order2));
    }
}