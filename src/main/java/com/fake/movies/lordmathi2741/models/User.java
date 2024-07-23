package com.fake.movies.lordmathi2741.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Data
@Getter
@Document(collection = "users")
public class User  {
    @Id
    private String id;

    @Setter
    private String username;

    @Setter
    private String email;

    @Setter
    private String password;

    @Setter
    private String role;

    @CreatedDate
    private Date created_at;

    public User() {
        this.role = UserTypes.Default.toString();
    }




    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
