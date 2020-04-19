package net.fly.order.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.fly.order.dao.AdminDao;
import net.fly.order.entity.Admin;
import net.fly.order.mapper.AdminMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台管理表
 服务实现类
 * </p>
 *
 * @author hengkun
 * @since 2019-08-28
 */
@Service
public class AdminDaoImpl extends ServiceImpl<AdminMapper, Admin> implements AdminDao {

}
