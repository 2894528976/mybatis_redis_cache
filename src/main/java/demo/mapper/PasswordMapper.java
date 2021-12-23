package demo.mapper;

import demo.Bean.Password;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface PasswordMapper {
    List<Password> getAll();
    Integer removePassowrd(int id);
}
