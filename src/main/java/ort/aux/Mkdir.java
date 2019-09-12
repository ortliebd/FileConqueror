package ort.aux;

import java.io.File;
import java.util.Vector;
import java.util.regex.Pattern;

public class Mkdir extends Command {
    public Mkdir() {
        super("mkdir",
                new String[]{""},
                new String[]{""});
    }

    public Mkdir(String name, String[] params, String[] args) {
        super(name, params, args);
    }

    @Override
    public String validate(String input) {
        String regex = "mkdir\\s+(?:/(?!/)|\\w|\\.|\\\\\\s|[^/])+";
        boolean isValid = Pattern.matches(regex, input);
        return isValid ? "OK" : "Entrada invalida";
    }

    @Override
    public String execute(String path, Vector<String> input) {
        File file = new File(path);

        return null;
    }
}
