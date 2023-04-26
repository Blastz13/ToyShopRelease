package com.example.toyshop.dto.feed_comment;

import com.example.toyshop.dto.feed.FeedDTO;
import com.example.toyshop.dto.user.UserDTO;
import lombok.Data;

@Data
public class FeedCommentDetailDTO {
    private Long id;
    private String comment;
    private UserDTO author;
    private FeedDTO feed;
}
