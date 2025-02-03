package com.bankapp.bankapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WithdrawDto {
    @NotNull(message = "{id.null.message}")
    private Integer id;
    @Range(min = 0, message = "{amount.min.message}")
    @NotNull(message = "{amount.null.message}")
    private BigDecimal amount;
}
