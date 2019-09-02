package com.sc.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysEmpuserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysEmpuserExample() {
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

        public Criteria andEmpIdIsNull() {
            addCriterion("EMP_ID is null");
            return (Criteria) this;
        }

        public Criteria andEmpIdIsNotNull() {
            addCriterion("EMP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andEmpIdEqualTo(Long value) {
            addCriterion("EMP_ID =", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotEqualTo(Long value) {
            addCriterion("EMP_ID <>", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdGreaterThan(Long value) {
            addCriterion("EMP_ID >", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdGreaterThanOrEqualTo(Long value) {
            addCriterion("EMP_ID >=", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdLessThan(Long value) {
            addCriterion("EMP_ID <", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdLessThanOrEqualTo(Long value) {
            addCriterion("EMP_ID <=", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdIn(List<Long> values) {
            addCriterion("EMP_ID in", values, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotIn(List<Long> values) {
            addCriterion("EMP_ID not in", values, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdBetween(Long value1, Long value2) {
            addCriterion("EMP_ID between", value1, value2, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotBetween(Long value1, Long value2) {
            addCriterion("EMP_ID not between", value1, value2, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpNameIsNull() {
            addCriterion("EMP_NAME is null");
            return (Criteria) this;
        }

        public Criteria andEmpNameIsNotNull() {
            addCriterion("EMP_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andEmpNameEqualTo(String value) {
            addCriterion("EMP_NAME =", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameNotEqualTo(String value) {
            addCriterion("EMP_NAME <>", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameGreaterThan(String value) {
            addCriterion("EMP_NAME >", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameGreaterThanOrEqualTo(String value) {
            addCriterion("EMP_NAME >=", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameLessThan(String value) {
            addCriterion("EMP_NAME <", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameLessThanOrEqualTo(String value) {
            addCriterion("EMP_NAME <=", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameLike(String value) {
            addCriterion("EMP_NAME like", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameNotLike(String value) {
            addCriterion("EMP_NAME not like", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameIn(List<String> values) {
            addCriterion("EMP_NAME in", values, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameNotIn(List<String> values) {
            addCriterion("EMP_NAME not in", values, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameBetween(String value1, String value2) {
            addCriterion("EMP_NAME between", value1, value2, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameNotBetween(String value1, String value2) {
            addCriterion("EMP_NAME not between", value1, value2, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpSixIsNull() {
            addCriterion("EMP_SIX is null");
            return (Criteria) this;
        }

        public Criteria andEmpSixIsNotNull() {
            addCriterion("EMP_SIX is not null");
            return (Criteria) this;
        }

        public Criteria andEmpSixEqualTo(String value) {
            addCriterion("EMP_SIX =", value, "empSix");
            return (Criteria) this;
        }

        public Criteria andEmpSixNotEqualTo(String value) {
            addCriterion("EMP_SIX <>", value, "empSix");
            return (Criteria) this;
        }

        public Criteria andEmpSixGreaterThan(String value) {
            addCriterion("EMP_SIX >", value, "empSix");
            return (Criteria) this;
        }

        public Criteria andEmpSixGreaterThanOrEqualTo(String value) {
            addCriterion("EMP_SIX >=", value, "empSix");
            return (Criteria) this;
        }

        public Criteria andEmpSixLessThan(String value) {
            addCriterion("EMP_SIX <", value, "empSix");
            return (Criteria) this;
        }

        public Criteria andEmpSixLessThanOrEqualTo(String value) {
            addCriterion("EMP_SIX <=", value, "empSix");
            return (Criteria) this;
        }

        public Criteria andEmpSixLike(String value) {
            addCriterion("EMP_SIX like", value, "empSix");
            return (Criteria) this;
        }

        public Criteria andEmpSixNotLike(String value) {
            addCriterion("EMP_SIX not like", value, "empSix");
            return (Criteria) this;
        }

        public Criteria andEmpSixIn(List<String> values) {
            addCriterion("EMP_SIX in", values, "empSix");
            return (Criteria) this;
        }

        public Criteria andEmpSixNotIn(List<String> values) {
            addCriterion("EMP_SIX not in", values, "empSix");
            return (Criteria) this;
        }

        public Criteria andEmpSixBetween(String value1, String value2) {
            addCriterion("EMP_SIX between", value1, value2, "empSix");
            return (Criteria) this;
        }

        public Criteria andEmpSixNotBetween(String value1, String value2) {
            addCriterion("EMP_SIX not between", value1, value2, "empSix");
            return (Criteria) this;
        }

        public Criteria andEmpPriceIsNull() {
            addCriterion("EMP_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andEmpPriceIsNotNull() {
            addCriterion("EMP_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andEmpPriceEqualTo(String value) {
            addCriterion("EMP_PRICE =", value, "empPrice");
            return (Criteria) this;
        }

        public Criteria andEmpPriceNotEqualTo(String value) {
            addCriterion("EMP_PRICE <>", value, "empPrice");
            return (Criteria) this;
        }

        public Criteria andEmpPriceGreaterThan(String value) {
            addCriterion("EMP_PRICE >", value, "empPrice");
            return (Criteria) this;
        }

        public Criteria andEmpPriceGreaterThanOrEqualTo(String value) {
            addCriterion("EMP_PRICE >=", value, "empPrice");
            return (Criteria) this;
        }

        public Criteria andEmpPriceLessThan(String value) {
            addCriterion("EMP_PRICE <", value, "empPrice");
            return (Criteria) this;
        }

        public Criteria andEmpPriceLessThanOrEqualTo(String value) {
            addCriterion("EMP_PRICE <=", value, "empPrice");
            return (Criteria) this;
        }

        public Criteria andEmpPriceLike(String value) {
            addCriterion("EMP_PRICE like", value, "empPrice");
            return (Criteria) this;
        }

        public Criteria andEmpPriceNotLike(String value) {
            addCriterion("EMP_PRICE not like", value, "empPrice");
            return (Criteria) this;
        }

        public Criteria andEmpPriceIn(List<String> values) {
            addCriterion("EMP_PRICE in", values, "empPrice");
            return (Criteria) this;
        }

        public Criteria andEmpPriceNotIn(List<String> values) {
            addCriterion("EMP_PRICE not in", values, "empPrice");
            return (Criteria) this;
        }

        public Criteria andEmpPriceBetween(String value1, String value2) {
            addCriterion("EMP_PRICE between", value1, value2, "empPrice");
            return (Criteria) this;
        }

        public Criteria andEmpPriceNotBetween(String value1, String value2) {
            addCriterion("EMP_PRICE not between", value1, value2, "empPrice");
            return (Criteria) this;
        }

        public Criteria andEmpNumberIsNull() {
            addCriterion("EMP_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andEmpNumberIsNotNull() {
            addCriterion("EMP_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andEmpNumberEqualTo(String value) {
            addCriterion("EMP_NUMBER =", value, "empNumber");
            return (Criteria) this;
        }

        public Criteria andEmpNumberNotEqualTo(String value) {
            addCriterion("EMP_NUMBER <>", value, "empNumber");
            return (Criteria) this;
        }

        public Criteria andEmpNumberGreaterThan(String value) {
            addCriterion("EMP_NUMBER >", value, "empNumber");
            return (Criteria) this;
        }

        public Criteria andEmpNumberGreaterThanOrEqualTo(String value) {
            addCriterion("EMP_NUMBER >=", value, "empNumber");
            return (Criteria) this;
        }

        public Criteria andEmpNumberLessThan(String value) {
            addCriterion("EMP_NUMBER <", value, "empNumber");
            return (Criteria) this;
        }

        public Criteria andEmpNumberLessThanOrEqualTo(String value) {
            addCriterion("EMP_NUMBER <=", value, "empNumber");
            return (Criteria) this;
        }

        public Criteria andEmpNumberLike(String value) {
            addCriterion("EMP_NUMBER like", value, "empNumber");
            return (Criteria) this;
        }

        public Criteria andEmpNumberNotLike(String value) {
            addCriterion("EMP_NUMBER not like", value, "empNumber");
            return (Criteria) this;
        }

        public Criteria andEmpNumberIn(List<String> values) {
            addCriterion("EMP_NUMBER in", values, "empNumber");
            return (Criteria) this;
        }

        public Criteria andEmpNumberNotIn(List<String> values) {
            addCriterion("EMP_NUMBER not in", values, "empNumber");
            return (Criteria) this;
        }

        public Criteria andEmpNumberBetween(String value1, String value2) {
            addCriterion("EMP_NUMBER between", value1, value2, "empNumber");
            return (Criteria) this;
        }

        public Criteria andEmpNumberNotBetween(String value1, String value2) {
            addCriterion("EMP_NUMBER not between", value1, value2, "empNumber");
            return (Criteria) this;
        }

        public Criteria andEmpAddressIsNull() {
            addCriterion("EMP_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andEmpAddressIsNotNull() {
            addCriterion("EMP_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andEmpAddressEqualTo(String value) {
            addCriterion("EMP_ADDRESS =", value, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressNotEqualTo(String value) {
            addCriterion("EMP_ADDRESS <>", value, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressGreaterThan(String value) {
            addCriterion("EMP_ADDRESS >", value, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressGreaterThanOrEqualTo(String value) {
            addCriterion("EMP_ADDRESS >=", value, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressLessThan(String value) {
            addCriterion("EMP_ADDRESS <", value, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressLessThanOrEqualTo(String value) {
            addCriterion("EMP_ADDRESS <=", value, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressLike(String value) {
            addCriterion("EMP_ADDRESS like", value, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressNotLike(String value) {
            addCriterion("EMP_ADDRESS not like", value, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressIn(List<String> values) {
            addCriterion("EMP_ADDRESS in", values, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressNotIn(List<String> values) {
            addCriterion("EMP_ADDRESS not in", values, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressBetween(String value1, String value2) {
            addCriterion("EMP_ADDRESS between", value1, value2, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressNotBetween(String value1, String value2) {
            addCriterion("EMP_ADDRESS not between", value1, value2, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpTadayaddIsNull() {
            addCriterion("EMP_TADAYADD is null");
            return (Criteria) this;
        }

        public Criteria andEmpTadayaddIsNotNull() {
            addCriterion("EMP_TADAYADD is not null");
            return (Criteria) this;
        }

        public Criteria andEmpTadayaddEqualTo(String value) {
            addCriterion("EMP_TADAYADD =", value, "empTadayadd");
            return (Criteria) this;
        }

        public Criteria andEmpTadayaddNotEqualTo(String value) {
            addCriterion("EMP_TADAYADD <>", value, "empTadayadd");
            return (Criteria) this;
        }

        public Criteria andEmpTadayaddGreaterThan(String value) {
            addCriterion("EMP_TADAYADD >", value, "empTadayadd");
            return (Criteria) this;
        }

        public Criteria andEmpTadayaddGreaterThanOrEqualTo(String value) {
            addCriterion("EMP_TADAYADD >=", value, "empTadayadd");
            return (Criteria) this;
        }

        public Criteria andEmpTadayaddLessThan(String value) {
            addCriterion("EMP_TADAYADD <", value, "empTadayadd");
            return (Criteria) this;
        }

        public Criteria andEmpTadayaddLessThanOrEqualTo(String value) {
            addCriterion("EMP_TADAYADD <=", value, "empTadayadd");
            return (Criteria) this;
        }

        public Criteria andEmpTadayaddLike(String value) {
            addCriterion("EMP_TADAYADD like", value, "empTadayadd");
            return (Criteria) this;
        }

        public Criteria andEmpTadayaddNotLike(String value) {
            addCriterion("EMP_TADAYADD not like", value, "empTadayadd");
            return (Criteria) this;
        }

        public Criteria andEmpTadayaddIn(List<String> values) {
            addCriterion("EMP_TADAYADD in", values, "empTadayadd");
            return (Criteria) this;
        }

        public Criteria andEmpTadayaddNotIn(List<String> values) {
            addCriterion("EMP_TADAYADD not in", values, "empTadayadd");
            return (Criteria) this;
        }

        public Criteria andEmpTadayaddBetween(String value1, String value2) {
            addCriterion("EMP_TADAYADD between", value1, value2, "empTadayadd");
            return (Criteria) this;
        }

        public Criteria andEmpTadayaddNotBetween(String value1, String value2) {
            addCriterion("EMP_TADAYADD not between", value1, value2, "empTadayadd");
            return (Criteria) this;
        }

        public Criteria andEmpEducaIsNull() {
            addCriterion("EMP_EDUCA is null");
            return (Criteria) this;
        }

        public Criteria andEmpEducaIsNotNull() {
            addCriterion("EMP_EDUCA is not null");
            return (Criteria) this;
        }

        public Criteria andEmpEducaEqualTo(String value) {
            addCriterion("EMP_EDUCA =", value, "empEduca");
            return (Criteria) this;
        }

        public Criteria andEmpEducaNotEqualTo(String value) {
            addCriterion("EMP_EDUCA <>", value, "empEduca");
            return (Criteria) this;
        }

        public Criteria andEmpEducaGreaterThan(String value) {
            addCriterion("EMP_EDUCA >", value, "empEduca");
            return (Criteria) this;
        }

        public Criteria andEmpEducaGreaterThanOrEqualTo(String value) {
            addCriterion("EMP_EDUCA >=", value, "empEduca");
            return (Criteria) this;
        }

        public Criteria andEmpEducaLessThan(String value) {
            addCriterion("EMP_EDUCA <", value, "empEduca");
            return (Criteria) this;
        }

        public Criteria andEmpEducaLessThanOrEqualTo(String value) {
            addCriterion("EMP_EDUCA <=", value, "empEduca");
            return (Criteria) this;
        }

        public Criteria andEmpEducaLike(String value) {
            addCriterion("EMP_EDUCA like", value, "empEduca");
            return (Criteria) this;
        }

        public Criteria andEmpEducaNotLike(String value) {
            addCriterion("EMP_EDUCA not like", value, "empEduca");
            return (Criteria) this;
        }

        public Criteria andEmpEducaIn(List<String> values) {
            addCriterion("EMP_EDUCA in", values, "empEduca");
            return (Criteria) this;
        }

        public Criteria andEmpEducaNotIn(List<String> values) {
            addCriterion("EMP_EDUCA not in", values, "empEduca");
            return (Criteria) this;
        }

        public Criteria andEmpEducaBetween(String value1, String value2) {
            addCriterion("EMP_EDUCA between", value1, value2, "empEduca");
            return (Criteria) this;
        }

        public Criteria andEmpEducaNotBetween(String value1, String value2) {
            addCriterion("EMP_EDUCA not between", value1, value2, "empEduca");
            return (Criteria) this;
        }

        public Criteria andEmpFaceIsNull() {
            addCriterion("EMP_FACE is null");
            return (Criteria) this;
        }

        public Criteria andEmpFaceIsNotNull() {
            addCriterion("EMP_FACE is not null");
            return (Criteria) this;
        }

        public Criteria andEmpFaceEqualTo(String value) {
            addCriterion("EMP_FACE =", value, "empFace");
            return (Criteria) this;
        }

        public Criteria andEmpFaceNotEqualTo(String value) {
            addCriterion("EMP_FACE <>", value, "empFace");
            return (Criteria) this;
        }

        public Criteria andEmpFaceGreaterThan(String value) {
            addCriterion("EMP_FACE >", value, "empFace");
            return (Criteria) this;
        }

        public Criteria andEmpFaceGreaterThanOrEqualTo(String value) {
            addCriterion("EMP_FACE >=", value, "empFace");
            return (Criteria) this;
        }

        public Criteria andEmpFaceLessThan(String value) {
            addCriterion("EMP_FACE <", value, "empFace");
            return (Criteria) this;
        }

        public Criteria andEmpFaceLessThanOrEqualTo(String value) {
            addCriterion("EMP_FACE <=", value, "empFace");
            return (Criteria) this;
        }

        public Criteria andEmpFaceLike(String value) {
            addCriterion("EMP_FACE like", value, "empFace");
            return (Criteria) this;
        }

        public Criteria andEmpFaceNotLike(String value) {
            addCriterion("EMP_FACE not like", value, "empFace");
            return (Criteria) this;
        }

        public Criteria andEmpFaceIn(List<String> values) {
            addCriterion("EMP_FACE in", values, "empFace");
            return (Criteria) this;
        }

        public Criteria andEmpFaceNotIn(List<String> values) {
            addCriterion("EMP_FACE not in", values, "empFace");
            return (Criteria) this;
        }

        public Criteria andEmpFaceBetween(String value1, String value2) {
            addCriterion("EMP_FACE between", value1, value2, "empFace");
            return (Criteria) this;
        }

        public Criteria andEmpFaceNotBetween(String value1, String value2) {
            addCriterion("EMP_FACE not between", value1, value2, "empFace");
            return (Criteria) this;
        }

        public Criteria andEmpSchoolIsNull() {
            addCriterion("EMP_SCHOOL is null");
            return (Criteria) this;
        }

        public Criteria andEmpSchoolIsNotNull() {
            addCriterion("EMP_SCHOOL is not null");
            return (Criteria) this;
        }

        public Criteria andEmpSchoolEqualTo(String value) {
            addCriterion("EMP_SCHOOL =", value, "empSchool");
            return (Criteria) this;
        }

        public Criteria andEmpSchoolNotEqualTo(String value) {
            addCriterion("EMP_SCHOOL <>", value, "empSchool");
            return (Criteria) this;
        }

        public Criteria andEmpSchoolGreaterThan(String value) {
            addCriterion("EMP_SCHOOL >", value, "empSchool");
            return (Criteria) this;
        }

        public Criteria andEmpSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("EMP_SCHOOL >=", value, "empSchool");
            return (Criteria) this;
        }

        public Criteria andEmpSchoolLessThan(String value) {
            addCriterion("EMP_SCHOOL <", value, "empSchool");
            return (Criteria) this;
        }

        public Criteria andEmpSchoolLessThanOrEqualTo(String value) {
            addCriterion("EMP_SCHOOL <=", value, "empSchool");
            return (Criteria) this;
        }

        public Criteria andEmpSchoolLike(String value) {
            addCriterion("EMP_SCHOOL like", value, "empSchool");
            return (Criteria) this;
        }

        public Criteria andEmpSchoolNotLike(String value) {
            addCriterion("EMP_SCHOOL not like", value, "empSchool");
            return (Criteria) this;
        }

        public Criteria andEmpSchoolIn(List<String> values) {
            addCriterion("EMP_SCHOOL in", values, "empSchool");
            return (Criteria) this;
        }

        public Criteria andEmpSchoolNotIn(List<String> values) {
            addCriterion("EMP_SCHOOL not in", values, "empSchool");
            return (Criteria) this;
        }

        public Criteria andEmpSchoolBetween(String value1, String value2) {
            addCriterion("EMP_SCHOOL between", value1, value2, "empSchool");
            return (Criteria) this;
        }

        public Criteria andEmpSchoolNotBetween(String value1, String value2) {
            addCriterion("EMP_SCHOOL not between", value1, value2, "empSchool");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneIsNull() {
            addCriterion("EMP_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneIsNotNull() {
            addCriterion("EMP_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneEqualTo(String value) {
            addCriterion("EMP_PHONE =", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneNotEqualTo(String value) {
            addCriterion("EMP_PHONE <>", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneGreaterThan(String value) {
            addCriterion("EMP_PHONE >", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("EMP_PHONE >=", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneLessThan(String value) {
            addCriterion("EMP_PHONE <", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneLessThanOrEqualTo(String value) {
            addCriterion("EMP_PHONE <=", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneLike(String value) {
            addCriterion("EMP_PHONE like", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneNotLike(String value) {
            addCriterion("EMP_PHONE not like", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneIn(List<String> values) {
            addCriterion("EMP_PHONE in", values, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneNotIn(List<String> values) {
            addCriterion("EMP_PHONE not in", values, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneBetween(String value1, String value2) {
            addCriterion("EMP_PHONE between", value1, value2, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneNotBetween(String value1, String value2) {
            addCriterion("EMP_PHONE not between", value1, value2, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpMeshphoneIsNull() {
            addCriterion("EMP_MESHPHONE is null");
            return (Criteria) this;
        }

        public Criteria andEmpMeshphoneIsNotNull() {
            addCriterion("EMP_MESHPHONE is not null");
            return (Criteria) this;
        }

        public Criteria andEmpMeshphoneEqualTo(String value) {
            addCriterion("EMP_MESHPHONE =", value, "empMeshphone");
            return (Criteria) this;
        }

        public Criteria andEmpMeshphoneNotEqualTo(String value) {
            addCriterion("EMP_MESHPHONE <>", value, "empMeshphone");
            return (Criteria) this;
        }

        public Criteria andEmpMeshphoneGreaterThan(String value) {
            addCriterion("EMP_MESHPHONE >", value, "empMeshphone");
            return (Criteria) this;
        }

        public Criteria andEmpMeshphoneGreaterThanOrEqualTo(String value) {
            addCriterion("EMP_MESHPHONE >=", value, "empMeshphone");
            return (Criteria) this;
        }

        public Criteria andEmpMeshphoneLessThan(String value) {
            addCriterion("EMP_MESHPHONE <", value, "empMeshphone");
            return (Criteria) this;
        }

        public Criteria andEmpMeshphoneLessThanOrEqualTo(String value) {
            addCriterion("EMP_MESHPHONE <=", value, "empMeshphone");
            return (Criteria) this;
        }

        public Criteria andEmpMeshphoneLike(String value) {
            addCriterion("EMP_MESHPHONE like", value, "empMeshphone");
            return (Criteria) this;
        }

        public Criteria andEmpMeshphoneNotLike(String value) {
            addCriterion("EMP_MESHPHONE not like", value, "empMeshphone");
            return (Criteria) this;
        }

        public Criteria andEmpMeshphoneIn(List<String> values) {
            addCriterion("EMP_MESHPHONE in", values, "empMeshphone");
            return (Criteria) this;
        }

        public Criteria andEmpMeshphoneNotIn(List<String> values) {
            addCriterion("EMP_MESHPHONE not in", values, "empMeshphone");
            return (Criteria) this;
        }

        public Criteria andEmpMeshphoneBetween(String value1, String value2) {
            addCriterion("EMP_MESHPHONE between", value1, value2, "empMeshphone");
            return (Criteria) this;
        }

        public Criteria andEmpMeshphoneNotBetween(String value1, String value2) {
            addCriterion("EMP_MESHPHONE not between", value1, value2, "empMeshphone");
            return (Criteria) this;
        }

        public Criteria andEmpContactIsNull() {
            addCriterion("EMP_CONTACT is null");
            return (Criteria) this;
        }

        public Criteria andEmpContactIsNotNull() {
            addCriterion("EMP_CONTACT is not null");
            return (Criteria) this;
        }

        public Criteria andEmpContactEqualTo(String value) {
            addCriterion("EMP_CONTACT =", value, "empContact");
            return (Criteria) this;
        }

        public Criteria andEmpContactNotEqualTo(String value) {
            addCriterion("EMP_CONTACT <>", value, "empContact");
            return (Criteria) this;
        }

        public Criteria andEmpContactGreaterThan(String value) {
            addCriterion("EMP_CONTACT >", value, "empContact");
            return (Criteria) this;
        }

        public Criteria andEmpContactGreaterThanOrEqualTo(String value) {
            addCriterion("EMP_CONTACT >=", value, "empContact");
            return (Criteria) this;
        }

        public Criteria andEmpContactLessThan(String value) {
            addCriterion("EMP_CONTACT <", value, "empContact");
            return (Criteria) this;
        }

        public Criteria andEmpContactLessThanOrEqualTo(String value) {
            addCriterion("EMP_CONTACT <=", value, "empContact");
            return (Criteria) this;
        }

        public Criteria andEmpContactLike(String value) {
            addCriterion("EMP_CONTACT like", value, "empContact");
            return (Criteria) this;
        }

        public Criteria andEmpContactNotLike(String value) {
            addCriterion("EMP_CONTACT not like", value, "empContact");
            return (Criteria) this;
        }

        public Criteria andEmpContactIn(List<String> values) {
            addCriterion("EMP_CONTACT in", values, "empContact");
            return (Criteria) this;
        }

        public Criteria andEmpContactNotIn(List<String> values) {
            addCriterion("EMP_CONTACT not in", values, "empContact");
            return (Criteria) this;
        }

        public Criteria andEmpContactBetween(String value1, String value2) {
            addCriterion("EMP_CONTACT between", value1, value2, "empContact");
            return (Criteria) this;
        }

        public Criteria andEmpContactNotBetween(String value1, String value2) {
            addCriterion("EMP_CONTACT not between", value1, value2, "empContact");
            return (Criteria) this;
        }

        public Criteria andEmpStateIsNull() {
            addCriterion("EMP_STATE is null");
            return (Criteria) this;
        }

        public Criteria andEmpStateIsNotNull() {
            addCriterion("EMP_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andEmpStateEqualTo(String value) {
            addCriterion("EMP_STATE =", value, "empState");
            return (Criteria) this;
        }

        public Criteria andEmpStateNotEqualTo(String value) {
            addCriterion("EMP_STATE <>", value, "empState");
            return (Criteria) this;
        }

        public Criteria andEmpStateGreaterThan(String value) {
            addCriterion("EMP_STATE >", value, "empState");
            return (Criteria) this;
        }

        public Criteria andEmpStateGreaterThanOrEqualTo(String value) {
            addCriterion("EMP_STATE >=", value, "empState");
            return (Criteria) this;
        }

        public Criteria andEmpStateLessThan(String value) {
            addCriterion("EMP_STATE <", value, "empState");
            return (Criteria) this;
        }

        public Criteria andEmpStateLessThanOrEqualTo(String value) {
            addCriterion("EMP_STATE <=", value, "empState");
            return (Criteria) this;
        }

        public Criteria andEmpStateLike(String value) {
            addCriterion("EMP_STATE like", value, "empState");
            return (Criteria) this;
        }

        public Criteria andEmpStateNotLike(String value) {
            addCriterion("EMP_STATE not like", value, "empState");
            return (Criteria) this;
        }

        public Criteria andEmpStateIn(List<String> values) {
            addCriterion("EMP_STATE in", values, "empState");
            return (Criteria) this;
        }

        public Criteria andEmpStateNotIn(List<String> values) {
            addCriterion("EMP_STATE not in", values, "empState");
            return (Criteria) this;
        }

        public Criteria andEmpStateBetween(String value1, String value2) {
            addCriterion("EMP_STATE between", value1, value2, "empState");
            return (Criteria) this;
        }

        public Criteria andEmpStateNotBetween(String value1, String value2) {
            addCriterion("EMP_STATE not between", value1, value2, "empState");
            return (Criteria) this;
        }

        public Criteria andDutIdIsNull() {
            addCriterion("DUT_ID is null");
            return (Criteria) this;
        }

        public Criteria andDutIdIsNotNull() {
            addCriterion("DUT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDutIdEqualTo(Long value) {
            addCriterion("DUT_ID =", value, "dutId");
            return (Criteria) this;
        }

        public Criteria andDutIdNotEqualTo(Long value) {
            addCriterion("DUT_ID <>", value, "dutId");
            return (Criteria) this;
        }

        public Criteria andDutIdGreaterThan(Long value) {
            addCriterion("DUT_ID >", value, "dutId");
            return (Criteria) this;
        }

        public Criteria andDutIdGreaterThanOrEqualTo(Long value) {
            addCriterion("DUT_ID >=", value, "dutId");
            return (Criteria) this;
        }

        public Criteria andDutIdLessThan(Long value) {
            addCriterion("DUT_ID <", value, "dutId");
            return (Criteria) this;
        }

        public Criteria andDutIdLessThanOrEqualTo(Long value) {
            addCriterion("DUT_ID <=", value, "dutId");
            return (Criteria) this;
        }

        public Criteria andDutIdIn(List<Long> values) {
            addCriterion("DUT_ID in", values, "dutId");
            return (Criteria) this;
        }

        public Criteria andDutIdNotIn(List<Long> values) {
            addCriterion("DUT_ID not in", values, "dutId");
            return (Criteria) this;
        }

        public Criteria andDutIdBetween(Long value1, Long value2) {
            addCriterion("DUT_ID between", value1, value2, "dutId");
            return (Criteria) this;
        }

        public Criteria andDutIdNotBetween(Long value1, Long value2) {
            addCriterion("DUT_ID not between", value1, value2, "dutId");
            return (Criteria) this;
        }

        public Criteria andEmpSysstateIsNull() {
            addCriterion("EMP_SYSSTATE is null");
            return (Criteria) this;
        }

        public Criteria andEmpSysstateIsNotNull() {
            addCriterion("EMP_SYSSTATE is not null");
            return (Criteria) this;
        }

        public Criteria andEmpSysstateEqualTo(String value) {
            addCriterion("EMP_SYSSTATE =", value, "empSysstate");
            return (Criteria) this;
        }

        public Criteria andEmpSysstateNotEqualTo(String value) {
            addCriterion("EMP_SYSSTATE <>", value, "empSysstate");
            return (Criteria) this;
        }

        public Criteria andEmpSysstateGreaterThan(String value) {
            addCriterion("EMP_SYSSTATE >", value, "empSysstate");
            return (Criteria) this;
        }

        public Criteria andEmpSysstateGreaterThanOrEqualTo(String value) {
            addCriterion("EMP_SYSSTATE >=", value, "empSysstate");
            return (Criteria) this;
        }

        public Criteria andEmpSysstateLessThan(String value) {
            addCriterion("EMP_SYSSTATE <", value, "empSysstate");
            return (Criteria) this;
        }

        public Criteria andEmpSysstateLessThanOrEqualTo(String value) {
            addCriterion("EMP_SYSSTATE <=", value, "empSysstate");
            return (Criteria) this;
        }

        public Criteria andEmpSysstateLike(String value) {
            addCriterion("EMP_SYSSTATE like", value, "empSysstate");
            return (Criteria) this;
        }

        public Criteria andEmpSysstateNotLike(String value) {
            addCriterion("EMP_SYSSTATE not like", value, "empSysstate");
            return (Criteria) this;
        }

        public Criteria andEmpSysstateIn(List<String> values) {
            addCriterion("EMP_SYSSTATE in", values, "empSysstate");
            return (Criteria) this;
        }

        public Criteria andEmpSysstateNotIn(List<String> values) {
            addCriterion("EMP_SYSSTATE not in", values, "empSysstate");
            return (Criteria) this;
        }

        public Criteria andEmpSysstateBetween(String value1, String value2) {
            addCriterion("EMP_SYSSTATE between", value1, value2, "empSysstate");
            return (Criteria) this;
        }

        public Criteria andEmpSysstateNotBetween(String value1, String value2) {
            addCriterion("EMP_SYSSTATE not between", value1, value2, "empSysstate");
            return (Criteria) this;
        }

        public Criteria andEmpRemarkIsNull() {
            addCriterion("EMP_REMARK is null");
            return (Criteria) this;
        }

        public Criteria andEmpRemarkIsNotNull() {
            addCriterion("EMP_REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andEmpRemarkEqualTo(String value) {
            addCriterion("EMP_REMARK =", value, "empRemark");
            return (Criteria) this;
        }

        public Criteria andEmpRemarkNotEqualTo(String value) {
            addCriterion("EMP_REMARK <>", value, "empRemark");
            return (Criteria) this;
        }

        public Criteria andEmpRemarkGreaterThan(String value) {
            addCriterion("EMP_REMARK >", value, "empRemark");
            return (Criteria) this;
        }

        public Criteria andEmpRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("EMP_REMARK >=", value, "empRemark");
            return (Criteria) this;
        }

        public Criteria andEmpRemarkLessThan(String value) {
            addCriterion("EMP_REMARK <", value, "empRemark");
            return (Criteria) this;
        }

        public Criteria andEmpRemarkLessThanOrEqualTo(String value) {
            addCriterion("EMP_REMARK <=", value, "empRemark");
            return (Criteria) this;
        }

        public Criteria andEmpRemarkLike(String value) {
            addCriterion("EMP_REMARK like", value, "empRemark");
            return (Criteria) this;
        }

        public Criteria andEmpRemarkNotLike(String value) {
            addCriterion("EMP_REMARK not like", value, "empRemark");
            return (Criteria) this;
        }

        public Criteria andEmpRemarkIn(List<String> values) {
            addCriterion("EMP_REMARK in", values, "empRemark");
            return (Criteria) this;
        }

        public Criteria andEmpRemarkNotIn(List<String> values) {
            addCriterion("EMP_REMARK not in", values, "empRemark");
            return (Criteria) this;
        }

        public Criteria andEmpRemarkBetween(String value1, String value2) {
            addCriterion("EMP_REMARK between", value1, value2, "empRemark");
            return (Criteria) this;
        }

        public Criteria andEmpRemarkNotBetween(String value1, String value2) {
            addCriterion("EMP_REMARK not between", value1, value2, "empRemark");
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