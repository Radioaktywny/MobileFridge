package org.mobilefridge.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.stereotype.Component;

/**
 * Created by Marcin on 28.10.2016.
 */

@Component
public class AccountAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private AccountUserDetalisService accountUserDetalisService;

    @Autowired
    private PasswordEncoder passwordEncoder;

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

        UserDetails userDetails = accountUserDetalisService.loadUserByUsername(username);
        return userDetails;
    }
}
