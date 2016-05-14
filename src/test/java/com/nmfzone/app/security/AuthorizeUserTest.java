package com.nfmzone.app.security;

import com.google.gson.Gson;

import org.junit.Test;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

// import com.nmfzone.app.model.User;

public class AuthorizeUserTest
{

    public static final Gson gson = new Gson();

    @Test
    public void user_authorization_test(Authentication authentication)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(gson.toJson(auth));
        // if (principal instanceof User) {
        //     System.out.println(gson.toJson(model));
        //     UserDetails userDetails = (UserDetails) principal;
        //     String principalRole = getRole(userDetails.getAuthorities());
        //     if (principalRole.equals(SecurityRole.ROLE_USER.name())) {
        //         LOGGER.debug("Principal: {} has permission to perform requested operation", userDetails);
        //         hasPermission = true;
        //     }
        // }
        // else {
        //     LOGGER.debug("User is anonymous. Permission denied.");
        // }
    }

}
