package com.me.yh.entity;

import com.me.utils.base.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RoleEO extends BaseEntity {


    private String roleId;

    private String roleName;

    private Date updateDate;

    private String updateBy;
}