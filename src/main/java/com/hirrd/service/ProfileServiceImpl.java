package com.hirrd.service;

import com.hirrd.dto.ProfileDTO;
import com.hirrd.dto.UserDTO;
import com.hirrd.exception.JobPortalException;
import com.hirrd.model.Profile;
import com.hirrd.repository.ProfileRepository;
import com.hirrd.utility.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("profileService")
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public Long createProfile(UserDTO userDTO) throws JobPortalException {
        Profile profile = new Profile();
        profile.setId(Utilities.getNextSequence("profiles"));
        profile.setName(userDTO.getName());
        profile.setEmail(userDTO.getEmail());
        profile.setPicture(null);
        profile.setSkills(new ArrayList<>());
        profile.setExperiences(new ArrayList<>());
        profile.setCertifications(new ArrayList<>());
        profileRepository.save(profile);
        return profile.getId();
    }

    @Override
    public ProfileDTO getProfile(Long id) throws JobPortalException {
        return profileRepository.findById(id).orElseThrow(() -> new JobPortalException("PROFILE_NOT_FOUND")).toProfileDTO();
    }

    @Override
    public ProfileDTO updateProfile (ProfileDTO profileDTO) throws JobPortalException {
        profileRepository.findById(profileDTO.getId()).orElseThrow(() -> new JobPortalException("PROFILE_NOT_FOUND"));
        profileRepository.save(profileDTO.toEntity());
        return profileDTO;
    }

    @Override
    public List<ProfileDTO> getAllProfiles() throws JobPortalException {
        return profileRepository.findAll().stream().map(Profile::toProfileDTO).toList();
    }
}