package net.fly.order.web.service.serviceImply;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import net.fly.api.model.ApiResultResponse;
import net.fly.order.api.ResponseUtils;
import net.fly.order.generate.entity.THotel;
import net.fly.order.generate.entity.TIncomeRatio;
import net.fly.order.generate.entity.TInvest;
import net.fly.order.generate.entity.TRoyalty;
import net.fly.order.generate.mapper.THotelMapper;
import net.fly.order.generate.mapper.TIncomeRatioMapper;
import net.fly.order.generate.mapper.TInvestMapper;
import net.fly.order.generate.mapper.TRoyaltyMapper;
import net.fly.order.generate.service.ITIncomeRatioService;
import net.fly.order.generate.service.ITInvestService;
import net.fly.order.generate.service.ITRoyaltyService;
import net.fly.order.web.service.service.LegionService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class LegionServiceImply implements LegionService {
    @Autowired
    ITInvestService itInvestService;
    @Autowired
    TInvestMapper tInvestMapper;
    @Autowired
    TIncomeRatioMapper incomeRatioMapper;
    @Autowired
    TRoyaltyMapper royaltyMapper;
    @Autowired
    THotelMapper hotelMapper;

    @Override
    public ApiResultResponse createSenior(String investType, Long id, String earnings, String bail) {

        //id已存在
        if (null != itInvestService.getById(id)) {
            return ResponseUtils.fail("创建失败,ID已存在");
        }
        //插入角色
        TInvest tInvest = new TInvest();
        tInvest.setInvestType(investType);
        tInvest.setId(id);
        tInvest.setEarnings(earnings);
        tInvest.setBail(new BigDecimal(bail));
        tInvestMapper.insert(tInvest);

        return ResponseUtils.success("角色创建成功");
    }

    @Override
    public ApiResultResponse createOrdinary(String name, String mobile, String address, String idNumber) {

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id_number", idNumber);
        //身份证去重
        if (itInvestService.list(wrapper).size() > 0) {
            return ResponseUtils.fail("角色重复");
        }
        TInvest tInvest = new TInvest();
        tInvest.setName(name);
        tInvest.setMobile(mobile);
        tInvest.setAddress(address);
        tInvest.setIdNumber(idNumber);
        tInvestMapper.insert(tInvest);
        return ResponseUtils.success();
    }

    @Override
    public ApiResultResponse search(String name, String investType, Long id) {
        QueryWrapper wrapper = new QueryWrapper();
        if ("" != name.trim() && null != name) {
            wrapper.like("name", name);
        }
        if ("" != investType.trim() && null != investType) {
            wrapper.like("investType", investType);
        }
        if (null != id) {
            wrapper.like("id", id);
        }
        List<TInvest> invests = itInvestService.list(wrapper);

        return ResponseUtils.success(invests);
    }

    @Override
    public ApiResultResponse update(TInvest tInvest) {
        tInvestMapper.updateById(tInvest);
        return ResponseUtils.success();
    }

    @Override
    public ApiResultResponse delete(String id) {
        tInvestMapper.deleteById(id);
        return ResponseUtils.success();
    }

    @Override
    public ApiResultResponse profitSearch(Integer role, String region) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("role", role);
       if ("".equals(region)){
           wrapper.like("address", region);
       }
        List<TInvest> invests = itInvestService.list(wrapper);
        BigDecimal profits = invests.stream().map(TInvest::getProfit).reduce(BigDecimal.ZERO, BigDecimal::add);

        return ResponseUtils.success(profits);
    }

    @Override
    public ApiResultResponse profitUpdateRole(Integer role, Integer type, Integer ratio, Integer state) {
        TIncomeRatio incomeRatio = new TIncomeRatio();
        incomeRatio.setRatio(ratio);
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("type",type);
        wrapper.eq("role",role);
        incomeRatioMapper.update( incomeRatio,wrapper);
        return ResponseUtils.success();
    }

    @Override
    public ApiResultResponse profitUpdateAgent(Integer type, Integer ratio) {
        TRoyalty royalty = new TRoyalty();
        royalty.setRatio(ratio);
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("type",type);
        royaltyMapper.update( royalty,wrapper);
        return ResponseUtils.success();
    }

    @Override
    public ApiResultResponse hotelWarning(Integer ratio) {
    List<String> hotels =hotelMapper.hotelWarning(ratio);
        return null;
    }
}
