package net.fly.order.generate.service.impl;

import net.fly.order.generate.entity.TOrder;
import net.fly.order.generate.mapper.TOrderMapper;
import net.fly.order.generate.service.ITOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户订单表
 服务实现类
 * </p>
 *
 * @author lijiawei
 * @since 2020-04-19
 */
@Service
public class TOrderServiceImpl extends ServiceImpl<TOrderMapper, TOrder> implements ITOrderService {

}
