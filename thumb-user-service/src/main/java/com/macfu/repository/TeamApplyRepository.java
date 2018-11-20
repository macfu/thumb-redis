package com.macfu.repository;

import com.macfu.po.TeamApply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: liming
 * @Date: 2018/11/20 16:32
 * @Description:
 */
public interface TeamApplyRepository extends JpaRepository<TeamApply, Integer> {
    List<TeamApply> findByProjectCreatorId(String projectCreatorId);

    List<TeamApply> findByApplicationsId(String applicationsId);
}
