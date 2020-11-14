package com.arrudamoreira.cursomc.services;

import com.arrudamoreira.cursomc.security.UserSpringSecurity;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author marioarruda
 */
public class UserService {

    public static UserSpringSecurity authenticated() {
        try {
            return (UserSpringSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        } catch (Exception e) {
            return null;
        }

    }
}
