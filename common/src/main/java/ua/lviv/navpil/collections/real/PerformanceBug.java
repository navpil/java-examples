package ua.lviv.navpil.collections.real;

import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PerformanceBug {

    public void realStoryWithList() {
        List<MicroMessage> l = getMessages();

        for (int i = l.size() - 1; i >= 0; i--) {
            l.get(i).delete();
        }
    }

    @NotNull
    private LinkedList<MicroMessage> getMessages() {
        return new LinkedList<>();
    }

    private class MicroMessage {
        public void delete() {

        }
    }
}
