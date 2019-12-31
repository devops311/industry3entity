package com.mindtree.industry.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.industry.entity.Project;
@Repository
public interface ProjectRepo extends JpaRepository<Project,Integer> {

}
