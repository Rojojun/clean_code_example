package cleancode.refacoted.marshaler;

import cleancode.refacoted.ArgsException;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static cleancode.refacoted.ArgsException.ErrorCode.MISSING_DOUBLE;

public class DoubleArgumentMarshaler implements ArgumentMarshaler{
    private double doubleValue = 0;

    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        String parameter = null;
        try {
            parameter = currentArgument.next();
            doubleValue = Double.parseDouble(parameter);
        } catch (NoSuchElementException e) {
            throw new ArgsException(MISSING_DOUBLE);
        } catch (NumberFormatException e) {
            throw new ArgsException(MISSING_DOUBLE, parameter);
        }
    }

    public static double getValue(ArgumentMarshaler am) {
        if (am != null && am instanceof DoubleArgumentMarshaler)
            return ((DoubleArgumentMarshaler) am).doubleValue;
        else
            return 0;
    }
}
