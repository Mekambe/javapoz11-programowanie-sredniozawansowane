package TODO.model.Model;

import TODO.model.Model.Moddel.Exception.InvalidPasswordException;
import TODO.model.Model.Moddel.Exception.todoUserDoesNotAlreadyExistsException;
import TODO.model.Model.Moddel.Todo;
import TODO.model.Model.Moddel.TodoUser;
import TODO.model.Model.Service.TodoService;
import TODO.model.Model.TodoRepository.Memory.InMemoryTodoRepository;
import TODO.model.Model.TodoRepository.Memory.InMemoryTodoUserRepository;
import TODO.model.Model.TodoRepository.TodoRepository;
import TODO.model.Model.TodoRepository.TodoUserRepository;
import TODO.model.Model.View.TodoConsoleView;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Scanner;

@AllArgsConstructor
public class TodoApplication {

    private TodoService todoService;

    private TodoConsoleView todoConsoleView;

    private TodoUser currentUser;

    public static void main(String[] args) {

        TodoRepository todoRepository = new InMemoryTodoRepository();
        TodoUserRepository todoUserRepository = new InMemoryTodoUserRepository();
        TodoService todoService = new TodoService(todoRepository, todoUserRepository);

        Scanner scanner = new Scanner(System.in);
        TodoConsoleView todoConsoleView = new TodoConsoleView(scanner);

        TodoApplication todoApplication = new TodoApplication(todoService, todoConsoleView, null);
        todoApplication.start();
    }

    public  void start (){
       do {
           Integer menu = todoConsoleView.menu();
           switch (menu){
               case 1:
                   login();
                   break;
               case 2:
                   register();
                   break;
               case 3:
                   addNewTodo();
                   break;
               case 4:
                   break;
                   default:
                       break;

           }
       } while (true);

    }

    private void login (){

        this.currentUser = null;
        String name = todoConsoleView.logInName();
        String password = todoConsoleView.logInPassword();
try {
    this.currentUser = todoService.login(name, password);
}catch (todoUserDoesNotAlreadyExistsException | InvalidPasswordException e) {
    todoConsoleView.displayError(e.getMessage());
}
        if (this.currentUser != null) {
            todoConsoleView.displaySucces("Uzytkownik o nicku" + name + "\"zalogowany");
        }

    }


    private void register (){

       String name = todoConsoleView.registerName();
       String password = todoConsoleView.registerPassword();
        TodoUser user = todoService.register(name, password);

        if (user == null) {
    todoConsoleView.displayError("Nie mozna zarejetsrowac uzytkownika.\n" + "Uzytkownik o podnaje nazwie juz istnieje");
}else {
    todoConsoleView.displaySucces ("Udalo Sie Zarejestrowac uzytkownika");
}


    }




    private void addNewTodo () {
        if (currentUser == null) {
            login();
        }

        String todoName = todoConsoleView.createNewTodoName();
        String todoDescription = todoConsoleView.createNewTodoDescription();

        Todo todo = new Todo(todoName, this.currentUser);
todo.setDescription(todoDescription);
        todoService.save(todo);



    }
}
