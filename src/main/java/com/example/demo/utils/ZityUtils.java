package com.example.demo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.*;

/**
 * @Author: madongfang
 * @Date: 2019/3/22 9:01
 * @Version 1.0
 */
@Component
public class ZityUtils {



    private static final Logger logger = LoggerFactory.getLogger(ZityUtils.class);
    private static final String RESULT_CODE = "ret_result";
    private static String accessKey;
    private static String serverUrl;
    private static String cpId;
    private static final int MAX = 999999;
    private static final int MIN = 100000;
    private static final Map<String, String> provinceMap = new HashMap();

    static {
        provinceMap.put("01", "北京");
        provinceMap.put("02", "天津");
        provinceMap.put("03", "河北");
        provinceMap.put("04", "山西");
        provinceMap.put("05", "内蒙古");
        provinceMap.put("07", "吉林");
        provinceMap.put("08", "黑龙江");
        provinceMap.put("09", "上海");
        provinceMap.put("10", "江苏");
        provinceMap.put("11", "浙江");
        provinceMap.put("12", "安徽");
        provinceMap.put("13", "福建");
        provinceMap.put("14", "江西");
        provinceMap.put("15", "山东");
        provinceMap.put("16", "河南");
        provinceMap.put("17", "湖北");
        provinceMap.put("18", "湖南");
        provinceMap.put("19", "广东");
        provinceMap.put("20", "广西");
        provinceMap.put("21", "海南");
        provinceMap.put("22", "四川");
        provinceMap.put("23", "贵州");
        provinceMap.put("24", "云南");
        provinceMap.put("25", "西藏");
        provinceMap.put("26", "陕西");
        provinceMap.put("27", "甘肃");
        provinceMap.put("28", "青海");
        provinceMap.put("29", "宁夏");
        provinceMap.put("30", "新疆");
        provinceMap.put("31", "重庆");
    }

    @Value("${zity.accessKey}")
    public void setAccessKey(String accessKey) {
        ZityUtils.accessKey = accessKey;
    }

    @Value("${zity.serverUrl}")
    public void setServerUrl(String serverUrl) {
        ZityUtils.serverUrl = serverUrl;
    }

    @Value("${zity.cpid}")
    public void setCpId(String cpId) {
        ZityUtils.cpId = cpId;
    }

