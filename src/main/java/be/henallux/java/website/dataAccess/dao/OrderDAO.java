package be.henallux.java.website.dataAccess.dao;

import be.henallux.java.website.dataAccess.entity.OrderEntity;
import be.henallux.java.website.dataAccess.repository.OrderRepository;
import be.henallux.java.website.dataAccess.utils.ProviderConverter;
import be.henallux.java.website.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDAO implements OrderDataAccess{
    private OrderRepository orderRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public OrderDAO(OrderRepository orderRepository, ProviderConverter providerConverter){
        this.orderRepository = orderRepository;
        this.providerConverter = providerConverter;
    }

    public Order save(Order order){
        OrderEntity orderEntity = providerConverter.orderModelToOrderEntity(order);
        orderEntity = orderRepository.save(orderEntity);
        return providerConverter.orderEntityToOrderModel(orderEntity);
    }
}
