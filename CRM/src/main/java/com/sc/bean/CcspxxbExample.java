package com.sc.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CcspxxbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CcspxxbExample() {
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

        public Criteria andSpMcIsNull() {
            addCriterion("SP_MC is null");
            return (Criteria) this;
        }

        public Criteria andSpMcIsNotNull() {
            addCriterion("SP_MC is not null");
            return (Criteria) this;
        }

        public Criteria andSpMcEqualTo(String value) {
            addCriterion("SP_MC =", value, "spMc");
            return (Criteria) this;
        }

        public Criteria andSpMcNotEqualTo(String value) {
            addCriterion("SP_MC <>", value, "spMc");
            return (Criteria) this;
        }

        public Criteria andSpMcGreaterThan(String value) {
            addCriterion("SP_MC >", value, "spMc");
            return (Criteria) this;
        }

        public Criteria andSpMcGreaterThanOrEqualTo(String value) {
            addCriterion("SP_MC >=", value, "spMc");
            return (Criteria) this;
        }

        public Criteria andSpMcLessThan(String value) {
            addCriterion("SP_MC <", value, "spMc");
            return (Criteria) this;
        }

        public Criteria andSpMcLessThanOrEqualTo(String value) {
            addCriterion("SP_MC <=", value, "spMc");
            return (Criteria) this;
        }

        public Criteria andSpMcLike(String value) {
            addCriterion("SP_MC like", value, "spMc");
            return (Criteria) this;
        }

        public Criteria andSpMcNotLike(String value) {
            addCriterion("SP_MC not like", value, "spMc");
            return (Criteria) this;
        }

        public Criteria andSpMcIn(List<String> values) {
            addCriterion("SP_MC in", values, "spMc");
            return (Criteria) this;
        }

        public Criteria andSpMcNotIn(List<String> values) {
            addCriterion("SP_MC not in", values, "spMc");
            return (Criteria) this;
        }

        public Criteria andSpMcBetween(String value1, String value2) {
            addCriterion("SP_MC between", value1, value2, "spMc");
            return (Criteria) this;
        }

        public Criteria andSpMcNotBetween(String value1, String value2) {
            addCriterion("SP_MC not between", value1, value2, "spMc");
            return (Criteria) this;
        }

        public Criteria andSpLbIsNull() {
            addCriterion("SP_LB is null");
            return (Criteria) this;
        }

        public Criteria andSpLbIsNotNull() {
            addCriterion("SP_LB is not null");
            return (Criteria) this;
        }

        public Criteria andSpLbEqualTo(String value) {
            addCriterion("SP_LB =", value, "spLb");
            return (Criteria) this;
        }

        public Criteria andSpLbNotEqualTo(String value) {
            addCriterion("SP_LB <>", value, "spLb");
            return (Criteria) this;
        }

        public Criteria andSpLbGreaterThan(String value) {
            addCriterion("SP_LB >", value, "spLb");
            return (Criteria) this;
        }

        public Criteria andSpLbGreaterThanOrEqualTo(String value) {
            addCriterion("SP_LB >=", value, "spLb");
            return (Criteria) this;
        }

        public Criteria andSpLbLessThan(String value) {
            addCriterion("SP_LB <", value, "spLb");
            return (Criteria) this;
        }

        public Criteria andSpLbLessThanOrEqualTo(String value) {
            addCriterion("SP_LB <=", value, "spLb");
            return (Criteria) this;
        }

        public Criteria andSpLbLike(String value) {
            addCriterion("SP_LB like", value, "spLb");
            return (Criteria) this;
        }

        public Criteria andSpLbNotLike(String value) {
            addCriterion("SP_LB not like", value, "spLb");
            return (Criteria) this;
        }

        public Criteria andSpLbIn(List<String> values) {
            addCriterion("SP_LB in", values, "spLb");
            return (Criteria) this;
        }

        public Criteria andSpLbNotIn(List<String> values) {
            addCriterion("SP_LB not in", values, "spLb");
            return (Criteria) this;
        }

        public Criteria andSpLbBetween(String value1, String value2) {
            addCriterion("SP_LB between", value1, value2, "spLb");
            return (Criteria) this;
        }

        public Criteria andSpLbNotBetween(String value1, String value2) {
            addCriterion("SP_LB not between", value1, value2, "spLb");
            return (Criteria) this;
        }

        public Criteria andGgSmIsNull() {
            addCriterion("GG_SM is null");
            return (Criteria) this;
        }

        public Criteria andGgSmIsNotNull() {
            addCriterion("GG_SM is not null");
            return (Criteria) this;
        }

        public Criteria andGgSmEqualTo(String value) {
            addCriterion("GG_SM =", value, "ggSm");
            return (Criteria) this;
        }

        public Criteria andGgSmNotEqualTo(String value) {
            addCriterion("GG_SM <>", value, "ggSm");
            return (Criteria) this;
        }

        public Criteria andGgSmGreaterThan(String value) {
            addCriterion("GG_SM >", value, "ggSm");
            return (Criteria) this;
        }

        public Criteria andGgSmGreaterThanOrEqualTo(String value) {
            addCriterion("GG_SM >=", value, "ggSm");
            return (Criteria) this;
        }

        public Criteria andGgSmLessThan(String value) {
            addCriterion("GG_SM <", value, "ggSm");
            return (Criteria) this;
        }

        public Criteria andGgSmLessThanOrEqualTo(String value) {
            addCriterion("GG_SM <=", value, "ggSm");
            return (Criteria) this;
        }

        public Criteria andGgSmLike(String value) {
            addCriterion("GG_SM like", value, "ggSm");
            return (Criteria) this;
        }

        public Criteria andGgSmNotLike(String value) {
            addCriterion("GG_SM not like", value, "ggSm");
            return (Criteria) this;
        }

        public Criteria andGgSmIn(List<String> values) {
            addCriterion("GG_SM in", values, "ggSm");
            return (Criteria) this;
        }

        public Criteria andGgSmNotIn(List<String> values) {
            addCriterion("GG_SM not in", values, "ggSm");
            return (Criteria) this;
        }

        public Criteria andGgSmBetween(String value1, String value2) {
            addCriterion("GG_SM between", value1, value2, "ggSm");
            return (Criteria) this;
        }

        public Criteria andGgSmNotBetween(String value1, String value2) {
            addCriterion("GG_SM not between", value1, value2, "ggSm");
            return (Criteria) this;
        }

        public Criteria andDwIsNull() {
            addCriterion("DW is null");
            return (Criteria) this;
        }

        public Criteria andDwIsNotNull() {
            addCriterion("DW is not null");
            return (Criteria) this;
        }

        public Criteria andDwEqualTo(String value) {
            addCriterion("DW =", value, "dw");
            return (Criteria) this;
        }

        public Criteria andDwNotEqualTo(String value) {
            addCriterion("DW <>", value, "dw");
            return (Criteria) this;
        }

        public Criteria andDwGreaterThan(String value) {
            addCriterion("DW >", value, "dw");
            return (Criteria) this;
        }

        public Criteria andDwGreaterThanOrEqualTo(String value) {
            addCriterion("DW >=", value, "dw");
            return (Criteria) this;
        }

        public Criteria andDwLessThan(String value) {
            addCriterion("DW <", value, "dw");
            return (Criteria) this;
        }

        public Criteria andDwLessThanOrEqualTo(String value) {
            addCriterion("DW <=", value, "dw");
            return (Criteria) this;
        }

        public Criteria andDwLike(String value) {
            addCriterion("DW like", value, "dw");
            return (Criteria) this;
        }

        public Criteria andDwNotLike(String value) {
            addCriterion("DW not like", value, "dw");
            return (Criteria) this;
        }

        public Criteria andDwIn(List<String> values) {
            addCriterion("DW in", values, "dw");
            return (Criteria) this;
        }

        public Criteria andDwNotIn(List<String> values) {
            addCriterion("DW not in", values, "dw");
            return (Criteria) this;
        }

        public Criteria andDwBetween(String value1, String value2) {
            addCriterion("DW between", value1, value2, "dw");
            return (Criteria) this;
        }

        public Criteria andDwNotBetween(String value1, String value2) {
            addCriterion("DW not between", value1, value2, "dw");
            return (Criteria) this;
        }

        public Criteria andCkBhIsNull() {
            addCriterion("CK_BH is null");
            return (Criteria) this;
        }

        public Criteria andCkBhIsNotNull() {
            addCriterion("CK_BH is not null");
            return (Criteria) this;
        }

        public Criteria andCkBhEqualTo(Long value) {
            addCriterion("CK_BH =", value, "ckBh");
            return (Criteria) this;
        }

        public Criteria andCkBhNotEqualTo(Long value) {
            addCriterion("CK_BH <>", value, "ckBh");
            return (Criteria) this;
        }

        public Criteria andCkBhGreaterThan(Long value) {
            addCriterion("CK_BH >", value, "ckBh");
            return (Criteria) this;
        }

        public Criteria andCkBhGreaterThanOrEqualTo(Long value) {
            addCriterion("CK_BH >=", value, "ckBh");
            return (Criteria) this;
        }

        public Criteria andCkBhLessThan(Long value) {
            addCriterion("CK_BH <", value, "ckBh");
            return (Criteria) this;
        }

        public Criteria andCkBhLessThanOrEqualTo(Long value) {
            addCriterion("CK_BH <=", value, "ckBh");
            return (Criteria) this;
        }

        public Criteria andCkBhIn(List<Long> values) {
            addCriterion("CK_BH in", values, "ckBh");
            return (Criteria) this;
        }

        public Criteria andCkBhNotIn(List<Long> values) {
            addCriterion("CK_BH not in", values, "ckBh");
            return (Criteria) this;
        }

        public Criteria andCkBhBetween(Long value1, Long value2) {
            addCriterion("CK_BH between", value1, value2, "ckBh");
            return (Criteria) this;
        }

        public Criteria andCkBhNotBetween(Long value1, Long value2) {
            addCriterion("CK_BH not between", value1, value2, "ckBh");
            return (Criteria) this;
        }

        public Criteria andKcSlIsNull() {
            addCriterion("KC_SL is null");
            return (Criteria) this;
        }

        public Criteria andKcSlIsNotNull() {
            addCriterion("KC_SL is not null");
            return (Criteria) this;
        }

        public Criteria andKcSlEqualTo(Long value) {
            addCriterion("KC_SL =", value, "kcSl");
            return (Criteria) this;
        }

        public Criteria andKcSlNotEqualTo(Long value) {
            addCriterion("KC_SL <>", value, "kcSl");
            return (Criteria) this;
        }

        public Criteria andKcSlGreaterThan(Long value) {
            addCriterion("KC_SL >", value, "kcSl");
            return (Criteria) this;
        }

        public Criteria andKcSlGreaterThanOrEqualTo(Long value) {
            addCriterion("KC_SL >=", value, "kcSl");
            return (Criteria) this;
        }

        public Criteria andKcSlLessThan(Long value) {
            addCriterion("KC_SL <", value, "kcSl");
            return (Criteria) this;
        }

        public Criteria andKcSlLessThanOrEqualTo(Long value) {
            addCriterion("KC_SL <=", value, "kcSl");
            return (Criteria) this;
        }

        public Criteria andKcSlIn(List<Long> values) {
            addCriterion("KC_SL in", values, "kcSl");
            return (Criteria) this;
        }

        public Criteria andKcSlNotIn(List<Long> values) {
            addCriterion("KC_SL not in", values, "kcSl");
            return (Criteria) this;
        }

        public Criteria andKcSlBetween(Long value1, Long value2) {
            addCriterion("KC_SL between", value1, value2, "kcSl");
            return (Criteria) this;
        }

        public Criteria andKcSlNotBetween(Long value1, Long value2) {
            addCriterion("KC_SL not between", value1, value2, "kcSl");
            return (Criteria) this;
        }

        public Criteria andCbjIsNull() {
            addCriterion("CBJ is null");
            return (Criteria) this;
        }

        public Criteria andCbjIsNotNull() {
            addCriterion("CBJ is not null");
            return (Criteria) this;
        }

        public Criteria andCbjEqualTo(BigDecimal value) {
            addCriterion("CBJ =", value, "cbj");
            return (Criteria) this;
        }

        public Criteria andCbjNotEqualTo(BigDecimal value) {
            addCriterion("CBJ <>", value, "cbj");
            return (Criteria) this;
        }

        public Criteria andCbjGreaterThan(BigDecimal value) {
            addCriterion("CBJ >", value, "cbj");
            return (Criteria) this;
        }

        public Criteria andCbjGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CBJ >=", value, "cbj");
            return (Criteria) this;
        }

        public Criteria andCbjLessThan(BigDecimal value) {
            addCriterion("CBJ <", value, "cbj");
            return (Criteria) this;
        }

        public Criteria andCbjLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CBJ <=", value, "cbj");
            return (Criteria) this;
        }

        public Criteria andCbjIn(List<BigDecimal> values) {
            addCriterion("CBJ in", values, "cbj");
            return (Criteria) this;
        }

        public Criteria andCbjNotIn(List<BigDecimal> values) {
            addCriterion("CBJ not in", values, "cbj");
            return (Criteria) this;
        }

        public Criteria andCbjBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CBJ between", value1, value2, "cbj");
            return (Criteria) this;
        }

        public Criteria andCbjNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CBJ not between", value1, value2, "cbj");
            return (Criteria) this;
        }

        public Criteria andLsjIsNull() {
            addCriterion("LSJ is null");
            return (Criteria) this;
        }

        public Criteria andLsjIsNotNull() {
            addCriterion("LSJ is not null");
            return (Criteria) this;
        }

        public Criteria andLsjEqualTo(BigDecimal value) {
            addCriterion("LSJ =", value, "lsj");
            return (Criteria) this;
        }

        public Criteria andLsjNotEqualTo(BigDecimal value) {
            addCriterion("LSJ <>", value, "lsj");
            return (Criteria) this;
        }

        public Criteria andLsjGreaterThan(BigDecimal value) {
            addCriterion("LSJ >", value, "lsj");
            return (Criteria) this;
        }

        public Criteria andLsjGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LSJ >=", value, "lsj");
            return (Criteria) this;
        }

        public Criteria andLsjLessThan(BigDecimal value) {
            addCriterion("LSJ <", value, "lsj");
            return (Criteria) this;
        }

        public Criteria andLsjLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LSJ <=", value, "lsj");
            return (Criteria) this;
        }

        public Criteria andLsjIn(List<BigDecimal> values) {
            addCriterion("LSJ in", values, "lsj");
            return (Criteria) this;
        }

        public Criteria andLsjNotIn(List<BigDecimal> values) {
            addCriterion("LSJ not in", values, "lsj");
            return (Criteria) this;
        }

        public Criteria andLsjBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LSJ between", value1, value2, "lsj");
            return (Criteria) this;
        }

        public Criteria andLsjNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LSJ not between", value1, value2, "lsj");
            return (Criteria) this;
        }

        public Criteria andJxjIsNull() {
            addCriterion("JXJ is null");
            return (Criteria) this;
        }

        public Criteria andJxjIsNotNull() {
            addCriterion("JXJ is not null");
            return (Criteria) this;
        }

        public Criteria andJxjEqualTo(BigDecimal value) {
            addCriterion("JXJ =", value, "jxj");
            return (Criteria) this;
        }

        public Criteria andJxjNotEqualTo(BigDecimal value) {
            addCriterion("JXJ <>", value, "jxj");
            return (Criteria) this;
        }

        public Criteria andJxjGreaterThan(BigDecimal value) {
            addCriterion("JXJ >", value, "jxj");
            return (Criteria) this;
        }

        public Criteria andJxjGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("JXJ >=", value, "jxj");
            return (Criteria) this;
        }

        public Criteria andJxjLessThan(BigDecimal value) {
            addCriterion("JXJ <", value, "jxj");
            return (Criteria) this;
        }

        public Criteria andJxjLessThanOrEqualTo(BigDecimal value) {
            addCriterion("JXJ <=", value, "jxj");
            return (Criteria) this;
        }

        public Criteria andJxjIn(List<BigDecimal> values) {
            addCriterion("JXJ in", values, "jxj");
            return (Criteria) this;
        }

        public Criteria andJxjNotIn(List<BigDecimal> values) {
            addCriterion("JXJ not in", values, "jxj");
            return (Criteria) this;
        }

        public Criteria andJxjBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("JXJ between", value1, value2, "jxj");
            return (Criteria) this;
        }

        public Criteria andJxjNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("JXJ not between", value1, value2, "jxj");
            return (Criteria) this;
        }

        public Criteria andBzxxIsNull() {
            addCriterion("BZXX is null");
            return (Criteria) this;
        }

        public Criteria andBzxxIsNotNull() {
            addCriterion("BZXX is not null");
            return (Criteria) this;
        }

        public Criteria andBzxxEqualTo(String value) {
            addCriterion("BZXX =", value, "bzxx");
            return (Criteria) this;
        }

        public Criteria andBzxxNotEqualTo(String value) {
            addCriterion("BZXX <>", value, "bzxx");
            return (Criteria) this;
        }

        public Criteria andBzxxGreaterThan(String value) {
            addCriterion("BZXX >", value, "bzxx");
            return (Criteria) this;
        }

        public Criteria andBzxxGreaterThanOrEqualTo(String value) {
            addCriterion("BZXX >=", value, "bzxx");
            return (Criteria) this;
        }

        public Criteria andBzxxLessThan(String value) {
            addCriterion("BZXX <", value, "bzxx");
            return (Criteria) this;
        }

        public Criteria andBzxxLessThanOrEqualTo(String value) {
            addCriterion("BZXX <=", value, "bzxx");
            return (Criteria) this;
        }

        public Criteria andBzxxLike(String value) {
            addCriterion("BZXX like", value, "bzxx");
            return (Criteria) this;
        }

        public Criteria andBzxxNotLike(String value) {
            addCriterion("BZXX not like", value, "bzxx");
            return (Criteria) this;
        }

        public Criteria andBzxxIn(List<String> values) {
            addCriterion("BZXX in", values, "bzxx");
            return (Criteria) this;
        }

        public Criteria andBzxxNotIn(List<String> values) {
            addCriterion("BZXX not in", values, "bzxx");
            return (Criteria) this;
        }

        public Criteria andBzxxBetween(String value1, String value2) {
            addCriterion("BZXX between", value1, value2, "bzxx");
            return (Criteria) this;
        }

        public Criteria andBzxxNotBetween(String value1, String value2) {
            addCriterion("BZXX not between", value1, value2, "bzxx");
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