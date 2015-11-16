package com.a3a3el.mvc.model;

import java.util.List;

/**
 * Created by paulvoropaiev on 11/13/15.
 */
public interface IStringHandler {

    List<String> getFullStringList();

    void removeSingleString(String s);

    void removeFullList();

    void writeSingleString(String s);

    void writeFullList(List<String> list);


}
