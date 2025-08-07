package com.eazybytes.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Schema(
        name = "Cards",
        description = "Schema to hold Card information"
)
@Data
public class CardsDto {

    @NotEmpty(message = "Mobile Number should not be empty")
    @Pattern(regexp = "($|[0-9]{10})", message = "Mobile number must be 10 digits")
    @Schema(
            description = "Mobile Number of Customer", example = "9284773267"
    )
    private String mobileNumber;

    @NotEmpty
    @Pattern(regexp = "($|[0-9]{12})", message = "Card number must be 12 digits")
    @Schema(
            description = "Card Number of customer", example = "100100013456"
    )
    private String cardNumber;

    @NotEmpty(message = "Card Type cannot be null or empty")
    @Schema(
            description = "Type of the card", example = "Credit Card"
    )
    private String cardType;

    @Positive(message = "Total card limit should be greater than zero")
    @Schema(
            description = "Total amount limit available against a crad", example = "100000"
    )
    private int totalLimit;

    @PositiveOrZero(message = "Amount used should be 0 or more than 0")
    @Schema(
            description = "Total amount used by a Customer", example = "1000"
    )
    private int amountUsed;

    @PositiveOrZero(message = "Total available amount should be equal or greater than zero")
    @Schema(
            description = "Total available amount against a card", example = "90000";
    )
    private int availableAmount;
}
