package com.sc.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OfficeChecktaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OfficeChecktaskExample() {
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

        public Criteria andTaskIdIsNull() {
            addCriterion("TASK_ID is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("TASK_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(Long value) {
            addCriterion("TASK_ID =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(Long value) {
            addCriterion("TASK_ID <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(Long value) {
            addCriterion("TASK_ID >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(Long value) {
            addCriterion("TASK_ID >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(Long value) {
            addCriterion("TASK_ID <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(Long value) {
            addCriterion("TASK_ID <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<Long> values) {
            addCriterion("TASK_ID in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<Long> values) {
            addCriterion("TASK_ID not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(Long value1, Long value2) {
            addCriterion("TASK_ID between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(Long value1, Long value2) {
            addCriterion("TASK_ID not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskTitleIsNull() {
            addCriterion("TASK_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andTaskTitleIsNotNull() {
            addCriterion("TASK_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTitleEqualTo(String value) {
            addCriterion("TASK_TITLE =", value, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleNotEqualTo(String value) {
            addCriterion("TASK_TITLE <>", value, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleGreaterThan(String value) {
            addCriterion("TASK_TITLE >", value, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleGreaterThanOrEqualTo(String value) {
            addCriterion("TASK_TITLE >=", value, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleLessThan(String value) {
            addCriterion("TASK_TITLE <", value, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleLessThanOrEqualTo(String value) {
            addCriterion("TASK_TITLE <=", value, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleLike(String value) {
            addCriterion("TASK_TITLE like", value, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleNotLike(String value) {
            addCriterion("TASK_TITLE not like", value, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleIn(List<String> values) {
            addCriterion("TASK_TITLE in", values, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleNotIn(List<String> values) {
            addCriterion("TASK_TITLE not in", values, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleBetween(String value1, String value2) {
            addCriterion("TASK_TITLE between", value1, value2, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleNotBetween(String value1, String value2) {
            addCriterion("TASK_TITLE not between", value1, value2, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskContentIsNull() {
            addCriterion("TASK_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andTaskContentIsNotNull() {
            addCriterion("TASK_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andTaskContentEqualTo(String value) {
            addCriterion("TASK_CONTENT =", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotEqualTo(String value) {
            addCriterion("TASK_CONTENT <>", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentGreaterThan(String value) {
            addCriterion("TASK_CONTENT >", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentGreaterThanOrEqualTo(String value) {
            addCriterion("TASK_CONTENT >=", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentLessThan(String value) {
            addCriterion("TASK_CONTENT <", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentLessThanOrEqualTo(String value) {
            addCriterion("TASK_CONTENT <=", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentLike(String value) {
            addCriterion("TASK_CONTENT like", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotLike(String value) {
            addCriterion("TASK_CONTENT not like", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentIn(List<String> values) {
            addCriterion("TASK_CONTENT in", values, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotIn(List<String> values) {
            addCriterion("TASK_CONTENT not in", values, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentBetween(String value1, String value2) {
            addCriterion("TASK_CONTENT between", value1, value2, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotBetween(String value1, String value2) {
            addCriterion("TASK_CONTENT not between", value1, value2, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskPublisherIsNull() {
            addCriterion("TASK_PUBLISHER is null");
            return (Criteria) this;
        }

        public Criteria andTaskPublisherIsNotNull() {
            addCriterion("TASK_PUBLISHER is not null");
            return (Criteria) this;
        }

        public Criteria andTaskPublisherEqualTo(String value) {
            addCriterion("TASK_PUBLISHER =", value, "taskPublisher");
            return (Criteria) this;
        }

        public Criteria andTaskPublisherNotEqualTo(String value) {
            addCriterion("TASK_PUBLISHER <>", value, "taskPublisher");
            return (Criteria) this;
        }

        public Criteria andTaskPublisherGreaterThan(String value) {
            addCriterion("TASK_PUBLISHER >", value, "taskPublisher");
            return (Criteria) this;
        }

        public Criteria andTaskPublisherGreaterThanOrEqualTo(String value) {
            addCriterion("TASK_PUBLISHER >=", value, "taskPublisher");
            return (Criteria) this;
        }

        public Criteria andTaskPublisherLessThan(String value) {
            addCriterion("TASK_PUBLISHER <", value, "taskPublisher");
            return (Criteria) this;
        }

        public Criteria andTaskPublisherLessThanOrEqualTo(String value) {
            addCriterion("TASK_PUBLISHER <=", value, "taskPublisher");
            return (Criteria) this;
        }

        public Criteria andTaskPublisherLike(String value) {
            addCriterion("TASK_PUBLISHER like", value, "taskPublisher");
            return (Criteria) this;
        }

        public Criteria andTaskPublisherNotLike(String value) {
            addCriterion("TASK_PUBLISHER not like", value, "taskPublisher");
            return (Criteria) this;
        }

        public Criteria andTaskPublisherIn(List<String> values) {
            addCriterion("TASK_PUBLISHER in", values, "taskPublisher");
            return (Criteria) this;
        }

        public Criteria andTaskPublisherNotIn(List<String> values) {
            addCriterion("TASK_PUBLISHER not in", values, "taskPublisher");
            return (Criteria) this;
        }

        public Criteria andTaskPublisherBetween(String value1, String value2) {
            addCriterion("TASK_PUBLISHER between", value1, value2, "taskPublisher");
            return (Criteria) this;
        }

        public Criteria andTaskPublisherNotBetween(String value1, String value2) {
            addCriterion("TASK_PUBLISHER not between", value1, value2, "taskPublisher");
            return (Criteria) this;
        }

        public Criteria andTargetIdIsNull() {
            addCriterion("TARGET_ID is null");
            return (Criteria) this;
        }

        public Criteria andTargetIdIsNotNull() {
            addCriterion("TARGET_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTargetIdEqualTo(Long value) {
            addCriterion("TARGET_ID =", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdNotEqualTo(Long value) {
            addCriterion("TARGET_ID <>", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdGreaterThan(Long value) {
            addCriterion("TARGET_ID >", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdGreaterThanOrEqualTo(Long value) {
            addCriterion("TARGET_ID >=", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdLessThan(Long value) {
            addCriterion("TARGET_ID <", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdLessThanOrEqualTo(Long value) {
            addCriterion("TARGET_ID <=", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdIn(List<Long> values) {
            addCriterion("TARGET_ID in", values, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdNotIn(List<Long> values) {
            addCriterion("TARGET_ID not in", values, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdBetween(Long value1, Long value2) {
            addCriterion("TARGET_ID between", value1, value2, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdNotBetween(Long value1, Long value2) {
            addCriterion("TARGET_ID not between", value1, value2, "targetId");
            return (Criteria) this;
        }

        public Criteria andTaskStarttimeIsNull() {
            addCriterion("TASK_STARTTIME is null");
            return (Criteria) this;
        }

        public Criteria andTaskStarttimeIsNotNull() {
            addCriterion("TASK_STARTTIME is not null");
            return (Criteria) this;
        }

        public Criteria andTaskStarttimeEqualTo(Date value) {
            addCriterion("TASK_STARTTIME =", value, "taskStarttime");
            return (Criteria) this;
        }

        public Criteria andTaskStarttimeNotEqualTo(Date value) {
            addCriterion("TASK_STARTTIME <>", value, "taskStarttime");
            return (Criteria) this;
        }

        public Criteria andTaskStarttimeGreaterThan(Date value) {
            addCriterion("TASK_STARTTIME >", value, "taskStarttime");
            return (Criteria) this;
        }

        public Criteria andTaskStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("TASK_STARTTIME >=", value, "taskStarttime");
            return (Criteria) this;
        }

        public Criteria andTaskStarttimeLessThan(Date value) {
            addCriterion("TASK_STARTTIME <", value, "taskStarttime");
            return (Criteria) this;
        }

        public Criteria andTaskStarttimeLessThanOrEqualTo(Date value) {
            addCriterion("TASK_STARTTIME <=", value, "taskStarttime");
            return (Criteria) this;
        }

        public Criteria andTaskStarttimeIn(List<Date> values) {
            addCriterion("TASK_STARTTIME in", values, "taskStarttime");
            return (Criteria) this;
        }

        public Criteria andTaskStarttimeNotIn(List<Date> values) {
            addCriterion("TASK_STARTTIME not in", values, "taskStarttime");
            return (Criteria) this;
        }

        public Criteria andTaskStarttimeBetween(Date value1, Date value2) {
            addCriterion("TASK_STARTTIME between", value1, value2, "taskStarttime");
            return (Criteria) this;
        }

        public Criteria andTaskStarttimeNotBetween(Date value1, Date value2) {
            addCriterion("TASK_STARTTIME not between", value1, value2, "taskStarttime");
            return (Criteria) this;
        }

        public Criteria andTaskEndtimeIsNull() {
            addCriterion("TASK_ENDTIME is null");
            return (Criteria) this;
        }

        public Criteria andTaskEndtimeIsNotNull() {
            addCriterion("TASK_ENDTIME is not null");
            return (Criteria) this;
        }

        public Criteria andTaskEndtimeEqualTo(Date value) {
            addCriterion("TASK_ENDTIME =", value, "taskEndtime");
            return (Criteria) this;
        }

        public Criteria andTaskEndtimeNotEqualTo(Date value) {
            addCriterion("TASK_ENDTIME <>", value, "taskEndtime");
            return (Criteria) this;
        }

        public Criteria andTaskEndtimeGreaterThan(Date value) {
            addCriterion("TASK_ENDTIME >", value, "taskEndtime");
            return (Criteria) this;
        }

        public Criteria andTaskEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("TASK_ENDTIME >=", value, "taskEndtime");
            return (Criteria) this;
        }

        public Criteria andTaskEndtimeLessThan(Date value) {
            addCriterion("TASK_ENDTIME <", value, "taskEndtime");
            return (Criteria) this;
        }

        public Criteria andTaskEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("TASK_ENDTIME <=", value, "taskEndtime");
            return (Criteria) this;
        }

        public Criteria andTaskEndtimeIn(List<Date> values) {
            addCriterion("TASK_ENDTIME in", values, "taskEndtime");
            return (Criteria) this;
        }

        public Criteria andTaskEndtimeNotIn(List<Date> values) {
            addCriterion("TASK_ENDTIME not in", values, "taskEndtime");
            return (Criteria) this;
        }

        public Criteria andTaskEndtimeBetween(Date value1, Date value2) {
            addCriterion("TASK_ENDTIME between", value1, value2, "taskEndtime");
            return (Criteria) this;
        }

        public Criteria andTaskEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("TASK_ENDTIME not between", value1, value2, "taskEndtime");
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