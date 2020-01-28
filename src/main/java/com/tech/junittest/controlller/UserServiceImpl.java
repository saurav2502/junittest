package com.tech.junittest.controlller;

import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl {
    private UserInterface repository;

    public UserServiceImpl(UserInterface userInterface) {
        this.repository = userInterface;
    }

    public void save(User user) {
        byte[] serializedUser = convert(user);
        SerializedUser serialised = new SerializedUser(serializedUser);
        repository.save(serialised);
    }

    private byte[] convert(User user) {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(user);
            return outputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    public List<User> getUsers() {

        return repository.findAll()
                .stream()
                .map(user -> convert(user.getByteStream())).collect(Collectors.toList());

    }

    private User convert(byte[] serializedUser) {
        try (
                ByteArrayInputStream inputStream = new ByteArrayInputStream(serializedUser);
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            User user = (User) objectInputStream.readObject();
            return user;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
