package com.eazybytes.cards.service.impl;

import com.eazybytes.cards.constants.CardsConstants;
import com.eazybytes.cards.dto.CardsDto;
import com.eazybytes.cards.entity.Cards;
import com.eazybytes.cards.exception.CardAlreadyExistsException;
import com.eazybytes.cards.exception.ResourceNotFoundException;
import com.eazybytes.cards.mapper.CardsMapper;
import com.eazybytes.cards.repository.CardsRepository;
import com.eazybytes.cards.service.ICardsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class CardsServiceImpl implements ICardsService {

    private CardsRepository cardsRepo;

    /**
     * @param mobileNumber - Mobile Number of the customer
     */
    @Override
    public void createCard(String mobileNumber) {
        Optional<Cards> optionalCard = cardsRepo.findByMobileNumber(mobileNumber);
        if(optionalCard.isPresent()){
            throw new CardAlreadyExistsException("Card already registered with the given mobile number " + mobileNumber);
        }
        cardsRepo.save(createNewCard(mobileNumber));
    }

    /**
     * @param mobileNumber - Mobile Number of the customer
     * @return the new card details
     * */
    private Cards createNewCard(String mobileNumber){
        Cards cards = new Cards();
        long randomNumber = 100000000000L + new Random().nextInt(900000000);
        cards.setCardNumber(Long.toString(randomNumber));
        cards.setCardType(CardsConstants.CREDIT_CARD);
        cards.setMobileNumber(mobileNumber);
        cards.setTotalLimit(CardsConstants.NEW_CARD_LIMIT);
        cards.setAvailableAmount(CardsConstants.NEW_CARD_LIMIT);
        cards.setAmountUsed(0);

        return cards;
    }

    /**
     * @param mobileNumber - Input Mobile Number
     * @return Card details based on the given mobile number
     */
    @Override
    public CardsDto fetchCard(String mobileNumber) {
        Cards card = cardsRepo.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card", "Mobile Number", mobileNumber)
        );
        return CardsMapper.mapToCardsDto(card, new CardsDto());
    }

    /**
     * @param cardsDto - CardsDto Object
     * @return boolean indicating if the update of card details is done or not
     */
    @Override
    public boolean updateCard(CardsDto cardsDto) {
        Cards card = cardsRepo.findByCardNumber(cardsDto.getCardNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Card", "Card Number", cardsDto.getCardNumber())
        );
        CardsMapper.maptoCards(cardsDto, card);
        cardsRepo.save(card);
        return true;
    }

    /**
     * @param moblieNumber - Input Mobile Number
     * @return indicating boolean if the delete of the card details is successful or not
     */
    @Override
    public boolean deleteCard(String moblieNumber) {
        Cards card = cardsRepo.findByMobileNumber(moblieNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card", "Mobile Number", moblieNumber)
        );
        cardsRepo.deleteById(card.getCardId());
        return true;
    }
}
