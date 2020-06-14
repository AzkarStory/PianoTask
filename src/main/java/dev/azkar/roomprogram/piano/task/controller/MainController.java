package dev.azkar.roomprogram.piano.task.controller;

import dev.azkar.roomprogram.piano.task.model.Person;
import dev.azkar.roomprogram.piano.task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

    String response;

    Person person = new Person();

    @Autowired
    UserRepository userRepository;

    @GetMapping("/check")
    public String getUser(@RequestParam int keyId, @RequestParam boolean entrance, @RequestParam Integer roomId) {

        if (checkDataBase((long)keyId, entrance, roomId) == "200") {
            person.setKeyId((long)keyId);
            person.setDoorId(roomId);
            person.setEntrance(entrance);
            userRepository.saveAndFlush(person);
            response = "200";
        }

        else if (checkDataBase((long)keyId, entrance, roomId) == "403"){
            response = "403";
        }

        else response = "500";

        return response;

    }

    public String checkDataBase(Long keyId, boolean entrance, Integer roomId){

        Iterable<Person> users = userRepository.findAll();

        if (keyId!=null && keyId<10000){

            Person user1 = userRepository.getOne(keyId);

             if(user1 != null){

                 if (user1.getEntrance() == 0 && checkDevisionDoor(user1) == true){
                     user1.setEntrance(entrance);
                     return "200";
                 }

                 return "403";

            }

            else return "500";
        }

        else return "500";

    }


    public Boolean checkDevisionDoor(Person person){

        long id = person.getKeyId();

        int doorId = person.getDoorId();

        int intId = (int) id;

        int checkDevision = doorId % intId;

        if (checkDevision == 0){
            return true;
        }
        else return false;
    }

}
