package poke.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import poke.app.repository.LoginRepository;

@Component
public class PokeAppCommandLineRunner implements CommandLineRunner {

    private final LoginRepository loginRepository;

    @Autowired
    public PokeAppCommandLineRunner(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public void run(String... args) {

    }
}
