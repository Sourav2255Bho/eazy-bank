package com.eazybytes.cards.service;

import com.eazybytes.cards.dto.CardsDto;

public interface ICardsService {

    /**
     * @param mobileNumber - Mobile Number of the customer
     * */
    void createCard(String mobileNumber);

    /**
     * @param mobileNumber - Input Mobile Number
     * @return Card details based on the given mobile number
     * */
    CardsDto fetchCard(String mobileNumber);

    /**
     * @param cardsDto - CardsDto Object
     * @return boolean indicating if the update of card details is done or not
     * */
    boolean updateCard(CardsDto cardsDto);

    /**
     * @param moblieNumber - Input Mobile Number
     * @return indicating boolean if the delete of the card details is successful or not
     * */
    boolean deleteCard(String moblieNumber);
}
