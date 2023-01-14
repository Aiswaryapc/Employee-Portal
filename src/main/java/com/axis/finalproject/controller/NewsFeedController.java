package com.axis.finalproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.finalproject.entity.NewsFeed;
import com.axis.finalproject.product.dto.NewsFeedDto;
import com.axis.finalproject.service.NewsFeedService;

@RestController
@RequestMapping("/api/test/")
@CrossOrigin("http://localhost:3000")
public class NewsFeedController {
	@Autowired
	private NewsFeedService newsFeedService;
 
	
	@GetMapping("newsFeed/{newsFeedId}")
	public NewsFeed getNewsFeedById(@PathVariable Integer newsFeedId) {
		return  newsFeedService.getNewsFeedById(newsFeedId);
	
	}
	
	//@PreAuthorize("hasRole('ROLE_USER')  or hasRole('ROLE_ADMIN')")
	@GetMapping("/newsFeed")
	public List<NewsFeed> getNewsFeed()	{
		return newsFeedService.getAllNewsFeed();
		}
	
	@PostMapping("newsFeed/add")
	public ResponseEntity<String> addNewsFeed(@RequestBody NewsFeedDto newsFeed){
		newsFeedService.addNewsFeed(newsFeed);
		return new ResponseEntity<String>("NewsFeed added!!!",HttpStatus.CREATED);
	}
	
	@DeleteMapping("newsFeed/delete/{newsFeedId}")
	public ResponseEntity<String> deleteNewsFeed(@PathVariable Integer newsFeedId){
		newsFeedService.deleteNewsFeedById(newsFeedId);
		return new ResponseEntity<String>("NewsFeed Deleted!!!",HttpStatus.OK);
	}

	}
