package com.example.demo.controller;

import com.example.demo.config.ActionResult;
import com.example.demo.utils.ZityAttributionResult;
import com.example.demo.utils.ZityResult;
import com.example.demo.utils.ZityUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.util.Map;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName RechargeController
 * @date 2019/4/22  18:32
 */
@Api(value = "紫藤", tags = {"紫藤"}, description = "紫藤")
@RestController
@RequestMapping(value = "/recharge")
public class RechargeController {


    /**
     * <b>Description:</b>
     *
     * @Date: 2019/3/29 15:09
     */
    @ApiOperation(value = "充值")
    @PostMapping(value = "recharge")
    public ActionResult recharge() throws Exception {
        Boolean recharge = ZityUtils.recharge("17802598583", new BigDecimal(100));
        return new ActionResult(recharge);
    }

    /**
     * <b>Description:</b>
     *
     * @Date: 2019/3/29 15:09
     */
    @ApiOperation(value = "订单查询")
    @PostMapping(value = "queryOrder")
    public ActionResult queryOrder(){
        Boolean aBoolean = ZityUtils.queryOrder("", "17802598583");
        return new ActionResult(aBoolean);
    }

    /**
     * <b>Description:</b>
     *
     * @Date: 2019/3/29 15:09
     */
    @ApiOperation(value = "账户查询")
    @PostMapping(value = "queryBalance")
    public ActionResult queryBalance(){
        BigDecimal bigDecimal = ZityUtils.queryBalance();
        return new ActionResult(bigDecimal);
    }


    /**
     * <b>Description:</b>
     *
     * @Date: 2019/3/29 15:09
     */
    @ApiOperation(value = "号段查询")
    @PostMapping(value = "queryAttribution")
    public ActionResult queryAttribution(){
        ZityAttributionResult zityAttributionResult = ZityUtils.queryAttribution("17802598583");
        return new ActionResult(zityAttributionResult);
    }




    /**
     * <b>Description:</b>
     *
     * @Date: 2019/3/29 15:09
     */
    @ApiOperation(value = "号段查询")
    @PostMapping(value = "notifys")
    public ActionResult notifys(Map<String, String> params ){
/*        params.put("cpid","");
        params.put("trade_type","");
        params.put("operator","");
        params.put("charge_time","");
        params.put("mobile_num","");
        params.put("zt_order_no","");
        params.put("cp_order_no","");
        params.put("amount","");
        params.put("status","");
        params.put("cmpay_order_no","");*/
        ZityResult notify = ZityUtils.notify(params);
        return new ActionResult(notify);
    }

}
