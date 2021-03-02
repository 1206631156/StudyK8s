package com.example.activititest.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ActReModel implements Serializable {
    private String id;

    private Integer rev;

    private String name;

    private String key;

    private String category;

    private Date createTime;

    private Date lastUpdateTime;

    private Integer version;

    private String metaInfo;

    private String deploymentId;

    private String editorSourceValueId;

    private String editorSourceExtraValueId;

    private String tenantId;
    private String description;
    private static final long serialVersionUID = 1L;
}
