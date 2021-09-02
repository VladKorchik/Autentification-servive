package ru.netology.autentificationServive.repository;

import ru.netology.autentificationServive.authorities.Authorities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserRepository {
    private Map<String, String> listOfUsers;
    private final List<Authorities> EMPTY_AUTORITIES = new ArrayList<>();
    private List<Authorities> fullAutorities = new ArrayList<>();

    public UserRepository() {
        this.listOfUsers = new ConcurrentHashMap<>();
        fullAutorities.add(Authorities.READ);
        fullAutorities.add(Authorities.DELETE);
        fullAutorities.add(Authorities.WRITE);
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        //next line protect from NPE
        if (listOfUsers.isEmpty()) {
            return EMPTY_AUTORITIES;
        }
        if (listOfUsers.containsKey(user) & listOfUsers.get(user).equals(password)) {
            return fullAutorities;
        } else return EMPTY_AUTORITIES;
    }
}
