package org.muyun.rabbitconsumer.entry;

import java.util.Set;

public class User {
    private String uuid;
    private String name;
    private Set<String> phone;

    public User() {
    }

    public User(String uuid, String name, Set<String> phone) {
        this.uuid = uuid;
        this.name = name;
        this.phone = phone;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getPhone() {
        return phone;
    }

    public void setPhone(Set<String> phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                '}';
    }
}
