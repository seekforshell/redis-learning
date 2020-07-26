package a.b.c.request;

import a.b.c.request.order.OrderEntry;
import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateOrderRequest implements Serializable {
    private static final long serialVersionUID = -6670656397316330750L;

    @NotEmpty
    private List<OrderEntry> myCart;

    @NotNull
    private Long userId;
}
