package com.sc.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysDutyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysDutyExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andDutIdIsNull() {
            addCriterion("DUT_ID is null");
            return (Criteria) this;
        }

        public Criteria andDutIdIsNotNull() {
            addCriterion("DUT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDutIdEqualTo(BigDecimal value) {
            addCriterion("DUT_ID =", value, "dutId");
            return (Criteria) this;
        }

        public Criteria andDutIdNotEqualTo(BigDecimal value) {
            addCriterion("DUT_ID <>", value, "dutId");
            return (Criteria) this;
        }

        public Criteria andDutIdGreaterThan(BigDecimal value) {
            addCriterion("DUT_ID >", value, "dutId");
            return (Criteria) this;
        }

        public Criteria andDutIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DUT_ID >=", value, "dutId");
            return (Criteria) this;
        }

        public Criteria andDutIdLessThan(BigDecimal value) {
            addCriterion("DUT_ID <", value, "dutId");
            return (Criteria) this;
        }

        public Criteria andDutIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DUT_ID <=", value, "dutId");
            return (Criteria) this;
        }

        public Criteria andDutIdIn(List<BigDecimal> values) {
            addCriterion("DUT_ID in", values, "dutId");
            return (Criteria) this;
        }

        public Criteria andDutIdNotIn(List<BigDecimal> values) {
            addCriterion("DUT_ID not in", values, "dutId");
            return (Criteria) this;
        }

        public Criteria andDutIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DUT_ID between", value1, value2, "dutId");
            return (Criteria) this;
        }

        public Criteria andDutIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DUT_ID not between", value1, value2, "dutId");
            return (Criteria) this;
        }

        public Criteria andDutNameIsNull() {
            addCriterion("DUT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDutNameIsNotNull() {
            addCriterion("DUT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDutNameEqualTo(String value) {
            addCriterion("DUT_NAME =", value, "dutName");
            return (Criteria) this;
        }

        public Criteria andDutNameNotEqualTo(String value) {
            addCriterion("DUT_NAME <>", value, "dutName");
            return (Criteria) this;
        }

        public Criteria andDutNameGreaterThan(String value) {
            addCriterion("DUT_NAME >", value, "dutName");
            return (Criteria) this;
        }

        public Criteria andDutNameGreaterThanOrEqualTo(String value) {
            addCriterion("DUT_NAME >=", value, "dutName");
            return (Criteria) this;
        }

        public Criteria andDutNameLessThan(String value) {
            addCriterion("DUT_NAME <", value, "dutName");
            return (Criteria) this;
        }

        public Criteria andDutNameLessThanOrEqualTo(String value) {
            addCriterion("DUT_NAME <=", value, "dutName");
            return (Criteria) this;
        }

        public Criteria andDutNameLike(String value) {
            addCriterion("DUT_NAME like", value, "dutName");
            return (Criteria) this;
        }

        public Criteria andDutNameNotLike(String value) {
            addCriterion("DUT_NAME not like", value, "dutName");
            return (Criteria) this;
        }

        public Criteria andDutNameIn(List<String> values) {
            addCriterion("DUT_NAME in", values, "dutName");
            return (Criteria) this;
        }

        public Criteria andDutNameNotIn(List<String> values) {
            addCriterion("DUT_NAME not in", values, "dutName");
            return (Criteria) this;
        }

        public Criteria andDutNameBetween(String value1, String value2) {
            addCriterion("DUT_NAME between", value1, value2, "dutName");
            return (Criteria) this;
        }

        public Criteria andDutNameNotBetween(String value1, String value2) {
            addCriterion("DUT_NAME not between", value1, value2, "dutName");
            return (Criteria) this;
        }

        public Criteria andSecIdIsNull() {
            addCriterion("SEC_ID is null");
            return (Criteria) this;
        }

        public Criteria andSecIdIsNotNull() {
            addCriterion("SEC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSecIdEqualTo(BigDecimal value) {
            addCriterion("SEC_ID =", value, "secId");
            return (Criteria) this;
        }

        public Criteria andSecIdNotEqualTo(BigDecimal value) {
            addCriterion("SEC_ID <>", value, "secId");
            return (Criteria) this;
        }

        public Criteria andSecIdGreaterThan(BigDecimal value) {
            addCriterion("SEC_ID >", value, "secId");
            return (Criteria) this;
        }

        public Criteria andSecIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SEC_ID >=", value, "secId");
            return (Criteria) this;
        }

        public Criteria andSecIdLessThan(BigDecimal value) {
            addCriterion("SEC_ID <", value, "secId");
            return (Criteria) this;
        }

        public Criteria andSecIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SEC_ID <=", value, "secId");
            return (Criteria) this;
        }

        public Criteria andSecIdIn(List<BigDecimal> values) {
            addCriterion("SEC_ID in", values, "secId");
            return (Criteria) this;
        }

        public Criteria andSecIdNotIn(List<BigDecimal> values) {
            addCriterion("SEC_ID not in", values, "secId");
            return (Criteria) this;
        }

        public Criteria andSecIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SEC_ID between", value1, value2, "secId");
            return (Criteria) this;
        }

        public Criteria andSecIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SEC_ID not between", value1, value2, "secId");
            return (Criteria) this;
        }

        public Criteria andDutRemarkIsNull() {
            addCriterion("DUT_REMARK is null");
            return (Criteria) this;
        }

        public Criteria andDutRemarkIsNotNull() {
            addCriterion("DUT_REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andDutRemarkEqualTo(String value) {
            addCriterion("DUT_REMARK =", value, "dutRemark");
            return (Criteria) this;
        }

        public Criteria andDutRemarkNotEqualTo(String value) {
            addCriterion("DUT_REMARK <>", value, "dutRemark");
            return (Criteria) this;
        }

        public Criteria andDutRemarkGreaterThan(String value) {
            addCriterion("DUT_REMARK >", value, "dutRemark");
            return (Criteria) this;
        }

        public Criteria andDutRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("DUT_REMARK >=", value, "dutRemark");
            return (Criteria) this;
        }

        public Criteria andDutRemarkLessThan(String value) {
            addCriterion("DUT_REMARK <", value, "dutRemark");
            return (Criteria) this;
        }

        public Criteria andDutRemarkLessThanOrEqualTo(String value) {
            addCriterion("DUT_REMARK <=", value, "dutRemark");
            return (Criteria) this;
        }

        public Criteria andDutRemarkLike(String value) {
            addCriterion("DUT_REMARK like", value, "dutRemark");
            return (Criteria) this;
        }

        public Criteria andDutRemarkNotLike(String value) {
            addCriterion("DUT_REMARK not like", value, "dutRemark");
            return (Criteria) this;
        }

        public Criteria andDutRemarkIn(List<String> values) {
            addCriterion("DUT_REMARK in", values, "dutRemark");
            return (Criteria) this;
        }

        public Criteria andDutRemarkNotIn(List<String> values) {
            addCriterion("DUT_REMARK not in", values, "dutRemark");
            return (Criteria) this;
        }

        public Criteria andDutRemarkBetween(String value1, String value2) {
            addCriterion("DUT_REMARK between", value1, value2, "dutRemark");
            return (Criteria) this;
        }

        public Criteria andDutRemarkNotBetween(String value1, String value2) {
            addCriterion("DUT_REMARK not between", value1, value2, "dutRemark");
            return (Criteria) this;
        }

        public Criteria andComIdIsNull() {
            addCriterion("COM_ID is null");
            return (Criteria) this;
        }

        public Criteria andComIdIsNotNull() {
            addCriterion("COM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andComIdEqualTo(BigDecimal value) {
            addCriterion("COM_ID =", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotEqualTo(BigDecimal value) {
            addCriterion("COM_ID <>", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdGreaterThan(BigDecimal value) {
            addCriterion("COM_ID >", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COM_ID >=", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdLessThan(BigDecimal value) {
            addCriterion("COM_ID <", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COM_ID <=", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdIn(List<BigDecimal> values) {
            addCriterion("COM_ID in", values, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotIn(List<BigDecimal> values) {
            addCriterion("COM_ID not in", values, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COM_ID between", value1, value2, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COM_ID not between", value1, value2, "comId");
            return (Criteria) this;
        }

        public Criteria andLastTimeIsNull() {
            addCriterion("LAST_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLastTimeIsNotNull() {
            addCriterion("LAST_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastTimeEqualTo(Date value) {
            addCriterion("LAST_TIME =", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeNotEqualTo(Date value) {
            addCriterion("LAST_TIME <>", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeGreaterThan(Date value) {
            addCriterion("LAST_TIME >", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LAST_TIME >=", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeLessThan(Date value) {
            addCriterion("LAST_TIME <", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeLessThanOrEqualTo(Date value) {
            addCriterion("LAST_TIME <=", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeIn(List<Date> values) {
            addCriterion("LAST_TIME in", values, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeNotIn(List<Date> values) {
            addCriterion("LAST_TIME not in", values, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeBetween(Date value1, Date value2) {
            addCriterion("LAST_TIME between", value1, value2, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeNotBetween(Date value1, Date value2) {
            addCriterion("LAST_TIME not between", value1, value2, "lastTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}