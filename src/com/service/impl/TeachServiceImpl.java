package com.service.impl;

import com.entity.Teacher;
import com.service.TeachService;

public class TeachServiceImpl implements TeachService {


    @Override
    public boolean teachCheck(Teacher teacher) {
        return true;
    }

    @Override
    public Teacher getTeach(String tId) {
        return null;
    }
}
