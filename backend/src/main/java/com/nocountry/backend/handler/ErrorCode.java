package com.nocountry.backend.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

        // Internal Errors: 1 to 0999
        GENERIC_ERROR("0001", "The system is unable to complete the request."),

        HTTP_MEDIATYPE_NOT_SUPPORTED("0002",
                        "Requested media type is not supported. Please use application/json or application/xml as 'Content-Type' header value"),

        HTTP_MESSAGE_NOT_WRITABLE("0003", "Missing 'Accept' header. Please add 'Accept' header."),

        HTTP_MEDIA_TYPE_NOT_ACCEPTABLE("0004",
                        "Requested 'Accept' header value is not supported. Please use application/json or application/xml as 'Accept' value"),

        JSON_PARSE_ERROR("0005", "Make sure request payload should be a valid JSON object."),

        HTTP_MESSAGE_NOT_READABLE("0006",
                        "Make sure request payload should be a valid JSON or XML object according to 'Content-Type'."),

        ENTITY_NOT_FOUND("404", "Entity not found."),

        REGISTER_BAD_REQUEST("021", ""),

        EMAIL_EXISTS("022", "The email address you provided,is already in use."),

        CAR_NOT_FOUND("404", "Requested Car not found."),

        OVERLAPPED_BOOKING("401", "The booking overlaps with another existing booking."),

        USER_NOT_FOUND("404", "User not found."),

        USER_REGISTER("400", "Problem with registration."),

        LOGIN_BAD_CREDENTIALS("401", "Bad login credentials.");

        private String errCode;

        private String errMsgKey;
}