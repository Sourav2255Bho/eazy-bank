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
    
    /**
     * Updates the Account details of the customer except the account number and return boolean 
     * indicating if the update is successful or not
     * 
     * @param customerDto - customer Object
     * @return boolean indicating if the update of the account details is successful or not
     */
    boolean updateAccount(CustomerDto customerDto);
}
