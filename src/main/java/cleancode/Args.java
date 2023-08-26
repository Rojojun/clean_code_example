package cleancode;

import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class Args {
    private Map<Character, ArgumentMarshaler> marshalers;
    private Set<Character> argsFound;
    private ListIterator<String> currentArgument;

    public void ______________public_area______________() {}

    private void ______________private_area______________() {}
    private void parseSchema(String schema) throws ArgsException {
        for (String element : schema.split(", ")) {
            if (element.length() > 0) {
                parseSchemaElement(element.trim());
            }
        }
    }

    private void parseSchemaElement(String element) throws ArgsException {
        char elementId = element.charAt(0);
        String elementTail = element.substring(1);


        if ()
    }

    private void parseArgumentStrings(List<String> argsList) throws ArgsException {
        for (currentArgument = argsList.listIterator(); currentArgument.hasNext();) {
            String argString = currentArgument.next();
            if (argString.startsWith("-")) {
                parseArgumentCharacters(argString.substring(1));
            } else {
                currentArgument.previous();
                break;
            }
        }
    }

    private void parseArgumentCharacters(String argChars) throws ArgsException {
        for (int i = 0; i < argChars.length(); i++) {
            parseArgumentCharacter(argChars.charAt(i));
        }
    }

    private void parseArgumentCharacter(char argChar) throws ArgsException {
        ArgumentMarshaler m = marshalers.get(argChar);
        if (m == null) {
            throw new RuntimeException();
        } else {
            argsFound.add(argChar);
        } try {
            m.set(currentArgument);
        } catch (Exception e) {
            throw e;
        }
    }
}
