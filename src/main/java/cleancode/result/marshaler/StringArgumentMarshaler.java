package cleancode.result.marshaler;

import cleancode.result.ArgsException;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static cleancode.result.ArgsException.ErrorCode.MISSING_STRING;

public class StringArgumentMarshaler implements ArgumentMarshaler{
    private String stringValue = "";
    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        try {
            stringValue = currentArgument.next();
        } catch (NoSuchElementException e) {
            throw new ArgsException(MISSING_STRING); }
    }

    public static String getValue(ArgumentMarshaler am) {
        if (am != null && am instanceof StringArgumentMarshaler) {
            return ((StringArgumentMarshaler) am).stringValue;
        } else
            return "";
    }
}