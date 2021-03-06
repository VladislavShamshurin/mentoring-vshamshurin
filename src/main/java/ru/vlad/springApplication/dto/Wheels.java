package ru.vlad.springApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Wheels {

    private Long id;

    @NotNull
    @Size(max = 250)
    private String description;

    @NotNull
    private BigDecimal price;

    @NotNull
    private int radius;

}
