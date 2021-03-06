package com.ygjy.systemmanagement.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import org.apache.poi.ss.usermodel.Row;

import java.util.Date;
import java.util.List;

public class User extends BaseRowModel {

    private Integer id;

    @ExcelIgnore
    private Integer userId;

    @ExcelProperty(value = "用户名",index = 0)
    private String userAccount;

    @ExcelProperty(value = "用户账号",index = 1)
    private String username;

    private String password;

    private String salt;

    private Integer userState;

    @ExcelProperty(value = "单位名称",index = 2)
    private String userUnit;

    @ExcelProperty(value = "联系地址",index = 3)
    private String contactAddress;

    @ExcelProperty(value = "邮政编码",index = 4)
    private String postalCode;

    @ExcelProperty(value = "联系人",index = 5)
    private String contacts;

    @ExcelProperty(value = "联系方式",index = 6)
    private String userPhone;

    @ExcelProperty(value = "邮箱",index = 7)
    private String userEmail;

    @ExcelProperty(value = "创建时间",index = 8)
    private Date userCreateTime;

    @ExcelProperty(value = "更新时间",index = 9)
    private Date userUpdateTime;

    private Date lastLoginTime;

    private Role role;

    private UserRole userRole;

    private Jurisdiction jurisdiction;

    private RoleJurisdiction roleJurisdiction;

    private List<Role> roleList;

    private List<Jurisdiction> jurisdictionList;

    private List<UserRole> userRoleList;

    public List<UserRole> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List<UserRole> userRoleList) {
        this.userRoleList = userRoleList;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public List<Jurisdiction> getJurisdictionList() {
        return jurisdictionList;
    }

    public void setJurisdictionList(List<Jurisdiction> jurisdictionList) {
        this.jurisdictionList = jurisdictionList;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public Jurisdiction getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(Jurisdiction jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public RoleJurisdiction getRoleJurisdiction() {
        return roleJurisdiction;
    }

    public void setRoleJurisdiction(RoleJurisdiction roleJurisdiction) {
        this.roleJurisdiction = roleJurisdiction;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }

    public String getUserUnit() {
        return userUnit;
    }

    public void setUserUnit(String userUnit) {
        this.userUnit = userUnit == null ? null : userUnit.trim();
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress == null ? null : contactAddress.trim();
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode == null ? null : postalCode.trim();
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public Date getUserCreateTime() {
        return userCreateTime;
    }

    public void setUserCreateTime(Date userCreateTime) {
        this.userCreateTime = userCreateTime;
    }

    public Date getUserUpdateTime() {
        return userUpdateTime;
    }

    public void setUserUpdateTime(Date userUpdateTime) {
        this.userUpdateTime = userUpdateTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}