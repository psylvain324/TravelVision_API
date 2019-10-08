package com.travel.vision.api.utilities;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.Min;

@Validated
public class StandardQueryParamsCustom {
    @Min(0)
    @ApiModelProperty(value = "Page Number")
    private int fromRecords = 1;

    @Min(0)
    @ApiModelProperty(value = "Number of records to show")
    private int pageSize = 20;


    @ApiModelProperty(value = "Comma delimited list of sort by fields. Prefix a column with '-' for descending order")
    private String sort = null;

    public int getFromRecords() {
        return fromRecords;
    }

    public void setFromRecords(int fromRecords) {
        this.fromRecords = fromRecords;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "StandardQueryParamsCustom{" +
                "fromRecords=" + fromRecords +
                ", pageSize=" + pageSize +
                ", sort='" + sort + '\'' +
                '}';
    }
}
