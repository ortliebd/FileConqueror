package ort;

import java.io.IOException;

public class FileConqueror {
    public static void main(String[] args) throws IOException {
        Console console = new Console();
        Input input = new Input();
        Output output = new Output();

        while (!console.getShouldClose()) {
            input.read();
            String message = console.execute(input.getInput());
            output.print(message);
        }
    }
}
