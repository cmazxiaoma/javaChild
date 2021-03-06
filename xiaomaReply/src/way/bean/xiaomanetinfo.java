package way.bean;

import java.util.*;
import java.sql.*;
import jdbc.bean.DBBean;
import java.util.ArrayList;

public class xiaomanetinfo {
	private String id;
	private String username;
	private String liuyan;
	private String times;
	private String shenhe;
	private String hide;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLiuyan() {
		return liuyan;
	}

	public void setLiuyan(String liuyan) {
		this.liuyan = liuyan;
	}

	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	public String getShenhe() {
		return shenhe;
	}

	public void setShenhe(String shenhe) {
		this.shenhe = shenhe;
	}

	public String getHide() {
		return hide;
	}

	public void setHide(String hide) {
		this.hide = hide;
	}

	// 返回所有留言信息的方法
	public static ArrayList<xiaomanetinfo> getxiaomanetList() {
		ArrayList<xiaomanetinfo> list = new ArrayList<xiaomanetinfo>();
		String sql = "select *from xiaonetinfo where hide='否'";
		DBBean xm = new DBBean();
		ResultSet rs = xm.executeQuery(sql);
		try {
			while (rs.next()) {
				xiaomanetinfo xmm = new xiaomanetinfo();
				xmm.setId(rs.getString("id"));
				xmm.setUsername(rs.getString("username"));
				xmm.setLiuyan(rs.getString("liuyan"));
				xmm.setTimes(rs.getString("times"));
				xmm.setShenhe(rs.getString("shenhe"));
				xmm.setHide(rs.getString("hide"));
				list.add(xmm);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		xm.close();
		return list;
	}

	// 返回单条留言信息记录的方法
	public static xiaomanetinfo getxiaonetinfoById(String id) {
		String sql = "select * from xiaonetinfo where id=" + id;
		DBBean xm = new DBBean();
		ResultSet rs = xm.executeQuery(sql);
		xiaomanetinfo xmm1 = new xiaomanetinfo();
		try {
			if (rs.next()) {
				xmm1.setId(rs.getString("id"));
				xmm1.setUsername(rs.getString("username"));
				xmm1.setLiuyan(rs.getString("liuyan"));
				xmm1.setTimes(rs.getString("times"));
				xmm1.setShenhe(rs.getString("shenhe"));
				xmm1.setHide(rs.getString("hide"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		xm.close();
		return xmm1;
	}

	// 修改某条留言信息记录的方法
	public static int updatexiaonetinfo(String id, String username, String liuyan, String shenhe, String hide) {
		int result = 0;
		String sql = "update xiaonetinfo set username='" + username + "',liuyan='" + liuyan + "',shenhe='" + shenhe
				+ "',hide='" + hide + "' where id=" + id;
		DBBean xm = new DBBean();
		result = xm.executeUpdate(sql);
		return result;
	}

	// 删除某条留言信息记录的方法
	public static int deletexiaonetinfo(String id) {
		int result = 0;
		String sql = "delete from xiaonetinfo where id=" + id;
		DBBean xm = new DBBean();
		result = xm.executeUpdate(sql);
		return result;
	}

	// 添加留言信息的方法
	public static int addxiaonetinfo(String username, String liuyan, String shenhe, String hide) {
		int result = 0;
		String sql = "insert into xiaonetinfo(username,liuyan,times,shenhe,hide) values('" + username + "','" + liuyan
				+ "',now(),'" + shenhe + "','" + hide + "')";
		DBBean xm = new DBBean();
		result = xm.executeUpdate(sql);
		return result;
	}
}