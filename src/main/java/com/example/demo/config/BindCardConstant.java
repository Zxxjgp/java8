package com.example.demo.config;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName BindCardConstant
 * @date 2019/3/20  18:08
 */
public class BindCardConstant {

    public static String  ZERO = "0";
    public static String  ONE = "1";
    public static String  TWO = "2";
    public static String  THREE = "3";
    public static String  FOUR = "4";
    public static String  FIVE = "5";
    public static String  SIX = "6";



    // 是不是农业银行的标志 y 表示是 n 表示否
    public static String AGRICULTURAL_BANK_SIGN_YES = "Y";
    public static String AGRICULTURAL_BANK_SIGN_NO = "N";

    public static String RESULT_CODE = "0000";

    public static String CONTENT_TYPE="application/json";

    public static Integer SUCCESS = 0;
    public static Integer FAIL = 1;

    /**    start 卡类型  **/
    //贷记卡
    public static String CREDIT_CARD = "C";
    // 准贷记卡
    public static String QUASI_CREDIT_CARD = "Z";
    //借记卡
    public static String A_DEBIT_CARD = "A";
    //借记卡
    public static String S_DEBIT_CARD = "S";
    // 0 借记卡
    public static Integer ONe_DEBIT_CARD = 0;
    // 1 贷记卡
    public static Integer tow_DEBIT_CARD = 1;

    /**    end  卡类型  **/

    public static Integer  WX_ZERO = 0;
    public static Integer  WX_ONE = 1;

    //卡片的长度
    public static Integer CARD_LENGTH_SIX = 6;


    /**
     * 编码格式
     */
    public static String ENCODING_FORMAT_GB = "gb2312";
    public static String ENCODING_FORMAT_UTF = "UTF-8";



    /**
     * 时间的格式
     */
    public static String SIMPLEDATEFORMAT_DATE = "yyyyMMdd";
    public static String SIMPLEDATEFORMAT_TIME = "HHmmss";
    public static String SIMPLEDATEFORMAT_DATE_TIME = "yyyyMMddHHmmss";
    public static String SIMPLEDATEFORMAT_DATE_TIME_SECOND = "yyyyMMddHHmmssSSS";


    /**
     * 成功查询
     */
    public static String RET_CODE = "0000";
    /**
     * 后继查询标志：0-无后继查询，1-有后继查询
     */
    public static String NEXT_QRY_FLAG_HAS = "0";
    public static String NEXT_QRY_FLAG_NO = "1";


    //银行的一些查询接口名称
    public static String QUERY_CARD_SUB_ACCOUNT_BALANCE = "CardSubAccBalanceOp";
    public static String QUERY_QUASI_CREDIT_CARD_BALANCE = "QryBalOp";
    public static String QUERY_CARD_CHECK_ACCOUNT_PASSWORD = "ChkAccPwdOp";
    public static String QUERY_CARD_CUST_ = "CIFQryCustomerInfoOp";

    //卡明细查询
    public static String QUERY_CARD_DETAIL = "QUERY_CARD";


}
