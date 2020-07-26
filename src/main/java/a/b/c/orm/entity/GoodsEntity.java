package a.b.c.orm.entity;

import lombok.Data;

@Data
public class GoodsEntity {
    private Long goodsId;
    private String goodsName;
    private String goodsTitle;
    private String goodsDetail;
    private float goodsPrice;
    private Integer goodsStock;
}
