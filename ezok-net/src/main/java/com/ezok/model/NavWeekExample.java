package com.ezok.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NavWeekExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tbl_nav_week
     *
     * @mbggenerated Wed Mar 26 13:14:41 CST 2014
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tbl_nav_week
     *
     * @mbggenerated Wed Mar 26 13:14:41 CST 2014
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tbl_nav_week
     *
     * @mbggenerated Wed Mar 26 13:14:41 CST 2014
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_nav_week
     *
     * @mbggenerated Wed Mar 26 13:14:41 CST 2014
     */
    public NavWeekExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_nav_week
     *
     * @mbggenerated Wed Mar 26 13:14:41 CST 2014
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_nav_week
     *
     * @mbggenerated Wed Mar 26 13:14:41 CST 2014
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_nav_week
     *
     * @mbggenerated Wed Mar 26 13:14:41 CST 2014
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_nav_week
     *
     * @mbggenerated Wed Mar 26 13:14:41 CST 2014
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_nav_week
     *
     * @mbggenerated Wed Mar 26 13:14:41 CST 2014
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_nav_week
     *
     * @mbggenerated Wed Mar 26 13:14:41 CST 2014
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_nav_week
     *
     * @mbggenerated Wed Mar 26 13:14:41 CST 2014
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_nav_week
     *
     * @mbggenerated Wed Mar 26 13:14:41 CST 2014
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_nav_week
     *
     * @mbggenerated Wed Mar 26 13:14:41 CST 2014
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_nav_week
     *
     * @mbggenerated Wed Mar 26 13:14:41 CST 2014
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tbl_nav_week
     *
     * @mbggenerated Wed Mar 26 13:14:41 CST 2014
     */
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNavNoIsNull() {
            addCriterion("NAV_NO is null");
            return (Criteria) this;
        }

        public Criteria andNavNoIsNotNull() {
            addCriterion("NAV_NO is not null");
            return (Criteria) this;
        }

        public Criteria andNavNoEqualTo(String value) {
            addCriterion("NAV_NO =", value, "navNo");
            return (Criteria) this;
        }

        public Criteria andNavNoNotEqualTo(String value) {
            addCriterion("NAV_NO <>", value, "navNo");
            return (Criteria) this;
        }

        public Criteria andNavNoGreaterThan(String value) {
            addCriterion("NAV_NO >", value, "navNo");
            return (Criteria) this;
        }

        public Criteria andNavNoGreaterThanOrEqualTo(String value) {
            addCriterion("NAV_NO >=", value, "navNo");
            return (Criteria) this;
        }

        public Criteria andNavNoLessThan(String value) {
            addCriterion("NAV_NO <", value, "navNo");
            return (Criteria) this;
        }

        public Criteria andNavNoLessThanOrEqualTo(String value) {
            addCriterion("NAV_NO <=", value, "navNo");
            return (Criteria) this;
        }

        public Criteria andNavNoLike(String value) {
            addCriterion("NAV_NO like", value, "navNo");
            return (Criteria) this;
        }

        public Criteria andNavNoNotLike(String value) {
            addCriterion("NAV_NO not like", value, "navNo");
            return (Criteria) this;
        }

        public Criteria andNavNoIn(List<String> values) {
            addCriterion("NAV_NO in", values, "navNo");
            return (Criteria) this;
        }

        public Criteria andNavNoNotIn(List<String> values) {
            addCriterion("NAV_NO not in", values, "navNo");
            return (Criteria) this;
        }

        public Criteria andNavNoBetween(String value1, String value2) {
            addCriterion("NAV_NO between", value1, value2, "navNo");
            return (Criteria) this;
        }

        public Criteria andNavNoNotBetween(String value1, String value2) {
            addCriterion("NAV_NO not between", value1, value2, "navNo");
            return (Criteria) this;
        }

        public Criteria andTopReasonIsNull() {
            addCriterion("TOP_REASON is null");
            return (Criteria) this;
        }

        public Criteria andTopReasonIsNotNull() {
            addCriterion("TOP_REASON is not null");
            return (Criteria) this;
        }

        public Criteria andTopReasonEqualTo(String value) {
            addCriterion("TOP_REASON =", value, "topReason");
            return (Criteria) this;
        }

        public Criteria andTopReasonNotEqualTo(String value) {
            addCriterion("TOP_REASON <>", value, "topReason");
            return (Criteria) this;
        }

        public Criteria andTopReasonGreaterThan(String value) {
            addCriterion("TOP_REASON >", value, "topReason");
            return (Criteria) this;
        }

        public Criteria andTopReasonGreaterThanOrEqualTo(String value) {
            addCriterion("TOP_REASON >=", value, "topReason");
            return (Criteria) this;
        }

        public Criteria andTopReasonLessThan(String value) {
            addCriterion("TOP_REASON <", value, "topReason");
            return (Criteria) this;
        }

        public Criteria andTopReasonLessThanOrEqualTo(String value) {
            addCriterion("TOP_REASON <=", value, "topReason");
            return (Criteria) this;
        }

        public Criteria andTopReasonLike(String value) {
            addCriterion("TOP_REASON like", value, "topReason");
            return (Criteria) this;
        }

        public Criteria andTopReasonNotLike(String value) {
            addCriterion("TOP_REASON not like", value, "topReason");
            return (Criteria) this;
        }

        public Criteria andTopReasonIn(List<String> values) {
            addCriterion("TOP_REASON in", values, "topReason");
            return (Criteria) this;
        }

        public Criteria andTopReasonNotIn(List<String> values) {
            addCriterion("TOP_REASON not in", values, "topReason");
            return (Criteria) this;
        }

        public Criteria andTopReasonBetween(String value1, String value2) {
            addCriterion("TOP_REASON between", value1, value2, "topReason");
            return (Criteria) this;
        }

        public Criteria andTopReasonNotBetween(String value1, String value2) {
            addCriterion("TOP_REASON not between", value1, value2, "topReason");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("UPDATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("UPDATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("UPDATE_DATE =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("UPDATE_DATE <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("UPDATE_DATE >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_DATE >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("UPDATE_DATE <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_DATE <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("UPDATE_DATE in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("UPDATE_DATE not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("UPDATE_DATE between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_DATE not between", value1, value2, "updateDate");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tbl_nav_week
     *
     * @mbggenerated do_not_delete_during_merge Wed Mar 26 13:14:41 CST 2014
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tbl_nav_week
     *
     * @mbggenerated Wed Mar 26 13:14:41 CST 2014
     */
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