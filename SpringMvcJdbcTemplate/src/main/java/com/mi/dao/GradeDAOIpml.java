package com.mi.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mi.model.Grade;


@Repository("gradeDao")
public class GradeDAOIpml  extends AbstractDao<Integer, Grade>  implements GradeDAO{

	@Override
	public void save(Grade grade) {
	persist(grade);
		
	}

	@Override
	public void delete(int gradeId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Grade findByGradeName(String gradeName) {
		// TODO Auto-generated method stub
		return findByName(gradeName);
	}

	@Override
	public Grade findOne(int gradeId) {
		// TODO Auto-generated method stub
		return getByKey(gradeId);
	}

	@Override
	public List<Grade> findAll() {
		@SuppressWarnings("unchecked")
		List<Grade> grade = getEntityManager()
				.createQuery("SELECT u FROM Grade u ORDER BY u.nomGrade ASC")
				.getResultList();
		return grade;
	}

}
