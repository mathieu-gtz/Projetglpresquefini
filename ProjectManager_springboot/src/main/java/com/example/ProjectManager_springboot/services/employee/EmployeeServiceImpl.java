package com.example.ProjectManager_springboot.services.employee;

import com.example.ProjectManager_springboot.dto.TaskDto;
import com.example.ProjectManager_springboot.entities.Task;
import com.example.ProjectManager_springboot.enums.TaskStatus;
import com.example.ProjectManager_springboot.repositories.TaskRepository;
import com.example.ProjectManager_springboot.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final TaskRepository taskRepository;

    private final JwtUtil jwtUtil;


    @Override
    public List<TaskDto> getTasksByEmployee(Long employeeId) {
        List<Task> tasks = taskRepository.findByUser_Id(employeeId);
        return tasks.stream().map(Task::getTaskDto).collect(Collectors.toList());
    }

    @Override
    public TaskDto getTaskById(Long taskId) {
        Optional<Task> task = taskRepository.findById(taskId);
        return task.map(Task::getTaskDto).orElse(null);
    }

    @Override
    public TaskDto updateTaskStatus(Long taskId, TaskStatus status) {
        Optional<Task> taskOptional = taskRepository.findById(taskId);
        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            task.setTaskStatus(status);
            taskRepository.save(task);
            return task.getTaskDto();
        }
        return null;
    }



//    @Override
//    public CommentDto createComment(Long taskId, String content) {
//        Optional<Task> optionalTask = taskRepository.findById(taskId);
//        User user = jwtUtil.getLoggedInUser();
//        if (optionalTask.isPresent() && user != null){
//            Comment comment = new Comment();
//            comment.setCreatedAt(new Date());
//            comment.setContent(content);
//            comment.setTask(optionalTask.get());
//            comment.setUser(user);
//            return commentRepository.save(comment).getCommentDTO();
//        }
//        throw new EntityNotFoundException("User or Task not found");
//    }
//
//    @Override
//    public List<CommentDTO> getCommentsByTaskId(Long taskId) {
//        return commentRepository.findAllByTaskId(taskId)
//                .stream()
//                .map(Comment::getCommentDTO)
//                .collect(Collectors.toList());
//    }



    private TaskStatus mapStringToStatus(String status){
        switch (status){
            case "PENDING":
                return TaskStatus.PENDING;
            case "INPROGRESS":
                return TaskStatus.INPROGRESS;
            case "COMPLETED":
                return TaskStatus.COMPLETED;
            case "DEFERRED":
                return TaskStatus.DEFERRED;
            default:
                return TaskStatus.CANCELED;
        }
    }
}
