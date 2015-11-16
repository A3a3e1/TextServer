package com.a3a3el.mvc.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by paulvoropaiev on 11/12/15.
 */
public class StringHandler implements IStringHandler {

    Charset charset;
    Path pathObj;
    String path="/Users/paulvoropaiev/IdeaProjects/TextServer/src/files/strings.txt";
    List<String> list;

    public StringHandler() {
        charset = Charset.forName("US-ASCII");
        pathObj = FileSystems.getDefault().getPath(path);
        list = new ArrayList<>();
    }

    //Works fine!
    @Override
    public List<String> getFullStringList() {
        try (BufferedReader reader = Files.newBufferedReader(pathObj, charset)) {
            String line = null;
            int index=0;
            while ((line = reader.readLine()) != null) {
                list.add(index++, line);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

        return list;
    }

    //Works fine!
    @Override
    public void removeSingleString(String s) {
        list = getFullStringList();
        list.remove(s);
        writeFullList(list);
    }

    //Works fine!
    @Override
    public void removeFullList() {
        try (FileWriter fileWriter = new FileWriter(path);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {
            writer.write("", 0, 0);
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

    //Works fine!
    @Override
    public void writeSingleString(String s) {
        list = getFullStringList();
        list.add(s);
        writeFullList(list);
    }

    //Works fine!
    @Override
    public void writeFullList(List<String> list) {
        removeFullList();
        try (FileWriter fileWriter = new FileWriter(path, true);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                String line = iterator.next() + "\n";
                writer.write(line, 0, line.length());
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }
}
