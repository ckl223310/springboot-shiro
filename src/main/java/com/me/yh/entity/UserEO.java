package com.me.yh.entity;

import com.me.utils.base.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class UserEO extends BaseEntity {

    private String userId;

    private String userName;

    private String password;

    private String salt;

    private Date updateDate;

    private Date updateBy;
}