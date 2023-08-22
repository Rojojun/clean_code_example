package cleancode;

import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class Args {
    private Map<Character, ArgumentMarshaler> marshalers;
    private Set<Character> argsFound;
    private ListIterator<String> currentArgument;

    public void ______________public_area______________() {}

    private void ______________private_area______________() {}
    private void parseSchema(String schema) {
        for (String element : schema.split(", ")) {
            if (element.length() > 0) {
                parseSchemaElement(element.trim());
            }
        }
    }

    private void parseSchemaElement(String element) throws RuntimeException {
        char elementId = element.charAt(0);
        String elementTail = element.substring(1);


        if ()
    }


    private void parseArgumentCharacter(char argChar) throws RuntimeException {
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
