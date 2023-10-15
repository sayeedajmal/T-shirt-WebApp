package com.Strong.Tshirt_Web.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Strong.Tshirt_Web.Entity.Users;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface UsersRepo extends JpaRepository<Users, Integer> {
    /*
     * @Autowired
     * EntityManager entityManager;
     * 
     * public Users InsertUser(Users user) {
     * entityManager.persist(user);
     * return user;
     * }
     * 
     * public Users findById(Integer user_id) {
     * return entityManager.find(Users.class, user_id);
     * }
     * 
     * public void DeleteUserById(Integer user_id) {
     * Users user = findById(user_id);
     * entityManager.remove(user);
     * }
     * 
     * public boolean updateNameById(Integer user_id, String Username) {
     * Users existUser = findById(user_id);
     * if (existUser != null) {
     * existUser.setUsername(Username);
     * entityManager.merge(existUser);
     * return true;
     * } else
     * return false;
     * }
     * 
     * public boolean updatePasswordById(Integer user_id, String Password) {
     * Users existUser = findById(user_id);
     * if (existUser != null) {
     * existUser.setPassowrd_hash(Password);
     * entityManager.merge(existUser);
     * return true;
     * } else
     * return false;
     * }
     * 
     * public boolean updateAddressById(Integer user_id, String Address) {
     * Users existUser = findById(user_id);
     * if (existUser != null) {
     * existUser.setAddress(Address);
     * entityManager.merge(existUser);
     * return true;
     * } else
     * return false;
     * }
     * 
     * public boolean updatePhoneId(Integer user_id, String phone) {
     * Users existUser = findById(user_id);
     * if (existUser != null) {
     * existUser.setPhone_number(phone);
     * entityManager.merge(existUser);
     * return true;
     * } else
     * return false;
     * }
     * 
     * public boolean updateEmailId(Integer user_id, String email) {
     * Users existUser = findById(user_id);
     * if (existUser != null) {
     * existUser.setEmail(email);
     * entityManager.merge(existUser);
     * return true;
     * } else
     * return false;
     * }
     */
}
