package br.com.sgsistemas.udemyproject.service;

import br.com.sgsistemas.udemyproject.model.Order;
import br.com.sgsistemas.udemyproject.model.User;
import br.com.sgsistemas.udemyproject.repository.OrderRepository;
import br.com.sgsistemas.udemyproject.repository.UserRepository;
import br.com.sgsistemas.udemyproject.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<Order> listar() {
        return orderRepository.findAll();
    }

    public Order listarID(Integer id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void deleteById(Integer id) {
        orderRepository.deleteById(id);
    }

    public Order update(Integer id, Order order) {
        Order orderr = orderRepository.findById(id).get();
        dataUpdate(orderr,order);
        return orderRepository.save(orderr);
    }

    private void dataUpdate(Order orderr, Order order) {
        orderr.setOrderStatus(order.getOrderStatus());
        orderr.setItems(order.getItems());
        orderr.setPayment(order.getPayment());
        orderr.setTotal(order.getTotal());
    }

    public Order insert(Order order) {
        orderRepository.save(order);
        return order;
    }
}
