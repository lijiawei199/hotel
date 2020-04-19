package net.fly.order.web.controller;

import net.fly.api.model.ApiResultResponse;
import net.fly.order.generate.entity.TInvest;
import net.fly.order.web.service.LegionService;
import net.fly.order.web.service.legionService;
import net.fly.order.web.service.service.LegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@RestController
@RequestMapping("/legion")
public class LegionController {
    @Autowired
    LegionService legionService;

    //创建代理
    @RequestMapping("/create/senior")
    public ApiResultResponse createSenior(@RequestParam("investType") String investType, @RequestParam("id") Long id, @RequestParam("earnings") String earnings, @RequestParam("bail") String bail) {
        return legionService.createSenior(investType, id, earnings, bail);

    }

    //创建普通角色
    @RequestMapping("/create/ordinary")
    public ApiResultResponse createOrdinary(@RequestParam("name") String name, @RequestParam("mobile") String mobile, @RequestParam("address") String address, @RequestParam("idNumber") String idNumber) {

        return legionService.createOrdinary(name, mobile, address, idNumber);

    }

    //创建
    @RequestMapping("/search")
    public ApiResultResponse search(@RequestParam("name") String name, @RequestParam("investType") String investType, @RequestParam("id") Long id) {

        return legionService.search(name, investType, id);
    }

    //创建
    @RequestMapping("/update")
    public ApiResultResponse update(@RequestBody TInvest tInvest) {

        return legionService.update(tInvest);
    }

    @RequestMapping("/update")
    public ApiResultResponse delete(@RequestParam("id") @NotNull(message = "name 不能为空") String id) {

        return legionService.delete(id);
    }

    @RequestMapping("/profit/search")
    public ApiResultResponse profitSearch(@RequestParam("role") Integer role, @RequestParam("region") String region) {


        return legionService.profitSearch(role, region);
    }

    //更改角色收益比例
    @RequestMapping("/profit/updaterole")
    public ApiResultResponse profitUpdateRole(@RequestParam("role") Integer role, @RequestParam("type") Integer type, @RequestParam("ration") Integer ratio, @RequestParam("state") Integer state) {


        return legionService.profitUpdateRole(role, type, ratio, state);
    }

    //更改代理收益比例
    @RequestMapping("profit/updateagent")
    public ApiResultResponse profitUpdateAgent(@RequestParam("type") Integer type, @RequestParam("ratio") Integer ratio) {
        return legionService.profitUpdateAgent(type, ratio);
    }
        @RequestMapping("hotel/warning")
        public ApiResultResponse hotelWarning (@RequestParam("ratio") Integer ratio) {
            return legionService.hotelWarning( ratio);


        }


    }
