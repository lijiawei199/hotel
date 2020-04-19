package net.fly.order.generate.service.impl;

import net.fly.order.generate.entity.TCashAmount;
import net.fly.order.generate.mapper.TCashAmountMapper;
import net.fly.order.generate.service.ITCashAmountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 提现表
 服务实现类
 * </p>
 *
 * @author lijiawei
 * @since 2020-04-18
 */
@Service
public class TCashAmountServiceImpl extends ServiceImpl<TCashAmountMapper, TCashAmount> implements ITCashAmountService {

}
