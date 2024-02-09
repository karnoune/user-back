package fr.karnoune.user.service.impl;

import fr.karnoune.user.domain.UserDto;
import fr.karnoune.user.mapper.UserMapper;
import fr.karnoune.user.model.User;
import fr.karnoune.user.repository.UserRepository;
import fr.karnoune.user.service.IuserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IuserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUSer(UserDto userDto) {
        userRepository.save(UserMapper.toUser(userDto));
    }

    @Override
    public List<UserDto> getAllUser() {
        return UserMapper.toUserDto(userRepository.findAll());
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        Optional<User> optUser = userRepository.findById(userDto.getId());
        if (optUser.isPresent()) {
            optUser.get().setFirstName(userDto.getFirstName());
            optUser.get().setLastName(userDto.getLastName());
            User user = userRepository.save(optUser.get());
            return UserMapper.toUserDto(user);
        }
        return  null;
    }

    @Override
    public void deleteUseryId(Long userId) {
        Optional<User> optUser = userRepository.findById(userId);
        if (optUser.isPresent()) {
            userRepository.deleteById(userId);
        }
    }

    @Override
    public UserDto findByName(String name) {
        return null;
    }

    @Override
    public boolean checkEmailUser(String inputEmail) {
        User user =  userRepository.findByEmail(inputEmail);
        if (user == null) {
            return false;
        }
        return true;
    }
}
