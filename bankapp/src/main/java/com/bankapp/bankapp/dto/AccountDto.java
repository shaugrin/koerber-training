package com.bankapp.bankapp.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.springframework.core.env.Environment;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    @NotNull(message = "{id.null.message}")
    private Integer id;
    @NotNull(message = "{name.null.message}")
    private String name;
    @NotNull(message = "{balance.null.message}")
    private BigDecimal balance;

}
