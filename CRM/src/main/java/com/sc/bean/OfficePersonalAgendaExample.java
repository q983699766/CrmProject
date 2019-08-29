package com.sc.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OfficePersonalAgendaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OfficePersonalAgendaExample() {
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

        public Criteria andScheduleIdIsNull() {
            addCriterion("SCHEDULE_ID is null");
            return (Criteria) this;
        }

        public Criteria andScheduleIdIsNotNull() {
            addCriterion("SCHEDULE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleIdEqualTo(Long value) {
            addCriterion("SCHEDULE_ID =", value, "scheduleId");
            return (Criteria) this;
        }

        public Criteria andScheduleIdNotEqualTo(Long value) {
            addCriterion("SCHEDULE_ID <>", value, "scheduleId");
            return (Criteria) this;
        }

        public Criteria andScheduleIdGreaterThan(Long value) {
            addCriterion("SCHEDULE_ID >", value, "scheduleId");
            return (Criteria) this;
        }

        public Criteria andScheduleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("SCHEDULE_ID >=", value, "scheduleId");
            return (Criteria) this;
        }

        public Criteria andScheduleIdLessThan(Long value) {
            addCriterion("SCHEDULE_ID <", value, "scheduleId");
            return (Criteria) this;
        }

        public Criteria andScheduleIdLessThanOrEqualTo(Long value) {
            addCriterion("SCHEDULE_ID <=", value, "scheduleId");
            return (Criteria) this;
        }

        public Criteria andScheduleIdIn(List<Long> values) {
            addCriterion("SCHEDULE_ID in", values, "scheduleId");
            return (Criteria) this;
        }

        public Criteria andScheduleIdNotIn(List<Long> values) {
            addCriterion("SCHEDULE_ID not in", values, "scheduleId");
            return (Criteria) this;
        }

        public Criteria andScheduleIdBetween(Long value1, Long value2) {
            addCriterion("SCHEDULE_ID between", value1, value2, "scheduleId");
            return (Criteria) this;
        }

        public Criteria andScheduleIdNotBetween(Long value1, Long value2) {
            addCriterion("SCHEDULE_ID not between", value1, value2, "scheduleId");
            return (Criteria) this;
        }

        public Criteria andScheduleClassesIsNull() {
            addCriterion("SCHEDULE_CLASSES is null");
            return (Criteria) this;
        }

        public Criteria andScheduleClassesIsNotNull() {
            addCriterion("SCHEDULE_CLASSES is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleClassesEqualTo(String value) {
            addCriterion("SCHEDULE_CLASSES =", value, "scheduleClasses");
            return (Criteria) this;
        }

        public Criteria andScheduleClassesNotEqualTo(String value) {
            addCriterion("SCHEDULE_CLASSES <>", value, "scheduleClasses");
            return (Criteria) this;
        }

        public Criteria andScheduleClassesGreaterThan(String value) {
            addCriterion("SCHEDULE_CLASSES >", value, "scheduleClasses");
            return (Criteria) this;
        }

        public Criteria andScheduleClassesGreaterThanOrEqualTo(String value) {
            addCriterion("SCHEDULE_CLASSES >=", value, "scheduleClasses");
            return (Criteria) this;
        }

        public Criteria andScheduleClassesLessThan(String value) {
            addCriterion("SCHEDULE_CLASSES <", value, "scheduleClasses");
            return (Criteria) this;
        }

        public Criteria andScheduleClassesLessThanOrEqualTo(String value) {
            addCriterion("SCHEDULE_CLASSES <=", value, "scheduleClasses");
            return (Criteria) this;
        }

        public Criteria andScheduleClassesLike(String value) {
            addCriterion("SCHEDULE_CLASSES like", value, "scheduleClasses");
            return (Criteria) this;
        }

        public Criteria andScheduleClassesNotLike(String value) {
            addCriterion("SCHEDULE_CLASSES not like", value, "scheduleClasses");
            return (Criteria) this;
        }

        public Criteria andScheduleClassesIn(List<String> values) {
            addCriterion("SCHEDULE_CLASSES in", values, "scheduleClasses");
            return (Criteria) this;
        }

        public Criteria andScheduleClassesNotIn(List<String> values) {
            addCriterion("SCHEDULE_CLASSES not in", values, "scheduleClasses");
            return (Criteria) this;
        }

        public Criteria andScheduleClassesBetween(String value1, String value2) {
            addCriterion("SCHEDULE_CLASSES between", value1, value2, "scheduleClasses");
            return (Criteria) this;
        }

        public Criteria andScheduleClassesNotBetween(String value1, String value2) {
            addCriterion("SCHEDULE_CLASSES not between", value1, value2, "scheduleClasses");
            return (Criteria) this;
        }

        public Criteria andScheduleThemeIsNull() {
            addCriterion("SCHEDULE_THEME is null");
            return (Criteria) this;
        }

        public Criteria andScheduleThemeIsNotNull() {
            addCriterion("SCHEDULE_THEME is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleThemeEqualTo(String value) {
            addCriterion("SCHEDULE_THEME =", value, "scheduleTheme");
            return (Criteria) this;
        }

        public Criteria andScheduleThemeNotEqualTo(String value) {
            addCriterion("SCHEDULE_THEME <>", value, "scheduleTheme");
            return (Criteria) this;
        }

        public Criteria andScheduleThemeGreaterThan(String value) {
            addCriterion("SCHEDULE_THEME >", value, "scheduleTheme");
            return (Criteria) this;
        }

        public Criteria andScheduleThemeGreaterThanOrEqualTo(String value) {
            addCriterion("SCHEDULE_THEME >=", value, "scheduleTheme");
            return (Criteria) this;
        }

        public Criteria andScheduleThemeLessThan(String value) {
            addCriterion("SCHEDULE_THEME <", value, "scheduleTheme");
            return (Criteria) this;
        }

        public Criteria andScheduleThemeLessThanOrEqualTo(String value) {
            addCriterion("SCHEDULE_THEME <=", value, "scheduleTheme");
            return (Criteria) this;
        }

        public Criteria andScheduleThemeLike(String value) {
            addCriterion("SCHEDULE_THEME like", value, "scheduleTheme");
            return (Criteria) this;
        }

        public Criteria andScheduleThemeNotLike(String value) {
            addCriterion("SCHEDULE_THEME not like", value, "scheduleTheme");
            return (Criteria) this;
        }

        public Criteria andScheduleThemeIn(List<String> values) {
            addCriterion("SCHEDULE_THEME in", values, "scheduleTheme");
            return (Criteria) this;
        }

        public Criteria andScheduleThemeNotIn(List<String> values) {
            addCriterion("SCHEDULE_THEME not in", values, "scheduleTheme");
            return (Criteria) this;
        }

        public Criteria andScheduleThemeBetween(String value1, String value2) {
            addCriterion("SCHEDULE_THEME between", value1, value2, "scheduleTheme");
            return (Criteria) this;
        }

        public Criteria andScheduleThemeNotBetween(String value1, String value2) {
            addCriterion("SCHEDULE_THEME not between", value1, value2, "scheduleTheme");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNull() {
            addCriterion("START_DATE is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("START_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addCriterion("START_DATE =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Date value) {
            addCriterion("START_DATE <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Date value) {
            addCriterion("START_DATE >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterion("START_DATE >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Date value) {
            addCriterion("START_DATE <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterion("START_DATE <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<Date> values) {
            addCriterion("START_DATE in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<Date> values) {
            addCriterion("START_DATE not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Date value1, Date value2) {
            addCriterion("START_DATE between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterion("START_DATE not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("START_TIME =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("START_TIME <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("START_TIME >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("START_TIME >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("START_TIME <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("START_TIME <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("START_TIME in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("START_TIME not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("START_TIME between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("START_TIME not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andWriterIdIsNull() {
            addCriterion("WRITER_ID is null");
            return (Criteria) this;
        }

        public Criteria andWriterIdIsNotNull() {
            addCriterion("WRITER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWriterIdEqualTo(Long value) {
            addCriterion("WRITER_ID =", value, "writerId");
            return (Criteria) this;
        }

        public Criteria andWriterIdNotEqualTo(Long value) {
            addCriterion("WRITER_ID <>", value, "writerId");
            return (Criteria) this;
        }

        public Criteria andWriterIdGreaterThan(Long value) {
            addCriterion("WRITER_ID >", value, "writerId");
            return (Criteria) this;
        }

        public Criteria andWriterIdGreaterThanOrEqualTo(Long value) {
            addCriterion("WRITER_ID >=", value, "writerId");
            return (Criteria) this;
        }

        public Criteria andWriterIdLessThan(Long value) {
            addCriterion("WRITER_ID <", value, "writerId");
            return (Criteria) this;
        }

        public Criteria andWriterIdLessThanOrEqualTo(Long value) {
            addCriterion("WRITER_ID <=", value, "writerId");
            return (Criteria) this;
        }

        public Criteria andWriterIdIn(List<Long> values) {
            addCriterion("WRITER_ID in", values, "writerId");
            return (Criteria) this;
        }

        public Criteria andWriterIdNotIn(List<Long> values) {
            addCriterion("WRITER_ID not in", values, "writerId");
            return (Criteria) this;
        }

        public Criteria andWriterIdBetween(Long value1, Long value2) {
            addCriterion("WRITER_ID between", value1, value2, "writerId");
            return (Criteria) this;
        }

        public Criteria andWriterIdNotBetween(Long value1, Long value2) {
            addCriterion("WRITER_ID not between", value1, value2, "writerId");
            return (Criteria) this;
        }

        public Criteria andScheduleDescribeIsNull() {
            addCriterion("SCHEDULE_DESCRIBE is null");
            return (Criteria) this;
        }

        public Criteria andScheduleDescribeIsNotNull() {
            addCriterion("SCHEDULE_DESCRIBE is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleDescribeEqualTo(String value) {
            addCriterion("SCHEDULE_DESCRIBE =", value, "scheduleDescribe");
            return (Criteria) this;
        }

        public Criteria andScheduleDescribeNotEqualTo(String value) {
            addCriterion("SCHEDULE_DESCRIBE <>", value, "scheduleDescribe");
            return (Criteria) this;
        }

        public Criteria andScheduleDescribeGreaterThan(String value) {
            addCriterion("SCHEDULE_DESCRIBE >", value, "scheduleDescribe");
            return (Criteria) this;
        }

        public Criteria andScheduleDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("SCHEDULE_DESCRIBE >=", value, "scheduleDescribe");
            return (Criteria) this;
        }

        public Criteria andScheduleDescribeLessThan(String value) {
            addCriterion("SCHEDULE_DESCRIBE <", value, "scheduleDescribe");
            return (Criteria) this;
        }

        public Criteria andScheduleDescribeLessThanOrEqualTo(String value) {
            addCriterion("SCHEDULE_DESCRIBE <=", value, "scheduleDescribe");
            return (Criteria) this;
        }

        public Criteria andScheduleDescribeLike(String value) {
            addCriterion("SCHEDULE_DESCRIBE like", value, "scheduleDescribe");
            return (Criteria) this;
        }

        public Criteria andScheduleDescribeNotLike(String value) {
            addCriterion("SCHEDULE_DESCRIBE not like", value, "scheduleDescribe");
            return (Criteria) this;
        }

        public Criteria andScheduleDescribeIn(List<String> values) {
            addCriterion("SCHEDULE_DESCRIBE in", values, "scheduleDescribe");
            return (Criteria) this;
        }

        public Criteria andScheduleDescribeNotIn(List<String> values) {
            addCriterion("SCHEDULE_DESCRIBE not in", values, "scheduleDescribe");
            return (Criteria) this;
        }

        public Criteria andScheduleDescribeBetween(String value1, String value2) {
            addCriterion("SCHEDULE_DESCRIBE between", value1, value2, "scheduleDescribe");
            return (Criteria) this;
        }

        public Criteria andScheduleDescribeNotBetween(String value1, String value2) {
            addCriterion("SCHEDULE_DESCRIBE not between", value1, value2, "scheduleDescribe");
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