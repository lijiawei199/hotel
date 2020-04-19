package net.fly.api.model.request;

import net.fly.api.model.ApiBaseRequest;
import net.fly.api.model.ApiPage;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019-08-27 21:04
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
public class ApiPageRequest extends ApiBaseRequest {

    private static final long serialVersionUID = 1L;
    private ApiPage page;

    public ApiPageRequest() {
    }

    public ApiPage getPage() {
        return this.page;
    }

    public void setPage(ApiPage page) {
        this.page = page;
    }
}
