package com.multi.threading.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetPostByIdApiRes {


    private String userId;
    private String id;
    private String title;
    private String body;
}
