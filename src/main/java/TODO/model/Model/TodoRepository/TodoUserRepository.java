package TODO.model.Model.TodoRepository;

import TODO.model.Model.Moddel.TodoUser;

public interface TodoUserRepository {

    boolean save(TodoUser user);
    TodoUser findByName(String name);
    boolean exists (String name);

}
