package com.ygjy.supplymanagement.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ygjy.supplymanagement.pojo.DrugInformation;
import com.ygjy.supplymanagement.pojo.EnterpriseDrugCatalog;
import com.ygjy.supplymanagement.pojo.HospitalTransactionDetails;
import com.ygjy.supplymanagement.service.DrugsInformationService;
import com.ygjy.supplymanagement.utils.Dto;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author: 赵林
 * @Date: 2020/6/9 13:50
 * @Description:
 */
@RestController
public class DrugsInformationController {
    /**
     * 药品品目模糊查询及全部查询
     * @return
     */
    @Resource
    private DrugsInformationService drugsInformationService;
    @RequestMapping(value = "/DrugsInformation" ,produces = "application/json;charset=utf-8")
    public String findAll(@RequestParam(value = "commonName",required = false) String commonName,String serialNumber,@RequestParam(value = "dosageFormId",required = false)Integer dosageFormId,String specification,String unit,String conversionFraction,Integer drugCategoryId,Integer drugTransactionStatusId,Integer enterpriseNameId,String tradeName,Float latestRetailPrice,Integer qualityLevelId,
                          @RequestParam(value = "pageNum" ,defaultValue = "1",required = false) Integer pageNum){
        PageHelper.startPage(pageNum,5);
        if(dosageFormId!=null&&dosageFormId<=0){
            dosageFormId=null;
        }
        if(drugCategoryId!=null&&drugCategoryId<=0){
            drugCategoryId=null;
        }
        if(drugTransactionStatusId!=null&&drugTransactionStatusId<=0){
            drugTransactionStatusId=null;
        }
        if(qualityLevelId!=null&&qualityLevelId<=0){
            qualityLevelId=null;
        }
        if(enterpriseNameId!=null&&enterpriseNameId<=0){
            enterpriseNameId=null;
        }
        List<com.ygjy.supplymanagement.pojo.DrugInformation> query = drugsInformationService.getQuery(commonName, serialNumber, dosageFormId, specification, unit, conversionFraction, drugCategoryId, drugTransactionStatusId, enterpriseNameId, tradeName, latestRetailPrice, qualityLevelId);
        PageInfo<DrugInformation> pageInfo = new PageInfo<>(query);
        return JSON.toJSONString(pageInfo);
    }
    /**
     * 条件查询
     */
    @RequestMapping(value = "/getSelect" ,produces = "application/json;charset=utf-8")
    public Dto getSelect(Integer id){
        Dto query = drugsInformationService.getSelect(id);
        return query;
    }
    /**
     * 剂型表查询
     */
    @RequestMapping(value = "/selectDurgsFrom" ,produces = "application/json;charset=utf-8")
    public Dto selectDurgsFrom(){
        Dto query = drugsInformationService.selectDurgsFrom();
        return query;
    }
    /**
     * 药品类别表查询
     */
    @RequestMapping(value = "/selectdrugcategory" ,produces = "application/json;charset=utf-8")
    public Dto selectdrugcategory(){
        Dto query = drugsInformationService.selectDrugCategory();
        return query;
    }
    /**
     * 药品状态表查询
     */
    @RequestMapping(value = "/selectDrugTransactionStatus" ,produces = "application/json;charset=utf-8")
    public Dto selectDrugTransactionStatus(){
        Dto query = drugsInformationService.selectDrugTransactionStatus();
        return query;
    }
    /**
     * 质量层次查询
     */
    @RequestMapping(value = "/qualityLevel" ,produces = "application/json;charset=utf-8")
    public Dto qualityLevel(){
        Dto query = drugsInformationService.qualityLevel();
        return query;
    }
    /**
     * 企业查询
     */
    @RequestMapping(value = "/enterPrise" ,produces = "application/json;charset=utf-8")
    public Dto enterPrise(){
        Dto query = drugsInformationService.enterPrise();
        return query;
    }
    /**
     * 供货商查询
     */
    @RequestMapping(value = "/supplierSelect" ,produces = "application/json;charset=utf-8")
    public Dto supplierSelect(){
        Dto query = drugsInformationService.supplierSelect();
        return query;
    }
    /**
     * 添加从表供应商药品目录表
     */
    @RequestMapping(value = "/insertSelective" ,produces = "application/json;charset=utf-8")
    public int insertSelective(Integer[] importId){
//        List<EnterpriseDrugCatalog> EDClist=new ArrayList<>();
        List<EnterpriseDrugCatalog> enterpriseDrugCatalogs = drugsInformationService.selectEnterpriseDrugCatalog();
        boolean bel=true;
        int result=0;
        for(int i=0;i<importId.length;i++){
            bel=true;
            EnterpriseDrugCatalog enterpriseDrugCatalog=new EnterpriseDrugCatalog();
            enterpriseDrugCatalog.setEnterpriseId(importId[i]);
            enterpriseDrugCatalog.setDrugInformationId(importId[i]);
            for(int j=0;j<enterpriseDrugCatalogs.size();j++){
                if(enterpriseDrugCatalogs.get(j).getDrugInformationId()==enterpriseDrugCatalog.getDrugInformationId()&&enterpriseDrugCatalogs.get(j).getEnterpriseId()==enterpriseDrugCatalog.getEnterpriseId()) {
                    bel=false;
                    break;
                }
            }
            if(bel)result+=drugsInformationService.insertSelective(enterpriseDrugCatalog);
        }
        System.out.println("共"+importId.length+"条，成功"+result);
        return result;
    }
    /**
     * 取消供货查询
     */
    @RequestMapping(value = "/backSelect" ,produces = "application/json;charset=utf-8")
    public String backSelect(@RequestParam(value = "commonName",required = false) String commonName,String serialNumber,@RequestParam(value = "dosageFormId",required = false)Integer dosageFormId,String specification,String unit,String conversionFraction,Integer drugCategoryId,Integer drugTransactionStatusId,Integer enterpriseNameId,String tradeName,Float latestRetailPrice,Integer qualityLevelId,Integer suppliersid,Integer auditStatus,
                          @RequestParam(value = "pageNum" ,defaultValue = "1",required = false) Integer pageNum){
        PageHelper.startPage(pageNum,5);
        if(dosageFormId!=null&&dosageFormId<=0){
            dosageFormId=null;
        }
        if(drugCategoryId!=null&&drugCategoryId<=0){
            drugCategoryId=null;
        }
        if(drugTransactionStatusId!=null&&drugTransactionStatusId<=0){
            drugTransactionStatusId=null;
        }
        if(qualityLevelId!=null&&qualityLevelId<=0){
            qualityLevelId=null;
        }
        if(enterpriseNameId!=null&&enterpriseNameId<=0){
            enterpriseNameId=null;
        }
        if(suppliersid!=null&&suppliersid<=0){
            suppliersid=null;
        }
        if(auditStatus!=null&&auditStatus<0){
            auditStatus=null;
        }
        List<EnterpriseDrugCatalog> query = drugsInformationService.backSelect(commonName, serialNumber, dosageFormId, specification, unit, conversionFraction, drugCategoryId, drugTransactionStatusId, enterpriseNameId, tradeName, latestRetailPrice, qualityLevelId,suppliersid,auditStatus);
        PageInfo<EnterpriseDrugCatalog> pageInfo = new PageInfo<>(query);
        return JSON.toJSONString(pageInfo);
    }
    /**
     * 企业查询
     */
    @RequestMapping(value = "/falseDelete" ,produces = "application/json;charset=utf-8")
    public String falseDelete(String[] checkedId){
        int i = drugsInformationService.falseDelete(checkedId);
        return JSON.toJSONString(i);
    }
    /**
     * 修改商品信息维护
     */
    @RequestMapping(value = "/updateByPrimaryKeySelectives" ,produces = "application/json;charset=utf-8")
    public String updateByPrimaryKeySelective(DrugInformation drugInformation){
        int i = drugsInformationService.updateByPrimaryKeySelectives(drugInformation);
        return JSON.toJSONString(i);
    }
    /**
     * 退货单查询
     */
    @RequestMapping(value = "/returnSelect" ,produces = "application/json;charset=utf-8")
    public String returnSelect(String returnOrderNumber, String returnOrderName, Integer returnStateId, Date createReceiptsTime, Date submissionTime, String hospitalName, Date startTime, Date endTime, String purchaseOrderNumber, String nameOfPurchaseOrder, @RequestParam(value = "commonName",required = false)String commonName, String serialNumber, Integer dosageFormId, String specification, String unit, String conversionFraction, Integer drugCategoryId, Integer enterpriseNameId, String tradeName, Integer qualityLevelId,
                               @RequestParam(value = "pageNum" ,defaultValue = "1",required = false) Integer pageNum){
        PageHelper.startPage(pageNum,5);
        if(dosageFormId!=null&&dosageFormId<=0){
            dosageFormId=null;
        }
        if(drugCategoryId!=null&&drugCategoryId<=0){
            drugCategoryId=null;
        }
        if(qualityLevelId!=null&&qualityLevelId<=0){
            qualityLevelId=null;
        }
        if(enterpriseNameId!=null&&enterpriseNameId<=0){
            enterpriseNameId=null;
        }
        if(returnStateId!=null&&returnStateId<=0){
            returnStateId=null;
        }
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss") ;
//        Date date1=null;
//        Date date2=null;
//        try {
//             date1 = sdf.parse(createReceiptsTime);
//             date2 = sdf.parse(submissionTime);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        List<DrugInformation> drugInformations = drugsInformationService.returnSelect(returnOrderNumber, returnOrderName, returnStateId, createReceiptsTime, submissionTime, hospitalName, startTime, endTime, purchaseOrderNumber, nameOfPurchaseOrder, commonName, serialNumber, dosageFormId, specification, unit, conversionFraction, drugCategoryId, enterpriseNameId, tradeName, qualityLevelId);
        PageInfo<DrugInformation> pageInfo = new PageInfo<>(drugInformations);
        return JSON.toJSONString(pageInfo);
    }
    /**
     * 退货单状态查询
     */
    @RequestMapping(value = "/selectReturnStatus" ,produces = "application/json;charset=utf-8")
    public String selectReturnStatus(){
        Dto dto = drugsInformationService.selectReturnStatus();
        return JSON.toJSONString(dto);
    }
    @RequestMapping(value = "/selectPurchaseOrder" ,produces = "application/json;charset=utf-8")
    public String selectPurchaseOrder(String statementNumber,String statementName,String hospitalName,Date startTime,Date endTime,Integer statementStateId,String purchaseOrderNumber,String nameOfPurchaseOrder,String commonName,String serialNumber,Integer dosageFormId,String specification,String unit,String conversionFraction,Integer drugCategoryId,Integer enterpriseNameId,String tradeName,Integer qualityLevelId,
                                      @RequestParam(value = "pageNum" ,defaultValue = "1",required = false) Integer pageNum){
        PageHelper.startPage(pageNum,5);
        if(dosageFormId!=null&&dosageFormId<=0){
            dosageFormId=null;
        }
        if(drugCategoryId!=null&&drugCategoryId<=0){
            drugCategoryId=null;
        }
        if(qualityLevelId!=null&&qualityLevelId<=0){
            qualityLevelId=null;
        }
        if(enterpriseNameId!=null&&enterpriseNameId<=0){
            enterpriseNameId=null;
        }
        if(statementStateId!=null&&statementStateId<=0){
            statementStateId=null;
        }
        List<DrugInformation> drugInformations = drugsInformationService.selectPurchaseOrder(statementNumber, statementName, hospitalName, startTime, endTime, statementStateId, purchaseOrderNumber, nameOfPurchaseOrder, commonName, serialNumber, dosageFormId, specification, unit, conversionFraction, drugCategoryId, enterpriseNameId, tradeName, qualityLevelId);
        PageInfo<DrugInformation> pageInfo = new PageInfo<>(drugInformations);
        return JSON.toJSONString(pageInfo);
    }
    /**
     * 结算单状态查询
     */
    @RequestMapping(value = "/selectSettlementStatus" ,produces = "application/json;charset=utf-8")
    public String selectSettlementStatus(){
        Dto dto = drugsInformationService.selectSettlementStatus();
        return JSON.toJSONString(dto);
    }
    /**
     * 确认退货
     */
    @RequestMapping(value = "/updateByPrimaryKeyReturn" ,produces = "application/json;charset=utf-8")
    public int updateByPrimaryKeyReturn(@RequestParam("importId[]") Integer[] importId){
        int result=0;
        result += drugsInformationService.updateByPrimaryKeyReturn(Arrays.asList(importId));
        System.out.println("共"+ importId.length+"条,成功"+result+"条");
        return result;
    }
    /**
     * 确认结算
     */
    @RequestMapping(value = "/updateByPrimaryKeySettment" ,produces = "application/json;charset=utf-8")
    public int updateByPrimaryKeySettment(@RequestParam("importId[]") Integer[] importId){
        int result=0;
        result += drugsInformationService.updateByPrimaryKeySettment(Arrays.asList(importId));
        System.out.println("共"+ importId.length+"条,成功"+result+"条");
        return result;
    }
    @RequestMapping(value = "/selectPurchaseOrderProcessing" ,produces = "application/json;charset=utf-8")
    public String selectPurchaseOrderProcessing(String purchaseOrderNumber,String nameOfPurchaseOrder, Integer purchaseOrdersStatesId,String hospitalName,Date startTime,Date endTime,String commonName,String serialNumber,Integer dosageFormId,String specification,String unit,String conversionFraction,Integer drugCategoryId,Integer enterpriseNameId,String tradeName,
                                      @RequestParam(value = "pageNum" ,defaultValue = "1",required = false) Integer pageNum){
        PageHelper.startPage(pageNum,5);
        if(dosageFormId!=null&&dosageFormId<=0){
            dosageFormId=null;
        }
        if(drugCategoryId!=null&&drugCategoryId<=0){
            drugCategoryId=null;
        }
        if(enterpriseNameId!=null&&enterpriseNameId<=0){
            enterpriseNameId=null;
        }
        if(purchaseOrdersStatesId!=null&&purchaseOrdersStatesId<0){
            purchaseOrdersStatesId=null;
        }
        if(startTime!=null){
            startTime=null;
        }
        List<DrugInformation> drugInformations = drugsInformationService.selectPurchaseOrderProcessing(purchaseOrderNumber,nameOfPurchaseOrder,purchaseOrdersStatesId,hospitalName,startTime,endTime,commonName,serialNumber,dosageFormId,specification,unit,conversionFraction,drugCategoryId,enterpriseNameId,tradeName);
        PageInfo<DrugInformation> pageInfo = new PageInfo<>(drugInformations);
        return JSON.toJSONString(pageInfo);
    }
    //只需要加上下面这段即可，注意不能忘记注解
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {

        //转换日期
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }
    /**
     * 选择发货
     */
    @RequestMapping(value = "/updateReturnGoods" ,produces = "application/json;charset=utf-8")
    public int updateReturnGoods(@RequestParam("importId[]") Integer[] importId){
        int result=0;
        result += drugsInformationService.updateReturnGoods(Arrays.asList(importId));
        System.out.println("共"+ importId.length+"条,成功"+result+"条");
        return result;
    }
    /**
     * 选择发货
     */
    @RequestMapping(value = "/updateUnableToSupply" ,produces = "application/json;charset=utf-8")
    public int updateUnableToSupply(@RequestParam("importId[]") Integer[] importId){
        int result=0;
        result += drugsInformationService.updateUnableToSupply(Arrays.asList(importId));
        System.out.println("共"+ importId.length+"条,成功"+result+"条");
        return result;
    }

