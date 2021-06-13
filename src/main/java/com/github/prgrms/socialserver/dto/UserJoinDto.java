package com.github.prgrms.socialserver.dto;

import com.github.prgrms.socialserver.domain.Users;

public class UserJoinDto {
    private String principal;
    private String credentials;

    public UserJoinDto(String principal, String credentials) {
        this.principal = principal;
        this.credentials = credentials;
    }

    public Users toEntity() {
        return new Users(principal, credentials);
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }
}
