package com.sc.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CcCkxxbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CcCkxxbExample() {
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

        public Criteria andCkBhIsNull() {
            addCriterion("CK_BH is null");
            return (Criteria) this;
        }

        public Criteria andCkBhIsNotNull() {
            addCriterion("CK_BH is not null");
            return (Criteria) this;
        }

        public Criteria andCkBhEqualTo(Long value) {
            addCriterion("CK_BH =", value, "ckBh");
            return (Criteria) this;
        }

        public Criteria andCkBhNotEqualTo(Long value) {
            addCriterion("CK_BH <>", value, "ckBh");
            return (Criteria) this;
        }

        public Criteria andCkBhGreaterThan(Long value) {
            addCriterion("CK_BH >", value, "ckBh");
            return (Criteria) this;
        }

        public Criteria andCkBhGreaterThanOrEqualTo(Long value) {
            addCriterion("CK_BH >=", value, "ckBh");
            return (Criteria) this;
        }

        public Criteria andCkBhLessThan(Long value) {
            addCriterion("CK_BH <", value, "ckBh");
            return (Criteria) this;
        }

        public Criteria andCkBhLessThanOrEqualTo(Long value) {
            addCriterion("CK_BH <=", value, "ckBh");
            return (Criteria) this;
        }

        public Criteria andCkBhIn(List<Long> values) {
            addCriterion("CK_BH in", values, "ckBh");
            return (Criteria) this;
        }

        public Criteria andCkBhNotIn(List<Long> values) {
            addCriterion("CK_BH not in", values, "ckBh");
            return (Criteria) this;
        }

        public Criteria andCkBhBetween(Long value1, Long value2) {
            addCriterion("CK_BH between", value1, value2, "ckBh");
            return (Criteria) this;
        }

        public Criteria andCkBhNotBetween(Long value1, Long value2) {
            addCriterion("CK_BH not between", value1, value2, "ckBh");
            return (Criteria) this;
        }

        public Criteria andCkMIsNull() {
            addCriterion("CK_M is null");
            return (Criteria) this;
        }

        public Criteria andCkMIsNotNull() {
            addCriterion("CK_M is not null");
            return (Criteria) this;
        }

        public Criteria andCkMEqualTo(String value) {
            addCriterion("CK_M =", value, "ckM");
            return (Criteria) this;
        }

        public Criteria andCkMNotEqualTo(String value) {
            addCriterion("CK_M <>", value, "ckM");
            return (Criteria) this;
        }

        public Criteria andCkMGreaterThan(String value) {
            addCriterion("CK_M >", value, "ckM");
            return (Criteria) this;
        }

        public Criteria andCkMGreaterThanOrEqualTo(String value) {
            addCriterion("CK_M >=", value, "ckM");
            return (Criteria) this;
        }

        public Criteria andCkMLessThan(String value) {
            addCriterion("CK_M <", value, "ckM");
            return (Criteria) this;
        }

        public Criteria andCkMLessThanOrEqualTo(String value) {
            addCriterion("CK_M <=", value, "ckM");
            return (Criteria) this;
        }

        public Criteria andCkMLike(String value) {
            addCriterion("CK_M like", value, "ckM");
            return (Criteria) this;
        }

        public Criteria andCkMNotLike(String value) {
            addCriterion("CK_M not like", value, "ckM");
            return (Criteria) this;
        }

        public Criteria andCkMIn(List<String> values) {
            addCriterion("CK_M in", values, "ckM");
            return (Criteria) this;
        }

        public Criteria andCkMNotIn(List<String> values) {
            addCriterion("CK_M not in", values, "ckM");
            return (Criteria) this;
        }

        public Criteria andCkMBetween(String value1, String value2) {
            addCriterion("CK_M between", value1, value2, "ckM");
            return (Criteria) this;
        }

        public Criteria andCkMNotBetween(String value1, String value2) {
            addCriterion("CK_M not between", value1, value2, "ckM");
            return (Criteria) this;
        }

        public Criteria andBzxxIsNull() {
            addCriterion("BZXX is null");
            return (Criteria) this;
        }

        public Criteria andBzxxIsNotNull() {
            addCriterion("BZXX is not null");
            return (Criteria) this;
        }

        public Criteria andBzxxEqualTo(String value) {
            addCriterion("BZXX =", value, "bzxx");
            return (Criteria) this;
        }

        public Criteria andBzxxNotEqualTo(String value) {
            addCriterion("BZXX <>", value, "bzxx");
            return (Criteria) this;
        }

        public Criteria andBzxxGreaterThan(String value) {
            addCriterion("BZXX >", value, "bzxx");
            return (Criteria) this;
        }

        public Criteria andBzxxGreaterThanOrEqualTo(String value) {
            addCriterion("BZXX >=", value, "bzxx");
            return (Criteria) this;
        }

        public Criteria andBzxxLessThan(String value) {
            addCriterion("BZXX <", value, "bzxx");
            return (Criteria) this;
        }

        public Criteria andBzxxLessThanOrEqualTo(String value) {
            addCriterion("BZXX <=", value, "bzxx");
            return (Criteria) this;
        }

        public Criteria andBzxxLike(String value) {
            addCriterion("BZXX like", value, "bzxx");
            return (Criteria) this;
        }

        public Criteria andBzxxNotLike(String value) {
            addCriterion("BZXX not like", value, "bzxx");
            return (Criteria) this;
        }

        public Criteria andBzxxIn(List<String> values) {
            addCriterion("BZXX in", values, "bzxx");
            return (Criteria) this;
        }

        public Criteria andBzxxNotIn(List<String> values) {
            addCriterion("BZXX not in", values, "bzxx");
            return (Criteria) this;
        }

        public Criteria andBzxxBetween(String value1, String value2) {
            addCriterion("BZXX between", value1, value2, "bzxx");
            return (Criteria) this;
        }

        public Criteria andBzxxNotBetween(String value1, String value2) {
            addCriterion("BZXX not between", value1, value2, "bzxx");
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