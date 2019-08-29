package com.sc.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SalFeedbackExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SalFeedbackExample() {
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

        public Criteria andFeedbackIdIsNull() {
            addCriterion("FEEDBACK_ID is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdIsNotNull() {
            addCriterion("FEEDBACK_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdEqualTo(Long value) {
            addCriterion("FEEDBACK_ID =", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdNotEqualTo(Long value) {
            addCriterion("FEEDBACK_ID <>", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdGreaterThan(Long value) {
            addCriterion("FEEDBACK_ID >", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdGreaterThanOrEqualTo(Long value) {
            addCriterion("FEEDBACK_ID >=", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdLessThan(Long value) {
            addCriterion("FEEDBACK_ID <", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdLessThanOrEqualTo(Long value) {
            addCriterion("FEEDBACK_ID <=", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdIn(List<Long> values) {
            addCriterion("FEEDBACK_ID in", values, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdNotIn(List<Long> values) {
            addCriterion("FEEDBACK_ID not in", values, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdBetween(Long value1, Long value2) {
            addCriterion("FEEDBACK_ID between", value1, value2, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdNotBetween(Long value1, Long value2) {
            addCriterion("FEEDBACK_ID not between", value1, value2, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andPriIsNull() {
            addCriterion("PRI is null");
            return (Criteria) this;
        }

        public Criteria andPriIsNotNull() {
            addCriterion("PRI is not null");
            return (Criteria) this;
        }

        public Criteria andPriEqualTo(String value) {
            addCriterion("PRI =", value, "pri");
            return (Criteria) this;
        }

        public Criteria andPriNotEqualTo(String value) {
            addCriterion("PRI <>", value, "pri");
            return (Criteria) this;
        }

        public Criteria andPriGreaterThan(String value) {
            addCriterion("PRI >", value, "pri");
            return (Criteria) this;
        }

        public Criteria andPriGreaterThanOrEqualTo(String value) {
            addCriterion("PRI >=", value, "pri");
            return (Criteria) this;
        }

        public Criteria andPriLessThan(String value) {
            addCriterion("PRI <", value, "pri");
            return (Criteria) this;
        }

        public Criteria andPriLessThanOrEqualTo(String value) {
            addCriterion("PRI <=", value, "pri");
            return (Criteria) this;
        }

        public Criteria andPriLike(String value) {
            addCriterion("PRI like", value, "pri");
            return (Criteria) this;
        }

        public Criteria andPriNotLike(String value) {
            addCriterion("PRI not like", value, "pri");
            return (Criteria) this;
        }

        public Criteria andPriIn(List<String> values) {
            addCriterion("PRI in", values, "pri");
            return (Criteria) this;
        }

        public Criteria andPriNotIn(List<String> values) {
            addCriterion("PRI not in", values, "pri");
            return (Criteria) this;
        }

        public Criteria andPriBetween(String value1, String value2) {
            addCriterion("PRI between", value1, value2, "pri");
            return (Criteria) this;
        }

        public Criteria andPriNotBetween(String value1, String value2) {
            addCriterion("PRI not between", value1, value2, "pri");
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

        public Criteria andStatesIsNull() {
            addCriterion("STATES is null");
            return (Criteria) this;
        }

        public Criteria andStatesIsNotNull() {
            addCriterion("STATES is not null");
            return (Criteria) this;
        }

        public Criteria andStatesEqualTo(String value) {
            addCriterion("STATES =", value, "states");
            return (Criteria) this;
        }

        public Criteria andStatesNotEqualTo(String value) {
            addCriterion("STATES <>", value, "states");
            return (Criteria) this;
        }

        public Criteria andStatesGreaterThan(String value) {
            addCriterion("STATES >", value, "states");
            return (Criteria) this;
        }

        public Criteria andStatesGreaterThanOrEqualTo(String value) {
            addCriterion("STATES >=", value, "states");
            return (Criteria) this;
        }

        public Criteria andStatesLessThan(String value) {
            addCriterion("STATES <", value, "states");
            return (Criteria) this;
        }

        public Criteria andStatesLessThanOrEqualTo(String value) {
            addCriterion("STATES <=", value, "states");
            return (Criteria) this;
        }

        public Criteria andStatesLike(String value) {
            addCriterion("STATES like", value, "states");
            return (Criteria) this;
        }

        public Criteria andStatesNotLike(String value) {
            addCriterion("STATES not like", value, "states");
            return (Criteria) this;
        }

        public Criteria andStatesIn(List<String> values) {
            addCriterion("STATES in", values, "states");
            return (Criteria) this;
        }

        public Criteria andStatesNotIn(List<String> values) {
            addCriterion("STATES not in", values, "states");
            return (Criteria) this;
        }

        public Criteria andStatesBetween(String value1, String value2) {
            addCriterion("STATES between", value1, value2, "states");
            return (Criteria) this;
        }

        public Criteria andStatesNotBetween(String value1, String value2) {
            addCriterion("STATES not between", value1, value2, "states");
            return (Criteria) this;
        }

        public Criteria andFeedbackTypeIsNull() {
            addCriterion("FEEDBACK_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackTypeIsNotNull() {
            addCriterion("FEEDBACK_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackTypeEqualTo(String value) {
            addCriterion("FEEDBACK_TYPE =", value, "feedbackType");
            return (Criteria) this;
        }

        public Criteria andFeedbackTypeNotEqualTo(String value) {
            addCriterion("FEEDBACK_TYPE <>", value, "feedbackType");
            return (Criteria) this;
        }

        public Criteria andFeedbackTypeGreaterThan(String value) {
            addCriterion("FEEDBACK_TYPE >", value, "feedbackType");
            return (Criteria) this;
        }

        public Criteria andFeedbackTypeGreaterThanOrEqualTo(String value) {
            addCriterion("FEEDBACK_TYPE >=", value, "feedbackType");
            return (Criteria) this;
        }

        public Criteria andFeedbackTypeLessThan(String value) {
            addCriterion("FEEDBACK_TYPE <", value, "feedbackType");
            return (Criteria) this;
        }

        public Criteria andFeedbackTypeLessThanOrEqualTo(String value) {
            addCriterion("FEEDBACK_TYPE <=", value, "feedbackType");
            return (Criteria) this;
        }

        public Criteria andFeedbackTypeLike(String value) {
            addCriterion("FEEDBACK_TYPE like", value, "feedbackType");
            return (Criteria) this;
        }

        public Criteria andFeedbackTypeNotLike(String value) {
            addCriterion("FEEDBACK_TYPE not like", value, "feedbackType");
            return (Criteria) this;
        }

        public Criteria andFeedbackTypeIn(List<String> values) {
            addCriterion("FEEDBACK_TYPE in", values, "feedbackType");
            return (Criteria) this;
        }

        public Criteria andFeedbackTypeNotIn(List<String> values) {
            addCriterion("FEEDBACK_TYPE not in", values, "feedbackType");
            return (Criteria) this;
        }

        public Criteria andFeedbackTypeBetween(String value1, String value2) {
            addCriterion("FEEDBACK_TYPE between", value1, value2, "feedbackType");
            return (Criteria) this;
        }

        public Criteria andFeedbackTypeNotBetween(String value1, String value2) {
            addCriterion("FEEDBACK_TYPE not between", value1, value2, "feedbackType");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeIsNull() {
            addCriterion("FEEDBACK_TIME is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeIsNotNull() {
            addCriterion("FEEDBACK_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeEqualTo(Date value) {
            addCriterion("FEEDBACK_TIME =", value, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeNotEqualTo(Date value) {
            addCriterion("FEEDBACK_TIME <>", value, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeGreaterThan(Date value) {
            addCriterion("FEEDBACK_TIME >", value, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("FEEDBACK_TIME >=", value, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeLessThan(Date value) {
            addCriterion("FEEDBACK_TIME <", value, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeLessThanOrEqualTo(Date value) {
            addCriterion("FEEDBACK_TIME <=", value, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeIn(List<Date> values) {
            addCriterion("FEEDBACK_TIME in", values, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeNotIn(List<Date> values) {
            addCriterion("FEEDBACK_TIME not in", values, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeBetween(Date value1, Date value2) {
            addCriterion("FEEDBACK_TIME between", value1, value2, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeNotBetween(Date value1, Date value2) {
            addCriterion("FEEDBACK_TIME not between", value1, value2, "feedbackTime");
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

        public Criteria andFeedbackResourceIsNull() {
            addCriterion("FEEDBACK_RESOURCE is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackResourceIsNotNull() {
            addCriterion("FEEDBACK_RESOURCE is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackResourceEqualTo(String value) {
            addCriterion("FEEDBACK_RESOURCE =", value, "feedbackResource");
            return (Criteria) this;
        }

        public Criteria andFeedbackResourceNotEqualTo(String value) {
            addCriterion("FEEDBACK_RESOURCE <>", value, "feedbackResource");
            return (Criteria) this;
        }

        public Criteria andFeedbackResourceGreaterThan(String value) {
            addCriterion("FEEDBACK_RESOURCE >", value, "feedbackResource");
            return (Criteria) this;
        }

        public Criteria andFeedbackResourceGreaterThanOrEqualTo(String value) {
            addCriterion("FEEDBACK_RESOURCE >=", value, "feedbackResource");
            return (Criteria) this;
        }

        public Criteria andFeedbackResourceLessThan(String value) {
            addCriterion("FEEDBACK_RESOURCE <", value, "feedbackResource");
            return (Criteria) this;
        }

        public Criteria andFeedbackResourceLessThanOrEqualTo(String value) {
            addCriterion("FEEDBACK_RESOURCE <=", value, "feedbackResource");
            return (Criteria) this;
        }

        public Criteria andFeedbackResourceLike(String value) {
            addCriterion("FEEDBACK_RESOURCE like", value, "feedbackResource");
            return (Criteria) this;
        }

        public Criteria andFeedbackResourceNotLike(String value) {
            addCriterion("FEEDBACK_RESOURCE not like", value, "feedbackResource");
            return (Criteria) this;
        }

        public Criteria andFeedbackResourceIn(List<String> values) {
            addCriterion("FEEDBACK_RESOURCE in", values, "feedbackResource");
            return (Criteria) this;
        }

        public Criteria andFeedbackResourceNotIn(List<String> values) {
            addCriterion("FEEDBACK_RESOURCE not in", values, "feedbackResource");
            return (Criteria) this;
        }

        public Criteria andFeedbackResourceBetween(String value1, String value2) {
            addCriterion("FEEDBACK_RESOURCE between", value1, value2, "feedbackResource");
            return (Criteria) this;
        }

        public Criteria andFeedbackResourceNotBetween(String value1, String value2) {
            addCriterion("FEEDBACK_RESOURCE not between", value1, value2, "feedbackResource");
            return (Criteria) this;
        }

        public Criteria andFeedbackTopicIsNull() {
            addCriterion("FEEDBACK_TOPIC is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackTopicIsNotNull() {
            addCriterion("FEEDBACK_TOPIC is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackTopicEqualTo(String value) {
            addCriterion("FEEDBACK_TOPIC =", value, "feedbackTopic");
            return (Criteria) this;
        }

        public Criteria andFeedbackTopicNotEqualTo(String value) {
            addCriterion("FEEDBACK_TOPIC <>", value, "feedbackTopic");
            return (Criteria) this;
        }

        public Criteria andFeedbackTopicGreaterThan(String value) {
            addCriterion("FEEDBACK_TOPIC >", value, "feedbackTopic");
            return (Criteria) this;
        }

        public Criteria andFeedbackTopicGreaterThanOrEqualTo(String value) {
            addCriterion("FEEDBACK_TOPIC >=", value, "feedbackTopic");
            return (Criteria) this;
        }

        public Criteria andFeedbackTopicLessThan(String value) {
            addCriterion("FEEDBACK_TOPIC <", value, "feedbackTopic");
            return (Criteria) this;
        }

        public Criteria andFeedbackTopicLessThanOrEqualTo(String value) {
            addCriterion("FEEDBACK_TOPIC <=", value, "feedbackTopic");
            return (Criteria) this;
        }

        public Criteria andFeedbackTopicLike(String value) {
            addCriterion("FEEDBACK_TOPIC like", value, "feedbackTopic");
            return (Criteria) this;
        }

        public Criteria andFeedbackTopicNotLike(String value) {
            addCriterion("FEEDBACK_TOPIC not like", value, "feedbackTopic");
            return (Criteria) this;
        }

        public Criteria andFeedbackTopicIn(List<String> values) {
            addCriterion("FEEDBACK_TOPIC in", values, "feedbackTopic");
            return (Criteria) this;
        }

        public Criteria andFeedbackTopicNotIn(List<String> values) {
            addCriterion("FEEDBACK_TOPIC not in", values, "feedbackTopic");
            return (Criteria) this;
        }

        public Criteria andFeedbackTopicBetween(String value1, String value2) {
            addCriterion("FEEDBACK_TOPIC between", value1, value2, "feedbackTopic");
            return (Criteria) this;
        }

        public Criteria andFeedbackTopicNotBetween(String value1, String value2) {
            addCriterion("FEEDBACK_TOPIC not between", value1, value2, "feedbackTopic");
            return (Criteria) this;
        }

        public Criteria andFeedbackDescIsNull() {
            addCriterion("FEEDBACK_DESC is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackDescIsNotNull() {
            addCriterion("FEEDBACK_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackDescEqualTo(String value) {
            addCriterion("FEEDBACK_DESC =", value, "feedbackDesc");
            return (Criteria) this;
        }

        public Criteria andFeedbackDescNotEqualTo(String value) {
            addCriterion("FEEDBACK_DESC <>", value, "feedbackDesc");
            return (Criteria) this;
        }

        public Criteria andFeedbackDescGreaterThan(String value) {
            addCriterion("FEEDBACK_DESC >", value, "feedbackDesc");
            return (Criteria) this;
        }

        public Criteria andFeedbackDescGreaterThanOrEqualTo(String value) {
            addCriterion("FEEDBACK_DESC >=", value, "feedbackDesc");
            return (Criteria) this;
        }

        public Criteria andFeedbackDescLessThan(String value) {
            addCriterion("FEEDBACK_DESC <", value, "feedbackDesc");
            return (Criteria) this;
        }

        public Criteria andFeedbackDescLessThanOrEqualTo(String value) {
            addCriterion("FEEDBACK_DESC <=", value, "feedbackDesc");
            return (Criteria) this;
        }

        public Criteria andFeedbackDescLike(String value) {
            addCriterion("FEEDBACK_DESC like", value, "feedbackDesc");
            return (Criteria) this;
        }

        public Criteria andFeedbackDescNotLike(String value) {
            addCriterion("FEEDBACK_DESC not like", value, "feedbackDesc");
            return (Criteria) this;
        }

        public Criteria andFeedbackDescIn(List<String> values) {
            addCriterion("FEEDBACK_DESC in", values, "feedbackDesc");
            return (Criteria) this;
        }

        public Criteria andFeedbackDescNotIn(List<String> values) {
            addCriterion("FEEDBACK_DESC not in", values, "feedbackDesc");
            return (Criteria) this;
        }

        public Criteria andFeedbackDescBetween(String value1, String value2) {
            addCriterion("FEEDBACK_DESC between", value1, value2, "feedbackDesc");
            return (Criteria) this;
        }

        public Criteria andFeedbackDescNotBetween(String value1, String value2) {
            addCriterion("FEEDBACK_DESC not between", value1, value2, "feedbackDesc");
            return (Criteria) this;
        }

        public Criteria andAnaiusisIsNull() {
            addCriterion("ANAIUSIS is null");
            return (Criteria) this;
        }

        public Criteria andAnaiusisIsNotNull() {
            addCriterion("ANAIUSIS is not null");
            return (Criteria) this;
        }

        public Criteria andAnaiusisEqualTo(String value) {
            addCriterion("ANAIUSIS =", value, "anaiusis");
            return (Criteria) this;
        }

        public Criteria andAnaiusisNotEqualTo(String value) {
            addCriterion("ANAIUSIS <>", value, "anaiusis");
            return (Criteria) this;
        }

        public Criteria andAnaiusisGreaterThan(String value) {
            addCriterion("ANAIUSIS >", value, "anaiusis");
            return (Criteria) this;
        }

        public Criteria andAnaiusisGreaterThanOrEqualTo(String value) {
            addCriterion("ANAIUSIS >=", value, "anaiusis");
            return (Criteria) this;
        }

        public Criteria andAnaiusisLessThan(String value) {
            addCriterion("ANAIUSIS <", value, "anaiusis");
            return (Criteria) this;
        }

        public Criteria andAnaiusisLessThanOrEqualTo(String value) {
            addCriterion("ANAIUSIS <=", value, "anaiusis");
            return (Criteria) this;
        }

        public Criteria andAnaiusisLike(String value) {
            addCriterion("ANAIUSIS like", value, "anaiusis");
            return (Criteria) this;
        }

        public Criteria andAnaiusisNotLike(String value) {
            addCriterion("ANAIUSIS not like", value, "anaiusis");
            return (Criteria) this;
        }

        public Criteria andAnaiusisIn(List<String> values) {
            addCriterion("ANAIUSIS in", values, "anaiusis");
            return (Criteria) this;
        }

        public Criteria andAnaiusisNotIn(List<String> values) {
            addCriterion("ANAIUSIS not in", values, "anaiusis");
            return (Criteria) this;
        }

        public Criteria andAnaiusisBetween(String value1, String value2) {
            addCriterion("ANAIUSIS between", value1, value2, "anaiusis");
            return (Criteria) this;
        }

        public Criteria andAnaiusisNotBetween(String value1, String value2) {
            addCriterion("ANAIUSIS not between", value1, value2, "anaiusis");
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