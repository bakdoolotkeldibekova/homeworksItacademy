package itacademy1.Spring.Security.Intro.service;


import itacademy1.Spring.Security.Intro.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAll();
    Task getById(Long id);
    Task create(Task task);
    Task update(Task task);
    Task deleteById(Long id);

    List<Task> searchByTitle(String title);
    List<Task> searchByText(String text);
}
