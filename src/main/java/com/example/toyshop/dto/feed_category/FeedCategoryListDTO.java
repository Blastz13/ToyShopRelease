package com.example.toyshop.dto.feed_category;

import com.example.toyshop.dto.feed.FeedDTO;
import lombok.Data;

import java.util.List;

@Data
public class FeedCategoryListDTO {
    private Long id;
    private String title;
    private String slug;
    private List<FeedDTO> feeds;
}
