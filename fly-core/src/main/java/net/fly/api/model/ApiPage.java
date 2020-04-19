package net.fly.api.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019-08-27 21:02
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
@Data
public class ApiPage<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    private static int DEFAULT_COUNT = 20;
    private int pageSize;
    private int pageNbr;
    private int totalPage;
    private int count;
    private List<T> records;

    public ApiPage() {
        this.pageSize = DEFAULT_COUNT;
        this.pageNbr = 1;
        this.totalPage = 1;
    }

    public void calcTotal() {
        int totalPage = this.count / this.pageSize;
        this.totalPage = this.count % this.pageSize == 0 ? totalPage : totalPage + 1;
    }
}
