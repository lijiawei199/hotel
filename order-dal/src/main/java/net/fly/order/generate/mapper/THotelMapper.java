package net.fly.order.generate.mapper;

import net.fly.order.generate.entity.THotel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 酒店表
 Mapper 接口
 * </p>
 *
 * @author lijiawei
 * @since 2020-04-19
 */
public interface THotelMapper extends BaseMapper<THotel> {
@Select("select hotel_name,address,total,used from " +
        "t_hotel a LEFT JOIN " +
        " (select normal+damage as total,normal/damage as used,a.hotel_id from (SELECT hotel_id, count(*) as normal  from t_hotel_prod where state=1 GROUP BY hotel_id) a  " +
        "left join " +
        " (SELECT hotel_id, count(*) as damage from t_hotel_prod where state<>1 GROUP BY hotel_id) b on a.hotel_id=b.hotel_id   where normal/damage>0) b" +
        " on a.id=b.hotel_id")
    List<String> hotelWarning(@Param("ratio") Integer ratio);
}
