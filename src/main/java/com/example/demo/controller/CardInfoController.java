package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.config.ActionResult;
import com.example.demo.config.BankCardIdCode;
import com.example.demo.demo.MenuRO;
import com.example.demo.entity.*;
import com.example.demo.service.BankAreaCodeService;
import com.example.demo.service.BankLoanService;
import com.example.demo.service.CustInfoService;
import com.example.demo.service.TestService;
import com.example.demo.utils.IdCardUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.nio.charset.Charset;

import java.util.Date;
import java.util.List;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName CardInfoController
 * @date 2019/3/22  16:54
 */
@RestController
@RequestMapping(value = "index")
@Api("swaggerDemoController相关的api")
public class CardInfoController {

    @Resource
    private RestTemplate restTemplate;


    @Value("${book.name}")
    private String name;

    @Value("${book.gg}")
    private String gg;

    @Resource
    private BankLoanService bankLoanService;

    @Resource
    private TestService testService;

    @Resource
    private BankAreaCodeService bankAreaCodeService;

    @Autowired
    private CustInfoService custInfoService;

    @RequestMapping("list")
    public List<CardBindEntity> li(){
        List<CardBindEntity> cardList = bankLoanService.getCardList("1", "1");
        return cardList;
    }

    @RequestMapping("lists")
    public List<CardBindEntity> lis(){
        List<CardBindEntity> cardList = bankLoanService.getCardById("1");
        CustInfoEntity custInfo = bankLoanService.getCustInfo("2");
        System.out.println(custInfo);

        return cardList;
    }
    @RequestMapping("getListff")
    public List<CardInfoEntity> getListff(){
        return bankAreaCodeService.get();
    }

    /**
     *
     * @return
     */
    @GetMapping("gg")
    public String hu(String code){
     /*   String addressByCode = bankAreaCodeService.getAddressByCode(code);
        BankAreaCodeEntity byId = bankAreaCodeService.getById(code);
        System.out.println(byId);
        System.out.println(addressByCode);
        List<BankAreaCodeEntity> list = bankAreaCodeService.list();
        System.out.println(list);

        Integer up = bankAreaCodeService.up();
        System.out.println(up);*/

        List<BankAreaCodeEntity> lista = bankAreaCodeService.lista();
        System.out.println(lista.size());
        System.out.println(lista);

        return "ok";
    }
    @GetMapping("test")
    private String test(Test test) {
        String result = "";
        test.setLoginDate(new Date());
        if (testService.saveOrUpdate(test)) {
            return result = "OK";
        }
        result = "FAIL";
        return result;
    }

    @GetMapping("tests")
    private String tests(Test test) {
        String result = "";
        UpdateWrapper<Test> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("NAME","test");
        updateWrapper.eq("ID",1);
    //    queryWrapper.eq("ID",test.getId());
        if (testService.update(updateWrapper)) {
            return result = "OK";
        }
        result = "FAIL";
        return result;
    }

    @GetMapping("getList")
    private List<Test> getList(){



        return testService.list();
    }

    @GetMapping("getString/{openId}")
    public String get(@PathVariable("openId") String openId){

        String str = "ESTATE_MORTGAGE";
        return  "{ 'openId':"+openId+"}";

    }

    @GetMapping("getValue")
    @ApiOperation(value = "根据id查询学生信息", notes = "查询数据库中某个的学生信息")
    private List<SysOrganization> getValue(){
        String s= name + gg;
        List<SysOrganization> list = testService.getList("99H999");

        return list;
    }
    @PostMapping("getbyId")
    public Test getbyId(@RequestBody Test test){
        QueryWrapper<Test> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("ID",test.getId());

        Test byId = testService.getOne(queryWrapper);
        return byId;
    }


    public static void main(String[] args) {
        String code = (String) createCode();
        System.out.println(code);
    }

    public static String createCode(){
        String vcode = "";
        for (int i = 0; i < 6; i++) {
            vcode = vcode + (int)(Math.random() * 9);
        }
        return vcode;
    }
    @GetMapping("rest")
    public Test rest(HttpServletRequest request){
        String url = "http://localhost:8001/index/getbyId";
        Test test= new Test();
        test.setId("c0a9acebc06f9283eccbcaca43b2a255");

        ResponseEntity<Test> testResponseEntity = restTemplate.postForEntity(url, test , Test.class);

        Test body = testResponseEntity.getBody();
        return body;
    }

    @GetMapping("cardList")
    public ActionResult getcardList(String ids){

        BankCardIdCode bankCardIdCode = IdCardUtils.identityCardVerification(ids);
        if (bankCardIdCode.getCode() != 0) {
            return new ActionResult(bankCardIdCode.getCode(),bankCardIdCode.getMsg());
        }
        return new ActionResult();
    }

    @GetMapping("index")
    public String inde(){
        String str ="we";
        return "indewewewewe121212";
      //  URLEncoder.encode(Base64.encodeBytes(“广东”.getBytes(“gbk”)));
     /*   Base64.encodeBase64(str.getBytes(),"");
        Base64.encodeBytes(str.getBytes());*/

    }


    //消息转换器
    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter (){
        StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        return converter;
    }


    @PostMapping("/addMenu")
    public ActionResult addMenu(@RequestBody MenuRO ro){
       return testService.addMenu(ro);
    }
}
