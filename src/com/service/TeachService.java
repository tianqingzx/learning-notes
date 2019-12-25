package com.service;

import com.entity.Teacher;

public interface TeachService {
    boolean teachCheck(Teacher teacher);
    Teacher getTeach(String tId);
}
