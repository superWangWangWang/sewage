package com.jt.sewage.mapper;

import com.jt.sewage.entity.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 倒序查询数据表
     * @return
     */
    @Select("SELECT * FROM `sewage` ORDER BY `time` DESC")
    List<Sewage> getData();

    /**
     * 查询正常范围
     * @return
     */
    @Select("SELECT * FROM `sewage_range`")
    List<SewageRange> getRange();

    /**
     * 根据账号查询用户
     * @param account
     * @return
     */
    @Select("SELECT * FROM `sewage_user` WHERE `account` = #{account}")
    SewageUser finUserByAccount(String account);

    /**
     * 获取最新的一条警报数据
     * @return
     */
    @Select("SELECT * FROM `sewage_warning` ORDER BY `time` DESC")
    SewageWarning getLatestWarn();

    /**
     * 插入警报表 数据
     * @param sewage
     */
    @Insert("INSERT INTO `sewage_warning` (`time`,`ph`,`ss`,`cod`,`nh`,`cu`,`ni`,`fr`) VALUES (#{sewage.time},#{sewage.ph},#{sewage.ss},#{sewage.cod},#{sewage.nh},#{sewage.cu},#{sewage.ni},#{sewage.fr})")
    void addLastWarn(@Param("sewage") Sewage sewage);

    /**
     * 获取需要接受的email
     * @return
     */
    @Select("SELECT * FROM `sewage_email`")
    List<SewageEmail> getEmailList();

    /**
     * 查询历史平均数
     * @param name
     * @param date
     * @return
     */
    @Select("SELECT AVG(CAST(${name} AS DECIMAL(10,4))) AS `avg`,LEFT(`time`,10) AS `time`FROM `sewage`WHERE LEFT(`time`,8) = #{date}  GROUP BY LEFT(`time`,10) ORDER BY `time` ASC")
    List<SewageHistory> getHistoryAvg(String name, String date);

    List<SewageLog> getSewageLog(String uid);
}
