package t4j.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import t4j.app.repo.EnumRoles;

@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class User implements Serializable {

    /**
     * Variável de instância - username
     */
    private String username;

    /**
     * Variável de instância - email
     */
    private String email;

    /**
     * Variável de instância - contentor do tipo ArrayList que guarda todas as instâncias do tipo EnumRoles
     */
    private ArrayList<EnumRoles> rolenames;

    /**
     *
     */
    private final static char ROLES_DELIMITER = ',';

    /**
     * Construtor vazio de User
     */
    public User() {
        rolenames = new ArrayList<>();
    }

    /**
     *
     * @param username
     * @param email
     */
    public User(String username, String email) {
        this();
        this.username = username;
        this.email = email;
    }

    /**
     *
     * @param username
     * @param email
     * @param roles
     */
    public User(String username, String email, ArrayList<EnumRoles> roles) {
        this.username = username;
        this.email = email;
        this.rolenames = new ArrayList<>(roles);
    }

    /**
     * Construtor completo de User
     * @param username
     * @param email
     * @param roles
     */
    public User(String username, String email, String roles) {
        this(username, email);
        ArrayList<EnumRoles> newRoles = convertRolesFromStringToArrayList(roles);
        this.rolenames = new ArrayList<>(newRoles);
    }

    /**
     * Construtor cópia de User
     * @param desiredUser
     */
    public User(User desiredUser) {
        this.email = desiredUser.email;
        this.rolenames = desiredUser.getRoles();
        this.username = desiredUser.getUsername();
    }

    /**
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @return contentor do tipo ArrayList que guarda todas as instâncias do tipo EnumRoles
     */
    public ArrayList<EnumRoles> getRoles() {
        return rolenames;
    }

    /**
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param email especifica um novo email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @param roles especifica um novo contentor do tipo ArrayList que guarda todas as instâncias do tipo EnumRoles
     */
    public void setRoles(ArrayList<EnumRoles> roles) {
        this.rolenames = roles;
    }

    /**
     *
     * @param roles especifica um novo role
     */
    public void setRoles(String roles) {
        this.rolenames = convertRolesFromStringToArrayList(roles);
    }

    /**
     *
     * @param username especifica um novo username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return uma string com os papéis de utilizador
     */
    public String getRolesAsString() {
        StringBuilder result = new StringBuilder();
        result.append(this.rolenames.get(0).toString());
        for (int i = 1; i < rolenames.size(); i++) {
            result.append(ROLES_DELIMITER).append(this.rolenames.get(i));
        }
        return result.toString();
    }

    /**
     *
     * @return uma string com o username, o email e o papel do utilizador
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Username: ").append(username).append("\n");
        sb.append("Email: ").append(email).append("\n");
        sb.append("Rolesnames: ").append(rolenames).append("\n");
        return sb.toString();
    }

    /**
     *
     * @param outroObjeto instância de user a ser comparada
     * @return reescrita do método equals e retorna um booleano
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        User outroUser = (User) outroObjeto;
        return username.equalsIgnoreCase(outroUser.username)
                && email.equalsIgnoreCase(outroUser.email)
                && rolenames.equals(outroUser.rolenames);
    }

    /**
     *
     * @return Override do hashCode
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.username);
        hash = 19 * hash + Objects.hashCode(this.email);
        hash = 19 * hash + Objects.hashCode(this.rolenames);
        return hash;
    }

    /**
     *
     * @param roles1
     * @return cria uma ArrayList do tipo EnumRoles a partir de uma string que entra por parâmetro
     */
    private ArrayList<EnumRoles> convertRolesFromStringToArrayList(String roles1) {
        String[] rolesArray;
        ArrayList<EnumRoles> newRoles = new ArrayList<>();
        if (!roles1.isEmpty()) {
            rolesArray = roles1.split(String.valueOf(ROLES_DELIMITER));
            for (int i = 0; i < rolesArray.length; i++) {
                rolesArray[i] = rolesArray[i].trim();
            }
            for (String string : rolesArray) {
                for (EnumRoles role : EnumRoles.values()) {
                    if (role.toString().equalsIgnoreCase(string)) {
                        newRoles.add(role);
                    }
                }
            }
        }
        return newRoles;
    }
}
