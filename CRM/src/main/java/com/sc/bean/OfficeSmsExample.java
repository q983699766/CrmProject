package com.sc.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OfficeSmsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OfficeSmsExample() {
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

        public Criteria andSmsIdIsNull() {
            addCriterion("SMS_ID is null");
            return (Criteria) this;
        }

        public Criteria andSmsIdIsNotNull() {
            addCriterion("SMS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSmsIdEqualTo(Long value) {
            addCriterion("SMS_ID =", value, "smsId");
            return (Criteria) this;
        }

        public Criteria andSmsIdNotEqualTo(Long value) {
            addCriterion("SMS_ID <>", value, "smsId");
            return (Criteria) this;
        }

        public Criteria andSmsIdGreaterThan(Long value) {
            addCriterion("SMS_ID >", value, "smsId");
            return (Criteria) this;
        }

        public Criteria andSmsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("SMS_ID >=", value, "smsId");
            return (Criteria) this;
        }

        public Criteria andSmsIdLessThan(Long value) {
            addCriterion("SMS_ID <", value, "smsId");
            return (Criteria) this;
        }

        public Criteria andSmsIdLessThanOrEqualTo(Long value) {
            addCriterion("SMS_ID <=", value, "smsId");
            return (Criteria) this;
        }

        public Criteria andSmsIdIn(List<Long> values) {
            addCriterion("SMS_ID in", values, "smsId");
            return (Criteria) this;
        }

        public Criteria andSmsIdNotIn(List<Long> values) {
            addCriterion("SMS_ID not in", values, "smsId");
            return (Criteria) this;
        }

        public Criteria andSmsIdBetween(Long value1, Long value2) {
            addCriterion("SMS_ID between", value1, value2, "smsId");
            return (Criteria) this;
        }

        public Criteria andSmsIdNotBetween(Long value1, Long value2) {
            addCriterion("SMS_ID not between", value1, value2, "smsId");
            return (Criteria) this;
        }

        public Criteria andSmsHeadlineIsNull() {
            addCriterion("SMS_HEADLINE is null");
            return (Criteria) this;
        }

        public Criteria andSmsHeadlineIsNotNull() {
            addCriterion("SMS_HEADLINE is not null");
            return (Criteria) this;
        }

        public Criteria andSmsHeadlineEqualTo(String value) {
            addCriterion("SMS_HEADLINE =", value, "smsHeadline");
            return (Criteria) this;
        }

        public Criteria andSmsHeadlineNotEqualTo(String value) {
            addCriterion("SMS_HEADLINE <>", value, "smsHeadline");
            return (Criteria) this;
        }

        public Criteria andSmsHeadlineGreaterThan(String value) {
            addCriterion("SMS_HEADLINE >", value, "smsHeadline");
            return (Criteria) this;
        }

        public Criteria andSmsHeadlineGreaterThanOrEqualTo(String value) {
            addCriterion("SMS_HEADLINE >=", value, "smsHeadline");
            return (Criteria) this;
        }

        public Criteria andSmsHeadlineLessThan(String value) {
            addCriterion("SMS_HEADLINE <", value, "smsHeadline");
            return (Criteria) this;
        }

        public Criteria andSmsHeadlineLessThanOrEqualTo(String value) {
            addCriterion("SMS_HEADLINE <=", value, "smsHeadline");
            return (Criteria) this;
        }

        public Criteria andSmsHeadlineLike(String value) {
            addCriterion("SMS_HEADLINE like", value, "smsHeadline");
            return (Criteria) this;
        }

        public Criteria andSmsHeadlineNotLike(String value) {
            addCriterion("SMS_HEADLINE not like", value, "smsHeadline");
            return (Criteria) this;
        }

        public Criteria andSmsHeadlineIn(List<String> values) {
            addCriterion("SMS_HEADLINE in", values, "smsHeadline");
            return (Criteria) this;
        }

        public Criteria andSmsHeadlineNotIn(List<String> values) {
            addCriterion("SMS_HEADLINE not in", values, "smsHeadline");
            return (Criteria) this;
        }

        public Criteria andSmsHeadlineBetween(String value1, String value2) {
            addCriterion("SMS_HEADLINE between", value1, value2, "smsHeadline");
            return (Criteria) this;
        }

        public Criteria andSmsHeadlineNotBetween(String value1, String value2) {
            addCriterion("SMS_HEADLINE not between", value1, value2, "smsHeadline");
            return (Criteria) this;
        }

        public Criteria andSmsContentIsNull() {
            addCriterion("SMS_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andSmsContentIsNotNull() {
            addCriterion("SMS_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andSmsContentEqualTo(String value) {
            addCriterion("SMS_CONTENT =", value, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentNotEqualTo(String value) {
            addCriterion("SMS_CONTENT <>", value, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentGreaterThan(String value) {
            addCriterion("SMS_CONTENT >", value, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentGreaterThanOrEqualTo(String value) {
            addCriterion("SMS_CONTENT >=", value, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentLessThan(String value) {
            addCriterion("SMS_CONTENT <", value, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentLessThanOrEqualTo(String value) {
            addCriterion("SMS_CONTENT <=", value, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentLike(String value) {
            addCriterion("SMS_CONTENT like", value, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentNotLike(String value) {
            addCriterion("SMS_CONTENT not like", value, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentIn(List<String> values) {
            addCriterion("SMS_CONTENT in", values, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentNotIn(List<String> values) {
            addCriterion("SMS_CONTENT not in", values, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentBetween(String value1, String value2) {
            addCriterion("SMS_CONTENT between", value1, value2, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentNotBetween(String value1, String value2) {
            addCriterion("SMS_CONTENT not between", value1, value2, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsSenderIsNull() {
            addCriterion("SMS_SENDER is null");
            return (Criteria) this;
        }

        public Criteria andSmsSenderIsNotNull() {
            addCriterion("SMS_SENDER is not null");
            return (Criteria) this;
        }

        public Criteria andSmsSenderEqualTo(Long value) {
            addCriterion("SMS_SENDER =", value, "smsSender");
            return (Criteria) this;
        }

        public Criteria andSmsSenderNotEqualTo(Long value) {
            addCriterion("SMS_SENDER <>", value, "smsSender");
            return (Criteria) this;
        }

        public Criteria andSmsSenderGreaterThan(Long value) {
            addCriterion("SMS_SENDER >", value, "smsSender");
            return (Criteria) this;
        }

        public Criteria andSmsSenderGreaterThanOrEqualTo(Long value) {
            addCriterion("SMS_SENDER >=", value, "smsSender");
            return (Criteria) this;
        }

        public Criteria andSmsSenderLessThan(Long value) {
            addCriterion("SMS_SENDER <", value, "smsSender");
            return (Criteria) this;
        }

        public Criteria andSmsSenderLessThanOrEqualTo(Long value) {
            addCriterion("SMS_SENDER <=", value, "smsSender");
            return (Criteria) this;
        }

        public Criteria andSmsSenderIn(List<Long> values) {
            addCriterion("SMS_SENDER in", values, "smsSender");
            return (Criteria) this;
        }

        public Criteria andSmsSenderNotIn(List<Long> values) {
            addCriterion("SMS_SENDER not in", values, "smsSender");
            return (Criteria) this;
        }

        public Criteria andSmsSenderBetween(Long value1, Long value2) {
            addCriterion("SMS_SENDER between", value1, value2, "smsSender");
            return (Criteria) this;
        }

        public Criteria andSmsSenderNotBetween(Long value1, Long value2) {
            addCriterion("SMS_SENDER not between", value1, value2, "smsSender");
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

        public Criteria andComIdEqualTo(Long value) {
            addCriterion("COM_ID =", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotEqualTo(Long value) {
            addCriterion("COM_ID <>", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdGreaterThan(Long value) {
            addCriterion("COM_ID >", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdGreaterThanOrEqualTo(Long value) {
            addCriterion("COM_ID >=", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdLessThan(Long value) {
            addCriterion("COM_ID <", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdLessThanOrEqualTo(Long value) {
            addCriterion("COM_ID <=", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdIn(List<Long> values) {
            addCriterion("COM_ID in", values, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotIn(List<Long> values) {
            addCriterion("COM_ID not in", values, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdBetween(Long value1, Long value2) {
            addCriterion("COM_ID between", value1, value2, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotBetween(Long value1, Long value2) {
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