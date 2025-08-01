package com.eazybytes.accounts.controller;

import com.eazybytes.accounts.constants.AccountsConstants;
import com.eazybytes.accounts.dto.CustomerDto;
import com.eazybytes.accounts.dto.ResponseDto;
import com.eazybytes.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class AccountsController {

    private IAccountsService accountService;

    /*
    * How does the conversion of the json to DTO object happens and also while sending the response
    * how does it again converts the DTO to JSON response and then sends it?
    * -> This is because, inside SpringBoot there are Jackson libraries, with the help of those
    *   libraries sprinboot can convert a JSON content to a DTO object and a CTO object to a JSON response
    * */
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto){
        accountService.createAccount(customerDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccountDetails(@RequestParam String mobileNumber){
        CustomerDto customerDto = accountService.fetchAccount(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerDto);
    }
    
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccountDetails(@RequestBody CustomerDto customerDto){
    	boolean isUpdated = accountService.updateAccount(customerDto);
    	if(isUpdated) {
    		return ResponseEntity
    				.status(HttpStatus.OK)
    				.body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
    	}else {
    		return ResponseEntity
    				.status(HttpStatus.INTERNAL_SERVER_ERROR)
    				.body(new ResponseDto(AccountsConstants.STATUS_500, AccountsConstants.MESSAGE_500));
    	}
    }
}
