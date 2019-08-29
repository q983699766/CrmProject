package com.sc.mapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PurOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PurOrderExample() {
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

        public Criteria andPurTitleIsNull() {
            addCriterion("PUR_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andPurTitleIsNotNull() {
            addCriterion("PUR_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andPurTitleEqualTo(String value) {
            addCriterion("PUR_TITLE =", value, "purTitle");
            return (Criteria) this;
        }

        public Criteria andPurTitleNotEqualTo(String value) {
            addCriterion("PUR_TITLE <>", value, "purTitle");
            return (Criteria) this;
        }

        public Criteria andPurTitleGreaterThan(String value) {
            addCriterion("PUR_TITLE >", value, "purTitle");
            return (Criteria) this;
        }

        public Criteria andPurTitleGreaterThanOrEqualTo(String value) {
            addCriterion("PUR_TITLE >=", value, "purTitle");
            return (Criteria) this;
        }

        public Criteria andPurTitleLessThan(String value) {
            addCriterion("PUR_TITLE <", value, "purTitle");
            return (Criteria) this;
        }

        public Criteria andPurTitleLessThanOrEqualTo(String value) {
            addCriterion("PUR_TITLE <=", value, "purTitle");
            return (Criteria) this;
        }

        public Criteria andPurTitleLike(String value) {
            addCriterion("PUR_TITLE like", value, "purTitle");
            return (Criteria) this;
        }

        public Criteria andPurTitleNotLike(String value) {
            addCriterion("PUR_TITLE not like", value, "purTitle");
            return (Criteria) this;
        }

        public Criteria andPurTitleIn(List<String> values) {
            addCriterion("PUR_TITLE in", values, "purTitle");
            return (Criteria) this;
        }

        public Criteria andPurTitleNotIn(List<String> values) {
            addCriterion("PUR_TITLE not in", values, "purTitle");
            return (Criteria) this;
        }

        public Criteria andPurTitleBetween(String value1, String value2) {
            addCriterion("PUR_TITLE between", value1, value2, "purTitle");
            return (Criteria) this;
        }

        public Criteria andPurTitleNotBetween(String value1, String value2) {
            addCriterion("PUR_TITLE not between", value1, value2, "purTitle");
            return (Criteria) this;
        }

        public Criteria andPurDateIsNull() {
            addCriterion("PUR_DATE is null");
            return (Criteria) this;
        }

        public Criteria andPurDateIsNotNull() {
            addCriterion("PUR_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andPurDateEqualTo(Date value) {
            addCriterion("PUR_DATE =", value, "purDate");
            return (Criteria) this;
        }

        public Criteria andPurDateNotEqualTo(Date value) {
            addCriterion("PUR_DATE <>", value, "purDate");
            return (Criteria) this;
        }

        public Criteria andPurDateGreaterThan(Date value) {
            addCriterion("PUR_DATE >", value, "purDate");
            return (Criteria) this;
        }

        public Criteria andPurDateGreaterThanOrEqualTo(Date value) {
            addCriterion("PUR_DATE >=", value, "purDate");
            return (Criteria) this;
        }

        public Criteria andPurDateLessThan(Date value) {
            addCriterion("PUR_DATE <", value, "purDate");
            return (Criteria) this;
        }

        public Criteria andPurDateLessThanOrEqualTo(Date value) {
            addCriterion("PUR_DATE <=", value, "purDate");
            return (Criteria) this;
        }

        public Criteria andPurDateIn(List<Date> values) {
            addCriterion("PUR_DATE in", values, "purDate");
            return (Criteria) this;
        }

        public Criteria andPurDateNotIn(List<Date> values) {
            addCriterion("PUR_DATE not in", values, "purDate");
            return (Criteria) this;
        }

        public Criteria andPurDateBetween(Date value1, Date value2) {
            addCriterion("PUR_DATE between", value1, value2, "purDate");
            return (Criteria) this;
        }

        public Criteria andPurDateNotBetween(Date value1, Date value2) {
            addCriterion("PUR_DATE not between", value1, value2, "purDate");
            return (Criteria) this;
        }

        public Criteria andSupInfoNumIsNull() {
            addCriterion("SUP_INFO_NUM is null");
            return (Criteria) this;
        }

        public Criteria andSupInfoNumIsNotNull() {
            addCriterion("SUP_INFO_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andSupInfoNumEqualTo(Long value) {
            addCriterion("SUP_INFO_NUM =", value, "supInfoNum");
            return (Criteria) this;
        }

        public Criteria andSupInfoNumNotEqualTo(Long value) {
            addCriterion("SUP_INFO_NUM <>", value, "supInfoNum");
            return (Criteria) this;
        }

        public Criteria andSupInfoNumGreaterThan(Long value) {
            addCriterion("SUP_INFO_NUM >", value, "supInfoNum");
            return (Criteria) this;
        }

        public Criteria andSupInfoNumGreaterThanOrEqualTo(Long value) {
            addCriterion("SUP_INFO_NUM >=", value, "supInfoNum");
            return (Criteria) this;
        }

        public Criteria andSupInfoNumLessThan(Long value) {
            addCriterion("SUP_INFO_NUM <", value, "supInfoNum");
            return (Criteria) this;
        }

        public Criteria andSupInfoNumLessThanOrEqualTo(Long value) {
            addCriterion("SUP_INFO_NUM <=", value, "supInfoNum");
            return (Criteria) this;
        }

        public Criteria andSupInfoNumIn(List<Long> values) {
            addCriterion("SUP_INFO_NUM in", values, "supInfoNum");
            return (Criteria) this;
        }

        public Criteria andSupInfoNumNotIn(List<Long> values) {
            addCriterion("SUP_INFO_NUM not in", values, "supInfoNum");
            return (Criteria) this;
        }

        public Criteria andSupInfoNumBetween(Long value1, Long value2) {
            addCriterion("SUP_INFO_NUM between", value1, value2, "supInfoNum");
            return (Criteria) this;
        }

        public Criteria andSupInfoNumNotBetween(Long value1, Long value2) {
            addCriterion("SUP_INFO_NUM not between", value1, value2, "supInfoNum");
            return (Criteria) this;
        }

        public Criteria andPayAmountIsNull() {
            addCriterion("PAY_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andPayAmountIsNotNull() {
            addCriterion("PAY_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andPayAmountEqualTo(BigDecimal value) {
            addCriterion("PAY_AMOUNT =", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotEqualTo(BigDecimal value) {
            addCriterion("PAY_AMOUNT <>", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountGreaterThan(BigDecimal value) {
            addCriterion("PAY_AMOUNT >", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PAY_AMOUNT >=", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountLessThan(BigDecimal value) {
            addCriterion("PAY_AMOUNT <", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PAY_AMOUNT <=", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountIn(List<BigDecimal> values) {
            addCriterion("PAY_AMOUNT in", values, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotIn(List<BigDecimal> values) {
            addCriterion("PAY_AMOUNT not in", values, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PAY_AMOUNT between", value1, value2, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PAY_AMOUNT not between", value1, value2, "payAmount");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberIsNull() {
            addCriterion("INVOICE_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberIsNotNull() {
            addCriterion("INVOICE_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberEqualTo(String value) {
            addCriterion("INVOICE_NUMBER =", value, "invoiceNumber");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberNotEqualTo(String value) {
            addCriterion("INVOICE_NUMBER <>", value, "invoiceNumber");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberGreaterThan(String value) {
            addCriterion("INVOICE_NUMBER >", value, "invoiceNumber");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberGreaterThanOrEqualTo(String value) {
            addCriterion("INVOICE_NUMBER >=", value, "invoiceNumber");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberLessThan(String value) {
            addCriterion("INVOICE_NUMBER <", value, "invoiceNumber");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberLessThanOrEqualTo(String value) {
            addCriterion("INVOICE_NUMBER <=", value, "invoiceNumber");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberLike(String value) {
            addCriterion("INVOICE_NUMBER like", value, "invoiceNumber");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberNotLike(String value) {
            addCriterion("INVOICE_NUMBER not like", value, "invoiceNumber");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberIn(List<String> values) {
            addCriterion("INVOICE_NUMBER in", values, "invoiceNumber");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberNotIn(List<String> values) {
            addCriterion("INVOICE_NUMBER not in", values, "invoiceNumber");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberBetween(String value1, String value2) {
            addCriterion("INVOICE_NUMBER between", value1, value2, "invoiceNumber");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberNotBetween(String value1, String value2) {
            addCriterion("INVOICE_NUMBER not between", value1, value2, "invoiceNumber");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNull() {
            addCriterion("PAY_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNotNull() {
            addCriterion("PAY_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andPayStatusEqualTo(Long value) {
            addCriterion("PAY_STATUS =", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotEqualTo(Long value) {
            addCriterion("PAY_STATUS <>", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThan(Long value) {
            addCriterion("PAY_STATUS >", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThanOrEqualTo(Long value) {
            addCriterion("PAY_STATUS >=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThan(Long value) {
            addCriterion("PAY_STATUS <", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThanOrEqualTo(Long value) {
            addCriterion("PAY_STATUS <=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusIn(List<Long> values) {
            addCriterion("PAY_STATUS in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotIn(List<Long> values) {
            addCriterion("PAY_STATUS not in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusBetween(Long value1, Long value2) {
            addCriterion("PAY_STATUS between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotBetween(Long value1, Long value2) {
            addCriterion("PAY_STATUS not between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPurProgreesIsNull() {
            addCriterion("PUR_PROGREES is null");
            return (Criteria) this;
        }

        public Criteria andPurProgreesIsNotNull() {
            addCriterion("PUR_PROGREES is not null");
            return (Criteria) this;
        }

        public Criteria andPurProgreesEqualTo(Long value) {
            addCriterion("PUR_PROGREES =", value, "purProgrees");
            return (Criteria) this;
        }

        public Criteria andPurProgreesNotEqualTo(Long value) {
            addCriterion("PUR_PROGREES <>", value, "purProgrees");
            return (Criteria) this;
        }

        public Criteria andPurProgreesGreaterThan(Long value) {
            addCriterion("PUR_PROGREES >", value, "purProgrees");
            return (Criteria) this;
        }

        public Criteria andPurProgreesGreaterThanOrEqualTo(Long value) {
            addCriterion("PUR_PROGREES >=", value, "purProgrees");
            return (Criteria) this;
        }

        public Criteria andPurProgreesLessThan(Long value) {
            addCriterion("PUR_PROGREES <", value, "purProgrees");
            return (Criteria) this;
        }

        public Criteria andPurProgreesLessThanOrEqualTo(Long value) {
            addCriterion("PUR_PROGREES <=", value, "purProgrees");
            return (Criteria) this;
        }

        public Criteria andPurProgreesIn(List<Long> values) {
            addCriterion("PUR_PROGREES in", values, "purProgrees");
            return (Criteria) this;
        }

        public Criteria andPurProgreesNotIn(List<Long> values) {
            addCriterion("PUR_PROGREES not in", values, "purProgrees");
            return (Criteria) this;
        }

        public Criteria andPurProgreesBetween(Long value1, Long value2) {
            addCriterion("PUR_PROGREES between", value1, value2, "purProgrees");
            return (Criteria) this;
        }

        public Criteria andPurProgreesNotBetween(Long value1, Long value2) {
            addCriterion("PUR_PROGREES not between", value1, value2, "purProgrees");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIsNull() {
            addCriterion("DELIVERY_TIME is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIsNotNull() {
            addCriterion("DELIVERY_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeEqualTo(Date value) {
            addCriterion("DELIVERY_TIME =", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotEqualTo(Date value) {
            addCriterion("DELIVERY_TIME <>", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeGreaterThan(Date value) {
            addCriterion("DELIVERY_TIME >", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("DELIVERY_TIME >=", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeLessThan(Date value) {
            addCriterion("DELIVERY_TIME <", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeLessThanOrEqualTo(Date value) {
            addCriterion("DELIVERY_TIME <=", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIn(List<Date> values) {
            addCriterion("DELIVERY_TIME in", values, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotIn(List<Date> values) {
            addCriterion("DELIVERY_TIME not in", values, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeBetween(Date value1, Date value2) {
            addCriterion("DELIVERY_TIME between", value1, value2, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotBetween(Date value1, Date value2) {
            addCriterion("DELIVERY_TIME not between", value1, value2, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressIsNull() {
            addCriterion("DELIVERY_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressIsNotNull() {
            addCriterion("DELIVERY_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressEqualTo(String value) {
            addCriterion("DELIVERY_ADDRESS =", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressNotEqualTo(String value) {
            addCriterion("DELIVERY_ADDRESS <>", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressGreaterThan(String value) {
            addCriterion("DELIVERY_ADDRESS >", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressGreaterThanOrEqualTo(String value) {
            addCriterion("DELIVERY_ADDRESS >=", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressLessThan(String value) {
            addCriterion("DELIVERY_ADDRESS <", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressLessThanOrEqualTo(String value) {
            addCriterion("DELIVERY_ADDRESS <=", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressLike(String value) {
            addCriterion("DELIVERY_ADDRESS like", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressNotLike(String value) {
            addCriterion("DELIVERY_ADDRESS not like", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressIn(List<String> values) {
            addCriterion("DELIVERY_ADDRESS in", values, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressNotIn(List<String> values) {
            addCriterion("DELIVERY_ADDRESS not in", values, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressBetween(String value1, String value2) {
            addCriterion("DELIVERY_ADDRESS between", value1, value2, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressNotBetween(String value1, String value2) {
            addCriterion("DELIVERY_ADDRESS not between", value1, value2, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryModeIsNull() {
            addCriterion("DELIVERY_MODE is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryModeIsNotNull() {
            addCriterion("DELIVERY_MODE is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryModeEqualTo(String value) {
            addCriterion("DELIVERY_MODE =", value, "deliveryMode");
            return (Criteria) this;
        }

        public Criteria andDeliveryModeNotEqualTo(String value) {
            addCriterion("DELIVERY_MODE <>", value, "deliveryMode");
            return (Criteria) this;
        }

        public Criteria andDeliveryModeGreaterThan(String value) {
            addCriterion("DELIVERY_MODE >", value, "deliveryMode");
            return (Criteria) this;
        }

        public Criteria andDeliveryModeGreaterThanOrEqualTo(String value) {
            addCriterion("DELIVERY_MODE >=", value, "deliveryMode");
            return (Criteria) this;
        }

        public Criteria andDeliveryModeLessThan(String value) {
            addCriterion("DELIVERY_MODE <", value, "deliveryMode");
            return (Criteria) this;
        }

        public Criteria andDeliveryModeLessThanOrEqualTo(String value) {
            addCriterion("DELIVERY_MODE <=", value, "deliveryMode");
            return (Criteria) this;
        }

        public Criteria andDeliveryModeLike(String value) {
            addCriterion("DELIVERY_MODE like", value, "deliveryMode");
            return (Criteria) this;
        }

        public Criteria andDeliveryModeNotLike(String value) {
            addCriterion("DELIVERY_MODE not like", value, "deliveryMode");
            return (Criteria) this;
        }

        public Criteria andDeliveryModeIn(List<String> values) {
            addCriterion("DELIVERY_MODE in", values, "deliveryMode");
            return (Criteria) this;
        }

        public Criteria andDeliveryModeNotIn(List<String> values) {
            addCriterion("DELIVERY_MODE not in", values, "deliveryMode");
            return (Criteria) this;
        }

        public Criteria andDeliveryModeBetween(String value1, String value2) {
            addCriterion("DELIVERY_MODE between", value1, value2, "deliveryMode");
            return (Criteria) this;
        }

        public Criteria andDeliveryModeNotBetween(String value1, String value2) {
            addCriterion("DELIVERY_MODE not between", value1, value2, "deliveryMode");
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

        public Criteria andRemarksInfoIsNull() {
            addCriterion("REMARKS_INFO is null");
            return (Criteria) this;
        }

        public Criteria andRemarksInfoIsNotNull() {
            addCriterion("REMARKS_INFO is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksInfoEqualTo(String value) {
            addCriterion("REMARKS_INFO =", value, "remarksInfo");
            return (Criteria) this;
        }

        public Criteria andRemarksInfoNotEqualTo(String value) {
            addCriterion("REMARKS_INFO <>", value, "remarksInfo");
            return (Criteria) this;
        }

        public Criteria andRemarksInfoGreaterThan(String value) {
            addCriterion("REMARKS_INFO >", value, "remarksInfo");
            return (Criteria) this;
        }

        public Criteria andRemarksInfoGreaterThanOrEqualTo(String value) {
            addCriterion("REMARKS_INFO >=", value, "remarksInfo");
            return (Criteria) this;
        }

        public Criteria andRemarksInfoLessThan(String value) {
            addCriterion("REMARKS_INFO <", value, "remarksInfo");
            return (Criteria) this;
        }

        public Criteria andRemarksInfoLessThanOrEqualTo(String value) {
            addCriterion("REMARKS_INFO <=", value, "remarksInfo");
            return (Criteria) this;
        }

        public Criteria andRemarksInfoLike(String value) {
            addCriterion("REMARKS_INFO like", value, "remarksInfo");
            return (Criteria) this;
        }

        public Criteria andRemarksInfoNotLike(String value) {
            addCriterion("REMARKS_INFO not like", value, "remarksInfo");
            return (Criteria) this;
        }

        public Criteria andRemarksInfoIn(List<String> values) {
            addCriterion("REMARKS_INFO in", values, "remarksInfo");
            return (Criteria) this;
        }

        public Criteria andRemarksInfoNotIn(List<String> values) {
            addCriterion("REMARKS_INFO not in", values, "remarksInfo");
            return (Criteria) this;
        }

        public Criteria andRemarksInfoBetween(String value1, String value2) {
            addCriterion("REMARKS_INFO between", value1, value2, "remarksInfo");
            return (Criteria) this;
        }

        public Criteria andRemarksInfoNotBetween(String value1, String value2) {
            addCriterion("REMARKS_INFO not between", value1, value2, "remarksInfo");
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