package ru.hazard.generator.implement.models;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by hazard on 17.11.17.
 */
public class FromFile {

    private String pathOfFile;
    private List<String> result;

    public FromFile(String pathOfFile) {
        this.pathOfFile = pathOfFile;
    }

    public void next() {
        result = new ArrayList();
        Scanner scn;
        try {
            scn = new Scanner(new File(pathOfFile));
        } catch (Exception e) {
            System.out.println("Файл не найден");
            return;
        }

        while (scn.hasNext()) {
            result.add(scn.next());
        }
    }

    public String getPathOfFile() {
        return pathOfFile;
    }

    public void setPathOfFile(String pathOfFile) {
        this.pathOfFile = pathOfFile;
    }

    public List<String> getResult() {
        return result;
    }

    public void setResult(List<String> result) {
        this.result = result;
    }
}
