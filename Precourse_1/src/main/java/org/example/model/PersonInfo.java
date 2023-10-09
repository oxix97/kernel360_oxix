package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonInfo {
    private String photo;
    private String name;
    private String email;
    private String address;
    private String phone_number;
    private String birth;

    public static PersonInfo of(
            String photo,
            String name,
            String email,
            String address,
            String phone_number,
            String birth
    ) {
        return new PersonInfo(photo, name, email, address, phone_number, birth);
    }

    private PersonInfo(String photo, String name, String email, String address, String phone_number, String birth) {
        this.photo = photo;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone_number = phone_number;
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "PersonInfo{" +
                "photo='" + photo + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", birth='" + birth + '\'' +
                '}';
    }
}
