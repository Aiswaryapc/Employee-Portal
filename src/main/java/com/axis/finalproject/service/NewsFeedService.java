package com.axis.finalproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.finalproject.dto.NewsFeedDto;
import com.axis.finalproject.entity.Employee;
import com.axis.finalproject.entity.NewsFeed;
import com.axis.finalproject.exceptions.NewsFeedNotFoundException;
import com.axis.finalproject.repository.CommentRepository;
import com.axis.finalproject.repository.EmployeeRepository;
import com.axis.finalproject.repository.NewsFeedRepository;


@Service
public class NewsFeedService {
	@Autowired
	private NewsFeedRepository newsFeedRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	public NewsFeed getNewsFeedById(Integer newsFeedId) {
		Optional<NewsFeed> newsFeed=newsFeedRepository.findById(newsFeedId);
		if(!newsFeed.isPresent()) 
			throw new NewsFeedNotFoundException("NewsFeed not found by id "+newsFeedId);
		return newsFeed.get();

	}

	
	public List<NewsFeed> getAllNewsFeed() {
		
		return (List<NewsFeed>) newsFeedRepository.findAll();
	}


	public void addNewsFeed(NewsFeedDto newsFeedDto) {
		
		NewsFeed newsFeed = new NewsFeed(newsFeedDto.getHeading(),
				newsFeedDto.getDescription(),
				newsFeedDto.getImage(),
				employeeRepository.findByemail(newsFeedDto.getEmail())
				);
		newsFeedRepository.save(newsFeed);
	}

	
	public void deleteNewsFeedById(Integer newsFeedId) {
		
		newsFeedRepository.deleteById(newsFeedId);

	}
}

