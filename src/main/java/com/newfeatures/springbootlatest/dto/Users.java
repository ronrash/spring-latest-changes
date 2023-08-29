package com.newfeatures.springbootlatest.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users {

    private int id;
    private String name;
    private String type;
    private String location;
    private String avatar_url;
    private String url;
}
