package com.you.DBUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.you.bean.ChuanGanData;
import com.you.bean.ChuanGanModel;
import com.you.bean.ControlModel;

/**
 * @author lucher 
 * 本类为sql工具类，包括sql无参、有参查询，以及sql更新语句方法 
 * 该类一般配合DBUtil使用，只是列举了常用的方法
 */
public class SQLUtil {

	// 无参数的查询语句
	private static final String sql1 = "select * from ChuanGanModel";

	// 有参数的查询语句
	private static final String sql2 = "select * from ControlModel";
	
	//返回烟雾最新数据状态记录
	private static final String sql3 = "select top 1 * from YanWuData  order by YanWuDataId  desc";

	// 更新语句
	private static final String sql4 = "update ControlModel set ControlModel=? where ControlModelId=?";

	// 删除语句，同时执行
	private static final String sql5 = "delete from user where id=?";
	private static final String sql6 = "delete from userInfo where id=?";
	
	/**
	 * 添加传感器类方法
	 * @param ChuanGanModel对象
	 * @return 执行添加的结果
	 */
	public boolean addChuanGanModel(ChuanGanModel chuanGanModel) {
		
		String sql = "insert into ChuanGanModel (ChuanGanId,ChuanGanName,ChuanGanDataType,ChuanGanWhere) values (?,?,?,?)";
		int result = 0;
		boolean flag = true;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil.getSQLSERVERConnection();
//			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			System.out.println(sql);
			System.out.println(chuanGanModel.getChuanGanId()+chuanGanModel.getChuanGanDataType()+chuanGanModel.getChuanGanName()+chuanGanModel.getChuanGanWhere());
			pstmt.setInt(1, chuanGanModel.getChuanGanId());
			pstmt.setString(2, chuanGanModel.getChuanGanName());
			pstmt.setString(3, chuanGanModel.getChuanGanDataType());
			pstmt.setString(4, chuanGanModel.getChuanGanWhere());

			result = pstmt.executeUpdate();
			
//			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			DBUtil.closeConn(pstmt, conn);
		}

