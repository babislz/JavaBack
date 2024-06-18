package com.bosch.example.impl;

import org.springframework.stereotype.Component;
import com.bosch.example.services.PwdValidator;

@Component
public class DftPwdValidator implements PwdValidator {
    
    @Override
    public boolean validate(String pwd) {
        if(pwd == null || pwd.length() < 8) {
            return false;
        }

        boolean hLowerCase = false;
        boolean hUpperCase = false;
        boolean hDigit = false;

        for (char c : pwd.toCharArray()) {
            if (Character.isLowerCase(c)) {
                hLowerCase = true;
            } else if (Character.isUpperCase(c)) {
                hUpperCase = true;
            } else if (Character.isDigit(c)) {
                hDigit = true;
            }

            if (hLowerCase && hUpperCase && hDigit) {
                return true;
            }
        }
        return false;
    }
}
