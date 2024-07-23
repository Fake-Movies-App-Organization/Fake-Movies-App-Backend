package com.fake.movies.lordmathi2741.models;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Document(collection = "user_types")
@Getter
public class UserType {

    @Id
    private String id;
    @Setter
    private String type;

    public UserType(String type){
        this.type = type;
    }
}
