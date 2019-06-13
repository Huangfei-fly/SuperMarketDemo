package com.Luo.bean;

import java.util.ArrayList;
import java.util.List;

public class CommodityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommodityExample() {
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

        public Criteria andComNameIsNull() {
            addCriterion("com_Name is null");
            return (Criteria) this;
        }

        public Criteria andComNameIsNotNull() {
            addCriterion("com_Name is not null");
            return (Criteria) this;
        }

        public Criteria andComNameEqualTo(String value) {
            addCriterion("com_Name =", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameNotEqualTo(String value) {
            addCriterion("com_Name <>", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameGreaterThan(String value) {
            addCriterion("com_Name >", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameGreaterThanOrEqualTo(String value) {
            addCriterion("com_Name >=", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameLessThan(String value) {
            addCriterion("com_Name <", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameLessThanOrEqualTo(String value) {
            addCriterion("com_Name <=", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameLike(String value) {
            addCriterion("com_Name like", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameNotLike(String value) {
            addCriterion("com_Name not like", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameIn(List<String> values) {
            addCriterion("com_Name in", values, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameNotIn(List<String> values) {
            addCriterion("com_Name not in", values, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameBetween(String value1, String value2) {
            addCriterion("com_Name between", value1, value2, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameNotBetween(String value1, String value2) {
            addCriterion("com_Name not between", value1, value2, "comName");
            return (Criteria) this;
        }

        public Criteria andSellPriceIsNull() {
            addCriterion("sell_Price is null");
            return (Criteria) this;
        }

        public Criteria andSellPriceIsNotNull() {
            addCriterion("sell_Price is not null");
            return (Criteria) this;
        }

        public Criteria andSellPriceEqualTo(Float value) {
            addCriterion("sell_Price =", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceNotEqualTo(Float value) {
            addCriterion("sell_Price <>", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceGreaterThan(Float value) {
            addCriterion("sell_Price >", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("sell_Price >=", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceLessThan(Float value) {
            addCriterion("sell_Price <", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceLessThanOrEqualTo(Float value) {
            addCriterion("sell_Price <=", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceIn(List<Float> values) {
            addCriterion("sell_Price in", values, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceNotIn(List<Float> values) {
            addCriterion("sell_Price not in", values, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceBetween(Float value1, Float value2) {
            addCriterion("sell_Price between", value1, value2, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceNotBetween(Float value1, Float value2) {
            addCriterion("sell_Price not between", value1, value2, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceIsNull() {
            addCriterion("purchase_Price is null");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceIsNotNull() {
            addCriterion("purchase_Price is not null");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceEqualTo(Float value) {
            addCriterion("purchase_Price =", value, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceNotEqualTo(Float value) {
            addCriterion("purchase_Price <>", value, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceGreaterThan(Float value) {
            addCriterion("purchase_Price >", value, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceGreaterThanOrEqualTo(Float value) {
            addCriterion("purchase_Price >=", value, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceLessThan(Float value) {
            addCriterion("purchase_Price <", value, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceLessThanOrEqualTo(Float value) {
            addCriterion("purchase_Price <=", value, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceIn(List<Float> values) {
            addCriterion("purchase_Price in", values, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceNotIn(List<Float> values) {
            addCriterion("purchase_Price not in", values, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceBetween(Float value1, Float value2) {
            addCriterion("purchase_Price between", value1, value2, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceNotBetween(Float value1, Float value2) {
            addCriterion("purchase_Price not between", value1, value2, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andStockNumIsNull() {
            addCriterion("stock_Num is null");
            return (Criteria) this;
        }

        public Criteria andStockNumIsNotNull() {
            addCriterion("stock_Num is not null");
            return (Criteria) this;
        }

        public Criteria andStockNumEqualTo(Integer value) {
            addCriterion("stock_Num =", value, "stockNum");
            return (Criteria) this;
        }

        public Criteria andStockNumNotEqualTo(Integer value) {
            addCriterion("stock_Num <>", value, "stockNum");
            return (Criteria) this;
        }

        public Criteria andStockNumGreaterThan(Integer value) {
            addCriterion("stock_Num >", value, "stockNum");
            return (Criteria) this;
        }

        public Criteria andStockNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("stock_Num >=", value, "stockNum");
            return (Criteria) this;
        }

        public Criteria andStockNumLessThan(Integer value) {
            addCriterion("stock_Num <", value, "stockNum");
            return (Criteria) this;
        }

        public Criteria andStockNumLessThanOrEqualTo(Integer value) {
            addCriterion("stock_Num <=", value, "stockNum");
            return (Criteria) this;
        }

        public Criteria andStockNumIn(List<Integer> values) {
            addCriterion("stock_Num in", values, "stockNum");
            return (Criteria) this;
        }

        public Criteria andStockNumNotIn(List<Integer> values) {
            addCriterion("stock_Num not in", values, "stockNum");
            return (Criteria) this;
        }

        public Criteria andStockNumBetween(Integer value1, Integer value2) {
            addCriterion("stock_Num between", value1, value2, "stockNum");
            return (Criteria) this;
        }

        public Criteria andStockNumNotBetween(Integer value1, Integer value2) {
            addCriterion("stock_Num not between", value1, value2, "stockNum");
            return (Criteria) this;
        }

        public Criteria andWarningNumIsNull() {
            addCriterion("warning_Num is null");
            return (Criteria) this;
        }

        public Criteria andWarningNumIsNotNull() {
            addCriterion("warning_Num is not null");
            return (Criteria) this;
        }

        public Criteria andWarningNumEqualTo(Integer value) {
            addCriterion("warning_Num =", value, "warningNum");
            return (Criteria) this;
        }

        public Criteria andWarningNumNotEqualTo(Integer value) {
            addCriterion("warning_Num <>", value, "warningNum");
            return (Criteria) this;
        }

        public Criteria andWarningNumGreaterThan(Integer value) {
            addCriterion("warning_Num >", value, "warningNum");
            return (Criteria) this;
        }

        public Criteria andWarningNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("warning_Num >=", value, "warningNum");
            return (Criteria) this;
        }

        public Criteria andWarningNumLessThan(Integer value) {
            addCriterion("warning_Num <", value, "warningNum");
            return (Criteria) this;
        }

        public Criteria andWarningNumLessThanOrEqualTo(Integer value) {
            addCriterion("warning_Num <=", value, "warningNum");
            return (Criteria) this;
        }

        public Criteria andWarningNumIn(List<Integer> values) {
            addCriterion("warning_Num in", values, "warningNum");
            return (Criteria) this;
        }

        public Criteria andWarningNumNotIn(List<Integer> values) {
            addCriterion("warning_Num not in", values, "warningNum");
            return (Criteria) this;
        }

        public Criteria andWarningNumBetween(Integer value1, Integer value2) {
            addCriterion("warning_Num between", value1, value2, "warningNum");
            return (Criteria) this;
        }

        public Criteria andWarningNumNotBetween(Integer value1, Integer value2) {
            addCriterion("warning_Num not between", value1, value2, "warningNum");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdIsNull() {
            addCriterion("warehouse_Id is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdIsNotNull() {
            addCriterion("warehouse_Id is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdEqualTo(String value) {
            addCriterion("warehouse_Id =", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdNotEqualTo(String value) {
            addCriterion("warehouse_Id <>", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdGreaterThan(String value) {
            addCriterion("warehouse_Id >", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdGreaterThanOrEqualTo(String value) {
            addCriterion("warehouse_Id >=", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdLessThan(String value) {
            addCriterion("warehouse_Id <", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdLessThanOrEqualTo(String value) {
            addCriterion("warehouse_Id <=", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdLike(String value) {
            addCriterion("warehouse_Id like", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdNotLike(String value) {
            addCriterion("warehouse_Id not like", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdIn(List<String> values) {
            addCriterion("warehouse_Id in", values, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdNotIn(List<String> values) {
            addCriterion("warehouse_Id not in", values, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdBetween(String value1, String value2) {
            addCriterion("warehouse_Id between", value1, value2, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdNotBetween(String value1, String value2) {
            addCriterion("warehouse_Id not between", value1, value2, "warehouseId");
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