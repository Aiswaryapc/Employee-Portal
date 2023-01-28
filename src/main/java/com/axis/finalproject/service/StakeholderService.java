package com.axis.finalproject.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.finalproject.dto.StakeholderDto;

import com.axis.finalproject.entity.Stakeholders;

import com.axis.finalproject.exceptions.StakeholderNotFoundException;
import com.axis.finalproject.repository.ProjectRepository;
import com.axis.finalproject.repository.StakeholderRepository;
@Service
public class StakeholderService {
	@Autowired
	private StakeholderRepository stakeholderRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	public Stakeholders getStakeholderById(Integer stakeholderId) {
		Optional<Stakeholders> stakeholder=stakeholderRepository.findById(stakeholderId);
		if(!stakeholder.isPresent()) 
			throw new StakeholderNotFoundException("Stakeholder not found by id "+stakeholderId);
		return stakeholder.get();

	}

	
	public List<Stakeholders> getAllStakeholders() {
		
		return (List<Stakeholders>) stakeholderRepository.findAll();
	}


	public void addStakeholders(StakeholderDto stakeholderDto) {
		Stakeholders stakeholder = new Stakeholders(stakeholderDto.getName(),
				stakeholderDto.getOrganaization(),
				stakeholderDto.getPosition(),
				stakeholderDto.getEmail(),
				stakeholderDto.getState(),
				projectRepository.findByProjName(stakeholderDto.getProject())
				);
		stakeholderRepository.save(stakeholder);
	}

	@Transactional
	public Stakeholders updateStakeholder(int stakeholderId,StakeholderDto stakeholderDto) {
		 Stakeholders stake
         = stakeholderRepository.findById(stakeholderId)
               .get();

     if (Objects.nonNull(stakeholderDto.getProject())
            ) {
            		 
            stake.setProject(projectRepository.findByProjName(stakeholderDto.getProject()));
            		
         }


     return stakeholderRepository.save(stake);
	}

	public void deleteStakeholderById(Integer stakeholderId) {
		
		stakeholderRepository.deleteById(stakeholderId);

	}
}