		if (result == 0 ) {
			flag = false;
		}
		return flag;
	}
	
	/**
	 * 无参数查询,返回所有传感器基本信息
	 * 
	 * @return 所有传感器基本信息的list
	 */
	public static List<ChuanGanData> getChuanGanDataById(int ChuanGanId) {
		
		String sql = "select  * from ChuanGanData where ChuanGanId="+ChuanGanId+" order by DataTime";
		
		Connection conn = null;
		Statement ps = null;
		ResultSet rs = null;
		
		List<ChuanGanData> info = new ArrayList<ChuanGanData>();
		
		try {
			conn = DBUtil.getSQLSERVERConnection();
			ps = conn.createStatement();
			rs = ps.executeQuery(sql);

			while (rs.next()) {
				// 根据具体情况定（获取传感数据类型）
				ChuanGanData cgd = new ChuanGanData();
				
				cgd.setYanWu(rs.getInt("YanWuData"));
				cgd.setTuRang(rs.getInt("TuRangData"));
				cgd.setYuShui(rs.getInt("YuShuiData"));
				cgd.setGuangMin(rs.getInt("GuangMinData"));
				cgd.setWenDu(rs.getInt("WenDuData"));
				cgd.setShiDu(rs.getInt("ShiDuData"));
				cgd.setDataTime(rs.getDate("DataTime")+"");
				
				info.add(cgd);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(rs, ps, conn);
		}
		return info;
	}
	
	/**
	 * 无参数查询,返回所有传感器基本信息
	 * 
	 * @return 所有传感器基本信息的list
	 */
	public static List<ChuanGanModel> getChuanGanModel() {
		
		String sql = "select * from ChuanGanModel";
		
		Connection conn = null;
		Statement ps = null;
		ResultSet rs = null;
		
		List<ChuanGanModel> info = new ArrayList<ChuanGanModel>();
		
		try {
			conn = DBUtil.getSQLSERVERConnection();
			ps = conn.createStatement();
			rs = ps.executeQuery(sql);

			while (rs.next()) {
				// 根据具体情况定（获取传感数据类型）
				ChuanGanModel cgm = new ChuanGanModel();
				
				cgm.setChuanGanId(rs.getInt(("ChuanGanId"))); 
				cgm.setChuanGanName(rs.getString("ChuanGanName"));
				cgm.setChuanGanWhere(rs.getString("ChuanGanWhere"));
				cgm.setChuanGanDataType(rs.getString("ChuanGanDataType"));
				
				info.add(cgm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(rs, ps, conn);
		}
		return info;
	}
	
	/**
	 * 无参数查询,返回所有控制设备名称
	 * 
	 * @return 所有控制器的list
	 */
	public static List<ControlModel> getAllControlModel() {

		Connection conn = null;
		Statement ps = null;
		ResultSet rs = null;
		List<ControlModel> info = new ArrayList<ControlModel>();

		try {
			conn = DBUtil.getSQLSERVERConnection();
			ps = conn.createStatement();
			rs = ps.executeQuery(sql2);

			while (rs.next()) {
				// 根据具体情况定（获取传感数据类型）
				ControlModel cm = new ControlModel();
				cm.setControlModelId(rs.getInt(("ControlModelId"))); 
				cm.setControlModelName(rs.getString("ControlModelName"));
				cm.setControlModelWhere(rs.getString("ControlModelWhere"));
				cm.setControlModelOpen(rs.getInt("ControlModelOpen"));
				cm.setControlModelClose(rs.getInt("ControlModelClose"));
				cm.setControlModelState(rs.getBoolean("ControlModelState"));
				cm.setControlTime(rs.getDate("DataTime"));
				info.add(cm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(rs, ps, conn);
		}
		return info;
	}
	

	
	
	
	
	/**
	 * 无参数查询,返回所有控制设备名称
	 * 
	 * @return 所有记录的名字的list
	 */
//	public static List<String> getAllControlModelState() {
//
//		Connection conn = null;
//		Statement ps = null;
//		ResultSet rs = null;
//		List<String> info = new ArrayList<String>();
//
//		try {
//			conn = DBUtil.getSQLSERVERConnection();
//			ps = conn.createStatement();
//			rs = ps.executeQuery(sql2);
//
//			while (rs.next()) {
//				// 根据具体情况定（获取传感数据类型）
//				info.add(rs.getString("ControlModelState")); 
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			DBUtil.closeConn(rs, ps, conn);
//		}
//		return info;
//	}
	
	/**
	 * 有参数查询,返回最近一次采集传感数据
	 * 
	 * @return 所有记录的名字的list
	 */
	public static List<ChuanGanData> getLastChuanGanDataById(int ChuanGanId) {
		
		String sql = "select top 1 * from ChuanGanData where ChuanGanId="+ChuanGanId+" order by ChuanGanDataId  desc";
		
		Connection conn = null;
		Statement ps = null;
		ResultSet rs = null;
		List<ChuanGanData> info = new ArrayList<ChuanGanData>();

		try {
			conn = DBUtil.getSQLSERVERConnection();
			ps = conn.createStatement();
			rs = ps.executeQuery(sql);

			while (rs.next()) {
				
				ChuanGanData cgd = new ChuanGanData();
				
				cgd.setYanWu(rs.getInt("YanWuData"));
				cgd.setTuRang(rs.getInt("TuRangData"));
				cgd.setYuShui(rs.getInt("YuShuiData"));
				cgd.setGuangMin(rs.getInt("GuangMinData"));
				cgd.setWenDu(rs.getInt("WenDuData"));
				cgd.setShiDu(rs.getInt("ShiDuData"));
				cgd.setDataTime(rs.getDate("DataTime")+"");
				
				info.add(cgd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(rs, ps, conn);
		}
		return info;
	}
	
	
	/**
	 * 更新类方法,只执行一条的情况
	 * @param ModelType
	 * @param ModelWhere
	 * @return 执行更新的结果
	 */
	public static boolean updateControlModelStatuById(int ModelControlId, int ModelStatu) {
		
		String sql = "update ControlModel set ControlModelState=? where ControlModelId=?";
		
		int result = 0;
		boolean flag = true;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil.getSQLSERVERConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ModelStatu);
			pstmt.setInt(2, ModelControlId);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(pstmt, conn);
		}

		if (result == 0) {
			flag = false;
		}
		return flag;
	}
	

	/**
	 * 有参数查询,返回类型据情况稍加修改
	 * 
	 * @param ModelType
	 * @param ModelWhere
	 * @return 返回指定字段的记录list
	 */
//	public static List<String> getAllByMM(String ModelType, String ModelWhere) {
//
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		List<String> info = new ArrayList<String>();
//
//		try {
//			conn = DBUtil.getSQLSERVERConnection();
//			pstmt = conn.prepareStatement(sql1);
//			pstmt.setString(1, ModelType);
//			pstmt.setString(2, ModelWhere);
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				info.add(rs.getString(1));
//				info.add(rs.getString(2));
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			DBUtil.closeConn(rs, pstmt, conn);
//		}
//
//		return info;
//	}

	

//	/**
//	 * 更新类方法,同时执行两条的情况
//	 * @param ModelType
//	 * @return 执行删除的结果
//	 */
//	public static boolean deleteByModelType(String ModelType) {
//		
//		int result1 = 0;
//		int result2 = 0;
//		boolean flag = true;
//
//		Connection conn = null;
//		PreparedStatement pstmt1 = null;
//		PreparedStatement pstmt2 = null;
//
//		try {
//			conn = DBUtil.getSQLSERVERConnection();
//			conn.setAutoCommit(false);
//
//			pstmt1 = conn.prepareStatement(sql4);
//			pstmt1.setString(1, ModelType);
//
//			pstmt2 = conn.prepareStatement(sql5);
//			pstmt2.setString(1, ModelType);
//
//			result1 = pstmt1.executeUpdate();
//			result2 = pstmt2.executeUpdate();
//
//			conn.commit();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			try {
//				conn.rollback();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		} finally {
//			DBUtil.closeConn(pstmt1, pstmt2, conn);
//		}
//
//		if (result1 == 0 || result2 == 0) {
//			flag = false;
//		}
//		return flag;
//	}
}
