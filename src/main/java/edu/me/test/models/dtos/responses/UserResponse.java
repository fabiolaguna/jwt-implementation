package edu.me.test.models.dtos.responses;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import edu.me.test.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserResponse {

    private Integer id;

    private String name;

    private String lastName;

    private String userName;

    private String rol;

    private List<CarResponse> cars;

    public static UserResponse fromUser(User user){

        UserResponse response = UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .lastName(user.getLastName())
                .userName(user.getUsername())
                .rol(user.getRol().toString())
                .build();

        if (user.getCars() != null){
            response.setCars(user.getCars()
                    .stream()
                    .map(CarResponse::fromCar)
                    .collect(Collectors.toList()));
        }

        return response;
    }
}
