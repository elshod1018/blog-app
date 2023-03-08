package com.company.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment {
    private String id;
    private String userId;
    private String blogId;
    private String text;
}
