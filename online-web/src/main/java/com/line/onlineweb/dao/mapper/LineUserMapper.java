package com.line.onlineweb.dao.mapper;

import com.line.onlineweb.dao.entity.LineUser;

import java.util.List;

public interface LineUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table line_user
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table line_user
     *
     * @mbggenerated
     */
    int insert(LineUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table line_user
     *
     * @mbggenerated
     */
    int insertSelective(LineUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table line_user
     *
     * @mbggenerated
     */
    LineUser selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table line_user
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(LineUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table line_user
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(LineUser record);

    List<LineUser> findByNameAndPwd(String loginname, String pwd);
}