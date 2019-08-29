package com.sc.mapper;

import java.io.Serializable;
import java.util.Date;

public class SysPermissionColumn implements Serializable {
    private Long columnId;

    private String columnName;

    private String remark;

    private Date lastTime;

    private static final long serialVersionUID = 1L;

    public SysPermissionColumn(Long columnId, String columnName, String remark, Date lastTime) {
        this.columnId = columnId;
        this.columnName = columnName;
        this.remark = remark;
        this.lastTime = lastTime;
    }

    public SysPermissionColumn() {
        super();
    }

    public Long getColumnId() {
        return columnId;
    }

    public void setColumnId(Long columnId) {
        this.columnId = columnId;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName == null ? null : columnName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }
}