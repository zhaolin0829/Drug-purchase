package com.ygjy.purchasingmanagement1.dao;

import com.ygjy.purchasingmanagement1.pojo.PurchaseOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface PurchaseOrderDao {

    List<PurchaseOrder> selectPurchaseOrder();

    PurchaseOrder selectOne(Integer id);

    int updatePurchaseOrder(PurchaseOrder purchaseOrder);

    int deletePurchaseOrder(Integer id);

    int addPurchaseOrder(PurchaseOrder purchaseOrder);

    List<PurchaseOrder> selectLikePurchaseOrder(
            @Param("purchaseOrderNumber") String purchaseOrderNumber,
            @Param("nameOfPurchaseOrder") String nameOfPurchaseOrder,
            @Param("purchaseState")Integer purchaseState,
            @Param("submissionTime")Date submissionTime,
            @Param("hospitalId")Integer hospitalId
            );

}
