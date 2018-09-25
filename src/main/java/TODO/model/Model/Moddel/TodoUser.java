package TODO.model.Model.Moddel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
@Getter
@Setter
public class TodoUser {
    public static TodoUser unnasigned(){
        return new TodoUser("Nie przypisano", null);
    }
    private String name;
    private String password;

}