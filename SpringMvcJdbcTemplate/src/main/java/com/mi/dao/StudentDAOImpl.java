package com.mi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.mi.model.Contact;
import com.mi.model.Student;
import com.mi.model.Teacher;
import com.mi.model.User;

public class StudentDAOImpl implements StudentDAO {
	private JdbcTemplate jdbcTemplate;

	public StudentDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public int saveOrUpdate(Student student) {
		int ret=-1;
		System.out.println("1");
		if (student.getInscriptionCode() > 0) {
			String sql = "UPDATE student SET StudentLastName=?,StudentFirstName=?,UniversityName=?,StudentEmail=?,"
					+ "StudentOption=?,StudentPassword=?,StudentLevel=?, laboratoire=?, sexe=? "
					+ "WHERE StudentCode=?";
			try{
				jdbcTemplate.update(sql, student.getUserLastName(),student.getUserFirstName(),
						student.getUniversityName(),student.getUserEmail(),student.getOption(),
						student.getUserPassword(),student.getStudentLevel(),student.getLaboratoire(),
						student.getSexe(),student.getInscriptionCode());
				ret= 1;
			}catch(Exception e){
				ret=2;
				e.printStackTrace();
			}finally{
				return ret;
			}
		} else {
			String sql = "INSERT INTO student (StudentCode,StudentLastName, StudentFirstName,"
					+ " UniversityName, StudentEmail,StudentOption,StudentPassword,StudentLevel,laboratoire,sexe)"
					+ " VALUES (?, ?, ?, ?,?,?,?,?,?,?)";
			
			try{
				int i=jdbcTemplate.update(sql, student.getInscriptionCode(),student.getUserLastName(),student.getUserFirstName(),
						student.getUniversityName(),student.getUserEmail(),student.getOption(),
						student.getUserPassword(),student.getStudentLevel(),student.getLaboratoire(),student.getSexe());
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
	public Student get(int inscriptionCode) {
		String sql = "SELECT * FROM student WHERE StudentCode=" + inscriptionCode;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Student>() {

			@Override
			public Student extractData(ResultSet rs) throws SQLException,
			DataAccessException {
				if (rs.next()) {
					Student student = new Student();
					student.setStudentLevel(rs.getString("StudentLevel"));
					student.setUserLastName(rs.getString("StudentLastName"));
					student.setUserFirstName(rs.getString("StudentFirstName"));
					student.setUserEmail(rs.getString("StudentEmail"));
					student.setUniversityName(rs.getString("UniversityName"));
					student.setUserPassword(rs.getString("StudentPassword"));
					student.setOption(rs.getString("StudentOption"));
					student.setSexe(rs.getString("sexe"));
					student.setLaboratoire(rs.getString("laboratoire"));
					return student;
				}

				return null;
			}

		});
	}

	@Override
	public List<Student> list() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public User getByEmailAndPassword(String email, String password,String quality) {

		if(quality.equals("etudiant")){
			String sql = "SELECT * FROM student WHERE StudentEmail='" + email+"' AND StudentPassword='"+password+"'";
			return jdbcTemplate.query(sql, new ResultSetExtractor<Student>() {

				@Override
				public Student extractData(ResultSet rs) throws SQLException,
				DataAccessException {
					if (rs.next()) {
						Student student = new Student();
						student.setInscriptionCode(rs.getInt("StudentCode"));
						student.setStudentLevel(rs.getString("StudentLevel"));
						student.setUserLastName(rs.getString("StudentLastName"));
						student.setUserFirstName(rs.getString("StudentFirstName"));
						student.setUserEmail(rs.getString("StudentEmail"));
						student.setUniversityName(rs.getString("UniversityName"));
						student.setUserPassword(rs.getString("StudentPassword"));
						student.setOption(rs.getString("StudentOption"));
						student.setSexe(rs.getString("sexe"));
						student.setLaboratoire(rs.getString("laboratoire"));
						student.setUserFunction("Etudiant");
						return student;
					}

					return null;
				}

			});
		}else{
			String sql = "SELECT * FROM teacher WHERE TeacherEmail='" + email+"' AND TeacherPassword='"+password+"'";
			return jdbcTemplate.query(sql, new ResultSetExtractor<Teacher>() {

				@Override
				public Teacher extractData(ResultSet rs) throws SQLException,
				DataAccessException {
					if (rs.next()) {
						Teacher teacher = new Teacher();
						teacher.setInscriptionCode(rs.getInt("TeacherCode"));
						teacher.setGrade(rs.getString("TeacherGrade"));;
						teacher.setUserLastName(rs.getString("TeacherLastName"));
						teacher.setUserFirstName(rs.getString("TeacherFirstName"));
						teacher.setUserEmail(rs.getString("TeacherEmail"));
						teacher.setUniversityName(rs.getString("UniversityName"));
						teacher.setUserPassword(rs.getString("TeacherPassword"));
						teacher.setOption(rs.getString("TeacherOption"));
						teacher.setSexe(rs.getString("sexe"));
						teacher.setLaboratoire(rs.getString("laboratoire"));
						teacher.setUserFunction("Enseignant");
						return teacher;
					}

					return null;
				}

			});
		}
	}
	@Override
	public Student getByMail(String email) {
		String sql = "SELECT * FROM student WHERE StudentEmail=" + email;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Student>() {

			@Override
			public Student extractData(ResultSet rs) throws SQLException,
			DataAccessException {
				if (rs.next()) {
					Student student = new Student();
					student.setStudentLevel(rs.getString("StudentLevel"));
					student.setUserLastName(rs.getString("StudentLastName"));
					student.setUserFirstName(rs.getString("StudentFirstName"));
					student.setUserEmail(rs.getString("StudentEmail"));
					student.setUniversityName(rs.getString("UniversityName"));
					student.setUserPassword(rs.getString("StudentPassword"));
					student.setOption(rs.getString("StudentOption"));
					student.setSexe(rs.getString("sexe"));
					student.setLaboratoire(rs.getString("laboratoire"));
					return student;
				}

				return null;
			}

		});
	}


}
