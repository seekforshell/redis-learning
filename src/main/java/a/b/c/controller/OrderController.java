package a.b.c.controller;

import a.b.c.request.CreateOrderRequest;
import a.b.c.request.Response;
import a.b.c.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "order")
@Slf4j
public class OrderController {

    private IOrderService orderService;

    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(value = "/sale",
        consumes = "application/json;charset=utf-8",
        produces = "application/json;charset=utf-8")
    public Response greeting(@RequestBody CreateOrderRequest orderRequest) {
        Response response = new Response();

        try {
            Boolean success = orderService.createOrder(orderRequest);
            if (!success) {
                response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
                response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
            }
        } catch (Exception e) {
            log.error("request error", e);
            response.setMessage(e.getMessage());
        }

        return response;
    }
}
