package edu.me.test.services;

import edu.me.test.exceptions.UserNotExistException;
import edu.me.test.models.User;
import edu.me.test.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final UserRepository userRepository;

    public User deleteEmployee(Integer employeeId) {

        return userRepository.findById(employeeId)
                .orElseThrow(() -> new UserNotExistException("The employee doesn't exist"));
    }
}
