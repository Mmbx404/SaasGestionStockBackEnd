package org.mmb.gestionstock.common;

public interface SecurityParams {
    String JWT_HEADER_NAME = "Authorization";
    String SECRET = "ad5f7827-77e2-4cae-b2c7-50c735b715af";
    long EXPIRATION = 86400000;
    String HEADER_PREFIX = "Bearer ";
}
