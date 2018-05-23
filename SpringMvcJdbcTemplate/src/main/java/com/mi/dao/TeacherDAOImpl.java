package com.mi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.mi.model.Student;
import com.mi.model.Teacher;

public class TeacherDAOImpl implements TeacherDAO {
	private JdbcTemplate jdbcTemplate;

	public TeacherDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public int saveOrUpdate(Teacher teacher) {
		int ret=-1;
		System.out.println("1");
		if (teacher.getInscriptionCode() > 0) {
			String sql = "UPDATE teacher SET TeacherLastName=?,TeacherFirstName=?,UniversityName=?,TeacherEmail=?,"
					+ "TeacherOption=?,TeacherPassword=?,TeacherGrade=?, laboratoire=?, sexe=? "
					+ "WHERE TeacherCode=?";
			try{
				jdbcTemplate.update(sql, teacher.getUserLastName(),teacher.getUserFirstName(),
						teacher.getUniversityName(),teacher.getUserEmail(),teacher.getOption(),
						teacher.getUserPassword(),teacher.getGrade(),teacher.getLaboratoire(),
						teacher.getSexe(),teacher.getInscriptionCode());
				ret= 1;
			}catch(Exception e){
				ret=2;
				e.printStackTrace();
			}finally{
				return ret;
			}
		} else {
			String sql = "INSERT INTO teacher (TeacherCode,TeacherLastName, TeacherFirstName,"
					+ " UniversityName, TeacherEmail,TeacherOption,TeacherPassword,TeacherGrade,laboratoire,sexe)"
					+ " VALUES (?, ?, ?, ?,?,?,?,?,?,?)";
			
			try{
				int i=jdbcTemplate.update(sql, teacher.getInscriptionCode(),teacher.getUserLastName(),teacher.getUserFirstName(),
						teacher.getUniversityName(),teacher.getUserEmail(),teacher.getOption(),
						teacher.getUserPassword(),teacher.getGrade(),teacher.getLaboratoire(),teacher.getSexe());
				ret=3;
			}catch(Exception e){
				ret=4;
				e.printStackTrace();
			}finally {
				return ret;
			}
		}

	}

	@Override
	public void delete(int inscriptionCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Teacher get(int inscriptionCode) {
		String sql = "SELECT * FROM teacher WHERE TeacherCode=" + inscriptionCode;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Teacher>() {

			@Override
			public Teacher extractData(ResultSet rs) throws SQLException,
			DataAccessException {
				if (rs.next()) {
					Teacher teacher = new Teacher();
					teacher.setGrade(rs.getString("TeacherGrade"));
					teacher.setUserLastName(rs.getString("TeacherLastName"));
					teacher.setUserFirstName(rs.getString("TeacherFirstName"));
					teacher.setUserEmail(rs.getString("TeacherEmail"));
					teacher.setUniversityName(rs.getString("UniversityName"));
					teacher.setUserPassword(rs.getString("TeacherPassword"));
					teacher.setOption(rs.getString("TeacherOption"));
					teacher.setSexe(rs.getString("sexe"));
					teacher.setLaboratoire(rs.getString("laboratoire"));
					return teacher;
				}

				return null;
			}

		});
	}

	@Override
	public Teacher getByMail(String email) {
		String sql = "SELECT * FROM teacher WHERE TeacherEmail=" + email;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Teacher>() {

			@Override
			public Teacher extractData(ResultSet rs) throws SQLException,
			DataAccessException {
				if (rs.next()) {
					Teacher teacher = new Teacher();
					teacher.setGrade(rs.getString("TeacherGrade"));
					teacher.setUserLastName(rs.getString("TeacherLastName"));
					teacher.setUserFirstName(rs.getString("TeacherFirstName"));
					teacher.setUserEmail(rs.getString("TeacherEmail"));
					teacher.setUniversityName(rs.getString("UniversityName"));
					teacher.setUserPassword(rs.getString("TeacherPassword"));
					teacher.setOption(rs.getString("TeacherOption"));
					teacher.setSexe(rs.getString("sexe"));
					teacher.setLaboratoire(rs.getString("laboratoire"));
					return teacher;
				}

				return null;
			}

		});
	}

	@Override
	public List<Teacher> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
