package com.devsuperior.pedidos.services;

import com.devsuperior.pedidos.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    public double calculateOrderTotal(Order order) {

        double discountAmount = order.getBasic() * (order.getDiscount() / 100);
        double discountedValue = order.getBasic() - discountAmount;

        double shippingCost = shippingService.calculateShippingCost(order.getBasic());

        return discountedValue + shippingCost;
    }

}
