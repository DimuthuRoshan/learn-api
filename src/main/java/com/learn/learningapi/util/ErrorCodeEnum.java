package com.learn.learningapi.util;

import java.util.HashMap;
import java.util.Map;

public enum ErrorCodeEnum {
    ERROR_0001("Required request body is missing", "400", "BAD_REQUEST");

    private static final Map <String, ErrorCodeEnum> LABEL = new HashMap <> ();
    private static final Map<String, ErrorCodeEnum> HTTP_STATUS_CODE = new HashMap<>();
    private static final Map<String, ErrorCodeEnum> ERROR_TYPE = new HashMap<>();

    static {
        for (ErrorCodeEnum e : values()) {
            LABEL.put(e.label, e);
            HTTP_STATUS_CODE.put(e.httpStatusCode, e);
            ERROR_TYPE.put(e.errorType, e);
        }
    }

    public final String label;
    public final String httpStatusCode;
    public String  errorType;

    private ErrorCodeEnum(String label, String httpStatusCode, String errorType) {
        this.label = label;
        this.httpStatusCode = httpStatusCode;
        this.errorType = errorType;
    }

    public static ErrorCodeEnum valueOfLabel(String label) {
        return LABEL.get(label);
    }

    public static ErrorCodeEnum valueOfHttpStatusCode(int number) {
        return HTTP_STATUS_CODE.get(number);
    }

    public static ErrorCodeEnum valueOfAtomicWeight(float weight) {
        return ERROR_TYPE.get(weight);
    }
}
