package a.b.c.request.order;

import java.io.Serializable;
import lombok.Data;

@Data
public class OrderEntry implements Serializable {
    private static final long serialVersionUID = 2463317396147676760L;
    private Long goodsId;
    private Integer count;
}
