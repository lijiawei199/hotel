package net.fly.order.generate.service.impl;

import net.fly.order.generate.entity.TUser;
import net.fly.order.generate.mapper.TUserMapper;
import net.fly.order.generate.service.ITUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表
 服务实现类
 * </p>
 *
 * @author lijiawei
 * @since 2020-04-19
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

}
