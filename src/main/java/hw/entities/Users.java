package hw.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Users {
    public static Users PETER = new
            Users("epam", "1234", "PITER CHAILOVSKII");

    private final String login;
    private final String password;
    private final String fullName;
}