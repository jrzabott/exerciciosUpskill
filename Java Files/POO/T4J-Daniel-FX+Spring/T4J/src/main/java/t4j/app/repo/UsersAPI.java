package t4j.app.repo;

import java.io.Serializable;
import t4j.app.dto.UserInfoDTO;

@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class UsersAPI implements Serializable {

    /**
     * Variável de instância - app_key
     */
    private final String APP_KEY;
    
    /**
     * Variável de classe - userAPIAdapter
     */
    private UsersAPIAdapter usersAPIAdapter;

    /**
     * 
     * @param APP_KEY 
     */
    public UsersAPI(String APP_KEY) {
        this.APP_KEY = APP_KEY;
        this.usersAPIAdapter = new UsersAPIAdapter(this.APP_KEY);
    }

    /**
     * 
     * @param u informação do utilizador do qual se pretende saber o papel
     * @return papel do utilizador passado por parâmetro
     */
    public String getRoles(UserInfoDTO u) {
        return this.usersAPIAdapter.getRoles(u);
    }

    /**
     * 
     * @param u informação do utilizador do qual se pretende obter a sessão
     */
    public void getSession(UserInfoDTO u) {
        this.usersAPIAdapter.getSession(u);
    }

    /**
     * 
     * @param u informação do utilizador do qual se pretende fazer logout
     * @return true se efetuou logout e false se contrário
     */
    public boolean logout(UserInfoDTO u) {
        boolean result = this.usersAPIAdapter.logout(u);
        return result;
    }

    /**
     * 
     * @param u informação do utilizador do qual se pretende fazer login
     * @return true se efetuou login e false se contrário
     */
    public boolean login(UserInfoDTO u) {
        boolean result = this.usersAPIAdapter.login(u);
        return result;
    }

    /**
     * 
     * @param u informação do utilizador que se pretende registar
     * @return true se efetuou o registo do utlizador passado por parâmetro e false se contrário
     */
    public boolean registerUser(UserInfoDTO u) {
        boolean result = this.usersAPIAdapter.registerUserWithRoles(u);
        return result;
    }
}
