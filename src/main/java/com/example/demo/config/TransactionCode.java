package com.example.demo.config;

public enum TransactionCode {
    AUTHENTICATIONCIPHER("000000011","验证密码"),
    FINANCINGMUTIQUERY("000000012","理财产品多笔查询"),
    FINANCINGSINGLEQUERY("000000013","理财产品单笔查询"),
    FINANCINGTRIAL("000000014","理财产品试算"),
    FINANCINGPURCHASE("000000015","理财产品购买"),
    FINANCINGHOLDBYCUSTNO("000000016","理财持有查询(根据客户号)"),
    FINANCINGHOLDBYCARDNO("000000017","理财持有查询(根据卡号)"),
    DEBITCARDQUERYSUBACCOUNT("000000018","借记卡子账户查询"),
    QUASICREDITCARDBALANCEQUERY("000000019","准贷记卡余额查询"),
    CREDITCARDINSPECTION("000000020","贷记卡验密"),
    QUERYCARDDETAIL("000000021","查卡明细"),
    QUERYCYCLELOANCONTRACT("000000022","查询自助循环贷款类信贷合同合约"),
    QUERYLOANCONTRACTBYACCNO("000000023","通过卡号查询账单"),
    QUERYLOANPURPOSE("000000024","贷款用途查询"),
    OPENSELFHELPLOAN("000000025","自助贷款开立"),
    QUERYLOANCONTRACTINFO("000000026","贷款合约信息查询"),
    QUERYBILLINFORMATION("000000027","账单信息查询"),
    EXECUTEOVERDUEREPAY("000000028","正常超期还款执行"),
    SQUAREUPINADVANCECALCULATE("000000029","提前全部结清试算"),
    EXECUTEREPAYINADVANCE("000000030","提前还款执行"),
    QRYCREDITCONTRACTINFO("000000031","信贷合同合约信息查询"),
    INVESTMENTPRODUCTENTRUSTQUERYOP("000000032","理财委托查询"),
    INVESTPRODUCTCANCELBYACCNOANDXIEYICODE("000000033","理财产品撤销"),
    INVESTMENTPRODUCTREMETION("000000034","理财产品赎回"),
    QUERYHOLDFUNDBYACCNO("000000035","基金产品持有查询"),
    QRYLOANCONTRACTBYACCNO("000000036","通过卡号查询贷款"),
    MAINACC2DEPOSITSUBACC("000000037","活期转定期"),
    CLOSEDEPOSITSUBACC2MAINACC("000000038","定期转活期"),
    QUERYFUNDLIST("000000039","基金产品查询"),
    QUERYCANCELFUNDLIST("000000040","基金可撤销产品查询"),
    DEALCANCELFUNDBUSINESS("000000041","撤销基金"),
    QUERYSIGNISCONTRACT("000000042","基金签约查询"),
    DEALREDEMTIONFUND("000000043","基金赎回"),
    BUYFUND("000000044","基金购买"),
    VCCMO041("000000045","当期账单信息列表"),
    VCIMO024("000000046","账单分期试算"),
    VCIMO003("000000047","账单分期"),
    IFIDO081("000000048","基金定投计划建立"),
    IFIDO082("000000049","基金定投计划查询"),
    IFIDO083("000000050","终止基金定投计划"),
    IFIDO084("000000051","基金定投计划修改")
    ;

    private String code;
    private String description;
    TransactionCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
