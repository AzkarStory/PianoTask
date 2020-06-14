package dev.azkar.roomprogram.piano.task.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "key_id")
    private Long keyId;

    @Column
    private int entrance = 0;

    @Column(name = "door_id")
    private Integer doorId;

    public Person() {
    }


    public Person(Long id, boolean entrance, Integer doorId){
        this.keyId = id;
        this.doorId = doorId;
        if(entrance == true){
            this.entrance = 1;
        }
        else this.entrance = 0;
    }

    public Long getKeyId() {
        return keyId;
    }

    public void setKeyId(Long keyId) {
        this.keyId = keyId;
    }

    public Integer getDoorId() {
        return doorId;
    }

    public void setDoorId(Integer doorId) {
        this.doorId = doorId;
    }

    public int getEntrance() {
        return entrance;
    }

    public void setEntrance(boolean entrance) {
        if(entrance == true){
            this.entrance = 1;
        }
        else this.entrance = 0;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (entrance != person.entrance) return false;
        if (keyId != null ? !keyId.equals(person.keyId) : person.keyId != null) return false;
        return doorId != null ? doorId.equals(person.doorId) : person.doorId == null;
    }

    @Override
    public int hashCode() {
        int result = keyId != null ? keyId.hashCode() : 0;
        result = 31 * result + entrance;
        result = 31 * result + (doorId != null ? doorId.hashCode() : 0);
        return result;
    }
}
