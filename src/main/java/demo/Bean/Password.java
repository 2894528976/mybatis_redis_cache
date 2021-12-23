package demo.Bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Password implements Serializable {

    Integer id;
    String password;
}
