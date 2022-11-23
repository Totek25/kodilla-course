package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {

    private final List<ForumUser> theForumUserList = new ArrayList<>();

    public Forum() {
        theForumUserList.add(new ForumUser(1, "username1", 'M', LocalDate.of(1965, 1, 1), 10));
        theForumUserList.add(new ForumUser(2, "username2", 'M', LocalDate.of(1988, 1, 1), 11));
        theForumUserList.add(new ForumUser(3, "username3", 'F', LocalDate.of(1985, 1, 1), 10));
        theForumUserList.add(new ForumUser(4, "username4", 'M', LocalDate.of(1995, 1, 1), 12));
        theForumUserList.add(new ForumUser(5, "username5", 'F', LocalDate.of(2000, 1, 1), 15));
    }

    public List<ForumUser> getUserList() {
        return List.copyOf(theForumUserList);

    }
}
