package com.Luo.bean;

import java.util.ArrayList;
import java.util.List;

public class BillExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BillExample() {
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

        public Criteria andShopIdIsNull() {
            addCriterion("shop_ID is null");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNotNull() {
            addCriterion("shop_ID is not null");
            return (Criteria) this;
        }

        public Criteria andShopIdEqualTo(String value) {
            addCriterion("shop_ID =", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotEqualTo(String value) {
            addCriterion("shop_ID <>", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThan(String value) {
            addCriterion("shop_ID >", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThanOrEqualTo(String value) {
            addCriterion("shop_ID >=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThan(String value) {
            addCriterion("shop_ID <", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThanOrEqualTo(String value) {
            addCriterion("shop_ID <=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLike(String value) {
            addCriterion("shop_ID like", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotLike(String value) {
            addCriterion("shop_ID not like", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdIn(List<String> values) {
            addCriterion("shop_ID in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotIn(List<String> values) {
            addCriterion("shop_ID not in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdBetween(String value1, String value2) {
            addCriterion("shop_ID between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotBetween(String value1, String value2) {
            addCriterion("shop_ID not between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andCashierIdIsNull() {
            addCriterion("cashier_ID is null");
            return (Criteria) this;
        }

        public Criteria andCashierIdIsNotNull() {
            addCriterion("cashier_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCashierIdEqualTo(String value) {
            addCriterion("cashier_ID =", value, "cashierId");
            return (Criteria) this;
        }

        public Criteria andCashierIdNotEqualTo(String value) {
            addCriterion("cashier_ID <>", value, "cashierId");
            return (Criteria) this;
        }

        public Criteria andCashierIdGreaterThan(String value) {
            addCriterion("cashier_ID >", value, "cashierId");
            return (Criteria) this;
        }

        public Criteria andCashierIdGreaterThanOrEqualTo(String value) {
            addCriterion("cashier_ID >=", value, "cashierId");
            return (Criteria) this;
        }

        public Criteria andCashierIdLessThan(String value) {
            addCriterion("cashier_ID <", value, "cashierId");
            return (Criteria) this;
        }

        public Criteria andCashierIdLessThanOrEqualTo(String value) {
            addCriterion("cashier_ID <=", value, "cashierId");
            return (Criteria) this;
        }

        public Criteria andCashierIdLike(String value) {
            addCriterion("cashier_ID like", value, "cashierId");
            return (Criteria) this;
        }

        public Criteria andCashierIdNotLike(String value) {
            addCriterion("cashier_ID not like", value, "cashierId");
            return (Criteria) this;
        }

        public Criteria andCashierIdIn(List<String> values) {
            addCriterion("cashier_ID in", values, "cashierId");
            return (Criteria) this;
        }

        public Criteria andCashierIdNotIn(List<String> values) {
            addCriterion("cashier_ID not in", values, "cashierId");
            return (Criteria) this;
        }

        public Criteria andCashierIdBetween(String value1, String value2) {
            addCriterion("cashier_ID between", value1, value2, "cashierId");
            return (Criteria) this;
        }

        public Criteria andCashierIdNotBetween(String value1, String value2) {
            addCriterion("cashier_ID not between", value1, value2, "cashierId");
            return (Criteria) this;
        }

        public Criteria andComIdIsNull() {
            addCriterion("com_ID is null");
            return (Criteria) this;
        }

        public Criteria andComIdIsNotNull() {
            addCriterion("com_ID is not null");
            return (Criteria) this;
        }

        public Criteria andComIdEqualTo(String value) {
            addCriterion("com_ID =", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotEqualTo(String value) {
            addCriterion("com_ID <>", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdGreaterThan(String value) {
            addCriterion("com_ID >", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdGreaterThanOrEqualTo(String value) {
            addCriterion("com_ID >=", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdLessThan(String value) {
            addCriterion("com_ID <", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdLessThanOrEqualTo(String value) {
            addCriterion("com_ID <=", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdLike(String value) {
            addCriterion("com_ID like", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotLike(String value) {
            addCriterion("com_ID not like", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdIn(List<String> values) {
            addCriterion("com_ID in", values, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotIn(List<String> values) {
            addCriterion("com_ID not in", values, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdBetween(String value1, String value2) {
            addCriterion("com_ID between", value1, value2, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotBetween(String value1, String value2) {
            addCriterion("com_ID not between", value1, value2, "comId");
            return (Criteria) this;
        }

        public Criteria andSellNumIsNull() {
            addCriterion("sell_Num is null");
            return (Criteria) this;
        }

        public Criteria andSellNumIsNotNull() {
            addCriterion("sell_Num is not null");
            return (Criteria) this;
        }

        public Criteria andSellNumEqualTo(Integer value) {
            addCriterion("sell_Num =", value, "sellNum");
            return (Criteria) this;
        }

        public Criteria andSellNumNotEqualTo(Integer value) {
            addCriterion("sell_Num <>", value, "sellNum");
            return (Criteria) this;
        }

        public Criteria andSellNumGreaterThan(Integer value) {
            addCriterion("sell_Num >", value, "sellNum");
            return (Criteria) this;
        }

        public Criteria andSellNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("sell_Num >=", value, "sellNum");
            return (Criteria) this;
        }

        public Criteria andSellNumLessThan(Integer value) {
            addCriterion("sell_Num <", value, "sellNum");
            return (Criteria) this;
        }

        public Criteria andSellNumLessThanOrEqualTo(Integer value) {
            addCriterion("sell_Num <=", value, "sellNum");
            return (Criteria) this;
        }

        public Criteria andSellNumIn(List<Integer> values) {
            addCriterion("sell_Num in", values, "sellNum");
            return (Criteria) this;
        }

        public Criteria andSellNumNotIn(List<Integer> values) {
            addCriterion("sell_Num not in", values, "sellNum");
            return (Criteria) this;
        }

        public Criteria andSellNumBetween(Integer value1, Integer value2) {
            addCriterion("sell_Num between", value1, value2, "sellNum");
            return (Criteria) this;
        }

        public Criteria andSellNumNotBetween(Integer value1, Integer value2) {
            addCriterion("sell_Num not between", value1, value2, "sellNum");
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