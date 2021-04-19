package kr.onekey.dk.dto;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class DkManagerLoginDto {

    private String loginId;
    private String password;
    private boolean keepMeLogin = false;
}
