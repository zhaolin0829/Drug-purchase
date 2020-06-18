package com.ygjy.purchasingmanagement2.service.Impl;

import com.ygjy.purchasingmanagement2.pojo.HospitalTransactionDetails;
import com.ygjy.purchasingmanagement2.pojo.HospitalTransactionReturn;
import com.ygjy.purchasingmanagement2.dao.HospitalTransactionReturnsDao;
import com.ygjy.purchasingmanagement2.service.HospitalTransactionReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @outher: Huangdebao
 * @Date: 2020/6/9 0009 下午 2:10
 * Desc: 添加退货单
 */
@Service
public class HospitalTransactionReturnServiceImpl implements HospitalTransactionReturnService {

    @Autowired
    HospitalTransactionReturnsDao hospitalTransactionReturnsDao;


    /*添加退货单*/
    @Override
    public int insert(HospitalTransactionReturn hosp) {

        return hospitalTransactionReturnsDao.insert(hosp);
    }

    /*查询全部到页面*/
    @Override
    public List<HospitalTransactionReturn> list(String returnOrderNumber,
                                                String returnOrderName,
                                                Integer returnStateId,
                                                String contacts,
                                                String phone,
                                                String creatReceiptsPerson,
                                                String createReceiptsTime,
                                                String submissionTime,
                                                String remark,
                                                Integer hospitalId) {

        List<HospitalTransactionReturn> list = hospitalTransactionReturnsDao.list(returnOrderNumber, returnOrderName, returnStateId, contacts, phone, creatReceiptsPerson, createReceiptsTime, submissionTime,remark,hospitalId);

        return list;
    }

    /*修改回显*/
    @Override
    public HospitalTransactionReturn htrSee(Integer id) {

        return hospitalTransactionReturnsDao.htrSee(id);

    }

    /*更新*/
    @Override
    public int update(HospitalTransactionReturn htr) {

        return hospitalTransactionReturnsDao.update(htr);
    }

    public boolean removeByKeys(String[] ids) {

        int result=hospitalTransactionReturnsDao.deleteByKeys(ids);
        if (result>0) {
            return true;
        } else {
            return false;
        }

    }

/*    *//*条件查询*//*
    @Override
    public List<HospitalTransactionReturn> selList(String returnOrderNumber, String returnOrderName, Integer hospitalId, Integer returnStateId) {

        return hospitalTransactionReturnsDao.selList(returnOrderNumber,returnOrderName, hospitalId, returnStateId);
    }*/

    /*导出*/
    @Override
    public List<HospitalTransactionReturn> exportAll(HospitalTransactionReturn hospital) {
        return hospitalTransactionReturnsDao.exportAll(hospital);
    }



/*退货单维护*/
    /*退货药品查询*/
    @Override
    public List<HospitalTransactionDetails> seletedrugs(String purchaseOrderNumber, String nameOfPurchaseOrder, String supplierName,String serialNumber, String commonName, String drugFrom, String specification, String unit, String conversionFraction, String tradeName, String level, Date createReceiptsTime, Date submissionTime, String drugBatchNumber, String returnOfState, String enterpriseName, String InvoiceNumber) {
        return hospitalTransactionReturnsDao.seletedrugs(purchaseOrderNumber,
                nameOfPurchaseOrder, supplierName,
                serialNumber, commonName,drugFrom, specification,
                unit, conversionFraction,tradeName, level,
                createReceiptsTime, submissionTime,drugBatchNumber,
                returnOfState, enterpriseName, InvoiceNumber);
    }

}
