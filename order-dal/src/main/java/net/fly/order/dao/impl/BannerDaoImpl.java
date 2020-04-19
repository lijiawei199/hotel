package net.fly.order.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.fly.order.dao.BannerDao;
import net.fly.order.entity.Banner;
import net.fly.order.mapper.BannerMapper;
import org.springframework.stereotype.Service;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2020-04-08 10:35
 * <p>
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
@Service
public class BannerDaoImpl extends ServiceImpl<BannerMapper, Banner> implements BannerDao {
}
