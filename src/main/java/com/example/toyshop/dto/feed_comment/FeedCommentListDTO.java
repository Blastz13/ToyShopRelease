package com.example.toyshop.dto.feed_comment;

import com.example.toyshop.dto.user.UserDTO;
import lombok.Data;

@Data
public class FeedCommentListDTO {
    private Long id;
    private String comment;
    private UserDTO author;
}
