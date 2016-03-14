package com.survey.controller.dto.model;


import java.util.Map;

/**
 * @author Artur Myseliuk
 */

public class ErrorMessage {
    private Map<String, String> fieldErrors;
    private Map<String, String> globalErrors;

    public ErrorMessage() {
    }

    public ErrorMessage(Map<String, String> fieldErrors, Map<String, String> globalErrors) {
        this.fieldErrors = fieldErrors;
        this.globalErrors = globalErrors;
    }

    public Map<String, String> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(Map<String, String> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    public Map<String, String> getGlobalErrors() {
        return globalErrors;
    }

    public void setGlobalErrors(Map<String, String> globalErrors) {
        this.globalErrors = globalErrors;
    }
}
