package com.eazybytes.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Schema(
        name = "loans",
        description = "Schema to hold Loan information"
)
@Data
public class LoansDto {

    @NotEmpty(message = "Mobile number cannot be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number must be 10 digits")
    @Schema(
            description = "Mobile Number of Customer", example = "9284773267"
    )
    private String mobileNumber;

    @NotEmpty(message = "Loan Number can not be a null or empty")
    @Pattern(regexp = "(^$|[0-9]{12})", message = "Loan Number must be 12 digits")
    private String loanNumber;

    @NotEmpty(message = "Loan Type cannot be a null or empty")
    @Schema(
            description = "Type of the Loan", example = "Home Loan"
    )
    private String loanType;

    @Positive(message = "Total Loan amount should be greater than zero")
    @Schema(
            description = "Total loan amount paid", example = "10000"
    )
    private int totalLoan;

    @PositiveOrZero(message = "Total loan amount paid should be equal or greater than zero")
    @Schema(
            description = "Total loan amount paid", example = "1000"
    )
    private int amountPaid;

    @PositiveOrZero(message = "Total outstanding amount should be equal or greater than zero")
    @Schema(
            description = "Total outstanding amount against a loan", example = "99000"
    )
    private int outstandingAmount;
}
