package itacademy.demo.service;

import itacademy.demo.entity.User;
import itacademy.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MailService mailService;

    static String reverse(String s){
        return new StringBuilder(s).reverse().toString();
    }

    @Override
    public User create(User user) { //регистрайию могут пройти только @gmail.com и @email.ru
        String login = user.getLogin();
        Integer l = login.length();
        if(10 < l){
            if(login.substring(l-1, l-9).equals("@email.ru") || login.substring(l-1, l-10).equals("@gmail.com")){
                user.setPassword(reverse(user.getPassword()));
                return userRepository.save(user);
            }
            else
                return null;
        }
        if(9 < l & login.substring(l-1, l-9).equals("@email.ru")){
            user.setPassword(reverse(user.getPassword()));
            return userRepository.save(user);
        }
        else
            return null;

    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User getByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(User user) {
        user.setPassword(reverse(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Boolean dropPassword(Long id) {
        User user = getById(id);
        if(user == null ) return false;

        String newPassword = System.currentTimeMillis()+"";
        if(mailService.send(user.getLogin(),
                "Сброс пароля",
                "Пароль был сброшен " + LocalDateTime.now() + "\nВаш новый пароль " + newPassword)){
            user.setPassword(newPassword); //not necessary to reverse()
            update(user); //тут и так зашифровывается
            return true;
        }
        return false;
    }

    @Override
    public Boolean logIn(String login, String password) {
        User user = getByLogin(login);
        if(user == null){
            System.out.println("такого логина нет");
            return false;
        }
        return user.getPassword().equals(reverse(password));
    }

}
