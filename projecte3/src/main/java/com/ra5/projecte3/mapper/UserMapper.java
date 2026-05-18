package com.ra5.projecte3.mapper;

import org.springframework.stereotype.Component;

import com.ra5.projecte3.dto.AcademicProfileDTO;
import com.ra5.projecte3.dto.UserRequestDTO;
import com.ra5.projecte3.dto.UserResponseDTO;
import com.ra5.projecte3.model.AcademicProfile;
import com.ra5.projecte3.model.User;

import java.time.LocalDateTime;

@Component
public class UserMapper {

    public UserResponseDTO toDto(User user) {

        if (user == null) return null;

        UserResponseDTO dto = new UserResponseDTO();

        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setUsername(user.getUsername());
        dto.setRole(user.getRole());
        dto.setDataCreated(user.getDataCreated());

        if (user.getAcademicProfile() != null) {
            AcademicProfileDTO ap = new AcademicProfileDTO();
            ap.setGrade(user.getAcademicProfile().getGrade());
            ap.setCourse(user.getAcademicProfile().getCourse());
            ap.setObservations(user.getAcademicProfile().getObservations());
            ap.setStatus(user.getAcademicProfile().getStatus());

            dto.setAcademicProfile(ap);
        }

        return dto;
    }

    public User toEntity(UserRequestDTO request) {

        if (request == null) return null;

        User user = new User();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());
        user.setDataCreated(LocalDateTime.now());

        if (request.getGrade() != null) {
            AcademicProfile ap = new AcademicProfile();
            ap.setGrade(request.getGrade());
            ap.setCourse(request.getCourse());
            ap.setObservations(request.getObservations());
            ap.setStatus("ACTIVE");

            user.setAcademicProfile(ap);
        }

        return user;
    }
}