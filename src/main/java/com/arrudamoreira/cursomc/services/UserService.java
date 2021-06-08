package com.arrudamoreira.cursomc.services;

import com.arrudamoreira.cursomc.security.UserSS;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author marioarruda
 */
public class UserService {

    public static UserSS authenticated() {
        try {
            return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        } catch (Exception e) {
            return null;
        }

    }
}
