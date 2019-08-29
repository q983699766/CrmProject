package com.sc.mapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PurSupInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PurSupInfoExample() {
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

        public Criteria andSupNameIsNull() {
            addCriterion("SUP_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSupNameIsNotNull() {
            addCriterion("SUP_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSupNameEqualTo(String value) {
            addCriterion("SUP_NAME =", value, "supName");
            return (Criteria) this;
        }

        public Criteria andSupNameNotEqualTo(String value) {
            addCriterion("SUP_NAME <>", value, "supName");
            return (Criteria) this;
        }

        public Criteria andSupNameGreaterThan(String value) {
            addCriterion("SUP_NAME >", value, "supName");
            return (Criteria) this;
        }

        public Criteria andSupNameGreaterThanOrEqualTo(String value) {
            addCriterion("SUP_NAME >=", value, "supName");
            return (Criteria) this;
        }

        public Criteria andSupNameLessThan(String value) {
            addCriterion("SUP_NAME <", value, "supName");
            return (Criteria) this;
        }

        public Criteria andSupNameLessThanOrEqualTo(String value) {
            addCriterion("SUP_NAME <=", value, "supName");
            return (Criteria) this;
        }

        public Criteria andSupNameLike(String value) {
            addCriterion("SUP_NAME like", value, "supName");
            return (Criteria) this;
        }

        public Criteria andSupNameNotLike(String value) {
            addCriterion("SUP_NAME not like", value, "supName");
            return (Criteria) this;
        }

        public Criteria andSupNameIn(List<String> values) {
            addCriterion("SUP_NAME in", values, "supName");
            return (Criteria) this;
        }

        public Criteria andSupNameNotIn(List<String> values) {
            addCriterion("SUP_NAME not in", values, "supName");
            return (Criteria) this;
        }

        public Criteria andSupNameBetween(String value1, String value2) {
            addCriterion("SUP_NAME between", value1, value2, "supName");
            return (Criteria) this;
        }

        public Criteria andSupNameNotBetween(String value1, String value2) {
            addCriterion("SUP_NAME not between", value1, value2, "supName");
            return (Criteria) this;
        }

        public Criteria andSupUnameIsNull() {
            addCriterion("SUP_UNAME is null");
            return (Criteria) this;
        }

        public Criteria andSupUnameIsNotNull() {
            addCriterion("SUP_UNAME is not null");
            return (Criteria) this;
        }

        public Criteria andSupUnameEqualTo(String value) {
            addCriterion("SUP_UNAME =", value, "supUname");
            return (Criteria) this;
        }

        public Criteria andSupUnameNotEqualTo(String value) {
            addCriterion("SUP_UNAME <>", value, "supUname");
            return (Criteria) this;
        }

        public Criteria andSupUnameGreaterThan(String value) {
            addCriterion("SUP_UNAME >", value, "supUname");
            return (Criteria) this;
        }

        public Criteria andSupUnameGreaterThanOrEqualTo(String value) {
            addCriterion("SUP_UNAME >=", value, "supUname");
            return (Criteria) this;
        }

        public Criteria andSupUnameLessThan(String value) {
            addCriterion("SUP_UNAME <", value, "supUname");
            return (Criteria) this;
        }

        public Criteria andSupUnameLessThanOrEqualTo(String value) {
            addCriterion("SUP_UNAME <=", value, "supUname");
            return (Criteria) this;
        }

        public Criteria andSupUnameLike(String value) {
            addCriterion("SUP_UNAME like", value, "supUname");
            return (Criteria) this;
        }

        public Criteria andSupUnameNotLike(String value) {
            addCriterion("SUP_UNAME not like", value, "supUname");
            return (Criteria) this;
        }

        public Criteria andSupUnameIn(List<String> values) {
            addCriterion("SUP_UNAME in", values, "supUname");
            return (Criteria) this;
        }

        public Criteria andSupUnameNotIn(List<String> values) {
            addCriterion("SUP_UNAME not in", values, "supUname");
            return (Criteria) this;
        }

        public Criteria andSupUnameBetween(String value1, String value2) {
            addCriterion("SUP_UNAME between", value1, value2, "supUname");
            return (Criteria) this;
        }

        public Criteria andSupUnameNotBetween(String value1, String value2) {
            addCriterion("SUP_UNAME not between", value1, value2, "supUname");
            return (Criteria) this;
        }

        public Criteria andContactsIsNull() {
            addCriterion("CONTACTS is null");
            return (Criteria) this;
        }

        public Criteria andContactsIsNotNull() {
            addCriterion("CONTACTS is not null");
            return (Criteria) this;
        }

        public Criteria andContactsEqualTo(String value) {
            addCriterion("CONTACTS =", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotEqualTo(String value) {
            addCriterion("CONTACTS <>", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsGreaterThan(String value) {
            addCriterion("CONTACTS >", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsGreaterThanOrEqualTo(String value) {
            addCriterion("CONTACTS >=", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLessThan(String value) {
            addCriterion("CONTACTS <", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLessThanOrEqualTo(String value) {
            addCriterion("CONTACTS <=", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLike(String value) {
            addCriterion("CONTACTS like", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotLike(String value) {
            addCriterion("CONTACTS not like", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsIn(List<String> values) {
            addCriterion("CONTACTS in", values, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotIn(List<String> values) {
            addCriterion("CONTACTS not in", values, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsBetween(String value1, String value2) {
            addCriterion("CONTACTS between", value1, value2, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotBetween(String value1, String value2) {
            addCriterion("CONTACTS not between", value1, value2, "contacts");
            return (Criteria) this;
        }

        public Criteria andFixedTelIsNull() {
            addCriterion("FIXED_TEL is null");
            return (Criteria) this;
        }

        public Criteria andFixedTelIsNotNull() {
            addCriterion("FIXED_TEL is not null");
            return (Criteria) this;
        }

        public Criteria andFixedTelEqualTo(String value) {
            addCriterion("FIXED_TEL =", value, "fixedTel");
            return (Criteria) this;
        }

        public Criteria andFixedTelNotEqualTo(String value) {
            addCriterion("FIXED_TEL <>", value, "fixedTel");
            return (Criteria) this;
        }

        public Criteria andFixedTelGreaterThan(String value) {
            addCriterion("FIXED_TEL >", value, "fixedTel");
            return (Criteria) this;
        }

        public Criteria andFixedTelGreaterThanOrEqualTo(String value) {
            addCriterion("FIXED_TEL >=", value, "fixedTel");
            return (Criteria) this;
        }

        public Criteria andFixedTelLessThan(String value) {
            addCriterion("FIXED_TEL <", value, "fixedTel");
            return (Criteria) this;
        }

        public Criteria andFixedTelLessThanOrEqualTo(String value) {
            addCriterion("FIXED_TEL <=", value, "fixedTel");
            return (Criteria) this;
        }

        public Criteria andFixedTelLike(String value) {
            addCriterion("FIXED_TEL like", value, "fixedTel");
            return (Criteria) this;
        }

        public Criteria andFixedTelNotLike(String value) {
            addCriterion("FIXED_TEL not like", value, "fixedTel");
            return (Criteria) this;
        }

        public Criteria andFixedTelIn(List<String> values) {
            addCriterion("FIXED_TEL in", values, "fixedTel");
            return (Criteria) this;
        }

        public Criteria andFixedTelNotIn(List<String> values) {
            addCriterion("FIXED_TEL not in", values, "fixedTel");
            return (Criteria) this;
        }

        public Criteria andFixedTelBetween(String value1, String value2) {
            addCriterion("FIXED_TEL between", value1, value2, "fixedTel");
            return (Criteria) this;
        }

        public Criteria andFixedTelNotBetween(String value1, String value2) {
            addCriterion("FIXED_TEL not between", value1, value2, "fixedTel");
            return (Criteria) this;
        }

        public Criteria andTelphoneIsNull() {
            addCriterion("TELPHONE is null");
            return (Criteria) this;
        }

        public Criteria andTelphoneIsNotNull() {
            addCriterion("TELPHONE is not null");
            return (Criteria) this;
        }

        public Criteria andTelphoneEqualTo(String value) {
            addCriterion("TELPHONE =", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneNotEqualTo(String value) {
            addCriterion("TELPHONE <>", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneGreaterThan(String value) {
            addCriterion("TELPHONE >", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneGreaterThanOrEqualTo(String value) {
            addCriterion("TELPHONE >=", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneLessThan(String value) {
            addCriterion("TELPHONE <", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneLessThanOrEqualTo(String value) {
            addCriterion("TELPHONE <=", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneLike(String value) {
            addCriterion("TELPHONE like", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneNotLike(String value) {
            addCriterion("TELPHONE not like", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneIn(List<String> values) {
            addCriterion("TELPHONE in", values, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneNotIn(List<String> values) {
            addCriterion("TELPHONE not in", values, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneBetween(String value1, String value2) {
            addCriterion("TELPHONE between", value1, value2, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneNotBetween(String value1, String value2) {
            addCriterion("TELPHONE not between", value1, value2, "telphone");
            return (Criteria) this;
        }

        public Criteria andFaxIsNull() {
            addCriterion("FAX is null");
            return (Criteria) this;
        }

        public Criteria andFaxIsNotNull() {
            addCriterion("FAX is not null");
            return (Criteria) this;
        }

        public Criteria andFaxEqualTo(String value) {
            addCriterion("FAX =", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotEqualTo(String value) {
            addCriterion("FAX <>", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThan(String value) {
            addCriterion("FAX >", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThanOrEqualTo(String value) {
            addCriterion("FAX >=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThan(String value) {
            addCriterion("FAX <", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThanOrEqualTo(String value) {
            addCriterion("FAX <=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLike(String value) {
            addCriterion("FAX like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotLike(String value) {
            addCriterion("FAX not like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxIn(List<String> values) {
            addCriterion("FAX in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotIn(List<String> values) {
            addCriterion("FAX not in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxBetween(String value1, String value2) {
            addCriterion("FAX between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotBetween(String value1, String value2) {
            addCriterion("FAX not between", value1, value2, "fax");
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

        public Criteria andOpenBankIsNull() {
            addCriterion("OPEN_BANK is null");
            return (Criteria) this;
        }

        public Criteria andOpenBankIsNotNull() {
            addCriterion("OPEN_BANK is not null");
            return (Criteria) this;
        }

        public Criteria andOpenBankEqualTo(String value) {
            addCriterion("OPEN_BANK =", value, "openBank");
            return (Criteria) this;
        }

        public Criteria andOpenBankNotEqualTo(String value) {
            addCriterion("OPEN_BANK <>", value, "openBank");
            return (Criteria) this;
        }

        public Criteria andOpenBankGreaterThan(String value) {
            addCriterion("OPEN_BANK >", value, "openBank");
            return (Criteria) this;
        }

        public Criteria andOpenBankGreaterThanOrEqualTo(String value) {
            addCriterion("OPEN_BANK >=", value, "openBank");
            return (Criteria) this;
        }

        public Criteria andOpenBankLessThan(String value) {
            addCriterion("OPEN_BANK <", value, "openBank");
            return (Criteria) this;
        }

        public Criteria andOpenBankLessThanOrEqualTo(String value) {
            addCriterion("OPEN_BANK <=", value, "openBank");
            return (Criteria) this;
        }

        public Criteria andOpenBankLike(String value) {
            addCriterion("OPEN_BANK like", value, "openBank");
            return (Criteria) this;
        }

        public Criteria andOpenBankNotLike(String value) {
            addCriterion("OPEN_BANK not like", value, "openBank");
            return (Criteria) this;
        }

        public Criteria andOpenBankIn(List<String> values) {
            addCriterion("OPEN_BANK in", values, "openBank");
            return (Criteria) this;
        }

        public Criteria andOpenBankNotIn(List<String> values) {
            addCriterion("OPEN_BANK not in", values, "openBank");
            return (Criteria) this;
        }

        public Criteria andOpenBankBetween(String value1, String value2) {
            addCriterion("OPEN_BANK between", value1, value2, "openBank");
            return (Criteria) this;
        }

        public Criteria andOpenBankNotBetween(String value1, String value2) {
            addCriterion("OPEN_BANK not between", value1, value2, "openBank");
            return (Criteria) this;
        }

        public Criteria andBankNatureIsNull() {
            addCriterion("BANK_NATURE is null");
            return (Criteria) this;
        }

        public Criteria andBankNatureIsNotNull() {
            addCriterion("BANK_NATURE is not null");
            return (Criteria) this;
        }

        public Criteria andBankNatureEqualTo(String value) {
            addCriterion("BANK_NATURE =", value, "bankNature");
            return (Criteria) this;
        }

        public Criteria andBankNatureNotEqualTo(String value) {
            addCriterion("BANK_NATURE <>", value, "bankNature");
            return (Criteria) this;
        }

        public Criteria andBankNatureGreaterThan(String value) {
            addCriterion("BANK_NATURE >", value, "bankNature");
            return (Criteria) this;
        }

        public Criteria andBankNatureGreaterThanOrEqualTo(String value) {
            addCriterion("BANK_NATURE >=", value, "bankNature");
            return (Criteria) this;
        }

        public Criteria andBankNatureLessThan(String value) {
            addCriterion("BANK_NATURE <", value, "bankNature");
            return (Criteria) this;
        }

        public Criteria andBankNatureLessThanOrEqualTo(String value) {
            addCriterion("BANK_NATURE <=", value, "bankNature");
            return (Criteria) this;
        }

        public Criteria andBankNatureLike(String value) {
            addCriterion("BANK_NATURE like", value, "bankNature");
            return (Criteria) this;
        }

        public Criteria andBankNatureNotLike(String value) {
            addCriterion("BANK_NATURE not like", value, "bankNature");
            return (Criteria) this;
        }

        public Criteria andBankNatureIn(List<String> values) {
            addCriterion("BANK_NATURE in", values, "bankNature");
            return (Criteria) this;
        }

        public Criteria andBankNatureNotIn(List<String> values) {
            addCriterion("BANK_NATURE not in", values, "bankNature");
            return (Criteria) this;
        }

        public Criteria andBankNatureBetween(String value1, String value2) {
            addCriterion("BANK_NATURE between", value1, value2, "bankNature");
            return (Criteria) this;
        }

        public Criteria andBankNatureNotBetween(String value1, String value2) {
            addCriterion("BANK_NATURE not between", value1, value2, "bankNature");
            return (Criteria) this;
        }

        public Criteria andComIndexIsNull() {
            addCriterion("COM_INDEX is null");
            return (Criteria) this;
        }

        public Criteria andComIndexIsNotNull() {
            addCriterion("COM_INDEX is not null");
            return (Criteria) this;
        }

        public Criteria andComIndexEqualTo(String value) {
            addCriterion("COM_INDEX =", value, "comIndex");
            return (Criteria) this;
        }

        public Criteria andComIndexNotEqualTo(String value) {
            addCriterion("COM_INDEX <>", value, "comIndex");
            return (Criteria) this;
        }

        public Criteria andComIndexGreaterThan(String value) {
            addCriterion("COM_INDEX >", value, "comIndex");
            return (Criteria) this;
        }

        public Criteria andComIndexGreaterThanOrEqualTo(String value) {
            addCriterion("COM_INDEX >=", value, "comIndex");
            return (Criteria) this;
        }

        public Criteria andComIndexLessThan(String value) {
            addCriterion("COM_INDEX <", value, "comIndex");
            return (Criteria) this;
        }

        public Criteria andComIndexLessThanOrEqualTo(String value) {
            addCriterion("COM_INDEX <=", value, "comIndex");
            return (Criteria) this;
        }

        public Criteria andComIndexLike(String value) {
            addCriterion("COM_INDEX like", value, "comIndex");
            return (Criteria) this;
        }

        public Criteria andComIndexNotLike(String value) {
            addCriterion("COM_INDEX not like", value, "comIndex");
            return (Criteria) this;
        }

        public Criteria andComIndexIn(List<String> values) {
            addCriterion("COM_INDEX in", values, "comIndex");
            return (Criteria) this;
        }

        public Criteria andComIndexNotIn(List<String> values) {
            addCriterion("COM_INDEX not in", values, "comIndex");
            return (Criteria) this;
        }

        public Criteria andComIndexBetween(String value1, String value2) {
            addCriterion("COM_INDEX between", value1, value2, "comIndex");
            return (Criteria) this;
        }

        public Criteria andComIndexNotBetween(String value1, String value2) {
            addCriterion("COM_INDEX not between", value1, value2, "comIndex");
            return (Criteria) this;
        }

        public Criteria andEffectiveOrnotIsNull() {
            addCriterion("EFFECTIVE_ORNOT is null");
            return (Criteria) this;
        }

        public Criteria andEffectiveOrnotIsNotNull() {
            addCriterion("EFFECTIVE_ORNOT is not null");
            return (Criteria) this;
        }

        public Criteria andEffectiveOrnotEqualTo(String value) {
            addCriterion("EFFECTIVE_ORNOT =", value, "effectiveOrnot");
            return (Criteria) this;
        }

        public Criteria andEffectiveOrnotNotEqualTo(String value) {
            addCriterion("EFFECTIVE_ORNOT <>", value, "effectiveOrnot");
            return (Criteria) this;
        }

        public Criteria andEffectiveOrnotGreaterThan(String value) {
            addCriterion("EFFECTIVE_ORNOT >", value, "effectiveOrnot");
            return (Criteria) this;
        }

        public Criteria andEffectiveOrnotGreaterThanOrEqualTo(String value) {
            addCriterion("EFFECTIVE_ORNOT >=", value, "effectiveOrnot");
            return (Criteria) this;
        }

        public Criteria andEffectiveOrnotLessThan(String value) {
            addCriterion("EFFECTIVE_ORNOT <", value, "effectiveOrnot");
            return (Criteria) this;
        }

        public Criteria andEffectiveOrnotLessThanOrEqualTo(String value) {
            addCriterion("EFFECTIVE_ORNOT <=", value, "effectiveOrnot");
            return (Criteria) this;
        }

        public Criteria andEffectiveOrnotLike(String value) {
            addCriterion("EFFECTIVE_ORNOT like", value, "effectiveOrnot");
            return (Criteria) this;
        }

        public Criteria andEffectiveOrnotNotLike(String value) {
            addCriterion("EFFECTIVE_ORNOT not like", value, "effectiveOrnot");
            return (Criteria) this;
        }

        public Criteria andEffectiveOrnotIn(List<String> values) {
            addCriterion("EFFECTIVE_ORNOT in", values, "effectiveOrnot");
            return (Criteria) this;
        }

        public Criteria andEffectiveOrnotNotIn(List<String> values) {
            addCriterion("EFFECTIVE_ORNOT not in", values, "effectiveOrnot");
            return (Criteria) this;
        }

        public Criteria andEffectiveOrnotBetween(String value1, String value2) {
            addCriterion("EFFECTIVE_ORNOT between", value1, value2, "effectiveOrnot");
            return (Criteria) this;
        }

        public Criteria andEffectiveOrnotNotBetween(String value1, String value2) {
            addCriterion("EFFECTIVE_ORNOT not between", value1, value2, "effectiveOrnot");
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

        public Criteria andBankNumberIsNull() {
            addCriterion("BANK_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andBankNumberIsNotNull() {
            addCriterion("BANK_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andBankNumberEqualTo(BigDecimal value) {
            addCriterion("BANK_NUMBER =", value, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberNotEqualTo(BigDecimal value) {
            addCriterion("BANK_NUMBER <>", value, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberGreaterThan(BigDecimal value) {
            addCriterion("BANK_NUMBER >", value, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BANK_NUMBER >=", value, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberLessThan(BigDecimal value) {
            addCriterion("BANK_NUMBER <", value, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BANK_NUMBER <=", value, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberIn(List<BigDecimal> values) {
            addCriterion("BANK_NUMBER in", values, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberNotIn(List<BigDecimal> values) {
            addCriterion("BANK_NUMBER not in", values, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BANK_NUMBER between", value1, value2, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BANK_NUMBER not between", value1, value2, "bankNumber");
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