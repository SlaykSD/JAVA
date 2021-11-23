package ru.mephi.labs.lab5;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;

@Data @Builder
public class Price {
    @NonNull
    private Integer priceId;
    private String name;
    private String numCode;
    @NonNull
    private Long lot;
    private BigDecimal value;

}
