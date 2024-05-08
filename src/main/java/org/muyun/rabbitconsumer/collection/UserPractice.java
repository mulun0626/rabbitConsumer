package org.muyun.rabbitconsumer.collection;

import org.muyun.rabbitconsumer.entry.User;

import java.util.*;

public class UserPractice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, User> users = new HashMap<>();
        while (true) {
            System.out.println("请输入操作指令:");
            System.out.println("1、录入用户信息");
            System.out.println("2、查询所有用户信息");
            System.out.println("3、输入用户名查询用户信息");
            System.out.println("4、删除用户信息");
            switch (scanner.next()) {
                case "1":
                    User user = new User();
                    System.out.println("请输入用户名");
                    String name = scanner.next();
                    while (true) {
                        System.out.println("请输入联系方式A");
                        String phone = scanner.next();
                        System.out.println("请输入联系方式B");
                        String phoneB = scanner.next();
                        Set<String> phoneSet = new HashSet<String>();
                        phoneSet.add(phone);
                        phoneSet.add(phoneB);
                        if (phoneSet.size()<2) {
                            System.out.println("请不要输入相同的联系方式");
                        } else {
                            user.setPhone(phoneSet);
                            break;
                        }
                    }
                    user.setName(name);
                    user.setUuid(UUID.randomUUID().toString());
                    users.put(name, user);
                    break;
                case "2":
                    Collection<User> values = users.values();
                    if (values.size() == 0) {
                        System.out.println("当前并没有用户信息、请录入！！！！");
                    }
                    for (User value : values) {
                        System.out.println(value.toString());
                    }

                    break;
                case "3":
                    System.out.println("请输入用户名:");
                    String queryUserName = scanner.next();
                    User queryUser = users.get(queryUserName);
                    if (queryUser == null) {
                        System.out.println("未查到输入的用户信息！");
                    } else {
                        System.out.println(queryUser);
                    }
                    break;
                case "4":
                    System.out.println("请输入用户名:");
                    String removeUserName = scanner.next();
                    User userRemove = users.remove(removeUserName);
                    if (userRemove == null) {
                        System.out.println("未查到您要删除的用户信息！");
                    } else {
                        System.out.println(removeUserName + "信息删除成功");
                    }
                    break;
                default:
                    System.out.println("请输入正确的指令");
                    break;
            }
        }
    }
}
