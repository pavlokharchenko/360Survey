package com.survey.service.impl;

import com.survey.dao.GroupRepository;
import com.survey.entity.Group;
import com.survey.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Taras Danylchuk. Created on 14.03.2016.
 */
@Service
public class GroupServiceBean implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public void save(Group group) {
        groupRepository.save(group);
    }

    @Override
    public boolean isExist(Group group) {
        return groupRepository.exists(group.getName());
    }

    @Override
    public Page<Group> findAll(Pageable pageable) {
        return groupRepository.findAll(pageable);
    }

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public Group find(String name) {
        return groupRepository.findOne(name);
    }
}
