package net.fly.order.generate.service.impl;

import net.fly.order.generate.entity.TPayOrder;
import net.fly.order.generate.mapper.TPayOrderMapper;
import net.fly.order.generate.service.ITPayOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 支付订单表 服务实现类
 * </p>
 *
 * @author lijiawei
 * @since 2020-04-18
 */
@Service
public class TPayOrderServiceImpl extends ServiceImpl<TPayOrderMapper, TPayOrder> implements ITPayOrderService {

}
