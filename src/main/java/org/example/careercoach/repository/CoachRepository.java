// src/main/java/org/example/careercoach/repository/CoachRepository.java
package org.example.careercoach.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.careercoach.entity.Coach;

@Mapper
public interface CoachRepository {
    @Select("SELECT * FROM coaches WHERE id = #{id}")
    Coach findById(String id);
}
