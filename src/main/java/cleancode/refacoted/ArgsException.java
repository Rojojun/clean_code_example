package cleancode.refacoted;

import static cleancode.refacoted.ArgsException.ErrorCode.*;

public class ArgsException extends Exception{
    private char errorArgumentId = '\0';
    private String errorParameter = null;
    private ErrorCode errorCode = OK;

    public ArgsException() {}

    public ArgsException(String message) {
        super(message);
    }

    public ArgsException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ArgsException(ErrorCode errorCode, String errorParameter) {
        this.errorCode = errorCode;
        this.errorParameter = errorParameter;
    }

    public ArgsException(ErrorCode errorCode, char errorArgumentId, String errorParameter) {
        this.errorCode = errorCode;
        this.errorArgumentId = errorArgumentId;
        this.errorParameter = errorParameter;
    }

    public char getErrorArgumentId() {
        return errorArgumentId;
    }

    public String getErrorParameter() {
        return errorParameter;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorArgumentId(char errorArgumentId) {
        this.errorArgumentId = errorArgumentId;
    }

    public void setErrorParameter(String errorParameter) {
        this.errorParameter = errorParameter;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public String errorMessage() {
//        switch (errorCode) {
//            case OK:
//                return "TILT: Should not get here.";
//            case UNEXPECTED_ARGUMENT:
//                return String.format("Argument -%c unexpected.", errorArgumentId);
//            case MISSING_STRING:
//                return String.format("Could not find string parameter for -%c.",
//                        errorArgumentId);
//            case INVALID_INTEGER:
//                return String.format("Argument -%c expects an integer but was '%s'.",
//                        errorArgumentId, errorParameter);
//            case MISSING_INTEGER:
//                return String.format("Could not find integer parameter for -%c.",
//                        errorArgumentId);
//            case INVALID_DOUBLE:
//                return String.format("Argument -%c expects a double but was '%s'.",
//                        errorArgumentId, errorParameter);
//            case MISSING_DOUBLE:
//                return String.format("Could not find double parameter for -%c.",
//                        errorArgumentId);
//            case INVALID_ARGUMENT_NAME:
//                return String.format("'%c' is not a valid argument name.", errorArgumentId);
//            case INVALID_ARGUMENT_FORMAT:
//                return String.format("'%s' is not a valid argument format.",
//                        errorParameter);
//        }
//        return "";

        return switch (errorCode) {
            case OK -> "TILT: Should not get here.";
            case UNEXPECTED_ARGUMENT -> String.format("Argument -%c unexpected.", errorArgumentId);
            case MISSING_STRING -> String.format("Could not find string parameter for -%c.",
                    errorArgumentId);
            case INVALID_INTEGER -> String.format("Argument -%c expects an integer but was '%s'.",
                    errorArgumentId, errorParameter);
            case MISSING_INTEGER -> String.format("Could not find integer parameter for -%c.",
                    errorArgumentId);
            case INVALID_DOUBLE -> String.format("Argument -%c expects a double but was '%s'.",
                    errorArgumentId, errorParameter);
            case MISSING_DOUBLE -> String.format("Could not find double parameter for -%c.",
                    errorArgumentId);
            case INVALID_ARGUMENT_NAME -> String.format("'%c' is not a valid argument name.", errorArgumentId);
            case INVALID_ARGUMENT_FORMAT -> String.format("'%s' is not a valid argument format.",
                    errorParameter);
        };
    }

    public enum ErrorCode {
        OK,
        INVALID_ARGUMENT_FORMAT,
        UNEXPECTED_ARGUMENT,
        INVALID_ARGUMENT_NAME,
        MISSING_STRING,
        MISSING_INTEGER,
        MISSING_DOUBLE,
        INVALID_INTEGER,
        INVALID_DOUBLE
    }
}
