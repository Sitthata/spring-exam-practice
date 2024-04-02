package com.example.springexampractice.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageDTO<T> {
    private List<T> content;
    private int totalPages;
    private long totalElements;
    private int size;
    private boolean first;
    private boolean last;

    @JsonIgnore
    private Integer number;

    public Integer getPage() {
        return number;
    }
}
