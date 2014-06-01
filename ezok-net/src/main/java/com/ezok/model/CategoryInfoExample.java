package com.ezok.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CategoryInfoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tbl_category_info
     *
     * @mbggenerated Tue Apr 01 13:29:30 CST 2014
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tbl_category_info
     *
     * @mbggenerated Tue Apr 01 13:29:30 CST 2014
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tbl_category_info
     *
     * @mbggenerated Tue Apr 01 13:29:30 CST 2014
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_category_info
     *
     * @mbggenerated Tue Apr 01 13:29:30 CST 2014
     */
    public CategoryInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_category_info
     *
     * @mbggenerated Tue Apr 01 13:29:30 CST 2014
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_category_info
     *
     * @mbggenerated Tue Apr 01 13:29:30 CST 2014
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_category_info
     *
     * @mbggenerated Tue Apr 01 13:29:30 CST 2014
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_category_info
     *
     * @mbggenerated Tue Apr 01 13:29:30 CST 2014
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_category_info
     *
     * @mbggenerated Tue Apr 01 13:29:30 CST 2014
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_category_info
     *
     * @mbggenerated Tue Apr 01 13:29:30 CST 2014
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_category_info
     *
     * @mbggenerated Tue Apr 01 13:29:30 CST 2014
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_category_info
     *
     * @mbggenerated Tue Apr 01 13:29:30 CST 2014
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
     * This method corresponds to the database table tbl_category_info
     *
     * @mbggenerated Tue Apr 01 13:29:30 CST 2014
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_category_info
     *
     * @mbggenerated Tue Apr 01 13:29:30 CST 2014
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tbl_category_info
     *
     * @mbggenerated Tue Apr 01 13:29:30 CST 2014
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

        public Criteria andNoIsNull() {
            addCriterion("NO is null");
            return (Criteria) this;
        }

        public Criteria andNoIsNotNull() {
            addCriterion("NO is not null");
            return (Criteria) this;
        }

        public Criteria andNoEqualTo(String value) {
            addCriterion("NO =", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotEqualTo(String value) {
            addCriterion("NO <>", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoGreaterThan(String value) {
            addCriterion("NO >", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoGreaterThanOrEqualTo(String value) {
            addCriterion("NO >=", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoLessThan(String value) {
            addCriterion("NO <", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoLessThanOrEqualTo(String value) {
            addCriterion("NO <=", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoLike(String value) {
            addCriterion("NO like", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotLike(String value) {
            addCriterion("NO not like", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoIn(List<String> values) {
            addCriterion("NO in", values, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotIn(List<String> values) {
            addCriterion("NO not in", values, "no");
            return (Criteria) this;
        }

        public Criteria andNoBetween(String value1, String value2) {
            addCriterion("NO between", value1, value2, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotBetween(String value1, String value2) {
            addCriterion("NO not between", value1, value2, "no");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNull() {
            addCriterion("PRIORITY is null");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNotNull() {
            addCriterion("PRIORITY is not null");
            return (Criteria) this;
        }

        public Criteria andPriorityEqualTo(Integer value) {
            addCriterion("PRIORITY =", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotEqualTo(Integer value) {
            addCriterion("PRIORITY <>", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThan(Integer value) {
            addCriterion("PRIORITY >", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRIORITY >=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThan(Integer value) {
            addCriterion("PRIORITY <", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThanOrEqualTo(Integer value) {
            addCriterion("PRIORITY <=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityIn(List<Integer> values) {
            addCriterion("PRIORITY in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotIn(List<Integer> values) {
            addCriterion("PRIORITY not in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityBetween(Integer value1, Integer value2) {
            addCriterion("PRIORITY between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotBetween(Integer value1, Integer value2) {
            addCriterion("PRIORITY not between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andParentNoIsNull() {
            addCriterion("PARENT_NO is null");
            return (Criteria) this;
        }

        public Criteria andParentNoIsNotNull() {
            addCriterion("PARENT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andParentNoEqualTo(String value) {
            addCriterion("PARENT_NO =", value, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoNotEqualTo(String value) {
            addCriterion("PARENT_NO <>", value, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoGreaterThan(String value) {
            addCriterion("PARENT_NO >", value, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoGreaterThanOrEqualTo(String value) {
            addCriterion("PARENT_NO >=", value, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoLessThan(String value) {
            addCriterion("PARENT_NO <", value, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoLessThanOrEqualTo(String value) {
            addCriterion("PARENT_NO <=", value, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoLike(String value) {
            addCriterion("PARENT_NO like", value, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoNotLike(String value) {
            addCriterion("PARENT_NO not like", value, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoIn(List<String> values) {
            addCriterion("PARENT_NO in", values, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoNotIn(List<String> values) {
            addCriterion("PARENT_NO not in", values, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoBetween(String value1, String value2) {
            addCriterion("PARENT_NO between", value1, value2, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoNotBetween(String value1, String value2) {
            addCriterion("PARENT_NO not between", value1, value2, "parentNo");
            return (Criteria) this;
        }

        public Criteria andStructIsNull() {
            addCriterion("STRUCT is null");
            return (Criteria) this;
        }

        public Criteria andStructIsNotNull() {
            addCriterion("STRUCT is not null");
            return (Criteria) this;
        }

        public Criteria andStructEqualTo(String value) {
            addCriterion("STRUCT =", value, "struct");
            return (Criteria) this;
        }

        public Criteria andStructNotEqualTo(String value) {
            addCriterion("STRUCT <>", value, "struct");
            return (Criteria) this;
        }

        public Criteria andStructGreaterThan(String value) {
            addCriterion("STRUCT >", value, "struct");
            return (Criteria) this;
        }

        public Criteria andStructGreaterThanOrEqualTo(String value) {
            addCriterion("STRUCT >=", value, "struct");
            return (Criteria) this;
        }

        public Criteria andStructLessThan(String value) {
            addCriterion("STRUCT <", value, "struct");
            return (Criteria) this;
        }

        public Criteria andStructLessThanOrEqualTo(String value) {
            addCriterion("STRUCT <=", value, "struct");
            return (Criteria) this;
        }

        public Criteria andStructLike(String value) {
            addCriterion("STRUCT like", value, "struct");
            return (Criteria) this;
        }

        public Criteria andStructNotLike(String value) {
            addCriterion("STRUCT not like", value, "struct");
            return (Criteria) this;
        }

        public Criteria andStructIn(List<String> values) {
            addCriterion("STRUCT in", values, "struct");
            return (Criteria) this;
        }

        public Criteria andStructNotIn(List<String> values) {
            addCriterion("STRUCT not in", values, "struct");
            return (Criteria) this;
        }

        public Criteria andStructBetween(String value1, String value2) {
            addCriterion("STRUCT between", value1, value2, "struct");
            return (Criteria) this;
        }

        public Criteria andStructNotBetween(String value1, String value2) {
            addCriterion("STRUCT not between", value1, value2, "struct");
            return (Criteria) this;
        }

        public Criteria andStructNameIsNull() {
            addCriterion("STRUCT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andStructNameIsNotNull() {
            addCriterion("STRUCT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andStructNameEqualTo(String value) {
            addCriterion("STRUCT_NAME =", value, "structName");
            return (Criteria) this;
        }

        public Criteria andStructNameNotEqualTo(String value) {
            addCriterion("STRUCT_NAME <>", value, "structName");
            return (Criteria) this;
        }

        public Criteria andStructNameGreaterThan(String value) {
            addCriterion("STRUCT_NAME >", value, "structName");
            return (Criteria) this;
        }

        public Criteria andStructNameGreaterThanOrEqualTo(String value) {
            addCriterion("STRUCT_NAME >=", value, "structName");
            return (Criteria) this;
        }

        public Criteria andStructNameLessThan(String value) {
            addCriterion("STRUCT_NAME <", value, "structName");
            return (Criteria) this;
        }

        public Criteria andStructNameLessThanOrEqualTo(String value) {
            addCriterion("STRUCT_NAME <=", value, "structName");
            return (Criteria) this;
        }

        public Criteria andStructNameLike(String value) {
            addCriterion("STRUCT_NAME like", value, "structName");
            return (Criteria) this;
        }

        public Criteria andStructNameNotLike(String value) {
            addCriterion("STRUCT_NAME not like", value, "structName");
            return (Criteria) this;
        }

        public Criteria andStructNameIn(List<String> values) {
            addCriterion("STRUCT_NAME in", values, "structName");
            return (Criteria) this;
        }

        public Criteria andStructNameNotIn(List<String> values) {
            addCriterion("STRUCT_NAME not in", values, "structName");
            return (Criteria) this;
        }

        public Criteria andStructNameBetween(String value1, String value2) {
            addCriterion("STRUCT_NAME between", value1, value2, "structName");
            return (Criteria) this;
        }

        public Criteria andStructNameNotBetween(String value1, String value2) {
            addCriterion("STRUCT_NAME not between", value1, value2, "structName");
            return (Criteria) this;
        }

        public Criteria andClickSumIsNull() {
            addCriterion("CLICK_SUM is null");
            return (Criteria) this;
        }

        public Criteria andClickSumIsNotNull() {
            addCriterion("CLICK_SUM is not null");
            return (Criteria) this;
        }

        public Criteria andClickSumEqualTo(Integer value) {
            addCriterion("CLICK_SUM =", value, "clickSum");
            return (Criteria) this;
        }

        public Criteria andClickSumNotEqualTo(Integer value) {
            addCriterion("CLICK_SUM <>", value, "clickSum");
            return (Criteria) this;
        }

        public Criteria andClickSumGreaterThan(Integer value) {
            addCriterion("CLICK_SUM >", value, "clickSum");
            return (Criteria) this;
        }

        public Criteria andClickSumGreaterThanOrEqualTo(Integer value) {
            addCriterion("CLICK_SUM >=", value, "clickSum");
            return (Criteria) this;
        }

        public Criteria andClickSumLessThan(Integer value) {
            addCriterion("CLICK_SUM <", value, "clickSum");
            return (Criteria) this;
        }

        public Criteria andClickSumLessThanOrEqualTo(Integer value) {
            addCriterion("CLICK_SUM <=", value, "clickSum");
            return (Criteria) this;
        }

        public Criteria andClickSumIn(List<Integer> values) {
            addCriterion("CLICK_SUM in", values, "clickSum");
            return (Criteria) this;
        }

        public Criteria andClickSumNotIn(List<Integer> values) {
            addCriterion("CLICK_SUM not in", values, "clickSum");
            return (Criteria) this;
        }

        public Criteria andClickSumBetween(Integer value1, Integer value2) {
            addCriterion("CLICK_SUM between", value1, value2, "clickSum");
            return (Criteria) this;
        }

        public Criteria andClickSumNotBetween(Integer value1, Integer value2) {
            addCriterion("CLICK_SUM not between", value1, value2, "clickSum");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("CREATE_DATE =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("CREATE_DATE <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("CREATE_DATE >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("CREATE_DATE <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("CREATE_DATE in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("CREATE_DATE not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE not between", value1, value2, "createDate");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tbl_category_info
     *
     * @mbggenerated do_not_delete_during_merge Tue Apr 01 13:29:30 CST 2014
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tbl_category_info
     *
     * @mbggenerated Tue Apr 01 13:29:30 CST 2014
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