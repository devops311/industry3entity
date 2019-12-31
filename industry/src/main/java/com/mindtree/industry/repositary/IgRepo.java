package com.mindtree.industry.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.industry.entity.Ig;

@Repository
public interface IgRepo extends JpaRepository<Ig,Integer> {

}
