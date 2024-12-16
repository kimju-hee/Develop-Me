package com.example.Develop_Me.Validator;

import com.example.Develop_Me.enums.ErrorMessage;
import com.example.Develop_Me.enums.RegexPattern;

public class UserNickNameValidator {
    private static final int MAX_LEN = 50;
    private static final int MIN_LEN = 2;
    public UserNickNameValidator(){}

    public static  void validate(String input){
        validateIsStartBlank(input);
        validateIsEndBlank(input);
        validateNickNameCond(input);

    }

    private static void validateIsStartBlank(String nickName) {
        if (RegexPattern.BLANK_IN_START.matches(nickName)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_BLANK_IN_START.getMessage());
        }
    }

    private static void validateIsEndBlank(String nickName) {
        if (RegexPattern.BLANK_IN_END.matches(nickName)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_BLANK_IN_END.getMessage());
        }
    }

    private static void validateNickNameCond(String nickName){
        if(RegexPattern.NOT_NICKNAME_COND.matches(nickName)){
            throw new IllegalArgumentException(ErrorMessage.NICKNAME_COND.getMessage());
        }
    }

}
