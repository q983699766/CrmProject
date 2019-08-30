package com.sc.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SalCustomInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SalCustomInfoExample() {
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

        public Criteria andCustomIdIsNull() {
            addCriterion("CUSTOM_ID is null");
            return (Criteria) this;
        }

        public Criteria andCustomIdIsNotNull() {
            addCriterion("CUSTOM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCustomIdEqualTo(Long value) {
            addCriterion("CUSTOM_ID =", value, "customId");
            return (Criteria) this;
        }

        public Criteria andCustomIdNotEqualTo(Long value) {
            addCriterion("CUSTOM_ID <>", value, "customId");
            return (Criteria) this;
        }

        public Criteria andCustomIdGreaterThan(Long value) {
            addCriterion("CUSTOM_ID >", value, "customId");
            return (Criteria) this;
        }

        public Criteria andCustomIdGreaterThanOrEqualTo(Long value) {
            addCriterion("CUSTOM_ID >=", value, "customId");
            return (Criteria) this;
        }

        public Criteria andCustomIdLessThan(Long value) {
            addCriterion("CUSTOM_ID <", value, "customId");
            return (Criteria) this;
        }

        public Criteria andCustomIdLessThanOrEqualTo(Long value) {
            addCriterion("CUSTOM_ID <=", value, "customId");
            return (Criteria) this;
        }

        public Criteria andCustomIdIn(List<Long> values) {
            addCriterion("CUSTOM_ID in", values, "customId");
            return (Criteria) this;
        }

        public Criteria andCustomIdNotIn(List<Long> values) {
            addCriterion("CUSTOM_ID not in", values, "customId");
            return (Criteria) this;
        }

        public Criteria andCustomIdBetween(Long value1, Long value2) {
            addCriterion("CUSTOM_ID between", value1, value2, "customId");
            return (Criteria) this;
        }

        public Criteria andCustomIdNotBetween(Long value1, Long value2) {
            addCriterion("CUSTOM_ID not between", value1, value2, "customId");
            return (Criteria) this;
        }

        public Criteria andCustomNameIsNull() {
            addCriterion("CUSTOM_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCustomNameIsNotNull() {
            addCriterion("CUSTOM_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCustomNameEqualTo(String value) {
            addCriterion("CUSTOM_NAME =", value, "customName");
            return (Criteria) this;
        }

        public Criteria andCustomNameNotEqualTo(String value) {
            addCriterion("CUSTOM_NAME <>", value, "customName");
            return (Criteria) this;
        }

        public Criteria andCustomNameGreaterThan(String value) {
            addCriterion("CUSTOM_NAME >", value, "customName");
            return (Criteria) this;
        }

        public Criteria andCustomNameGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTOM_NAME >=", value, "customName");
            return (Criteria) this;
        }

        public Criteria andCustomNameLessThan(String value) {
            addCriterion("CUSTOM_NAME <", value, "customName");
            return (Criteria) this;
        }

        public Criteria andCustomNameLessThanOrEqualTo(String value) {
            addCriterion("CUSTOM_NAME <=", value, "customName");
            return (Criteria) this;
        }

        public Criteria andCustomNameLike(String value) {
            addCriterion("CUSTOM_NAME like", value, "customName");
            return (Criteria) this;
        }

        public Criteria andCustomNameNotLike(String value) {
            addCriterion("CUSTOM_NAME not like", value, "customName");
            return (Criteria) this;
        }

        public Criteria andCustomNameIn(List<String> values) {
            addCriterion("CUSTOM_NAME in", values, "customName");
            return (Criteria) this;
        }

        public Criteria andCustomNameNotIn(List<String> values) {
            addCriterion("CUSTOM_NAME not in", values, "customName");
            return (Criteria) this;
        }

        public Criteria andCustomNameBetween(String value1, String value2) {
            addCriterion("CUSTOM_NAME between", value1, value2, "customName");
            return (Criteria) this;
        }

        public Criteria andCustomNameNotBetween(String value1, String value2) {
            addCriterion("CUSTOM_NAME not between", value1, value2, "customName");
            return (Criteria) this;
        }

        public Criteria andCustomPropertiesIsNull() {
            addCriterion("CUSTOM_PROPERTIES is null");
            return (Criteria) this;
        }

        public Criteria andCustomPropertiesIsNotNull() {
            addCriterion("CUSTOM_PROPERTIES is not null");
            return (Criteria) this;
        }

        public Criteria andCustomPropertiesEqualTo(String value) {
            addCriterion("CUSTOM_PROPERTIES =", value, "customProperties");
            return (Criteria) this;
        }

        public Criteria andCustomPropertiesNotEqualTo(String value) {
            addCriterion("CUSTOM_PROPERTIES <>", value, "customProperties");
            return (Criteria) this;
        }

        public Criteria andCustomPropertiesGreaterThan(String value) {
            addCriterion("CUSTOM_PROPERTIES >", value, "customProperties");
            return (Criteria) this;
        }

        public Criteria andCustomPropertiesGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTOM_PROPERTIES >=", value, "customProperties");
            return (Criteria) this;
        }

        public Criteria andCustomPropertiesLessThan(String value) {
            addCriterion("CUSTOM_PROPERTIES <", value, "customProperties");
            return (Criteria) this;
        }

        public Criteria andCustomPropertiesLessThanOrEqualTo(String value) {
            addCriterion("CUSTOM_PROPERTIES <=", value, "customProperties");
            return (Criteria) this;
        }

        public Criteria andCustomPropertiesLike(String value) {
            addCriterion("CUSTOM_PROPERTIES like", value, "customProperties");
            return (Criteria) this;
        }

        public Criteria andCustomPropertiesNotLike(String value) {
            addCriterion("CUSTOM_PROPERTIES not like", value, "customProperties");
            return (Criteria) this;
        }

        public Criteria andCustomPropertiesIn(List<String> values) {
            addCriterion("CUSTOM_PROPERTIES in", values, "customProperties");
            return (Criteria) this;
        }

        public Criteria andCustomPropertiesNotIn(List<String> values) {
            addCriterion("CUSTOM_PROPERTIES not in", values, "customProperties");
            return (Criteria) this;
        }

        public Criteria andCustomPropertiesBetween(String value1, String value2) {
            addCriterion("CUSTOM_PROPERTIES between", value1, value2, "customProperties");
            return (Criteria) this;
        }

        public Criteria andCustomPropertiesNotBetween(String value1, String value2) {
            addCriterion("CUSTOM_PROPERTIES not between", value1, value2, "customProperties");
            return (Criteria) this;
        }

        public Criteria andWebsiteIsNull() {
            addCriterion("WEBSITE is null");
            return (Criteria) this;
        }

        public Criteria andWebsiteIsNotNull() {
            addCriterion("WEBSITE is not null");
            return (Criteria) this;
        }

        public Criteria andWebsiteEqualTo(String value) {
            addCriterion("WEBSITE =", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotEqualTo(String value) {
            addCriterion("WEBSITE <>", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteGreaterThan(String value) {
            addCriterion("WEBSITE >", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteGreaterThanOrEqualTo(String value) {
            addCriterion("WEBSITE >=", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLessThan(String value) {
            addCriterion("WEBSITE <", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLessThanOrEqualTo(String value) {
            addCriterion("WEBSITE <=", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLike(String value) {
            addCriterion("WEBSITE like", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotLike(String value) {
            addCriterion("WEBSITE not like", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteIn(List<String> values) {
            addCriterion("WEBSITE in", values, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotIn(List<String> values) {
            addCriterion("WEBSITE not in", values, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteBetween(String value1, String value2) {
            addCriterion("WEBSITE between", value1, value2, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotBetween(String value1, String value2) {
            addCriterion("WEBSITE not between", value1, value2, "website");
            return (Criteria) this;
        }

        public Criteria andTicketCodeIsNull() {
            addCriterion("TICKET_CODE is null");
            return (Criteria) this;
        }

        public Criteria andTicketCodeIsNotNull() {
            addCriterion("TICKET_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andTicketCodeEqualTo(String value) {
            addCriterion("TICKET_CODE =", value, "ticketCode");
            return (Criteria) this;
        }

        public Criteria andTicketCodeNotEqualTo(String value) {
            addCriterion("TICKET_CODE <>", value, "ticketCode");
            return (Criteria) this;
        }

        public Criteria andTicketCodeGreaterThan(String value) {
            addCriterion("TICKET_CODE >", value, "ticketCode");
            return (Criteria) this;
        }

        public Criteria andTicketCodeGreaterThanOrEqualTo(String value) {
            addCriterion("TICKET_CODE >=", value, "ticketCode");
            return (Criteria) this;
        }

        public Criteria andTicketCodeLessThan(String value) {
            addCriterion("TICKET_CODE <", value, "ticketCode");
            return (Criteria) this;
        }

        public Criteria andTicketCodeLessThanOrEqualTo(String value) {
            addCriterion("TICKET_CODE <=", value, "ticketCode");
            return (Criteria) this;
        }

        public Criteria andTicketCodeLike(String value) {
            addCriterion("TICKET_CODE like", value, "ticketCode");
            return (Criteria) this;
        }

        public Criteria andTicketCodeNotLike(String value) {
            addCriterion("TICKET_CODE not like", value, "ticketCode");
            return (Criteria) this;
        }

        public Criteria andTicketCodeIn(List<String> values) {
            addCriterion("TICKET_CODE in", values, "ticketCode");
            return (Criteria) this;
        }

        public Criteria andTicketCodeNotIn(List<String> values) {
            addCriterion("TICKET_CODE not in", values, "ticketCode");
            return (Criteria) this;
        }

        public Criteria andTicketCodeBetween(String value1, String value2) {
            addCriterion("TICKET_CODE between", value1, value2, "ticketCode");
            return (Criteria) this;
        }

        public Criteria andTicketCodeNotBetween(String value1, String value2) {
            addCriterion("TICKET_CODE not between", value1, value2, "ticketCode");
            return (Criteria) this;
        }

        public Criteria andSuperiorUnitsIsNull() {
            addCriterion("SUPERIOR_UNITS is null");
            return (Criteria) this;
        }

        public Criteria andSuperiorUnitsIsNotNull() {
            addCriterion("SUPERIOR_UNITS is not null");
            return (Criteria) this;
        }

        public Criteria andSuperiorUnitsEqualTo(String value) {
            addCriterion("SUPERIOR_UNITS =", value, "superiorUnits");
            return (Criteria) this;
        }

        public Criteria andSuperiorUnitsNotEqualTo(String value) {
            addCriterion("SUPERIOR_UNITS <>", value, "superiorUnits");
            return (Criteria) this;
        }

        public Criteria andSuperiorUnitsGreaterThan(String value) {
            addCriterion("SUPERIOR_UNITS >", value, "superiorUnits");
            return (Criteria) this;
        }

        public Criteria andSuperiorUnitsGreaterThanOrEqualTo(String value) {
            addCriterion("SUPERIOR_UNITS >=", value, "superiorUnits");
            return (Criteria) this;
        }

        public Criteria andSuperiorUnitsLessThan(String value) {
            addCriterion("SUPERIOR_UNITS <", value, "superiorUnits");
            return (Criteria) this;
        }

        public Criteria andSuperiorUnitsLessThanOrEqualTo(String value) {
            addCriterion("SUPERIOR_UNITS <=", value, "superiorUnits");
            return (Criteria) this;
        }

        public Criteria andSuperiorUnitsLike(String value) {
            addCriterion("SUPERIOR_UNITS like", value, "superiorUnits");
            return (Criteria) this;
        }

        public Criteria andSuperiorUnitsNotLike(String value) {
            addCriterion("SUPERIOR_UNITS not like", value, "superiorUnits");
            return (Criteria) this;
        }

        public Criteria andSuperiorUnitsIn(List<String> values) {
            addCriterion("SUPERIOR_UNITS in", values, "superiorUnits");
            return (Criteria) this;
        }

        public Criteria andSuperiorUnitsNotIn(List<String> values) {
            addCriterion("SUPERIOR_UNITS not in", values, "superiorUnits");
            return (Criteria) this;
        }

        public Criteria andSuperiorUnitsBetween(String value1, String value2) {
            addCriterion("SUPERIOR_UNITS between", value1, value2, "superiorUnits");
            return (Criteria) this;
        }

        public Criteria andSuperiorUnitsNotBetween(String value1, String value2) {
            addCriterion("SUPERIOR_UNITS not between", value1, value2, "superiorUnits");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNull() {
            addCriterion("OWNER is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNotNull() {
            addCriterion("OWNER is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerEqualTo(String value) {
            addCriterion("OWNER =", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotEqualTo(String value) {
            addCriterion("OWNER <>", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThan(String value) {
            addCriterion("OWNER >", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("OWNER >=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThan(String value) {
            addCriterion("OWNER <", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThanOrEqualTo(String value) {
            addCriterion("OWNER <=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLike(String value) {
            addCriterion("OWNER like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotLike(String value) {
            addCriterion("OWNER not like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerIn(List<String> values) {
            addCriterion("OWNER in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotIn(List<String> values) {
            addCriterion("OWNER not in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerBetween(String value1, String value2) {
            addCriterion("OWNER between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotBetween(String value1, String value2) {
            addCriterion("OWNER not between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andStaffIsNull() {
            addCriterion("STAFF is null");
            return (Criteria) this;
        }

        public Criteria andStaffIsNotNull() {
            addCriterion("STAFF is not null");
            return (Criteria) this;
        }

        public Criteria andStaffEqualTo(Long value) {
            addCriterion("STAFF =", value, "staff");
            return (Criteria) this;
        }

        public Criteria andStaffNotEqualTo(Long value) {
            addCriterion("STAFF <>", value, "staff");
            return (Criteria) this;
        }

        public Criteria andStaffGreaterThan(Long value) {
            addCriterion("STAFF >", value, "staff");
            return (Criteria) this;
        }

        public Criteria andStaffGreaterThanOrEqualTo(Long value) {
            addCriterion("STAFF >=", value, "staff");
            return (Criteria) this;
        }

        public Criteria andStaffLessThan(Long value) {
            addCriterion("STAFF <", value, "staff");
            return (Criteria) this;
        }

        public Criteria andStaffLessThanOrEqualTo(Long value) {
            addCriterion("STAFF <=", value, "staff");
            return (Criteria) this;
        }

        public Criteria andStaffIn(List<Long> values) {
            addCriterion("STAFF in", values, "staff");
            return (Criteria) this;
        }

        public Criteria andStaffNotIn(List<Long> values) {
            addCriterion("STAFF not in", values, "staff");
            return (Criteria) this;
        }

        public Criteria andStaffBetween(Long value1, Long value2) {
            addCriterion("STAFF between", value1, value2, "staff");
            return (Criteria) this;
        }

        public Criteria andStaffNotBetween(Long value1, Long value2) {
            addCriterion("STAFF not between", value1, value2, "staff");
            return (Criteria) this;
        }

        public Criteria andTradeNumberIsNull() {
            addCriterion("TRADE_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andTradeNumberIsNotNull() {
            addCriterion("TRADE_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andTradeNumberEqualTo(String value) {
            addCriterion("TRADE_NUMBER =", value, "tradeNumber");
            return (Criteria) this;
        }

        public Criteria andTradeNumberNotEqualTo(String value) {
            addCriterion("TRADE_NUMBER <>", value, "tradeNumber");
            return (Criteria) this;
        }

        public Criteria andTradeNumberGreaterThan(String value) {
            addCriterion("TRADE_NUMBER >", value, "tradeNumber");
            return (Criteria) this;
        }

        public Criteria andTradeNumberGreaterThanOrEqualTo(String value) {
            addCriterion("TRADE_NUMBER >=", value, "tradeNumber");
            return (Criteria) this;
        }

        public Criteria andTradeNumberLessThan(String value) {
            addCriterion("TRADE_NUMBER <", value, "tradeNumber");
            return (Criteria) this;
        }

        public Criteria andTradeNumberLessThanOrEqualTo(String value) {
            addCriterion("TRADE_NUMBER <=", value, "tradeNumber");
            return (Criteria) this;
        }

        public Criteria andTradeNumberLike(String value) {
            addCriterion("TRADE_NUMBER like", value, "tradeNumber");
            return (Criteria) this;
        }

        public Criteria andTradeNumberNotLike(String value) {
            addCriterion("TRADE_NUMBER not like", value, "tradeNumber");
            return (Criteria) this;
        }

        public Criteria andTradeNumberIn(List<String> values) {
            addCriterion("TRADE_NUMBER in", values, "tradeNumber");
            return (Criteria) this;
        }

        public Criteria andTradeNumberNotIn(List<String> values) {
            addCriterion("TRADE_NUMBER not in", values, "tradeNumber");
            return (Criteria) this;
        }

        public Criteria andTradeNumberBetween(String value1, String value2) {
            addCriterion("TRADE_NUMBER between", value1, value2, "tradeNumber");
            return (Criteria) this;
        }

        public Criteria andTradeNumberNotBetween(String value1, String value2) {
            addCriterion("TRADE_NUMBER not between", value1, value2, "tradeNumber");
            return (Criteria) this;
        }

        public Criteria andCustomTypeIsNull() {
            addCriterion("CUSTOM_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCustomTypeIsNotNull() {
            addCriterion("CUSTOM_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCustomTypeEqualTo(String value) {
            addCriterion("CUSTOM_TYPE =", value, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeNotEqualTo(String value) {
            addCriterion("CUSTOM_TYPE <>", value, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeGreaterThan(String value) {
            addCriterion("CUSTOM_TYPE >", value, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTOM_TYPE >=", value, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeLessThan(String value) {
            addCriterion("CUSTOM_TYPE <", value, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeLessThanOrEqualTo(String value) {
            addCriterion("CUSTOM_TYPE <=", value, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeLike(String value) {
            addCriterion("CUSTOM_TYPE like", value, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeNotLike(String value) {
            addCriterion("CUSTOM_TYPE not like", value, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeIn(List<String> values) {
            addCriterion("CUSTOM_TYPE in", values, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeNotIn(List<String> values) {
            addCriterion("CUSTOM_TYPE not in", values, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeBetween(String value1, String value2) {
            addCriterion("CUSTOM_TYPE between", value1, value2, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeNotBetween(String value1, String value2) {
            addCriterion("CUSTOM_TYPE not between", value1, value2, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomStateIsNull() {
            addCriterion("CUSTOM_STATE is null");
            return (Criteria) this;
        }

        public Criteria andCustomStateIsNotNull() {
            addCriterion("CUSTOM_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andCustomStateEqualTo(String value) {
            addCriterion("CUSTOM_STATE =", value, "customState");
            return (Criteria) this;
        }

        public Criteria andCustomStateNotEqualTo(String value) {
            addCriterion("CUSTOM_STATE <>", value, "customState");
            return (Criteria) this;
        }

        public Criteria andCustomStateGreaterThan(String value) {
            addCriterion("CUSTOM_STATE >", value, "customState");
            return (Criteria) this;
        }

        public Criteria andCustomStateGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTOM_STATE >=", value, "customState");
            return (Criteria) this;
        }

        public Criteria andCustomStateLessThan(String value) {
            addCriterion("CUSTOM_STATE <", value, "customState");
            return (Criteria) this;
        }

        public Criteria andCustomStateLessThanOrEqualTo(String value) {
            addCriterion("CUSTOM_STATE <=", value, "customState");
            return (Criteria) this;
        }

        public Criteria andCustomStateLike(String value) {
            addCriterion("CUSTOM_STATE like", value, "customState");
            return (Criteria) this;
        }

        public Criteria andCustomStateNotLike(String value) {
            addCriterion("CUSTOM_STATE not like", value, "customState");
            return (Criteria) this;
        }

        public Criteria andCustomStateIn(List<String> values) {
            addCriterion("CUSTOM_STATE in", values, "customState");
            return (Criteria) this;
        }

        public Criteria andCustomStateNotIn(List<String> values) {
            addCriterion("CUSTOM_STATE not in", values, "customState");
            return (Criteria) this;
        }

        public Criteria andCustomStateBetween(String value1, String value2) {
            addCriterion("CUSTOM_STATE between", value1, value2, "customState");
            return (Criteria) this;
        }

        public Criteria andCustomStateNotBetween(String value1, String value2) {
            addCriterion("CUSTOM_STATE not between", value1, value2, "customState");
            return (Criteria) this;
        }

        public Criteria andCustomSourceIsNull() {
            addCriterion("CUSTOM_SOURCE is null");
            return (Criteria) this;
        }

        public Criteria andCustomSourceIsNotNull() {
            addCriterion("CUSTOM_SOURCE is not null");
            return (Criteria) this;
        }

        public Criteria andCustomSourceEqualTo(String value) {
            addCriterion("CUSTOM_SOURCE =", value, "customSource");
            return (Criteria) this;
        }

        public Criteria andCustomSourceNotEqualTo(String value) {
            addCriterion("CUSTOM_SOURCE <>", value, "customSource");
            return (Criteria) this;
        }

        public Criteria andCustomSourceGreaterThan(String value) {
            addCriterion("CUSTOM_SOURCE >", value, "customSource");
            return (Criteria) this;
        }

        public Criteria andCustomSourceGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTOM_SOURCE >=", value, "customSource");
            return (Criteria) this;
        }

        public Criteria andCustomSourceLessThan(String value) {
            addCriterion("CUSTOM_SOURCE <", value, "customSource");
            return (Criteria) this;
        }

        public Criteria andCustomSourceLessThanOrEqualTo(String value) {
            addCriterion("CUSTOM_SOURCE <=", value, "customSource");
            return (Criteria) this;
        }

        public Criteria andCustomSourceLike(String value) {
            addCriterion("CUSTOM_SOURCE like", value, "customSource");
            return (Criteria) this;
        }

        public Criteria andCustomSourceNotLike(String value) {
            addCriterion("CUSTOM_SOURCE not like", value, "customSource");
            return (Criteria) this;
        }

        public Criteria andCustomSourceIn(List<String> values) {
            addCriterion("CUSTOM_SOURCE in", values, "customSource");
            return (Criteria) this;
        }

        public Criteria andCustomSourceNotIn(List<String> values) {
            addCriterion("CUSTOM_SOURCE not in", values, "customSource");
            return (Criteria) this;
        }

        public Criteria andCustomSourceBetween(String value1, String value2) {
            addCriterion("CUSTOM_SOURCE between", value1, value2, "customSource");
            return (Criteria) this;
        }

        public Criteria andCustomSourceNotBetween(String value1, String value2) {
            addCriterion("CUSTOM_SOURCE not between", value1, value2, "customSource");
            return (Criteria) this;
        }

        public Criteria andHeadIdIsNull() {
            addCriterion("HEAD_ID is null");
            return (Criteria) this;
        }

        public Criteria andHeadIdIsNotNull() {
            addCriterion("HEAD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andHeadIdEqualTo(Long value) {
            addCriterion("HEAD_ID =", value, "headId");
            return (Criteria) this;
        }

        public Criteria andHeadIdNotEqualTo(Long value) {
            addCriterion("HEAD_ID <>", value, "headId");
            return (Criteria) this;
        }

        public Criteria andHeadIdGreaterThan(Long value) {
            addCriterion("HEAD_ID >", value, "headId");
            return (Criteria) this;
        }

        public Criteria andHeadIdGreaterThanOrEqualTo(Long value) {
            addCriterion("HEAD_ID >=", value, "headId");
            return (Criteria) this;
        }

        public Criteria andHeadIdLessThan(Long value) {
            addCriterion("HEAD_ID <", value, "headId");
            return (Criteria) this;
        }

        public Criteria andHeadIdLessThanOrEqualTo(Long value) {
            addCriterion("HEAD_ID <=", value, "headId");
            return (Criteria) this;
        }

        public Criteria andHeadIdIn(List<Long> values) {
            addCriterion("HEAD_ID in", values, "headId");
            return (Criteria) this;
        }

        public Criteria andHeadIdNotIn(List<Long> values) {
            addCriterion("HEAD_ID not in", values, "headId");
            return (Criteria) this;
        }

        public Criteria andHeadIdBetween(Long value1, Long value2) {
            addCriterion("HEAD_ID between", value1, value2, "headId");
            return (Criteria) this;
        }

        public Criteria andHeadIdNotBetween(Long value1, Long value2) {
            addCriterion("HEAD_ID not between", value1, value2, "headId");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneIsNull() {
            addCriterion("FIXED_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneIsNotNull() {
            addCriterion("FIXED_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneEqualTo(String value) {
            addCriterion("FIXED_PHONE =", value, "fixedPhone");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneNotEqualTo(String value) {
            addCriterion("FIXED_PHONE <>", value, "fixedPhone");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneGreaterThan(String value) {
            addCriterion("FIXED_PHONE >", value, "fixedPhone");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("FIXED_PHONE >=", value, "fixedPhone");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneLessThan(String value) {
            addCriterion("FIXED_PHONE <", value, "fixedPhone");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneLessThanOrEqualTo(String value) {
            addCriterion("FIXED_PHONE <=", value, "fixedPhone");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneLike(String value) {
            addCriterion("FIXED_PHONE like", value, "fixedPhone");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneNotLike(String value) {
            addCriterion("FIXED_PHONE not like", value, "fixedPhone");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneIn(List<String> values) {
            addCriterion("FIXED_PHONE in", values, "fixedPhone");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneNotIn(List<String> values) {
            addCriterion("FIXED_PHONE not in", values, "fixedPhone");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneBetween(String value1, String value2) {
            addCriterion("FIXED_PHONE between", value1, value2, "fixedPhone");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneNotBetween(String value1, String value2) {
            addCriterion("FIXED_PHONE not between", value1, value2, "fixedPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneIsNull() {
            addCriterion("CELL_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andCellPhoneIsNotNull() {
            addCriterion("CELL_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andCellPhoneEqualTo(String value) {
            addCriterion("CELL_PHONE =", value, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneNotEqualTo(String value) {
            addCriterion("CELL_PHONE <>", value, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneGreaterThan(String value) {
            addCriterion("CELL_PHONE >", value, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("CELL_PHONE >=", value, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneLessThan(String value) {
            addCriterion("CELL_PHONE <", value, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneLessThanOrEqualTo(String value) {
            addCriterion("CELL_PHONE <=", value, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneLike(String value) {
            addCriterion("CELL_PHONE like", value, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneNotLike(String value) {
            addCriterion("CELL_PHONE not like", value, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneIn(List<String> values) {
            addCriterion("CELL_PHONE in", values, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneNotIn(List<String> values) {
            addCriterion("CELL_PHONE not in", values, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneBetween(String value1, String value2) {
            addCriterion("CELL_PHONE between", value1, value2, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneNotBetween(String value1, String value2) {
            addCriterion("CELL_PHONE not between", value1, value2, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCustomFaxIsNull() {
            addCriterion("CUSTOM_FAX is null");
            return (Criteria) this;
        }

        public Criteria andCustomFaxIsNotNull() {
            addCriterion("CUSTOM_FAX is not null");
            return (Criteria) this;
        }

        public Criteria andCustomFaxEqualTo(String value) {
            addCriterion("CUSTOM_FAX =", value, "customFax");
            return (Criteria) this;
        }

        public Criteria andCustomFaxNotEqualTo(String value) {
            addCriterion("CUSTOM_FAX <>", value, "customFax");
            return (Criteria) this;
        }

        public Criteria andCustomFaxGreaterThan(String value) {
            addCriterion("CUSTOM_FAX >", value, "customFax");
            return (Criteria) this;
        }

        public Criteria andCustomFaxGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTOM_FAX >=", value, "customFax");
            return (Criteria) this;
        }

        public Criteria andCustomFaxLessThan(String value) {
            addCriterion("CUSTOM_FAX <", value, "customFax");
            return (Criteria) this;
        }

        public Criteria andCustomFaxLessThanOrEqualTo(String value) {
            addCriterion("CUSTOM_FAX <=", value, "customFax");
            return (Criteria) this;
        }

        public Criteria andCustomFaxLike(String value) {
            addCriterion("CUSTOM_FAX like", value, "customFax");
            return (Criteria) this;
        }

        public Criteria andCustomFaxNotLike(String value) {
            addCriterion("CUSTOM_FAX not like", value, "customFax");
            return (Criteria) this;
        }

        public Criteria andCustomFaxIn(List<String> values) {
            addCriterion("CUSTOM_FAX in", values, "customFax");
            return (Criteria) this;
        }

        public Criteria andCustomFaxNotIn(List<String> values) {
            addCriterion("CUSTOM_FAX not in", values, "customFax");
            return (Criteria) this;
        }

        public Criteria andCustomFaxBetween(String value1, String value2) {
            addCriterion("CUSTOM_FAX between", value1, value2, "customFax");
            return (Criteria) this;
        }

        public Criteria andCustomFaxNotBetween(String value1, String value2) {
            addCriterion("CUSTOM_FAX not between", value1, value2, "customFax");
            return (Criteria) this;
        }

        public Criteria andDepositBankIsNull() {
            addCriterion("DEPOSIT_BANK is null");
            return (Criteria) this;
        }

        public Criteria andDepositBankIsNotNull() {
            addCriterion("DEPOSIT_BANK is not null");
            return (Criteria) this;
        }

        public Criteria andDepositBankEqualTo(String value) {
            addCriterion("DEPOSIT_BANK =", value, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankNotEqualTo(String value) {
            addCriterion("DEPOSIT_BANK <>", value, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankGreaterThan(String value) {
            addCriterion("DEPOSIT_BANK >", value, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankGreaterThanOrEqualTo(String value) {
            addCriterion("DEPOSIT_BANK >=", value, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankLessThan(String value) {
            addCriterion("DEPOSIT_BANK <", value, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankLessThanOrEqualTo(String value) {
            addCriterion("DEPOSIT_BANK <=", value, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankLike(String value) {
            addCriterion("DEPOSIT_BANK like", value, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankNotLike(String value) {
            addCriterion("DEPOSIT_BANK not like", value, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankIn(List<String> values) {
            addCriterion("DEPOSIT_BANK in", values, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankNotIn(List<String> values) {
            addCriterion("DEPOSIT_BANK not in", values, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankBetween(String value1, String value2) {
            addCriterion("DEPOSIT_BANK between", value1, value2, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankNotBetween(String value1, String value2) {
            addCriterion("DEPOSIT_BANK not between", value1, value2, "depositBank");
            return (Criteria) this;
        }

        public Criteria andBankAccoutIsNull() {
            addCriterion("BANK_ACCOUT is null");
            return (Criteria) this;
        }

        public Criteria andBankAccoutIsNotNull() {
            addCriterion("BANK_ACCOUT is not null");
            return (Criteria) this;
        }

        public Criteria andBankAccoutEqualTo(BigDecimal value) {
            addCriterion("BANK_ACCOUT =", value, "bankAccout");
            return (Criteria) this;
        }

        public Criteria andBankAccoutNotEqualTo(BigDecimal value) {
            addCriterion("BANK_ACCOUT <>", value, "bankAccout");
            return (Criteria) this;
        }

        public Criteria andBankAccoutGreaterThan(BigDecimal value) {
            addCriterion("BANK_ACCOUT >", value, "bankAccout");
            return (Criteria) this;
        }

        public Criteria andBankAccoutGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BANK_ACCOUT >=", value, "bankAccout");
            return (Criteria) this;
        }

        public Criteria andBankAccoutLessThan(BigDecimal value) {
            addCriterion("BANK_ACCOUT <", value, "bankAccout");
            return (Criteria) this;
        }

        public Criteria andBankAccoutLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BANK_ACCOUT <=", value, "bankAccout");
            return (Criteria) this;
        }

        public Criteria andBankAccoutIn(List<BigDecimal> values) {
            addCriterion("BANK_ACCOUT in", values, "bankAccout");
            return (Criteria) this;
        }

        public Criteria andBankAccoutNotIn(List<BigDecimal> values) {
            addCriterion("BANK_ACCOUT not in", values, "bankAccout");
            return (Criteria) this;
        }

        public Criteria andBankAccoutBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BANK_ACCOUT between", value1, value2, "bankAccout");
            return (Criteria) this;
        }

        public Criteria andBankAccoutNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BANK_ACCOUT not between", value1, value2, "bankAccout");
            return (Criteria) this;
        }

        public Criteria andNextcontactTimeIsNull() {
            addCriterion("NEXTCONTACT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andNextcontactTimeIsNotNull() {
            addCriterion("NEXTCONTACT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andNextcontactTimeEqualTo(Date value) {
            addCriterion("NEXTCONTACT_TIME =", value, "nextcontactTime");
            return (Criteria) this;
        }

        public Criteria andNextcontactTimeNotEqualTo(Date value) {
            addCriterion("NEXTCONTACT_TIME <>", value, "nextcontactTime");
            return (Criteria) this;
        }

        public Criteria andNextcontactTimeGreaterThan(Date value) {
            addCriterion("NEXTCONTACT_TIME >", value, "nextcontactTime");
            return (Criteria) this;
        }

        public Criteria andNextcontactTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("NEXTCONTACT_TIME >=", value, "nextcontactTime");
            return (Criteria) this;
        }

        public Criteria andNextcontactTimeLessThan(Date value) {
            addCriterion("NEXTCONTACT_TIME <", value, "nextcontactTime");
            return (Criteria) this;
        }

        public Criteria andNextcontactTimeLessThanOrEqualTo(Date value) {
            addCriterion("NEXTCONTACT_TIME <=", value, "nextcontactTime");
            return (Criteria) this;
        }

        public Criteria andNextcontactTimeIn(List<Date> values) {
            addCriterion("NEXTCONTACT_TIME in", values, "nextcontactTime");
            return (Criteria) this;
        }

        public Criteria andNextcontactTimeNotIn(List<Date> values) {
            addCriterion("NEXTCONTACT_TIME not in", values, "nextcontactTime");
            return (Criteria) this;
        }

        public Criteria andNextcontactTimeBetween(Date value1, Date value2) {
            addCriterion("NEXTCONTACT_TIME between", value1, value2, "nextcontactTime");
            return (Criteria) this;
        }

        public Criteria andNextcontactTimeNotBetween(Date value1, Date value2) {
            addCriterion("NEXTCONTACT_TIME not between", value1, value2, "nextcontactTime");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("EMAIL =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("EMAIL <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("EMAIL >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("EMAIL <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("EMAIL <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("EMAIL like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("EMAIL not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("EMAIL in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("EMAIL not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("EMAIL between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("EMAIL not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andSicCodeIsNull() {
            addCriterion("SIC_CODE is null");
            return (Criteria) this;
        }

        public Criteria andSicCodeIsNotNull() {
            addCriterion("SIC_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andSicCodeEqualTo(String value) {
            addCriterion("SIC_CODE =", value, "sicCode");
            return (Criteria) this;
        }

        public Criteria andSicCodeNotEqualTo(String value) {
            addCriterion("SIC_CODE <>", value, "sicCode");
            return (Criteria) this;
        }

        public Criteria andSicCodeGreaterThan(String value) {
            addCriterion("SIC_CODE >", value, "sicCode");
            return (Criteria) this;
        }

        public Criteria andSicCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SIC_CODE >=", value, "sicCode");
            return (Criteria) this;
        }

        public Criteria andSicCodeLessThan(String value) {
            addCriterion("SIC_CODE <", value, "sicCode");
            return (Criteria) this;
        }

        public Criteria andSicCodeLessThanOrEqualTo(String value) {
            addCriterion("SIC_CODE <=", value, "sicCode");
            return (Criteria) this;
        }

        public Criteria andSicCodeLike(String value) {
            addCriterion("SIC_CODE like", value, "sicCode");
            return (Criteria) this;
        }

        public Criteria andSicCodeNotLike(String value) {
            addCriterion("SIC_CODE not like", value, "sicCode");
            return (Criteria) this;
        }

        public Criteria andSicCodeIn(List<String> values) {
            addCriterion("SIC_CODE in", values, "sicCode");
            return (Criteria) this;
        }

        public Criteria andSicCodeNotIn(List<String> values) {
            addCriterion("SIC_CODE not in", values, "sicCode");
            return (Criteria) this;
        }

        public Criteria andSicCodeBetween(String value1, String value2) {
            addCriterion("SIC_CODE between", value1, value2, "sicCode");
            return (Criteria) this;
        }

        public Criteria andSicCodeNotBetween(String value1, String value2) {
            addCriterion("SIC_CODE not between", value1, value2, "sicCode");
            return (Criteria) this;
        }

        public Criteria andPayWayIsNull() {
            addCriterion("PAY_WAY is null");
            return (Criteria) this;
        }

        public Criteria andPayWayIsNotNull() {
            addCriterion("PAY_WAY is not null");
            return (Criteria) this;
        }

        public Criteria andPayWayEqualTo(String value) {
            addCriterion("PAY_WAY =", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayNotEqualTo(String value) {
            addCriterion("PAY_WAY <>", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayGreaterThan(String value) {
            addCriterion("PAY_WAY >", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_WAY >=", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayLessThan(String value) {
            addCriterion("PAY_WAY <", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayLessThanOrEqualTo(String value) {
            addCriterion("PAY_WAY <=", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayLike(String value) {
            addCriterion("PAY_WAY like", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayNotLike(String value) {
            addCriterion("PAY_WAY not like", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayIn(List<String> values) {
            addCriterion("PAY_WAY in", values, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayNotIn(List<String> values) {
            addCriterion("PAY_WAY not in", values, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayBetween(String value1, String value2) {
            addCriterion("PAY_WAY between", value1, value2, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayNotBetween(String value1, String value2) {
            addCriterion("PAY_WAY not between", value1, value2, "payWay");
            return (Criteria) this;
        }

        public Criteria andEffectivityIsNull() {
            addCriterion("EFFECTIVITY is null");
            return (Criteria) this;
        }

        public Criteria andEffectivityIsNotNull() {
            addCriterion("EFFECTIVITY is not null");
            return (Criteria) this;
        }

        public Criteria andEffectivityEqualTo(String value) {
            addCriterion("EFFECTIVITY =", value, "effectivity");
            return (Criteria) this;
        }

        public Criteria andEffectivityNotEqualTo(String value) {
            addCriterion("EFFECTIVITY <>", value, "effectivity");
            return (Criteria) this;
        }

        public Criteria andEffectivityGreaterThan(String value) {
            addCriterion("EFFECTIVITY >", value, "effectivity");
            return (Criteria) this;
        }

        public Criteria andEffectivityGreaterThanOrEqualTo(String value) {
            addCriterion("EFFECTIVITY >=", value, "effectivity");
            return (Criteria) this;
        }

        public Criteria andEffectivityLessThan(String value) {
            addCriterion("EFFECTIVITY <", value, "effectivity");
            return (Criteria) this;
        }

        public Criteria andEffectivityLessThanOrEqualTo(String value) {
            addCriterion("EFFECTIVITY <=", value, "effectivity");
            return (Criteria) this;
        }

        public Criteria andEffectivityLike(String value) {
            addCriterion("EFFECTIVITY like", value, "effectivity");
            return (Criteria) this;
        }

        public Criteria andEffectivityNotLike(String value) {
            addCriterion("EFFECTIVITY not like", value, "effectivity");
            return (Criteria) this;
        }

        public Criteria andEffectivityIn(List<String> values) {
            addCriterion("EFFECTIVITY in", values, "effectivity");
            return (Criteria) this;
        }

        public Criteria andEffectivityNotIn(List<String> values) {
            addCriterion("EFFECTIVITY not in", values, "effectivity");
            return (Criteria) this;
        }

        public Criteria andEffectivityBetween(String value1, String value2) {
            addCriterion("EFFECTIVITY between", value1, value2, "effectivity");
            return (Criteria) this;
        }

        public Criteria andEffectivityNotBetween(String value1, String value2) {
            addCriterion("EFFECTIVITY not between", value1, value2, "effectivity");
            return (Criteria) this;
        }

        public Criteria andDetailAddressIsNull() {
            addCriterion("DETAIL_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andDetailAddressIsNotNull() {
            addCriterion("DETAIL_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andDetailAddressEqualTo(String value) {
            addCriterion("DETAIL_ADDRESS =", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressNotEqualTo(String value) {
            addCriterion("DETAIL_ADDRESS <>", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressGreaterThan(String value) {
            addCriterion("DETAIL_ADDRESS >", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressGreaterThanOrEqualTo(String value) {
            addCriterion("DETAIL_ADDRESS >=", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressLessThan(String value) {
            addCriterion("DETAIL_ADDRESS <", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressLessThanOrEqualTo(String value) {
            addCriterion("DETAIL_ADDRESS <=", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressLike(String value) {
            addCriterion("DETAIL_ADDRESS like", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressNotLike(String value) {
            addCriterion("DETAIL_ADDRESS not like", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressIn(List<String> values) {
            addCriterion("DETAIL_ADDRESS in", values, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressNotIn(List<String> values) {
            addCriterion("DETAIL_ADDRESS not in", values, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressBetween(String value1, String value2) {
            addCriterion("DETAIL_ADDRESS between", value1, value2, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressNotBetween(String value1, String value2) {
            addCriterion("DETAIL_ADDRESS not between", value1, value2, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
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