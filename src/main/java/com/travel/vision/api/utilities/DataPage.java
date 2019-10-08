package com.travel.vision.api.utilities;

import lombok.Data;
import org.springframework.data.domain.Page;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
public class DataPage<U> {

    public static final DataPage<?> EMPTY = new DataPage<>();

    private List<U> data = new ArrayList<>();
    private int totalPages = 0;
    private long totalElements = 0;
    private int pageNumber = 1;
    private int pageSize = 0;

    public DataPage() {
        // Intentionally Private
    }

    public static <U, V> DataPage<U> newPage(Page<V> page, Function<V, U> mapper) {
        DataPage<U> dataPage = new DataPage<>();
        dataPage.data = page.getContent().stream().map(mapper).collect(Collectors.toList());
        dataPage.totalPages = page.getTotalPages();
        dataPage.totalElements = page.getTotalElements();
        dataPage.pageNumber = page.getNumber() + 1;
        dataPage.pageSize = dataPage.data.size();
        return dataPage;
    }

    public static <U> DataPage<U> newPage(List<U> items) {
        DataPage<U> dataPage = new DataPage<>();
        dataPage.data = items;
        return dataPage;
    }

    @SuppressWarnings("unchecked")
    public static <T> DataPage<T> empty() {
        return (DataPage<T>) getEMPTY();
    }

    public static DataPage<?> getEMPTY() {
        return EMPTY;
    }
}