package com.jwt.task.controller;


import com.jwt.task.adapter.controller.CreateUserController;
import com.jwt.task.entity.Role;
import com.jwt.task.entity.UserEntity;
import com.jwt.task.service.in.CreateUserUseCase;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;


@SpringBootTest(classes={CreateUserController.class})
public class CreateUserControllerTest {
    @Mock
    private CreateUserUseCase createUserUseCase;

    @InjectMocks
    private CreateUserController createUserController;

    @Test
    void createUserNoException_WillReturnCorrectResponse(CapturedOutput output) {

        //given
        UserEntity userEntity = new UserEntity();
        userEntity.setName("Shobir");
        userEntity.setEmail("souba676@gmail.com");
        userEntity.setPassword("password");
        userEntity.setRole(Role.USER);
        UserEntity expectedUser = new UserEntity(
                1, userEntity.getName(), userEntity.getEmail(), userEntity.getPassword(), userEntity.getRole());
        given(createUserUseCase.createUser(userEntity)).willReturn(expectedUser);

        //when
        UserEntity actualResponse = createUserController.createUser(userEntity);

        //then
        assertEquals(expectedUser, actualResponse);
        then(createUserUseCase).should(times(1)).createUser(userEntity);
        assertThat(output).contains("[UBA] /createUser is called");
    }
}
