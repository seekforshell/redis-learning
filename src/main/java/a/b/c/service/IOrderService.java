package a.b.c.service;

import a.b.c.request.CreateOrderRequest;

public interface IOrderService {
    Boolean createOrder(CreateOrderRequest orderRequest);
}
