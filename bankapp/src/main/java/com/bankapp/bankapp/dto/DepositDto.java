package com.bankapp.bankapp.dto;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepositDto {
    @NotNull(message = "{id.null.message}")
    private Integer id;
    @NotNull(message = "{amount.null.message}")
    private BigDecimal amount;
}
