package net.fly.order.api.constant;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019/3/15 9:41
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
public enum RedisKey {

    /**
     * 用户token
     */
    USER_ACCESSTOKEN("U:A:T:%s", 1),

    /**
     * 管理员密码校验次数
     */
    ADMIN_PWD_CHECK_NUM("A:P:C:N:%s", 1),

    /**
     * 用户ID
     */
    USER_ID("U:A:ID:%s", 1),

    /** 盘点 */
    GOODS_CHECK_KEY("G:C:S:%s", 1),

    /** 商品key */
    GOODS_KEY("G:K:%s", 1),

    GOODS_NAME_KEY("G:N:K:%s", 1),

    /** 套餐key */
    MEAL_KEY("M:K:%s", 1),

    /**  配置key */
    CONFIG_KEY("C:K:%s", 1),

    /** 后台登陆管理员TOKEN */
    ADMIN_TOKEN("A:U:T:%s", 1),
    ADMIN_ROLE_PERMISSION("A:U:R:P:%s", 1),

    /** 用户当前TOKEN */
    ADMIN_USER_TOKEN("A:T:U:%s", 1),

    /** 早餐 */
    ORDER_TYPE_BREAKFAST("O:T:B", 1),
    /** 午餐 */
    ORDER_TYPE_LUNCH("O:T:L", 1),
    /** 晚餐 */
    ORDER_TYPE_DINNER("O:T:D", 1),

    /** 分布式锁 */
    REDIS_DISTRIBUTED_LOCK("R:D:L:%s", 1),

    ;

    private final Integer version;
    private final String keyPattern;


    RedisKey(String keyPattern, Integer version) {
        this.version = version;
        this.keyPattern = keyPattern;
    }

    public String format(Object... args) {
        return "V:" + version + ":" + String.format(keyPattern, args);
    }


}
