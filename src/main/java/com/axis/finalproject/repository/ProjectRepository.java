package com.axis.finalproject.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.axis.finalproject.entity.Employee;
import com.axis.finalproject.entity.Project;
import com.axis.finalproject.entity.Stakeholders;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

	Project findByProjName(String name);
	@Modifying
	@Query("update Project set stakeholder=?1, jobopportunities=?2 , flowChart=?3 , employee=?4 where projectId=?5")
	void updateProjectInfo(List<Stakeholders> stakeholder,String jobopportunities,
			String flowChart,List<Employee> employee,Integer projectId);
}