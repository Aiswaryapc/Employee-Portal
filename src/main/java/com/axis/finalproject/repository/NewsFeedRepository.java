package com.axis.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axis.finalproject.entity.NewsFeed;
import com.axis.finalproject.entity.Stakeholders;

@Repository
public interface NewsFeedRepository extends JpaRepository<NewsFeed, Integer> {
 
	NewsFeed findByHeading(String heading);
	NewsFeed findByNewsFeedId(Integer newsfeedId);
}
