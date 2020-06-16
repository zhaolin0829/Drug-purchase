package com.ygjy.purchasingmanagement2.dao;


import com.ygjy.purchasingmanagement2.pojo.HospitalTransactionReturn;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * HHospitalTransactionReturnNoteMaintenanceDao继承基类
 * 退货单维护页面
 */
@Mapper
@Repository
public interface HospitalTransactionReturnNoteMaintenanceDao {

    /*添加退货单*/
    int insert(HospitalTransactionReturn hosp);

    /*查询所有到页面*/
    List<HospitalTransactionReturn> list(HospitalTransactionReturn htrList);

    /*修改回显*/
    HospitalTransactionReturn htrSee(Integer id);

    /*更新*/
    int update(HospitalTransactionReturn htr);

    /*批量删除*/
    int deleteByKeys(String[] ids);

    /*条件查询*/
    List<HospitalTransactionReturn> selList(@Param("returnOrderNumber") String returnOrderNumber, @Param("returnOrderName") String returnOrderName,
                                            @Param("hospitalId") Integer hospitalId, @Param("returnStateId") Integer returnStateId);
}