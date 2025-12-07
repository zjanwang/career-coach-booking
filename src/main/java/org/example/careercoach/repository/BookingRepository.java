// src/main/java/org/example/careercoach/repository/BookingRepository.java
package org.example.careercoach.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.example.careercoach.entity.Booking;
import java.util.List;

@Mapper
public interface BookingRepository {
    @Insert("INSERT INTO bookings(uid, user_id, coach_id, start_time, end_time, status) " +
            "VALUES(#{uid}, #{userId}, #{coachId}, #{startTime}, #{endTime}, #{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void save(Booking booking);

    @Select("SELECT * FROM bookings WHERE user_id = #{userId}")
    List<Booking> findByUserId(String userId);

    @Select("SELECT * FROM bookings WHERE uid = #{uid}")
    Booking findByUid(String uid);
}
