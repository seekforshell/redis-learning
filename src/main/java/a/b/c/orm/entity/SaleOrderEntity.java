package a.b.c.orm.entity;

import java.util.Date;
import lombok.Data;

@Data
public class SaleOrderEntity {
    private Long orderId;
    private Long userId;
    private Long goodsId;
    private Long deliveryAddrId;
    private String goodsName;
    private Integer goodsCount;
    private float goods_price;
    private Integer orderChannel;
    private Integer status;
    private Date createDate;
    private Date payDate;
}
