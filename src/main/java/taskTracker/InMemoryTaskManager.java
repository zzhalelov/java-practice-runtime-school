package taskTracker;

import taskTracker.entity.Epic;
import taskTracker.entity.SubTask;
import taskTracker.entity.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTaskManager implements TaskManager {
    private Map<Long, Task> tasks;
    private Map<Long, SubTask> subTasks;
    private Map<Long, Epic> epics;

    private long counter;

    HistoryManager historyManager;

    public InMemoryTaskManager(HistoryManager historyManager) {
        this();
        this.historyManager = historyManager;
    }

    //список для хранения истории просмотров
    private List<Task> history;

    public InMemoryTaskManager() {
        this.tasks = new HashMap<>();
        this.subTasks = new HashMap<>();
        this.epics = new HashMap<>();
        this.history = new ArrayList<>();
    }

    @Override
    public List<Task> getTasks() {
        return new ArrayList<>(tasks.values());
    }

    @Override
    public List<SubTask> getSubTasks() {
        return new ArrayList<>(subTasks.values());
    }

    @Override
    public List<Epic> getEpics() {
        return new ArrayList<>(epics.values());
    }

    @Override
    public Task getTaskById(long id) {
        Task task = tasks.get(id);
        //если таска с таким id существует - добавить в историю просмотров
        if (task != null) {
            historyManager.add(task);
        }
        return task;
//        return tasks.get(id);
    }

    @Override
    public SubTask getSubTaskById(long id) {
        SubTask subTask = subTasks.get(id);
        //если субтаска с таким id существует - добавить в историю просмотров
        if (subTask != null) {
            historyManager.add(subTask);
        }
        return subTask;
//        return subTasks.get(id);
    }

    @Override
    public Epic getEpicById(long id) {
        Epic epic = epics.get(id);
        if (epic != null) {
            historyManager.add(epic);
        }
        return epic;
//        return epics.get(id);
    }

    @Override
    public void createTask(Task task) {
        task.setId(getUniqueId());
        tasks.put(task.getId(), task);
    }

    @Override
    public void createSubTask(SubTask subTask) {
        //проверка существует ли эпик
        if (epics.containsKey(subTask.getEpic().getId())) {
            subTask.setId(getUniqueId());
            subTasks.put(subTask.getId(), subTask);
            //положить задачу в эпик
            Epic epic = epics.get(subTask.getEpic().getId());
            epic.addSubTask(subTask);
            //обновить статус эпика
            epic.updateStatus();
        }
    }

    @Override
    public void createEpic(Epic epic) {
        epic.setId(getUniqueId());
        epics.put(epic.getId(), epic);
    }

    @Override
    public void updateTask(long id, Task updatedTask) {
        //проверка существует ли таска с таким id
        if (tasks.containsKey(id)) {
            Task existingTask = tasks.get(id);
            //задаем новое имя задаче
            if (updatedTask.getName() != null && !updatedTask.getName().isBlank()) {
                existingTask.setName(updatedTask.getName());
            }
            //задаем новое описание задаче
            if (updatedTask.getDescription() != null && !updatedTask.getDescription().isBlank()) {
                existingTask.setDescription(updatedTask.getDescription());
            }
        }
    }

    @Override
    public void updatedSubTask(long id, SubTask updatedSubTask) {
        //проверка существует ли подзадача с таким id
        if (subTasks.containsKey(id)) {
            SubTask existingSubTask = subTasks.get(id);
            //задаем новое имя подзадаче
            if (updatedSubTask.getName() != null && !updatedSubTask.getName().isBlank()) {
                existingSubTask.setName(updatedSubTask.getName());
            }
            //задаем новое описание подзадаче
            if (updatedSubTask.getDescription() != null && !updatedSubTask.getDescription().isBlank()) {
                existingSubTask.setDescription(updatedSubTask.getDescription());
            }
            if (updatedSubTask.getStatus() != null) {
                existingSubTask.setStatus(updatedSubTask.getStatus());
            }
            existingSubTask.getEpic().updateStatus();
        }
    }

    @Override
    public void updateEpic(long id, Epic updatedEpic) {
        if (epics.containsKey(id)) {
            Epic existingEpic = epics.get(id);
            if (updatedEpic.getName() != null && !updatedEpic.getName().isBlank()) {
                existingEpic.setName(updatedEpic.getName());
            }
            if (updatedEpic.getDescription() != null && !updatedEpic.getDescription().isBlank()) {
                existingEpic.setDescription(updatedEpic.getDescription());
            }
        }
    }

    @Override
    public void removeTask(long id) {
        tasks.remove(id);
    }

    @Override
    public void removeSubTask(long id) {
        SubTask subTask = subTasks.get(id);
        Epic epic = subTask.getEpic();
        epic.removeSubtask(id);
        subTasks.remove(id);
        epic.updateStatus();
    }

    @Override
    public void removeEpic(long id) {
        if (epics.containsKey(id)) {
            for (SubTask subTask : epics.get(id).getSubTasks()) {
                subTasks.remove(subTask.getId());
            }
            epics.remove(id);
        }
    }

    @Override
    public long getUniqueId() {
        return ++counter;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("История просмотренных задач:\n");

        for (Task task : historyManager.getHistory()) {
            sb.append(task.toString()).append("\n");
        }

        return sb.toString();
    }
}