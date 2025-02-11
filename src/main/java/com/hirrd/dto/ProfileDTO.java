package com.hirrd.dto;

import com.hirrd.model.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Base64;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDTO {

    private Long id;
    private String email;
    private String jobTitle;
    private String company;
    private String location;
    private String about;
    private String picture;
    private List<String> skills;
    private List<Experience> experiences;
    private List<Certification> certifications;

    public Profile toEntity() {
        return new Profile(this.id, this.email, this.jobTitle, this.company, this.location, this.about, this.picture != null ? Base64.getDecoder().decode(this.picture) : null, this.skills, this
                .experiences, this.certifications);
    }
}
