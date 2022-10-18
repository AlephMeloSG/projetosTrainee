package br.com.sgsistemas.udemyproject.service;


import br.com.sgsistemas.udemyproject.model.User;
import br.com.sgsistemas.udemyproject.repository.UserRepository;
import br.com.sgsistemas.udemyproject.service.exceptions.DataBaseException;
import br.com.sgsistemas.udemyproject.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> listar() {
        return userRepository.findAll();
    }

    public User listarID(Integer id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        userRepository.save(user);
        return user;
    }

    public void deleteById(Integer id) {
        try {
            userRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }

    }

    public User update(Integer id, User user){
        try {
            User user1 = userRepository.getReferenceById(id);
            updateData(user1,user);
            return userRepository.save(user1);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    private void updateData(User user1, User user) {
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setPhone(user.getPhone());
    }
}
