package service;

import java.util.*;
import model.Task;

public class UserDatabase {
    public static Map<String, String> userMap = new HashMap<>();
    public static Map<String, List<Task>> userTasks = new HashMap<>();
}
