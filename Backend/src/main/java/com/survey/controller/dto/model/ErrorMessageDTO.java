package com.survey.controller.dto.model;


import java.util.Map;

/**
 * @author Artur Myseliuk
 */

public class ErrorMessageDTO {
    private Map<String, String> fieldErrors;
    private Map<String, String> globalError;

    public ErrorMessageDTO() {
    }

    public ErrorMessageDTO(Map<String, String> fieldErrors, Map<String, String> globalError) {
        this.fieldErrors = fieldErrors;
        this.globalError = globalError;
    }

    public Map<String, String> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(Map<String, String> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    public Map<String, String> getGlobalError() {
        return globalError;
    }

    public void setGlobalError(Map<String, String> globalError) {
        this.globalError = globalError;
    }
}
