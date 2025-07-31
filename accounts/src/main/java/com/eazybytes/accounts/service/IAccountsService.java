package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDto;

public interface IAccountsService {

    /**
     * Creates a new account and store it into the database based on
     * the customer details
     * @param customerDto - CustomerDto Object
     */
    void createAccount(CustomerDto customerDto);

    /**
     * Fetches the account details of the given mobile number
     *
     * @param mobileNumber - Input Mobile Number
     * @return Accounts Details based on the given Mobile Number
     */
    CustomerDto fetchAccount(String mobileNumber);
}
