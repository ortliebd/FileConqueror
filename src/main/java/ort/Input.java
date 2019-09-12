package ort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Input {
    private String input;
    private BufferedReader reader;

    Input() {
        input = "";
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    void read() throws IOException {
        input = reader.readLine();
    }

    String getInput() {
        return input;
    }

}
