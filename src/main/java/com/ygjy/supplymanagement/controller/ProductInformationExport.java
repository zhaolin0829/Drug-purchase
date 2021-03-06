package com.ygjy.supplymanagement.controller;

import com.ygjy.supplymanagement.pojo.DrugInformation;
import com.ygjy.supplymanagement.service.DrugsInformationService;
import com.ygjy.supplymanagement.utils.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author: 赵林
 * @Date: 2020/6/12 16:54
 * @Description:
 */
@RestController
public class ProductInformationExport {
    @Autowired
    private DrugsInformationService drugsInformationService;
    /**
     * 导出报表
     * @return
     */
    @RequestMapping("export3")
    public String export(HttpServletRequest request, HttpServletResponse response, String[] importId) throws Exception {

        String message = "";

        //获取数据
        List<DrugInformation> list = drugsInformationService.importselect(importId);
        System.out.println(list+"=======================");
        //excel标题
        String[] title = {"流水号","通用名","剂型","规格","单位","转换系数","生产企业","商品名","中标价","质量层次","药品类别","交易状态","零售价出处","通用名拼音","供货商" ,"审核状态"};

        //excel文件名
        String fileName = "商品信息维护详情表"+System.currentTimeMillis()+".xls";

        fileName= URLEncoder.encode(fileName, "UTF-8");

        //sheet名
        String sheetName = "商品信息维护详情表";

        String [][] content = new String[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            content[i] = new String[title.length];
            DrugInformation stu = list.get(i);
            String AuditStatus=stu.getAuditStatus()==0?"审核通过":"审核不通过";
            content[i][0] = stu.getSerialNumber()+"";
            content[i][1] = stu.getCommonName()+"";
            content[i][2] = stu.getDurgsFrom().getDrugFrom()+"";
            content[i][3] = stu.getSerialNumber()+"";
            content[i][4] = stu.getUnit()+"";
            content[i][5] = stu.getConversionFraction()+"";
            content[i][6] = stu.getEnterprise().getEnterpriseName()+"";
            content[i][7] = stu.getTradeName()+"";
            content[i][8] = stu.getBiddingPrice()+"";
            try {
                content[i][9] = stu.getQualityLevel().getLevel()+"";
                content[i][10] = stu.getDrugCategory().getDrugCategoryName()+"";
                content[i][11] = stu.getDrugTransactionStatus().getDrugTransactionExplain()+"";
            } catch (Exception e) {
                e.printStackTrace();
            }
            content[i][12] = stu.getSourceOfRetailPrice()+"";
            content[i][13] = stu.getCommonNamePinyin()+"";
            content[i][14] = stu.getSuppliers().getSuppliername()+"";
            content[i][15] = AuditStatus+"";
        }

        //创建HSSFWorkbook
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);

        //响应到客户端
        try {
            this.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
            message = "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
            message = "ERROR";
        }
        return null;
    }

    //发送响应流方法
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"utf-8");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
