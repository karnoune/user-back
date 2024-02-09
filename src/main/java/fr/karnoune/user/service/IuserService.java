package fr.karnoune.user.service;

import fr.karnoune.user.domain.UserDto;

import java.util.List;

public interface IuserService {

    void createUSer(UserDto userDto);
    List<UserDto> getAllUser();
    UserDto updateUser(UserDto userDto);
    void deleteUseryId(Long userId);

    UserDto findByName(String name);

    boolean checkEmailUser(String inputEmail);
}
