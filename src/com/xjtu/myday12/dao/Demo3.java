package com.xjtu.myday12.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.xjtu.util.JdbcUtil;

//ʹ��Dbutils���,��Curd
public class Demo3 {
  public static void main(String[] args) throws SQLException {
	QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
	String sql  = "update user set username=? where id=?";
	queryRunner.update(sql, new Object[]{"������",15});
}
}
