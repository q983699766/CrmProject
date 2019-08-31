package com.sc.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysComoanyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysComoanyExample() {
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

        public Criteria andComIdIsNull() {
            addCriterion("COM_ID is null");
            return (Criteria) this;
        }

        public Criteria andComIdIsNotNull() {
            addCriterion("COM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andComIdEqualTo(BigDecimal value) {
            addCriterion("COM_ID =", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotEqualTo(BigDecimal value) {
            addCriterion("COM_ID <>", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdGreaterThan(BigDecimal value) {
            addCriterion("COM_ID >", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COM_ID >=", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdLessThan(BigDecimal value) {
            addCriterion("COM_ID <", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COM_ID <=", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdIn(List<BigDecimal> values) {
            addCriterion("COM_ID in", values, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotIn(List<BigDecimal> values) {
            addCriterion("COM_ID not in", values, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COM_ID between", value1, value2, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COM_ID not between", value1, value2, "comId");
            return (Criteria) this;
        }

        public Criteria andComNameIsNull() {
            addCriterion("COM_NAME is null");
            return (Criteria) this;
        }

        public Criteria andComNameIsNotNull() {
            addCriterion("COM_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andComNameEqualTo(String value) {
            addCriterion("COM_NAME =", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameNotEqualTo(String value) {
            addCriterion("COM_NAME <>", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameGreaterThan(String value) {
            addCriterion("COM_NAME >", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameGreaterThanOrEqualTo(String value) {
            addCriterion("COM_NAME >=", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameLessThan(String value) {
            addCriterion("COM_NAME <", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameLessThanOrEqualTo(String value) {
            addCriterion("COM_NAME <=", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameLike(String value) {
            addCriterion("COM_NAME like", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameNotLike(String value) {
            addCriterion("COM_NAME not like", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameIn(List<String> values) {
            addCriterion("COM_NAME in", values, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameNotIn(List<String> values) {
            addCriterion("COM_NAME not in", values, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameBetween(String value1, String value2) {
            addCriterion("COM_NAME between", value1, value2, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameNotBetween(String value1, String value2) {
            addCriterion("COM_NAME not between", value1, value2, "comName");
            return (Criteria) this;
        }

        public Criteria andComCodeIsNull() {
            addCriterion("COM_CODE is null");
            return (Criteria) this;
        }

        public Criteria andComCodeIsNotNull() {
            addCriterion("COM_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andComCodeEqualTo(String value) {
            addCriterion("COM_CODE =", value, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeNotEqualTo(String value) {
            addCriterion("COM_CODE <>", value, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeGreaterThan(String value) {
            addCriterion("COM_CODE >", value, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeGreaterThanOrEqualTo(String value) {
            addCriterion("COM_CODE >=", value, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeLessThan(String value) {
            addCriterion("COM_CODE <", value, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeLessThanOrEqualTo(String value) {
            addCriterion("COM_CODE <=", value, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeLike(String value) {
            addCriterion("COM_CODE like", value, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeNotLike(String value) {
            addCriterion("COM_CODE not like", value, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeIn(List<String> values) {
            addCriterion("COM_CODE in", values, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeNotIn(List<String> values) {
            addCriterion("COM_CODE not in", values, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeBetween(String value1, String value2) {
            addCriterion("COM_CODE between", value1, value2, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeNotBetween(String value1, String value2) {
            addCriterion("COM_CODE not between", value1, value2, "comCode");
            return (Criteria) this;
        }

        public Criteria andComEmailIsNull() {
            addCriterion("COM_EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andComEmailIsNotNull() {
            addCriterion("COM_EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andComEmailEqualTo(String value) {
            addCriterion("COM_EMAIL =", value, "comEmail");
            return (Criteria) this;
        }

        public Criteria andComEmailNotEqualTo(String value) {
            addCriterion("COM_EMAIL <>", value, "comEmail");
            return (Criteria) this;
        }

        public Criteria andComEmailGreaterThan(String value) {
            addCriterion("COM_EMAIL >", value, "comEmail");
            return (Criteria) this;
        }

        public Criteria andComEmailGreaterThanOrEqualTo(String value) {
            addCriterion("COM_EMAIL >=", value, "comEmail");
            return (Criteria) this;
        }

        public Criteria andComEmailLessThan(String value) {
            addCriterion("COM_EMAIL <", value, "comEmail");
            return (Criteria) this;
        }

        public Criteria andComEmailLessThanOrEqualTo(String value) {
            addCriterion("COM_EMAIL <=", value, "comEmail");
            return (Criteria) this;
        }

        public Criteria andComEmailLike(String value) {
            addCriterion("COM_EMAIL like", value, "comEmail");
            return (Criteria) this;
        }

        public Criteria andComEmailNotLike(String value) {
            addCriterion("COM_EMAIL not like", value, "comEmail");
            return (Criteria) this;
        }

        public Criteria andComEmailIn(List<String> values) {
            addCriterion("COM_EMAIL in", values, "comEmail");
            return (Criteria) this;
        }

        public Criteria andComEmailNotIn(List<String> values) {
            addCriterion("COM_EMAIL not in", values, "comEmail");
            return (Criteria) this;
        }

        public Criteria andComEmailBetween(String value1, String value2) {
            addCriterion("COM_EMAIL between", value1, value2, "comEmail");
            return (Criteria) this;
        }

        public Criteria andComEmailNotBetween(String value1, String value2) {
            addCriterion("COM_EMAIL not between", value1, value2, "comEmail");
            return (Criteria) this;
        }

        public Criteria andComLinkmanIsNull() {
            addCriterion("COM_LINKMAN is null");
            return (Criteria) this;
        }

        public Criteria andComLinkmanIsNotNull() {
            addCriterion("COM_LINKMAN is not null");
            return (Criteria) this;
        }

        public Criteria andComLinkmanEqualTo(String value) {
            addCriterion("COM_LINKMAN =", value, "comLinkman");
            return (Criteria) this;
        }

        public Criteria andComLinkmanNotEqualTo(String value) {
            addCriterion("COM_LINKMAN <>", value, "comLinkman");
            return (Criteria) this;
        }

        public Criteria andComLinkmanGreaterThan(String value) {
            addCriterion("COM_LINKMAN >", value, "comLinkman");
            return (Criteria) this;
        }

        public Criteria andComLinkmanGreaterThanOrEqualTo(String value) {
            addCriterion("COM_LINKMAN >=", value, "comLinkman");
            return (Criteria) this;
        }

        public Criteria andComLinkmanLessThan(String value) {
            addCriterion("COM_LINKMAN <", value, "comLinkman");
            return (Criteria) this;
        }

        public Criteria andComLinkmanLessThanOrEqualTo(String value) {
            addCriterion("COM_LINKMAN <=", value, "comLinkman");
            return (Criteria) this;
        }

        public Criteria andComLinkmanLike(String value) {
            addCriterion("COM_LINKMAN like", value, "comLinkman");
            return (Criteria) this;
        }

        public Criteria andComLinkmanNotLike(String value) {
            addCriterion("COM_LINKMAN not like", value, "comLinkman");
            return (Criteria) this;
        }

        public Criteria andComLinkmanIn(List<String> values) {
            addCriterion("COM_LINKMAN in", values, "comLinkman");
            return (Criteria) this;
        }

        public Criteria andComLinkmanNotIn(List<String> values) {
            addCriterion("COM_LINKMAN not in", values, "comLinkman");
            return (Criteria) this;
        }

        public Criteria andComLinkmanBetween(String value1, String value2) {
            addCriterion("COM_LINKMAN between", value1, value2, "comLinkman");
            return (Criteria) this;
        }

        public Criteria andComLinkmanNotBetween(String value1, String value2) {
            addCriterion("COM_LINKMAN not between", value1, value2, "comLinkman");
            return (Criteria) this;
        }

        public Criteria andComAddressIsNull() {
            addCriterion("COM_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andComAddressIsNotNull() {
            addCriterion("COM_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andComAddressEqualTo(String value) {
            addCriterion("COM_ADDRESS =", value, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressNotEqualTo(String value) {
            addCriterion("COM_ADDRESS <>", value, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressGreaterThan(String value) {
            addCriterion("COM_ADDRESS >", value, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressGreaterThanOrEqualTo(String value) {
            addCriterion("COM_ADDRESS >=", value, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressLessThan(String value) {
            addCriterion("COM_ADDRESS <", value, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressLessThanOrEqualTo(String value) {
            addCriterion("COM_ADDRESS <=", value, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressLike(String value) {
            addCriterion("COM_ADDRESS like", value, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressNotLike(String value) {
            addCriterion("COM_ADDRESS not like", value, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressIn(List<String> values) {
            addCriterion("COM_ADDRESS in", values, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressNotIn(List<String> values) {
            addCriterion("COM_ADDRESS not in", values, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressBetween(String value1, String value2) {
            addCriterion("COM_ADDRESS between", value1, value2, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressNotBetween(String value1, String value2) {
            addCriterion("COM_ADDRESS not between", value1, value2, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComPhoneIsNull() {
            addCriterion("COM_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andComPhoneIsNotNull() {
            addCriterion("COM_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andComPhoneEqualTo(String value) {
            addCriterion("COM_PHONE =", value, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneNotEqualTo(String value) {
            addCriterion("COM_PHONE <>", value, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneGreaterThan(String value) {
            addCriterion("COM_PHONE >", value, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("COM_PHONE >=", value, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneLessThan(String value) {
            addCriterion("COM_PHONE <", value, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneLessThanOrEqualTo(String value) {
            addCriterion("COM_PHONE <=", value, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneLike(String value) {
            addCriterion("COM_PHONE like", value, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneNotLike(String value) {
            addCriterion("COM_PHONE not like", value, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneIn(List<String> values) {
            addCriterion("COM_PHONE in", values, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneNotIn(List<String> values) {
            addCriterion("COM_PHONE not in", values, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneBetween(String value1, String value2) {
            addCriterion("COM_PHONE between", value1, value2, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneNotBetween(String value1, String value2) {
            addCriterion("COM_PHONE not between", value1, value2, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComYphoneIsNull() {
            addCriterion("COM_YPHONE is null");
            return (Criteria) this;
        }

        public Criteria andComYphoneIsNotNull() {
            addCriterion("COM_YPHONE is not null");
            return (Criteria) this;
        }

        public Criteria andComYphoneEqualTo(String value) {
            addCriterion("COM_YPHONE =", value, "comYphone");
            return (Criteria) this;
        }

        public Criteria andComYphoneNotEqualTo(String value) {
            addCriterion("COM_YPHONE <>", value, "comYphone");
            return (Criteria) this;
        }

        public Criteria andComYphoneGreaterThan(String value) {
            addCriterion("COM_YPHONE >", value, "comYphone");
            return (Criteria) this;
        }

        public Criteria andComYphoneGreaterThanOrEqualTo(String value) {
            addCriterion("COM_YPHONE >=", value, "comYphone");
            return (Criteria) this;
        }

        public Criteria andComYphoneLessThan(String value) {
            addCriterion("COM_YPHONE <", value, "comYphone");
            return (Criteria) this;
        }

        public Criteria andComYphoneLessThanOrEqualTo(String value) {
            addCriterion("COM_YPHONE <=", value, "comYphone");
            return (Criteria) this;
        }

        public Criteria andComYphoneLike(String value) {
            addCriterion("COM_YPHONE like", value, "comYphone");
            return (Criteria) this;
        }

        public Criteria andComYphoneNotLike(String value) {
            addCriterion("COM_YPHONE not like", value, "comYphone");
            return (Criteria) this;
        }

        public Criteria andComYphoneIn(List<String> values) {
            addCriterion("COM_YPHONE in", values, "comYphone");
            return (Criteria) this;
        }

        public Criteria andComYphoneNotIn(List<String> values) {
            addCriterion("COM_YPHONE not in", values, "comYphone");
            return (Criteria) this;
        }

        public Criteria andComYphoneBetween(String value1, String value2) {
            addCriterion("COM_YPHONE between", value1, value2, "comYphone");
            return (Criteria) this;
        }

        public Criteria andComYphoneNotBetween(String value1, String value2) {
            addCriterion("COM_YPHONE not between", value1, value2, "comYphone");
            return (Criteria) this;
        }

        public Criteria andComFaxIsNull() {
            addCriterion("COM_FAX is null");
            return (Criteria) this;
        }

        public Criteria andComFaxIsNotNull() {
            addCriterion("COM_FAX is not null");
            return (Criteria) this;
        }

        public Criteria andComFaxEqualTo(String value) {
            addCriterion("COM_FAX =", value, "comFax");
            return (Criteria) this;
        }

        public Criteria andComFaxNotEqualTo(String value) {
            addCriterion("COM_FAX <>", value, "comFax");
            return (Criteria) this;
        }

        public Criteria andComFaxGreaterThan(String value) {
            addCriterion("COM_FAX >", value, "comFax");
            return (Criteria) this;
        }

        public Criteria andComFaxGreaterThanOrEqualTo(String value) {
            addCriterion("COM_FAX >=", value, "comFax");
            return (Criteria) this;
        }

        public Criteria andComFaxLessThan(String value) {
            addCriterion("COM_FAX <", value, "comFax");
            return (Criteria) this;
        }

        public Criteria andComFaxLessThanOrEqualTo(String value) {
            addCriterion("COM_FAX <=", value, "comFax");
            return (Criteria) this;
        }

        public Criteria andComFaxLike(String value) {
            addCriterion("COM_FAX like", value, "comFax");
            return (Criteria) this;
        }

        public Criteria andComFaxNotLike(String value) {
            addCriterion("COM_FAX not like", value, "comFax");
            return (Criteria) this;
        }

        public Criteria andComFaxIn(List<String> values) {
            addCriterion("COM_FAX in", values, "comFax");
            return (Criteria) this;
        }

        public Criteria andComFaxNotIn(List<String> values) {
            addCriterion("COM_FAX not in", values, "comFax");
            return (Criteria) this;
        }

        public Criteria andComFaxBetween(String value1, String value2) {
            addCriterion("COM_FAX between", value1, value2, "comFax");
            return (Criteria) this;
        }

        public Criteria andComFaxNotBetween(String value1, String value2) {
            addCriterion("COM_FAX not between", value1, value2, "comFax");
            return (Criteria) this;
        }

        public Criteria andComBankIsNull() {
            addCriterion("COM_BANK is null");
            return (Criteria) this;
        }

        public Criteria andComBankIsNotNull() {
            addCriterion("COM_BANK is not null");
            return (Criteria) this;
        }

        public Criteria andComBankEqualTo(String value) {
            addCriterion("COM_BANK =", value, "comBank");
            return (Criteria) this;
        }

        public Criteria andComBankNotEqualTo(String value) {
            addCriterion("COM_BANK <>", value, "comBank");
            return (Criteria) this;
        }

        public Criteria andComBankGreaterThan(String value) {
            addCriterion("COM_BANK >", value, "comBank");
            return (Criteria) this;
        }

        public Criteria andComBankGreaterThanOrEqualTo(String value) {
            addCriterion("COM_BANK >=", value, "comBank");
            return (Criteria) this;
        }

        public Criteria andComBankLessThan(String value) {
            addCriterion("COM_BANK <", value, "comBank");
            return (Criteria) this;
        }

        public Criteria andComBankLessThanOrEqualTo(String value) {
            addCriterion("COM_BANK <=", value, "comBank");
            return (Criteria) this;
        }

        public Criteria andComBankLike(String value) {
            addCriterion("COM_BANK like", value, "comBank");
            return (Criteria) this;
        }

        public Criteria andComBankNotLike(String value) {
            addCriterion("COM_BANK not like", value, "comBank");
            return (Criteria) this;
        }

        public Criteria andComBankIn(List<String> values) {
            addCriterion("COM_BANK in", values, "comBank");
            return (Criteria) this;
        }

        public Criteria andComBankNotIn(List<String> values) {
            addCriterion("COM_BANK not in", values, "comBank");
            return (Criteria) this;
        }

        public Criteria andComBankBetween(String value1, String value2) {
            addCriterion("COM_BANK between", value1, value2, "comBank");
            return (Criteria) this;
        }

        public Criteria andComBankNotBetween(String value1, String value2) {
            addCriterion("COM_BANK not between", value1, value2, "comBank");
            return (Criteria) this;
        }

        public Criteria andComBankuserIsNull() {
            addCriterion("COM_BANKUSER is null");
            return (Criteria) this;
        }

        public Criteria andComBankuserIsNotNull() {
            addCriterion("COM_BANKUSER is not null");
            return (Criteria) this;
        }

        public Criteria andComBankuserEqualTo(String value) {
            addCriterion("COM_BANKUSER =", value, "comBankuser");
            return (Criteria) this;
        }

        public Criteria andComBankuserNotEqualTo(String value) {
            addCriterion("COM_BANKUSER <>", value, "comBankuser");
            return (Criteria) this;
        }

        public Criteria andComBankuserGreaterThan(String value) {
            addCriterion("COM_BANKUSER >", value, "comBankuser");
            return (Criteria) this;
        }

        public Criteria andComBankuserGreaterThanOrEqualTo(String value) {
            addCriterion("COM_BANKUSER >=", value, "comBankuser");
            return (Criteria) this;
        }

        public Criteria andComBankuserLessThan(String value) {
            addCriterion("COM_BANKUSER <", value, "comBankuser");
            return (Criteria) this;
        }

        public Criteria andComBankuserLessThanOrEqualTo(String value) {
            addCriterion("COM_BANKUSER <=", value, "comBankuser");
            return (Criteria) this;
        }

        public Criteria andComBankuserLike(String value) {
            addCriterion("COM_BANKUSER like", value, "comBankuser");
            return (Criteria) this;
        }

        public Criteria andComBankuserNotLike(String value) {
            addCriterion("COM_BANKUSER not like", value, "comBankuser");
            return (Criteria) this;
        }

        public Criteria andComBankuserIn(List<String> values) {
            addCriterion("COM_BANKUSER in", values, "comBankuser");
            return (Criteria) this;
        }

        public Criteria andComBankuserNotIn(List<String> values) {
            addCriterion("COM_BANKUSER not in", values, "comBankuser");
            return (Criteria) this;
        }

        public Criteria andComBankuserBetween(String value1, String value2) {
            addCriterion("COM_BANKUSER between", value1, value2, "comBankuser");
            return (Criteria) this;
        }

        public Criteria andComBankuserNotBetween(String value1, String value2) {
            addCriterion("COM_BANKUSER not between", value1, value2, "comBankuser");
            return (Criteria) this;
        }

        public Criteria andComYesandnoIsNull() {
            addCriterion("COM_YESANDNO is null");
            return (Criteria) this;
        }

        public Criteria andComYesandnoIsNotNull() {
            addCriterion("COM_YESANDNO is not null");
            return (Criteria) this;
        }

        public Criteria andComYesandnoEqualTo(String value) {
            addCriterion("COM_YESANDNO =", value, "comYesandno");
            return (Criteria) this;
        }

        public Criteria andComYesandnoNotEqualTo(String value) {
            addCriterion("COM_YESANDNO <>", value, "comYesandno");
            return (Criteria) this;
        }

        public Criteria andComYesandnoGreaterThan(String value) {
            addCriterion("COM_YESANDNO >", value, "comYesandno");
            return (Criteria) this;
        }

        public Criteria andComYesandnoGreaterThanOrEqualTo(String value) {
            addCriterion("COM_YESANDNO >=", value, "comYesandno");
            return (Criteria) this;
        }

        public Criteria andComYesandnoLessThan(String value) {
            addCriterion("COM_YESANDNO <", value, "comYesandno");
            return (Criteria) this;
        }

        public Criteria andComYesandnoLessThanOrEqualTo(String value) {
            addCriterion("COM_YESANDNO <=", value, "comYesandno");
            return (Criteria) this;
        }

        public Criteria andComYesandnoLike(String value) {
            addCriterion("COM_YESANDNO like", value, "comYesandno");
            return (Criteria) this;
        }

        public Criteria andComYesandnoNotLike(String value) {
            addCriterion("COM_YESANDNO not like", value, "comYesandno");
            return (Criteria) this;
        }

        public Criteria andComYesandnoIn(List<String> values) {
            addCriterion("COM_YESANDNO in", values, "comYesandno");
            return (Criteria) this;
        }

        public Criteria andComYesandnoNotIn(List<String> values) {
            addCriterion("COM_YESANDNO not in", values, "comYesandno");
            return (Criteria) this;
        }

        public Criteria andComYesandnoBetween(String value1, String value2) {
            addCriterion("COM_YESANDNO between", value1, value2, "comYesandno");
            return (Criteria) this;
        }

        public Criteria andComYesandnoNotBetween(String value1, String value2) {
            addCriterion("COM_YESANDNO not between", value1, value2, "comYesandno");
            return (Criteria) this;
        }

        public Criteria andComRemarkIsNull() {
            addCriterion("COM_REMARK is null");
            return (Criteria) this;
        }

        public Criteria andComRemarkIsNotNull() {
            addCriterion("COM_REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andComRemarkEqualTo(String value) {
            addCriterion("COM_REMARK =", value, "comRemark");
            return (Criteria) this;
        }

        public Criteria andComRemarkNotEqualTo(String value) {
            addCriterion("COM_REMARK <>", value, "comRemark");
            return (Criteria) this;
        }

        public Criteria andComRemarkGreaterThan(String value) {
            addCriterion("COM_REMARK >", value, "comRemark");
            return (Criteria) this;
        }

        public Criteria andComRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("COM_REMARK >=", value, "comRemark");
            return (Criteria) this;
        }

        public Criteria andComRemarkLessThan(String value) {
            addCriterion("COM_REMARK <", value, "comRemark");
            return (Criteria) this;
        }

        public Criteria andComRemarkLessThanOrEqualTo(String value) {
            addCriterion("COM_REMARK <=", value, "comRemark");
            return (Criteria) this;
        }

        public Criteria andComRemarkLike(String value) {
            addCriterion("COM_REMARK like", value, "comRemark");
            return (Criteria) this;
        }

        public Criteria andComRemarkNotLike(String value) {
            addCriterion("COM_REMARK not like", value, "comRemark");
            return (Criteria) this;
        }

        public Criteria andComRemarkIn(List<String> values) {
            addCriterion("COM_REMARK in", values, "comRemark");
            return (Criteria) this;
        }

        public Criteria andComRemarkNotIn(List<String> values) {
            addCriterion("COM_REMARK not in", values, "comRemark");
            return (Criteria) this;
        }

        public Criteria andComRemarkBetween(String value1, String value2) {
            addCriterion("COM_REMARK between", value1, value2, "comRemark");
            return (Criteria) this;
        }

        public Criteria andComRemarkNotBetween(String value1, String value2) {
            addCriterion("COM_REMARK not between", value1, value2, "comRemark");
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