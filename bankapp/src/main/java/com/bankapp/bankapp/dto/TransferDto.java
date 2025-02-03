package com.bankapp.bankapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferDto {
    @NotNull(message = "{from.account.null.message}")
    @Range(min = 0, message = "{from.account.min.message}")
    private int fromId;
    @NotNull(message = "{to.account.null.message}")
    private int toId;
    @Range(min = 0, message = "{amount.min.message}")
    @NotNull(message = "{amount.null.message}")
    private BigDecimal amount;
}
