package com.example.activititest.po;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class MeunModel implements Serializable {
    private Integer id;
    private String label;
    private Integer menuId;
    private String materialsId;
    private Integer parentId;
    private List<MeunModel> children;
}
