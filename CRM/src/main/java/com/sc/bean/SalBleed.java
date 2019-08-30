package com.sc.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class SalBleed implements Serializable {
    private Long churnId;

    private Long customId;

    private Long operatorId;

    private String processingMode;

    private String treatmentMeasures;

    private String bleed;

    private Long comId;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date lastTime;

    private static final long serialVersionUID = 1L;

    public SalBleed(Long churnId, Long customId, Long operatorId, String processingMode, String treatmentMeasures, String bleed, Long comId, Date lastTime) {
        this.churnId = churnId;
        this.customId = customId;
        this.operatorId = operatorId;
        this.processingMode = processingMode;
        this.treatmentMeasures = treatmentMeasures;
        this.bleed = bleed;
        this.comId = comId;
        this.lastTime = lastTime;
    }

    public SalBleed() {
        super();
    }

    public Long getChurnId() {
        return churnId;
    }

    public void setChurnId(Long churnId) {
        this.churnId = churnId;
    }

    public Long getCustomId() {
        return customId;
    }

    public void setCustomId(Long customId) {
        this.customId = customId;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public String getProcessingMode() {
        return processingMode;
    }

    public void setProcessingMode(String processingMode) {
        this.processingMode = processingMode == null ? null : processingMode.trim();
    }

    public String getTreatmentMeasures() {
        return treatmentMeasures;
    }

    public void setTreatmentMeasures(String treatmentMeasures) {
        this.treatmentMeasures = treatmentMeasures == null ? null : treatmentMeasures.trim();
    }

    public String getBleed() {
        return bleed;
    }

    public void setBleed(String bleed) {
        this.bleed = bleed == null ? null : bleed.trim();
    }

    public Long getComId() {
        return comId;
    }

    public void setComId(Long comId) {
        this.comId = comId;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

	@Override
	public String toString() {
		return "SalBleed [churnId=" + churnId + ", customId=" + customId + ", operatorId=" + operatorId
				+ ", processingMode=" + processingMode + ", treatmentMeasures=" + treatmentMeasures + ", bleed=" + bleed
				+ ", comId=" + comId + ", lastTime=" + lastTime + "]";
	}
}