package net.fly.order.web.service.service;

import net.fly.api.model.ApiResultResponse;
import net.fly.order.generate.entity.TInvest;

public interface LegionService {
    ApiResultResponse createSenior(String investType, Long id, String earnings, String bail);

    ApiResultResponse createOrdinary(String name, String mobile, String address, String idNumber);

    ApiResultResponse search(String name, String investType, Long id);

    ApiResultResponse update(TInvest tInvest);

    ApiResultResponse delete(String id);

    ApiResultResponse profitSearch(Integer role, String region);

    ApiResultResponse profitUpdateRole(Integer role, Integer type, Integer ratio, Integer state);

    ApiResultResponse profitUpdateAgent(Integer type, Integer ratio);

    ApiResultResponse hotelWarning(Integer ratio);
}
