/*
 * Copyright (c) Marcin Witek 2016 / 2017
 * Engineering project for studies on Cracow university of technology
 */

package org.mobilefridge.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class AccountAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    private final AccountUserDetalisService accountUserDetalisService;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AccountAuthenticationProvider(PasswordEncoder passwordEncoder, AccountUserDetalisService accountUserDetalisService) {
        this.passwordEncoder = passwordEncoder;
        this.accountUserDetalisService = accountUserDetalisService;
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken token)
            throws AuthenticationException {
        if (token.getCredentials() == null || userDetails.getPassword() == null) {
            throw new BadCredentialsException("Credetnials may not be null");
        }
        if (!passwordEncoder.matches((String) token.getCredentials(), (userDetails.getPassword()))) {
            throw new BadCredentialsException("Invalid credentials.");
        }

    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken token) throws AuthenticationException {

        return accountUserDetalisService.loadUserByUsername(username);
    }
}
