package com.axis.finalproject.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axis.finalproject.entity.ProfileImage;




@Repository
public interface ProfileImageRepository extends JpaRepository<ProfileImage, String> {
	

	ProfileImage findByemployeeId(String id);
Optional<ProfileImage> getByemployeeId(String id);
	ProfileImage findBystakeHolderId(String id);
	Boolean existsByemployeeId(String id);

	void deleteByemployeeId(String userId);

}
