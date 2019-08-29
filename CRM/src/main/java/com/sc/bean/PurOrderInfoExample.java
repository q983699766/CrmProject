package com.sc.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PurOrderInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PurOrderInfoExample() {
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

        public Criteria andPurInfoNumberIsNull() {
            addCriterion("PUR_INFO_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andPurInfoNumberIsNotNull() {
            addCriterion("PUR_INFO_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andPurInfoNumberEqualTo(Long value) {
            addCriterion("PUR_INFO_NUMBER =", value, "purInfoNumber");
            return (Criteria) this;
        }

        public Criteria andPurInfoNumberNotEqualTo(Long value) {
            addCriterion("PUR_INFO_NUMBER <>", value, "purInfoNumber");
            return (Criteria) this;
        }

        public Criteria andPurInfoNumberGreaterThan(Long value) {
            addCriterion("PUR_INFO_NUMBER >", value, "purInfoNumber");
            return (Criteria) this;
        }

        public Criteria andPurInfoNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("PUR_INFO_NUMBER >=", value, "purInfoNumber");
            return (Criteria) this;
        }

        public Criteria andPurInfoNumberLessThan(Long value) {
            addCriterion("PUR_INFO_NUMBER <", value, "purInfoNumber");
            return (Criteria) this;
        }

        public Criteria andPurInfoNumberLessThanOrEqualTo(Long value) {
            addCriterion("PUR_INFO_NUMBER <=", value, "purInfoNumber");
            return (Criteria) this;
        }

        public Criteria andPurInfoNumberIn(List<Long> values) {
            addCriterion("PUR_INFO_NUMBER in", values, "purInfoNumber");
            return (Criteria) this;
        }

        public Criteria andPurInfoNumberNotIn(List<Long> values) {
            addCriterion("PUR_INFO_NUMBER not in", values, "purInfoNumber");
            return (Criteria) this;
        }

        public Criteria andPurInfoNumberBetween(Long value1, Long value2) {
            addCriterion("PUR_INFO_NUMBER between", value1, value2, "purInfoNumber");
            return (Criteria) this;
        }

        public Criteria andPurInfoNumberNotBetween(Long value1, Long value2) {
            addCriterion("PUR_INFO_NUMBER not between", value1, value2, "purInfoNumber");
            return (Criteria) this;
        }

        public Criteria andPurNumberIsNull() {
            addCriterion("PUR_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andPurNumberIsNotNull() {
            addCriterion("PUR_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andPurNumberEqualTo(Long value) {
            addCriterion("PUR_NUMBER =", value, "purNumber");
            return (Criteria) this;
        }

        public Criteria andPurNumberNotEqualTo(Long value) {
            addCriterion("PUR_NUMBER <>", value, "purNumber");
            return (Criteria) this;
        }

        public Criteria andPurNumberGreaterThan(Long value) {
            addCriterion("PUR_NUMBER >", value, "purNumber");
            return (Criteria) this;
        }

        public Criteria andPurNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("PUR_NUMBER >=", value, "purNumber");
            return (Criteria) this;
        }

        public Criteria andPurNumberLessThan(Long value) {
            addCriterion("PUR_NUMBER <", value, "purNumber");
            return (Criteria) this;
        }

        public Criteria andPurNumberLessThanOrEqualTo(Long value) {
            addCriterion("PUR_NUMBER <=", value, "purNumber");
            return (Criteria) this;
        }

        public Criteria andPurNumberIn(List<Long> values) {
            addCriterion("PUR_NUMBER in", values, "purNumber");
            return (Criteria) this;
        }

        public Criteria andPurNumberNotIn(List<Long> values) {
            addCriterion("PUR_NUMBER not in", values, "purNumber");
            return (Criteria) this;
        }

        public Criteria andPurNumberBetween(Long value1, Long value2) {
            addCriterion("PUR_NUMBER between", value1, value2, "purNumber");
            return (Criteria) this;
        }

        public Criteria andPurNumberNotBetween(Long value1, Long value2) {
            addCriterion("PUR_NUMBER not between", value1, value2, "purNumber");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("PRODUCT_ID is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("PRODUCT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Long value) {
            addCriterion("PRODUCT_ID =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Long value) {
            addCriterion("PRODUCT_ID <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Long value) {
            addCriterion("PRODUCT_ID >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PRODUCT_ID >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Long value) {
            addCriterion("PRODUCT_ID <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Long value) {
            addCriterion("PRODUCT_ID <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Long> values) {
            addCriterion("PRODUCT_ID in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Long> values) {
            addCriterion("PRODUCT_ID not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Long value1, Long value2) {
            addCriterion("PRODUCT_ID between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Long value1, Long value2) {
            addCriterion("PRODUCT_ID not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProPriceIsNull() {
            addCriterion("PRO_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andProPriceIsNotNull() {
            addCriterion("PRO_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andProPriceEqualTo(BigDecimal value) {
            addCriterion("PRO_PRICE =", value, "proPrice");
            return (Criteria) this;
        }

        public Criteria andProPriceNotEqualTo(BigDecimal value) {
            addCriterion("PRO_PRICE <>", value, "proPrice");
            return (Criteria) this;
        }

        public Criteria andProPriceGreaterThan(BigDecimal value) {
            addCriterion("PRO_PRICE >", value, "proPrice");
            return (Criteria) this;
        }

        public Criteria andProPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PRO_PRICE >=", value, "proPrice");
            return (Criteria) this;
        }

        public Criteria andProPriceLessThan(BigDecimal value) {
            addCriterion("PRO_PRICE <", value, "proPrice");
            return (Criteria) this;
        }

        public Criteria andProPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PRO_PRICE <=", value, "proPrice");
            return (Criteria) this;
        }

        public Criteria andProPriceIn(List<BigDecimal> values) {
            addCriterion("PRO_PRICE in", values, "proPrice");
            return (Criteria) this;
        }

        public Criteria andProPriceNotIn(List<BigDecimal> values) {
            addCriterion("PRO_PRICE not in", values, "proPrice");
            return (Criteria) this;
        }

        public Criteria andProPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRO_PRICE between", value1, value2, "proPrice");
            return (Criteria) this;
        }

        public Criteria andProPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRO_PRICE not between", value1, value2, "proPrice");
            return (Criteria) this;
        }

        public Criteria andWarehouseOrnotIsNull() {
            addCriterion("WAREHOUSE_ORNOT is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseOrnotIsNotNull() {
            addCriterion("WAREHOUSE_ORNOT is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseOrnotEqualTo(String value) {
            addCriterion("WAREHOUSE_ORNOT =", value, "warehouseOrnot");
            return (Criteria) this;
        }

        public Criteria andWarehouseOrnotNotEqualTo(String value) {
            addCriterion("WAREHOUSE_ORNOT <>", value, "warehouseOrnot");
            return (Criteria) this;
        }

        public Criteria andWarehouseOrnotGreaterThan(String value) {
            addCriterion("WAREHOUSE_ORNOT >", value, "warehouseOrnot");
            return (Criteria) this;
        }

        public Criteria andWarehouseOrnotGreaterThanOrEqualTo(String value) {
            addCriterion("WAREHOUSE_ORNOT >=", value, "warehouseOrnot");
            return (Criteria) this;
        }

        public Criteria andWarehouseOrnotLessThan(String value) {
            addCriterion("WAREHOUSE_ORNOT <", value, "warehouseOrnot");
            return (Criteria) this;
        }

        public Criteria andWarehouseOrnotLessThanOrEqualTo(String value) {
            addCriterion("WAREHOUSE_ORNOT <=", value, "warehouseOrnot");
            return (Criteria) this;
        }

        public Criteria andWarehouseOrnotLike(String value) {
            addCriterion("WAREHOUSE_ORNOT like", value, "warehouseOrnot");
            return (Criteria) this;
        }

        public Criteria andWarehouseOrnotNotLike(String value) {
            addCriterion("WAREHOUSE_ORNOT not like", value, "warehouseOrnot");
            return (Criteria) this;
        }

        public Criteria andWarehouseOrnotIn(List<String> values) {
            addCriterion("WAREHOUSE_ORNOT in", values, "warehouseOrnot");
            return (Criteria) this;
        }

        public Criteria andWarehouseOrnotNotIn(List<String> values) {
            addCriterion("WAREHOUSE_ORNOT not in", values, "warehouseOrnot");
            return (Criteria) this;
        }

        public Criteria andWarehouseOrnotBetween(String value1, String value2) {
            addCriterion("WAREHOUSE_ORNOT between", value1, value2, "warehouseOrnot");
            return (Criteria) this;
        }

        public Criteria andWarehouseOrnotNotBetween(String value1, String value2) {
            addCriterion("WAREHOUSE_ORNOT not between", value1, value2, "warehouseOrnot");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNull() {
            addCriterion("OPERATOR_ID is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNotNull() {
            addCriterion("OPERATOR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdEqualTo(Long value) {
            addCriterion("OPERATOR_ID =", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotEqualTo(Long value) {
            addCriterion("OPERATOR_ID <>", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThan(Long value) {
            addCriterion("OPERATOR_ID >", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("OPERATOR_ID >=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThan(Long value) {
            addCriterion("OPERATOR_ID <", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThanOrEqualTo(Long value) {
            addCriterion("OPERATOR_ID <=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIn(List<Long> values) {
            addCriterion("OPERATOR_ID in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotIn(List<Long> values) {
            addCriterion("OPERATOR_ID not in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdBetween(Long value1, Long value2) {
            addCriterion("OPERATOR_ID between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotBetween(Long value1, Long value2) {
            addCriterion("OPERATOR_ID not between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andRemarksInfomIsNull() {
            addCriterion("REMARKS_INFOM is null");
            return (Criteria) this;
        }

        public Criteria andRemarksInfomIsNotNull() {
            addCriterion("REMARKS_INFOM is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksInfomEqualTo(String value) {
            addCriterion("REMARKS_INFOM =", value, "remarksInfom");
            return (Criteria) this;
        }

        public Criteria andRemarksInfomNotEqualTo(String value) {
            addCriterion("REMARKS_INFOM <>", value, "remarksInfom");
            return (Criteria) this;
        }

        public Criteria andRemarksInfomGreaterThan(String value) {
            addCriterion("REMARKS_INFOM >", value, "remarksInfom");
            return (Criteria) this;
        }

        public Criteria andRemarksInfomGreaterThanOrEqualTo(String value) {
            addCriterion("REMARKS_INFOM >=", value, "remarksInfom");
            return (Criteria) this;
        }

        public Criteria andRemarksInfomLessThan(String value) {
            addCriterion("REMARKS_INFOM <", value, "remarksInfom");
            return (Criteria) this;
        }

        public Criteria andRemarksInfomLessThanOrEqualTo(String value) {
            addCriterion("REMARKS_INFOM <=", value, "remarksInfom");
            return (Criteria) this;
        }

        public Criteria andRemarksInfomLike(String value) {
            addCriterion("REMARKS_INFOM like", value, "remarksInfom");
            return (Criteria) this;
        }

        public Criteria andRemarksInfomNotLike(String value) {
            addCriterion("REMARKS_INFOM not like", value, "remarksInfom");
            return (Criteria) this;
        }

        public Criteria andRemarksInfomIn(List<String> values) {
            addCriterion("REMARKS_INFOM in", values, "remarksInfom");
            return (Criteria) this;
        }

        public Criteria andRemarksInfomNotIn(List<String> values) {
            addCriterion("REMARKS_INFOM not in", values, "remarksInfom");
            return (Criteria) this;
        }

        public Criteria andRemarksInfomBetween(String value1, String value2) {
            addCriterion("REMARKS_INFOM between", value1, value2, "remarksInfom");
            return (Criteria) this;
        }

        public Criteria andRemarksInfomNotBetween(String value1, String value2) {
            addCriterion("REMARKS_INFOM not between", value1, value2, "remarksInfom");
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

        public Criteria andLastDateIsNull() {
            addCriterion("LAST_DATE is null");
            return (Criteria) this;
        }

        public Criteria andLastDateIsNotNull() {
            addCriterion("LAST_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andLastDateEqualTo(Date value) {
            addCriterion("LAST_DATE =", value, "lastDate");
            return (Criteria) this;
        }

        public Criteria andLastDateNotEqualTo(Date value) {
            addCriterion("LAST_DATE <>", value, "lastDate");
            return (Criteria) this;
        }

        public Criteria andLastDateGreaterThan(Date value) {
            addCriterion("LAST_DATE >", value, "lastDate");
            return (Criteria) this;
        }

        public Criteria andLastDateGreaterThanOrEqualTo(Date value) {
            addCriterion("LAST_DATE >=", value, "lastDate");
            return (Criteria) this;
        }

        public Criteria andLastDateLessThan(Date value) {
            addCriterion("LAST_DATE <", value, "lastDate");
            return (Criteria) this;
        }

        public Criteria andLastDateLessThanOrEqualTo(Date value) {
            addCriterion("LAST_DATE <=", value, "lastDate");
            return (Criteria) this;
        }

        public Criteria andLastDateIn(List<Date> values) {
            addCriterion("LAST_DATE in", values, "lastDate");
            return (Criteria) this;
        }

        public Criteria andLastDateNotIn(List<Date> values) {
            addCriterion("LAST_DATE not in", values, "lastDate");
            return (Criteria) this;
        }

        public Criteria andLastDateBetween(Date value1, Date value2) {
            addCriterion("LAST_DATE between", value1, value2, "lastDate");
            return (Criteria) this;
        }

        public Criteria andLastDateNotBetween(Date value1, Date value2) {
            addCriterion("LAST_DATE not between", value1, value2, "lastDate");
            return (Criteria) this;
        }

        public Criteria andProductCountIsNull() {
            addCriterion("PRODUCT_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andProductCountIsNotNull() {
            addCriterion("PRODUCT_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andProductCountEqualTo(Long value) {
            addCriterion("PRODUCT_COUNT =", value, "productCount");
            return (Criteria) this;
        }

        public Criteria andProductCountNotEqualTo(Long value) {
            addCriterion("PRODUCT_COUNT <>", value, "productCount");
            return (Criteria) this;
        }

        public Criteria andProductCountGreaterThan(Long value) {
            addCriterion("PRODUCT_COUNT >", value, "productCount");
            return (Criteria) this;
        }

        public Criteria andProductCountGreaterThanOrEqualTo(Long value) {
            addCriterion("PRODUCT_COUNT >=", value, "productCount");
            return (Criteria) this;
        }

        public Criteria andProductCountLessThan(Long value) {
            addCriterion("PRODUCT_COUNT <", value, "productCount");
            return (Criteria) this;
        }

        public Criteria andProductCountLessThanOrEqualTo(Long value) {
            addCriterion("PRODUCT_COUNT <=", value, "productCount");
            return (Criteria) this;
        }

        public Criteria andProductCountIn(List<Long> values) {
            addCriterion("PRODUCT_COUNT in", values, "productCount");
            return (Criteria) this;
        }

        public Criteria andProductCountNotIn(List<Long> values) {
            addCriterion("PRODUCT_COUNT not in", values, "productCount");
            return (Criteria) this;
        }

        public Criteria andProductCountBetween(Long value1, Long value2) {
            addCriterion("PRODUCT_COUNT between", value1, value2, "productCount");
            return (Criteria) this;
        }

        public Criteria andProductCountNotBetween(Long value1, Long value2) {
            addCriterion("PRODUCT_COUNT not between", value1, value2, "productCount");
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