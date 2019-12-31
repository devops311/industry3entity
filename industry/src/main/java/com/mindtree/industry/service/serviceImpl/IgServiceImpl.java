package com.mindtree.industry.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.industry.dto.IgDto;
import com.mindtree.industry.entity.Ig;
import com.mindtree.industry.repositary.IgRepo;
import com.mindtree.industry.service.IgService;
@Service
public class IgServiceImpl implements IgService {

	@Autowired
	IgRepo igrepo;
	
	
	@Override
	public IgDto insert(IgDto ig) {
		
		Ig igentity=new Ig();
		igentity.setIgId(ig.getIgId());
		igentity.setIgName(ig.getIgName());
		
		igrepo.save(igentity);
		return ig;
	}

}
