package a.b.c.orm.dao;

import a.b.c.orm.entity.SaleOrderEntity;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.Mapping;

@Mapper
@Repository
public interface OrderMapper {
    void insertByBatch(@Param("entityList") List<SaleOrderEntity> entityList);
}
