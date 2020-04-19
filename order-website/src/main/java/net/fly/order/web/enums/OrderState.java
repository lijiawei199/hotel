package net.fly.order.web.enums;

public enum OrderState {

    //   0 订单生成(待审核) 1 审核通过，待配合同(排单中) 2 逾期未配 3 有人投资(发货中) 4 寄到(装配中) 5 订单结束
    CREATED("订单生成", 0),
    CHECKED("审核通过", 1),
    OVERDUE("逾期未配", 2),
    PAID("有人投资", 3),
    ARRIVAL("寄到", 4),
    FINISH("完成", 5);
    private String msg;
    private Integer code;

    OrderState(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
