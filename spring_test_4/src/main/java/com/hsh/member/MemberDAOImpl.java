package com.hsh.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO{

	@Inject
	private DataSource dataSource;
	
	@Override
	public int join(MemberDTO memberDTO) {
		Connection con;
		int result = 0;
		try {
			con = dataSource.getConnection();
			String sql = "insert into member2 values(?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, memberDTO.getId());
			st.setString(2, memberDTO.getPw());
			st.setString(3, memberDTO.getName());
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//DB연결 .. close
		}
		return result;
	}

	@Override
	public MemberDTO login(MemberDTO memberDTO) {
		try {
			Connection con = dataSource.getConnection();
			String sql = "select * from member2 where id=? and pw=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, memberDTO.getId());
			st.setString(2, memberDTO.getPw());
			ResultSet rs = st.executeQuery();
			if(rs.next()){
				memberDTO.setName(rs.getString("name"));
			}else{
				memberDTO = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//DB연결 .. close
		}
		
		return memberDTO;
	}

	@Override
	//회원정보수정
	public MemberDTO updte(MemberDTO memberDTO) {
		try {
			Connection  con = dataSource.getConnection();
			String sql = "update member2 set pw=?,name=? where id=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, memberDTO.getPw());
			st.setString(2, memberDTO.getName());
			st.setString(3, memberDTO.getId());
			int result = st.executeUpdate();
			if(result <= 0){
				memberDTO = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//DB연결 .. close
		}
		return memberDTO;
	}

	//회원탈퇴
	@Override
	public MemberDTO delete(MemberDTO memberDTO) {
		try {
			Connection con = dataSource.getConnection();
			String sql = "delete member2 where id=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, memberDTO.getId());
			int result = st.executeUpdate();
			if(result > 0){
				memberDTO = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//DB연결 .. close
		}
		return memberDTO;
	}

}
