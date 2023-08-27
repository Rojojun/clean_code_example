package cleancode.marshaler;

import cleancode.ArgsException;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static cleancode.ArgsException.ErrorCode.MISSING_INTEGER;

public class IntegerArgumentMarshaler implements ArgumentMarshaler {
    private int integerValue = 0;

    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        String parameter = null;
        try {
            parameter = currentArgument.next();
            integerValue = Integer.parseInt(parameter);
        } catch (NoSuchElementException e) {
            throw new ArgsException(MISSING_INTEGER);
        } catch (NumberFormatException e) {
            throw new ArgsException(MISSING_INTEGER, parameter);
        }
    }

    public static int getValue(ArgumentMarshaler am) {
        if (am != null && am instanceof IntegerArgumentMarshaler)
            return ((IntegerArgumentMarshaler) am).integerValue;
        else
            return 0;
    }
}
