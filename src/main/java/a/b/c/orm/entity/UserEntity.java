package a.b.c.orm.entity;

import java.util.Date;
import lombok.Data;

@Data
public class UserEntity {
    private Long userId;
    private String nickName;
    private Date registerDate;
    private Date lastLoginDate;
    private Integer loginCount;

}
