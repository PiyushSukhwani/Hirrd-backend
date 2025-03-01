package com.hirrd.service;

import com.hirrd.dto.ProfileDTO;
import com.hirrd.exception.JobPortalException;

import java.util.List;

public interface ProfileService {

    public Long createProfile(String email) throws JobPortalException;

    public ProfileDTO getProfile(Long id) throws JobPortalException;

    public ProfileDTO updateProfile (ProfileDTO profileDTO) throws JobPortalException;

    public List<ProfileDTO> getAllProfiles() throws JobPortalException;
}
