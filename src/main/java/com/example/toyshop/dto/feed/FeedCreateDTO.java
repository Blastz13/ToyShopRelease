package com.example.toyshop.dto.feed;

import lombok.Data;

import java.util.Date;

@Data
public class FeedCreateDTO {
    private String title;
    private String description;
    private Date dateCreate;
    private Long authorId;
    private Long categoryId;
}