    public static String getRechargeParams(String mobileNo, BigDecimal amount) throws Exception {
        ZityAttributionResult attributionResult = queryAttribution(mobileNo);
        if (!attributionResult.getStatus()) {
            throw new Exception( "手机归属地查询异常");
        }

        Random random = new Random();
        int randomValue = random.nextInt(MAX - MIN + 1) + MIN;
        Map<String, String> params = new HashMap<>();
        params.put("cpid", cpId);
        params.put("trade_type", "CZ");
        //YD 移动,UN 联通，DX 电信
        params.put("operator", attributionResult.getBrand());
        //TODO 验证省份返回值是否为编码，如果是做替换 provinceMap.get(attributionResult.getProvince());
        params.put("province", attributionResult.getProvince());
        params.put("create_time", DateUtils.format(new Date(), CommonConstant.DATE_LONG_FORMAT));
        params.put("mobile_num", mobileNo);
        String cpOrderNo = DateUtils.format(new Date(), CommonConstant.DATE_LONG_FORMAT) + String.valueOf(randomValue);


        params.put("cp_order_no", cpOrderNo);
        params.put("amount", String.valueOf(amount.multiply(new BigDecimal(CommonConstant.ONE_HUNDRED)).intValue()));
        params.put("ret_para", "");

        StringBuilder data = new StringBuilder();
        StringBuilder signData = new StringBuilder();

        try {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                if ("province".equals(entry.getKey())) {
                    data.append(String.format("%s=%s&", entry.getKey(), URLEncoder.encode(Base64.getUrlEncoder().encodeToString(entry.getValue().getBytes(CommonConstant.CHARSET_GBK)), CommonConstant.CHARSET_UTF_8)));
                    signData.append(String.format("%s=%s&", entry.getKey(), Base64.getUrlEncoder().encodeToString(entry.getValue().getBytes(CommonConstant.CHARSET_GBK)), CommonConstant.CHARSET_UTF_8));
                    continue;
                }
                data.append(String.format("%s=%s&", entry.getKey(), entry.getValue()));
                signData.append(String.format("%s=%s&", entry.getKey(), entry.getValue()));
            }
            String sign = EncryptUtils.md5(StringUtils.trimTrailingCharacter(signData.toString(), '&') + accessKey, CommonConstant.CHARSET_UTF_8);
            data.append(String.format("sign=%s", sign));
        } catch (Exception e) {
            logger.error("[紫藤科技]-话费充值报文生成失败->" + e.getMessage(), e);
        }
        return data.toString();
    }

    //花费充值
    public static Boolean recharge(String mobileNo, BigDecimal amount) throws Exception {
        Boolean result = false;
        String params = getRechargeParams(mobileNo, amount);
        String requestUrl = serverUrl;
        if (!StringUtils.isEmpty(requestUrl)) {
            requestUrl = StringUtils.trimTrailingCharacter(requestUrl, '/');
            requestUrl += "/mobile/do";
        }

        try {
            String response = HttpUtil.post(requestUrl, params, HttpUtil.FORM_CONTENT_TYPE);
            if (StringUtils.isEmpty(response)) {
                return result;
            }

            String[] values = response.split("&");
            Map<String, String> mapValues = new HashMap<>();
            for (String value : values) {
                String[] elements = value.split("=");
                if (elements.length == CommonConstant.TWO) {
                    mapValues.put(elements[CommonConstant.ZERO], elements[CommonConstant.ONE]);
                }
            }
            if (!mapValues.containsKey(RESULT_CODE) || !ZityReturnCode.SUCCESS.getCode().equals(mapValues.get(RESULT_CODE))) {
                ZityReturnCode returnCode = ZityReturnCode.getByCode(mapValues.get(RESULT_CODE));
                throw new Exception(String.format("[%s]-%s", returnCode.getCode(), returnCode.getMsg()));
            }
            result = true;
        } catch (Exception e) {
            logger.error("[紫藤科技]-话费充值失败->" + e.getMessage(), e);
        }
        return result;
    }

    //通知
    public static ZityResult notify(Map<String, String> params) {
        ZityResult result = new ZityResult();
        String responseBody = "cpid=%s&cp_order_no=%s&ret_result=%s";
        String cpId = params.get("cpid");
        String tradeType = params.get("trade_type");
        String operator = params.get("operator");
        String chargeTime = params.get("charge_time");
        String mobileNo = params.get("mobile_num");
        String ztOrderNo = params.get("zt_order_no");
        String cpOrderNo = params.get("cp_order_no");
        String amount = params.get("amount");
        String status = params.get("status");
        String cmpayOrderNo = params.get("cmpay_order_no");
        String sign = params.get("sign");

        StringBuilder signData = new StringBuilder();
        signData.append(String.format("cpid=%s&", cpId));
        signData.append(String.format("trade_type=%s&", tradeType));
        signData.append(String.format("operator=%s&", operator));
        signData.append(String.format("charge_time=%s&", chargeTime));
        signData.append(String.format("mobile_num=%s&", mobileNo));
        signData.append(String.format("zt_order_no=%s&", ztOrderNo));
        signData.append(String.format("cp_order_no=%s&", cpOrderNo));
        signData.append(String.format("amount=%s&", amount));
        signData.append(String.format("status=SUCCESS%s", accessKey));

        try {
            String verifySign = EncryptUtils.md5(signData.toString(), CommonConstant.CHARSET_UTF_8);
            if (verifySign.equals(sign)) {
                result.setResponseBody(String.format(responseBody, cpId, cpOrderNo, ZityReturnCode.SUCCESS.getCode()));
                result.setStatus(true);
            } else {
                result.setResponseBody(String.format(responseBody, cpId, cpOrderNo, ZityReturnCode.FAILURE.getCode()));
                result.setStatus(false);
            }
        } catch (Exception e) {
            logger.error("[紫藤科技]-充值结果后台通知处理异常->" + e.getMessage(), e);
        }

        return result;
    }

    public static Boolean queryOrder(String orderNo, String mobileNo) {
        Boolean result = false;

        Map<String, String> params = new HashMap<>();
        params.put("cpid", cpId);
        params.put("cp_order_no", orderNo);
        params.put("mobile_num", mobileNo);

        String requestUrl = serverUrl;
        if (!StringUtils.isEmpty(requestUrl)) {
            requestUrl = StringUtils.trimTrailingCharacter(requestUrl, '/');
            requestUrl += "/mobile/queryorder";
        }

        StringBuilder data = new StringBuilder();
        StringBuilder signData = new StringBuilder();

        try {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                data.append(String.format("%s=%s&", entry.getKey(), entry.getValue()));
                signData.append(String.format("%s=%s&", entry.getKey(), entry.getValue()));
            }
            String sign = EncryptUtils.md5(StringUtils.trimTrailingCharacter(signData.toString(), '&') + accessKey, CommonConstant.CHARSET_UTF_8);
            data.append(String.format("sign=%s", sign));

            String response = HttpUtil.post(requestUrl, data.toString(), HttpUtil.FORM_CONTENT_TYPE);
            if (StringUtils.isEmpty(response)) {
                return result;
            }

            String[] values = response.split("&");
            Map<String, String> mapValues = new HashMap<>();
            for (String value : values) {
                String[] elements = value.split("=");
                if (elements.length == CommonConstant.TWO) {
                    mapValues.put(elements[CommonConstant.ZERO], elements[CommonConstant.ONE]);
                }
                // 返回内容
                // zt_order_no 紫藤订单号
                // amount 扣费金额
            }

            if (mapValues.containsKey(RESULT_CODE) && ZityReturnCode.SUCCESS.getCode().equals(mapValues.get(RESULT_CODE))) {
                // 充值处理中
                result = true;
                return result;
            }

            if (!mapValues.containsKey(RESULT_CODE) || !ZityReturnCode.RECHARGE_SUCCESS.getCode().equals(mapValues.get(RESULT_CODE))) {
                ZityReturnCode returnCode = ZityReturnCode.getByCode(mapValues.get(RESULT_CODE));
                throw new Exception("异常");
            }
            result = true;
        } catch (Exception e) {
            logger.error("[紫藤科技]-订单查询异常->" + e.getMessage(), e);
        }

        return result;
    }

    public static BigDecimal queryBalance() {
        BigDecimal result = BigDecimal.ZERO;

        String requestUrl = serverUrl;
        if (!StringUtils.isEmpty(requestUrl)) {
            requestUrl = StringUtils.trimTrailingCharacter(requestUrl, '/');
            requestUrl += "/mobile/querybalance";
        }

        StringBuilder data = new StringBuilder();
        StringBuilder signData = new StringBuilder();

        try {
            data.append(String.format("cpid=%s&", cpId));
            signData.append(String.format("cpid=%s%s", cpId, accessKey));

            String sign = EncryptUtils.md5(signData.toString(), CommonConstant.CHARSET_UTF_8);
            data.append(String.format("sign=%s", sign));
            String response = HttpUtil.post(requestUrl, data.toString(), HttpUtil.FORM_CONTENT_TYPE);
            if (StringUtils.isEmpty(response)) {
                return result;
            }

            String[] values = response.split("&");
            Map<String, String> mapValues = new HashMap<>();
            for (String value : values) {
                String[] elements = value.split("=");
                if (elements.length == CommonConstant.TWO) {
                    mapValues.put(elements[CommonConstant.ZERO], elements[CommonConstant.ONE]);
                }
            }

            if (!mapValues.containsKey(RESULT_CODE) || !ZityReturnCode.SUCCESS.getCode().equals(mapValues.get(RESULT_CODE))) {
                throw new Exception("账户余额查询错误");
            }
            result = new BigDecimal(mapValues.get("balance"));
        } catch (Exception e) {
            logger.error("[紫藤科技]-账户余额查询异常->" + e.getMessage(), e);
        }

        return result;
    }

    public static ZityAttributionResult queryAttribution(String mobileNo) {
        ZityAttributionResult result = new ZityAttributionResult();

        String requestUrl = serverUrl;
        if (!StringUtils.isEmpty(requestUrl)) {
            requestUrl = StringUtils.trimTrailingCharacter(requestUrl, '/');
            requestUrl += "/mobile/querynumarea";
        }

        StringBuilder data = new StringBuilder();
        StringBuilder signData = new StringBuilder();

        try {
            data.append(String.format("cpid=%s&mobile_num=%s&", cpId, mobileNo));
            signData.append(String.format("cpid=%s&mobile_num=%s%s", cpId, mobileNo, accessKey));

            String sign = EncryptUtils.md5(signData.toString(), CommonConstant.CHARSET_UTF_8);
            data.append(String.format("sign=%s", sign));
            String response = HttpUtil.post(requestUrl, data.toString(), HttpUtil.FORM_CONTENT_TYPE);
            if (StringUtils.isEmpty(response)) {
                return result;
            }

            String[] values = response.split("&");
            Map<String, String> mapValues = new HashMap<>();
            for (String value : values) {
                String[] elements = value.split("=");
                if (elements.length == CommonConstant.TWO) {
                    mapValues.put(elements[CommonConstant.ZERO], elements[CommonConstant.ONE]);
                }
            }

            if (!mapValues.containsKey(RESULT_CODE) || !ZityReturnCode.SUCCESS.getCode().equals(mapValues.get(RESULT_CODE))) {
                throw new Exception("[%s]-手机号段查询错误");
            }

            result.setStatus(true);
            result.setBrand(mapValues.get("brand"));
            result.setMobileNo(mapValues.get("mobile_num"));
            result.setProvince(mapValues.get("province"));
        } catch (Exception e) {
            logger.error("[紫藤科技]-手机号段查询异常->" + e.getMessage(), e);
        }

        return result;
    }
}
