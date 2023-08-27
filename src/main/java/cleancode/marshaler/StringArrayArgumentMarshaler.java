package cleancode.marshaler;

import cleancode.ArgsException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static cleancode.ArgsException.ErrorCode.MISSING_STRING;

public class StringArrayArgumentMarshaler implements ArgumentMarshaler{
    private List<String> arrayValue = new ArrayList<String>();

    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        try {
            arrayValue.add(currentArgument.next());
        } catch (NoSuchElementException e) {
            throw new ArgsException(MISSING_STRING);
        }
    }

    public static List<String> getValue(ArgumentMarshaler am) {
        if (am != null && am instanceof StringArrayArgumentMarshaler)
            return ((StringArrayArgumentMarshaler) am).arrayValue;
        else
            return new ArrayList<String>();
    }
}
