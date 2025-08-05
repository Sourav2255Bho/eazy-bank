package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Schema(
        name = "Accounts",
        description = "Schema to hold Account Information"
)
@Data
public class AccountsDto {

    @Schema(
            description = "Account number of EazyBank Account", example = "3850284078"
    )
    @NotEmpty(message = "Account Number cannot be null or empty")
    @Pattern(regexp = "(&|[0-9]{10})", message = "Account Number must be 10 digits")
    private Long accountNumber;

    @Schema(
            description = "Account type of EazyBank Account", example = "Savings"
    )
    @NotEmpty(message = "Account type cannot be null or empty")
    private String accountType;

    @Schema(
            description = "EazyBank branch Address", example = "123-ABC, Mira road, Mumbai"
    )
    @NotEmpty(message = "Branch address cannot be null or empty")
    private String branchAddress;
}
