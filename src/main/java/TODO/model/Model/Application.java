package TODO.model.Model;

import java.util.*;

public class Application {
//   // DOBRZE :)
//    String nazwa = name.map(todo -> todo.getCreator())
//            .map(creator -> creator.getName())
//            .orElse("puste");
//        System.out.println(nazwa);
//
//    //ŹLE :(
//    Todo todo = name.get();
//        if (todo != null) {
//        TodoUser creator = todo.getCreator();
//        if (creator != null) {
//            String nameNullable = creator.getName();
//            System.out.println(nameNullable);
//        } else {
//            System.out.println("puste");
//        }
//    } else {
//        System.out.println("puste");
//    }

//    public static void main(String[] args) {
//        List<String> texts = Arrays.asList("Ala","ma",null,"kota", null, "abc");
//        for (String text : texts){
//            Optional<String> optional = Optional.ofNullable(text);
//            //wyswietlic elemnt gdy ma wiecej niz 2 liter
//            // w przeciwnym wypadku wysiwtelic " stop"
//
//
//            System.out.println(optional.filter(e->e.length() > 2).orElse("Stop"));
//        }
//
//
//    }

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<Integer, String>() {{
            put(2, "dwa");
            put(3, "trzy");
            put(4, "cztery");
            put(5,null);
            put(6,"");

        }};
        for (Map.Entry <Integer, String> entry : map.entrySet()){
            Integer key = entry.getKey();
            Optional<String> value = Optional.ofNullable(entry.getValue());
        }
    }

}
