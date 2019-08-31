package com.sc.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysBranchExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysBranchExample() {
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

        public Criteria andSecIdIsNull() {
            addCriterion("SEC_ID is null");
            return (Criteria) this;
        }

        public Criteria andSecIdIsNotNull() {
            addCriterion("SEC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSecIdEqualTo(Long value) {
            addCriterion("SEC_ID =", value, "secId");
            return (Criteria) this;
        }

        public Criteria andSecIdNotEqualTo(Long value) {
            addCriterion("SEC_ID <>", value, "secId");
            return (Criteria) this;
        }

        public Criteria andSecIdGreaterThan(Long value) {
            addCriterion("SEC_ID >", value, "secId");
            return (Criteria) this;
        }

        public Criteria andSecIdGreaterThanOrEqualTo(Long value) {
            addCriterion("SEC_ID >=", value, "secId");
            return (Criteria) this;
        }

        public Criteria andSecIdLessThan(Long value) {
            addCriterion("SEC_ID <", value, "secId");
            return (Criteria) this;
        }

        public Criteria andSecIdLessThanOrEqualTo(Long value) {
            addCriterion("SEC_ID <=", value, "secId");
            return (Criteria) this;
        }

        public Criteria andSecIdIn(List<Long> values) {
            addCriterion("SEC_ID in", values, "secId");
            return (Criteria) this;
        }

        public Criteria andSecIdNotIn(List<Long> values) {
            addCriterion("SEC_ID not in", values, "secId");
            return (Criteria) this;
        }

        public Criteria andSecIdBetween(Long value1, Long value2) {
            addCriterion("SEC_ID between", value1, value2, "secId");
            return (Criteria) this;
        }

        public Criteria andSecIdNotBetween(Long value1, Long value2) {
            addCriterion("SEC_ID not between", value1, value2, "secId");
            return (Criteria) this;
        }

        public Criteria andSecNameIsNull() {
            addCriterion("SEC_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSecNameIsNotNull() {
            addCriterion("SEC_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSecNameEqualTo(String value) {
            addCriterion("SEC_NAME =", value, "secName");
            return (Criteria) this;
        }

        public Criteria andSecNameNotEqualTo(String value) {
            addCriterion("SEC_NAME <>", value, "secName");
            return (Criteria) this;
        }

        public Criteria andSecNameGreaterThan(String value) {
            addCriterion("SEC_NAME >", value, "secName");
            return (Criteria) this;
        }

        public Criteria andSecNameGreaterThanOrEqualTo(String value) {
            addCriterion("SEC_NAME >=", value, "secName");
            return (Criteria) this;
        }

        public Criteria andSecNameLessThan(String value) {
            addCriterion("SEC_NAME <", value, "secName");
            return (Criteria) this;
        }

        public Criteria andSecNameLessThanOrEqualTo(String value) {
            addCriterion("SEC_NAME <=", value, "secName");
            return (Criteria) this;
        }

        public Criteria andSecNameLike(String value) {
            addCriterion("SEC_NAME like", value, "secName");
            return (Criteria) this;
        }

        public Criteria andSecNameNotLike(String value) {
            addCriterion("SEC_NAME not like", value, "secName");
            return (Criteria) this;
        }

        public Criteria andSecNameIn(List<String> values) {
            addCriterion("SEC_NAME in", values, "secName");
            return (Criteria) this;
        }

        public Criteria andSecNameNotIn(List<String> values) {
            addCriterion("SEC_NAME not in", values, "secName");
            return (Criteria) this;
        }

        public Criteria andSecNameBetween(String value1, String value2) {
            addCriterion("SEC_NAME between", value1, value2, "secName");
            return (Criteria) this;
        }

        public Criteria andSecNameNotBetween(String value1, String value2) {
            addCriterion("SEC_NAME not between", value1, value2, "secName");
            return (Criteria) this;
        }

        public Criteria andSecCommentIsNull() {
            addCriterion("SEC_COMMENT is null");
            return (Criteria) this;
        }

        public Criteria andSecCommentIsNotNull() {
            addCriterion("SEC_COMMENT is not null");
            return (Criteria) this;
        }

        public Criteria andSecCommentEqualTo(String value) {
            addCriterion("SEC_COMMENT =", value, "secComment");
            return (Criteria) this;
        }

        public Criteria andSecCommentNotEqualTo(String value) {
            addCriterion("SEC_COMMENT <>", value, "secComment");
            return (Criteria) this;
        }

        public Criteria andSecCommentGreaterThan(String value) {
            addCriterion("SEC_COMMENT >", value, "secComment");
            return (Criteria) this;
        }

        public Criteria andSecCommentGreaterThanOrEqualTo(String value) {
            addCriterion("SEC_COMMENT >=", value, "secComment");
            return (Criteria) this;
        }

        public Criteria andSecCommentLessThan(String value) {
            addCriterion("SEC_COMMENT <", value, "secComment");
            return (Criteria) this;
        }

        public Criteria andSecCommentLessThanOrEqualTo(String value) {
            addCriterion("SEC_COMMENT <=", value, "secComment");
            return (Criteria) this;
        }

        public Criteria andSecCommentLike(String value) {
            addCriterion("SEC_COMMENT like", value, "secComment");
            return (Criteria) this;
        }

        public Criteria andSecCommentNotLike(String value) {
            addCriterion("SEC_COMMENT not like", value, "secComment");
            return (Criteria) this;
        }

        public Criteria andSecCommentIn(List<String> values) {
            addCriterion("SEC_COMMENT in", values, "secComment");
            return (Criteria) this;
        }

        public Criteria andSecCommentNotIn(List<String> values) {
            addCriterion("SEC_COMMENT not in", values, "secComment");
            return (Criteria) this;
        }

        public Criteria andSecCommentBetween(String value1, String value2) {
            addCriterion("SEC_COMMENT between", value1, value2, "secComment");
            return (Criteria) this;
        }

        public Criteria andSecCommentNotBetween(String value1, String value2) {
            addCriterion("SEC_COMMENT not between", value1, value2, "secComment");
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