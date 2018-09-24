package TODO.model.Model.TodoRepository.Memory;

import TODO.model.Model.Moddel.Todo;
import TODO.model.Model.Moddel.TodoUser;
import TODO.model.Model.TodoRepository.TodoRepository;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class InMemoryTodoRepository implements TodoRepository {

    private List <Todo> todos;

    public InMemoryTodoRepository () {
        this.todos = new ArrayList<>();
    }






    @Override
    public void save(Todo todo) {

        todos.add(todo);

    }

    @Override
    public Optional<Todo> findbyID(String id) {
        return todos.stream()
                .filter(e->e.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Todo> findAll() {
        return null;
    }
}
