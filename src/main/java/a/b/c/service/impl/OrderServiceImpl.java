package a.b.c.service.impl;

import a.b.c.orm.dao.OrderMapper;
import a.b.c.orm.entity.SaleOrderEntity;
import a.b.c.request.CreateOrderRequest;
import a.b.c.service.IOrderService;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements IOrderService {

    private OrderMapper orderMapper;

    OrderServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public Boolean createOrder(CreateOrderRequest orderRequest) {
        Long userId = orderRequest.getUserId();
        List<SaleOrderEntity> orderEntityList = new ArrayList<>();
        orderRequest.getMyCart().stream().forEach(e ->{
            SaleOrderEntity newOrder = new SaleOrderEntity();
            BeanUtils.copyProperties(e, newOrder);
            newOrder.setUserId(userId);
            newOrder.setOrderId(1001L);
            orderEntityList.add(newOrder);

        });

        orderMapper.insertByBatch(orderEntityList);

        return true;
    }
}