    /**
     * 按采购单查询
     * @param purchaseOrderNumber
     * @param nameOfPurchaseOrder
     * @param purchaseOrdersStatesId
     * @param hospitalName
     * @param
     * @param
     * @param commonName
     * @param serialNumber
     * @param dosageFormId
     * @param specification
     * @param unit
     * @param conversionFraction
     * @param drugCategoryId
     * @param enterpriseNameId
     * @param tradeName
     * @param pageNum
     * @return
     */
    @RequestMapping(value = "/selectPurchaseToOrder" ,produces = "application/json;charset=utf-8")
    public String selectPurchaseToOrder(String purchaseOrderNumber, String nameOfPurchaseOrder, Integer purchaseOrdersStatesId, String hospitalName, Date createTime, Date subTime, String commonName, String serialNumber, Integer dosageFormId, String specification, String unit, String conversionFraction, Integer drugCategoryId, Integer enterpriseNameId, String tradeName, Integer suppliersid,
                                                @RequestParam(value = "pageNum" ,defaultValue = "1",required = false) Integer pageNum){
        PageHelper.startPage(pageNum,5);
        if(dosageFormId!=null&&dosageFormId<=0){
            dosageFormId=null;
        }
        if(drugCategoryId!=null&&drugCategoryId<=0){
            drugCategoryId=null;
        }
        if(enterpriseNameId!=null&&enterpriseNameId<=0){
            enterpriseNameId=null;
        }
        if(purchaseOrdersStatesId!=null&&purchaseOrdersStatesId<0){
            purchaseOrdersStatesId=null;
        }
       if(suppliersid!=null&&suppliersid<=0){
           suppliersid=null;
       }
        List<DrugInformation> drugInformations = drugsInformationService.selectPurchaseToOrder(purchaseOrderNumber,nameOfPurchaseOrder, purchaseOrdersStatesId,hospitalName,createTime,subTime,commonName,serialNumber,
                dosageFormId,specification,unit,conversionFraction,drugCategoryId,enterpriseNameId,tradeName,suppliersid);
        PageInfo<DrugInformation> pageInfo = new PageInfo<>(drugInformations);
        return JSON.toJSONString(pageInfo);
    }
}
