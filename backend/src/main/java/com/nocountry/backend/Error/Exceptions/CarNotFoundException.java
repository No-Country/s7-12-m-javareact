package com.nocountry.backend.Error.Exceptions;

import com.nocountry.backend.Error.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public class CarNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    private final String errMsgKey;
    private final String errorCode;

    public CarNotFoundException(ErrorCode code) {
        super(code.getErrMsgKey());
        this.errMsgKey = code.getErrMsgKey();
        this.errorCode = code.getErrCode();
    }

    public CarNotFoundException(final String message) {
        super(message);
        this.errMsgKey = ErrorCode.CAR_NOT_FOUND.getErrMsgKey();
        this.errorCode = ErrorCode.CAR_NOT_FOUND.getErrCode();
    }

    public String getErrMsgKey() {
        return errMsgKey;
    }

    public String getErrorCode() {
        return errorCode;
    }
}