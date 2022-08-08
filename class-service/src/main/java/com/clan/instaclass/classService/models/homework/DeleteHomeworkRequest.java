package com.clan.instaclass.classService.models.homework;

import lombok.Data;

@Data
public class DeleteHomeworkRequest {
    private Integer id;
    private Integer classId;
}
