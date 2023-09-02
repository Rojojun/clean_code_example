package cleancode.refacoted.marshaler;

import cleancode.refacoted.ArgsException;

import java.util.Iterator;

public interface ArgumentMarshaler {
    void set(Iterator<String> currentArgument) throws ArgsException;
}
