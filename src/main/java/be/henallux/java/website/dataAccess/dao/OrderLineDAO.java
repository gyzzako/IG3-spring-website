package be.henallux.java.website.dataAccess.dao;

import be.henallux.java.website.dataAccess.entity.OrderLineEntity;
import be.henallux.java.website.dataAccess.repository.OrderLineRepository;
import be.henallux.java.website.dataAccess.utils.ProviderConverter;
import be.henallux.java.website.model.OrderLine;
import org.springframework.stereotype.Service;

@Service
public class OrderLineDAO implements OrderLineDataAccess{
    private OrderLineRepository orderLineRepository;
    private ProviderConverter providerConverter;

    public OrderLineDAO(OrderLineRepository orderLineRepository, ProviderConverter providerConverter){
        this.orderLineRepository = orderLineRepository;
        this.providerConverter = providerConverter;
    }

    public OrderLine save(OrderLine orderLine){
        OrderLineEntity orderLineEntity = providerConverter.orderLineModelToOrderLineEntity(orderLine);
        orderLineEntity = orderLineRepository.save(orderLineEntity);
        return providerConverter.orderLineEntityToOrderLineModel(orderLineEntity);
    }
}
