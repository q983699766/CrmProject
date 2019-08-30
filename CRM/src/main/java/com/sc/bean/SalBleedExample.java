package com.sc.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SalBleedExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SalBleedExample() {
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

        public Criteria andChurnIdIsNull() {
            addCriterion("CHURN_ID is null");
            return (Criteria) this;
        }

        public Criteria andChurnIdIsNotNull() {
            addCriterion("CHURN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andChurnIdEqualTo(Long value) {
            addCriterion("CHURN_ID =", value, "churnId");
            return (Criteria) this;
        }

        public Criteria andChurnIdNotEqualTo(Long value) {
            addCriterion("CHURN_ID <>", value, "churnId");
            return (Criteria) this;
        }

        public Criteria andChurnIdGreaterThan(Long value) {
            addCriterion("CHURN_ID >", value, "churnId");
            return (Criteria) this;
        }

        public Criteria andChurnIdGreaterThanOrEqualTo(Long value) {
            addCriterion("CHURN_ID >=", value, "churnId");
            return (Criteria) this;
        }

        public Criteria andChurnIdLessThan(Long value) {
            addCriterion("CHURN_ID <", value, "churnId");
            return (Criteria) this;
        }

        public Criteria andChurnIdLessThanOrEqualTo(Long value) {
            addCriterion("CHURN_ID <=", value, "churnId");
            return (Criteria) this;
        }

        public Criteria andChurnIdIn(List<Long> values) {
            addCriterion("CHURN_ID in", values, "churnId");
            return (Criteria) this;
        }

        public Criteria andChurnIdNotIn(List<Long> values) {
            addCriterion("CHURN_ID not in", values, "churnId");
            return (Criteria) this;
        }

        public Criteria andChurnIdBetween(Long value1, Long value2) {
            addCriterion("CHURN_ID between", value1, value2, "churnId");
            return (Criteria) this;
        }

        public Criteria andChurnIdNotBetween(Long value1, Long value2) {
            addCriterion("CHURN_ID not between", value1, value2, "churnId");
            return (Criteria) this;
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

        public Criteria andProcessingModeIsNull() {
            addCriterion("PROCESSING_MODE is null");
            return (Criteria) this;
        }

        public Criteria andProcessingModeIsNotNull() {
            addCriterion("PROCESSING_MODE is not null");
            return (Criteria) this;
        }

        public Criteria andProcessingModeEqualTo(String value) {
            addCriterion("PROCESSING_MODE =", value, "processingMode");
            return (Criteria) this;
        }

        public Criteria andProcessingModeNotEqualTo(String value) {
            addCriterion("PROCESSING_MODE <>", value, "processingMode");
            return (Criteria) this;
        }

        public Criteria andProcessingModeGreaterThan(String value) {
            addCriterion("PROCESSING_MODE >", value, "processingMode");
            return (Criteria) this;
        }

        public Criteria andProcessingModeGreaterThanOrEqualTo(String value) {
            addCriterion("PROCESSING_MODE >=", value, "processingMode");
            return (Criteria) this;
        }

        public Criteria andProcessingModeLessThan(String value) {
            addCriterion("PROCESSING_MODE <", value, "processingMode");
            return (Criteria) this;
        }

        public Criteria andProcessingModeLessThanOrEqualTo(String value) {
            addCriterion("PROCESSING_MODE <=", value, "processingMode");
            return (Criteria) this;
        }

        public Criteria andProcessingModeLike(String value) {
            addCriterion("PROCESSING_MODE like", value, "processingMode");
            return (Criteria) this;
        }

        public Criteria andProcessingModeNotLike(String value) {
            addCriterion("PROCESSING_MODE not like", value, "processingMode");
            return (Criteria) this;
        }

        public Criteria andProcessingModeIn(List<String> values) {
            addCriterion("PROCESSING_MODE in", values, "processingMode");
            return (Criteria) this;
        }

        public Criteria andProcessingModeNotIn(List<String> values) {
            addCriterion("PROCESSING_MODE not in", values, "processingMode");
            return (Criteria) this;
        }

        public Criteria andProcessingModeBetween(String value1, String value2) {
            addCriterion("PROCESSING_MODE between", value1, value2, "processingMode");
            return (Criteria) this;
        }

        public Criteria andProcessingModeNotBetween(String value1, String value2) {
            addCriterion("PROCESSING_MODE not between", value1, value2, "processingMode");
            return (Criteria) this;
        }

        public Criteria andTreatmentMeasuresIsNull() {
            addCriterion("TREATMENT_MEASURES is null");
            return (Criteria) this;
        }

        public Criteria andTreatmentMeasuresIsNotNull() {
            addCriterion("TREATMENT_MEASURES is not null");
            return (Criteria) this;
        }

        public Criteria andTreatmentMeasuresEqualTo(String value) {
            addCriterion("TREATMENT_MEASURES =", value, "treatmentMeasures");
            return (Criteria) this;
        }

        public Criteria andTreatmentMeasuresNotEqualTo(String value) {
            addCriterion("TREATMENT_MEASURES <>", value, "treatmentMeasures");
            return (Criteria) this;
        }

        public Criteria andTreatmentMeasuresGreaterThan(String value) {
            addCriterion("TREATMENT_MEASURES >", value, "treatmentMeasures");
            return (Criteria) this;
        }

        public Criteria andTreatmentMeasuresGreaterThanOrEqualTo(String value) {
            addCriterion("TREATMENT_MEASURES >=", value, "treatmentMeasures");
            return (Criteria) this;
        }

        public Criteria andTreatmentMeasuresLessThan(String value) {
            addCriterion("TREATMENT_MEASURES <", value, "treatmentMeasures");
            return (Criteria) this;
        }

        public Criteria andTreatmentMeasuresLessThanOrEqualTo(String value) {
            addCriterion("TREATMENT_MEASURES <=", value, "treatmentMeasures");
            return (Criteria) this;
        }

        public Criteria andTreatmentMeasuresLike(String value) {
            addCriterion("TREATMENT_MEASURES like", value, "treatmentMeasures");
            return (Criteria) this;
        }

        public Criteria andTreatmentMeasuresNotLike(String value) {
            addCriterion("TREATMENT_MEASURES not like", value, "treatmentMeasures");
            return (Criteria) this;
        }

        public Criteria andTreatmentMeasuresIn(List<String> values) {
            addCriterion("TREATMENT_MEASURES in", values, "treatmentMeasures");
            return (Criteria) this;
        }

        public Criteria andTreatmentMeasuresNotIn(List<String> values) {
            addCriterion("TREATMENT_MEASURES not in", values, "treatmentMeasures");
            return (Criteria) this;
        }

        public Criteria andTreatmentMeasuresBetween(String value1, String value2) {
            addCriterion("TREATMENT_MEASURES between", value1, value2, "treatmentMeasures");
            return (Criteria) this;
        }

        public Criteria andTreatmentMeasuresNotBetween(String value1, String value2) {
            addCriterion("TREATMENT_MEASURES not between", value1, value2, "treatmentMeasures");
            return (Criteria) this;
        }

        public Criteria andBleedIsNull() {
            addCriterion("BLEED is null");
            return (Criteria) this;
        }

        public Criteria andBleedIsNotNull() {
            addCriterion("BLEED is not null");
            return (Criteria) this;
        }

        public Criteria andBleedEqualTo(String value) {
            addCriterion("BLEED =", value, "bleed");
            return (Criteria) this;
        }

        public Criteria andBleedNotEqualTo(String value) {
            addCriterion("BLEED <>", value, "bleed");
            return (Criteria) this;
        }

        public Criteria andBleedGreaterThan(String value) {
            addCriterion("BLEED >", value, "bleed");
            return (Criteria) this;
        }

        public Criteria andBleedGreaterThanOrEqualTo(String value) {
            addCriterion("BLEED >=", value, "bleed");
            return (Criteria) this;
        }

        public Criteria andBleedLessThan(String value) {
            addCriterion("BLEED <", value, "bleed");
            return (Criteria) this;
        }

        public Criteria andBleedLessThanOrEqualTo(String value) {
            addCriterion("BLEED <=", value, "bleed");
            return (Criteria) this;
        }

        public Criteria andBleedLike(String value) {
            addCriterion("BLEED like", value, "bleed");
            return (Criteria) this;
        }

        public Criteria andBleedNotLike(String value) {
            addCriterion("BLEED not like", value, "bleed");
            return (Criteria) this;
        }

        public Criteria andBleedIn(List<String> values) {
            addCriterion("BLEED in", values, "bleed");
            return (Criteria) this;
        }

        public Criteria andBleedNotIn(List<String> values) {
            addCriterion("BLEED not in", values, "bleed");
            return (Criteria) this;
        }

        public Criteria andBleedBetween(String value1, String value2) {
            addCriterion("BLEED between", value1, value2, "bleed");
            return (Criteria) this;
        }

        public Criteria andBleedNotBetween(String value1, String value2) {
            addCriterion("BLEED not between", value1, value2, "bleed");
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