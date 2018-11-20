package com.macfu.repository;

import com.macfu.po.EducationExperience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: liming
 * @Date: 2018/11/20 16:12
 * @Description:
 */
public interface EducationExperienceRepository extends JpaRepository<EducationExperience, Integer> {
    List<EducationExperience> findByUserId(String userId);
}
