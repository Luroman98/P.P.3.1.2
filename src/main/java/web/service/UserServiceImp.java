package web.service;

import web.dao.UserDao;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;
   @Transactional
   @Override
   public void add(User user) {
      userDao.save(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return (List<User>) userDao.findAll();
   }
   @Transactional
   @Override
   public User getUser(Long id) {
      return userDao.findById(id).get();
   }

   @Transactional
   @Override
   public void update(Long id, User updateUser) {
      User userToBeUpdated = getUser((Long) id);
      userToBeUpdated.setFirstName(updateUser.getFirstName());
      userToBeUpdated.setLastName(updateUser.getLastName());
      userToBeUpdated.setEmail(updateUser.getEmail());
   }
   @Transactional
   public void deleteUser(Long id) {
      userDao.deleteById(id);
   }
}
