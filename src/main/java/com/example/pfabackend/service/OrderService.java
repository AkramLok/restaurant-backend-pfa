package com.example.pfabackend.service;

import com.example.pfabackend.entities.Discount;
import com.example.pfabackend.entities.Order;
import com.example.pfabackend.entities.Product;
import com.example.pfabackend.entities.Reward;
import com.example.pfabackend.repository.ClientRepository;
import com.example.pfabackend.repository.OrderRepository;
import com.example.pfabackend.repository.WaiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private WaiterRepository waiterRepository;

    public List<Order> getOrdersByClientId(Long clientId) {
        return orderRepository.findByClientId(clientId);
    }

    public List<Order> getOrdersByWaiterId(Long waiterId) {
        return orderRepository.findByWaiterId(waiterId);
    }

    public Order createOrder(Long clientId, Long waiterId, Set<Product> products,
                             Set<Discount> discounts,
                             Set<Reward> rewards, double totalPrice) {
        Order order = new Order();
        order.setClient(clientRepository.findById(clientId).orElse(null));
        order.setWaiter(waiterRepository.findById(waiterId).orElse(null));
        order.setProducts(products);
        order.setDiscounts(discounts);
        order.setRewards(rewards);
        order.setTotalPrice(totalPrice);
        return orderRepository.save(order);
    }
}
