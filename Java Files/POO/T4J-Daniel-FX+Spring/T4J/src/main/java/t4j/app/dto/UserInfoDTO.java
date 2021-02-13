package t4j.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserInfoDTO {

    /**
     * Variável de instância - username
     */
    @JsonProperty("username")
    private String username;

    /**
     * Variável de instância - password
     */
    @JsonProperty("password")
    private String password;

    /**
     * Variável de instância - email
     */
    @JsonProperty("email")
    private String email;

    /**
     * Variável de instância - data de login
     */
    @JsonProperty("logindate")
    private String logindate;

    /**
     * Variável de instância - nome do role
     */
    @JsonProperty("rolenames")
    private String rolenames;

    /**
     * Variável de instância - app_context
     */
    @JsonProperty("app_context")
    private String app_context;

    /**
     * Variável de instância - sessão
     */
    @JsonProperty("session")
    private String session;

    /**
     * Variável de instância - resposta do serviço http
     */
    @JsonProperty("lastHttpResponse")
    private String lastHttpResponse;

    /**
     * Variável de instância - código da resposta do serviço http
     */
    @JsonProperty("lastHttpResponseCode")
    private String lastHttpResponseCode;

    /**
     * Variável de instância - organização do utilizador (quando colaborador ou
     * gestor)
     */
    @JsonProperty("organizacao")
    private OrganizacaoDTO organizacao;

    /**
     * Construtor vazio do UserInfo
     */
    public UserInfoDTO() {
        this.username = "";
        this.password = "";
        this.email = "";
        this.logindate = "";
        this.rolenames = "";
        this.app_context = "";
        this.session = "";
        this.lastHttpResponse = "";
        this.lastHttpResponseCode = "";
        this.organizacao = new OrganizacaoDTO();
    }

    /**
     *
     * @return nome do role
     */
    public String getRolenames() {
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
     * @return password
     */
    public String getPassword() {
        return password;
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
     * @return data do login
     */
    public String getLogindate() {
        return logindate;
    }

    /**
     *
     * @return app_context
     */
    public String getApp_context() {
        return app_context;
    }

    /**
     *
     * @return sessão
     */
    public String getSession() {
        return session;
    }

    /**
     *
     * @return resposta do serviço http
     */
    public String getLastHttpResponse() {
        return lastHttpResponse;
    }

    /**
     *
     * @return código da resposta do serviço http
     */
    public String getLastHttpResponseCode() {
        return lastHttpResponseCode;
    }

    /**
     *
     * @param rolenames especifica um novo nome do role
     */
    public void setRolenames(String rolenames) {
        this.rolenames = rolenames;
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
     * @param password especifica uma nova password
     */
    public void setPassword(String password) {
        this.password = password;
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
     * @param logindate especifica uma nova data de login
     */
    public void setLogindate(String logindate) {
        this.logindate = logindate;
    }

    /**
     *
     * @param app_context especifica um novo app_context
     */
    public void setApp_context(String app_context) {
        this.app_context = app_context;
    }

    /**
     *
     * @param session especifica uma nova sessão
     */
    public void setSession(String session) {
        this.session = session;
    }

    /**
     *
     * @param lastHttpResponse especifica uma nova resposta do serviço http
     */
    public void setLastHttpResponse(String lastHttpResponse) {
        this.lastHttpResponse = lastHttpResponse;
    }

    /**
     *
     * @param lastHttpResponseCode especifica um novo código da resposta do
     * serviço http
     */
    public void setLastHttpResponseCode(String lastHttpResponseCode) {
        this.lastHttpResponseCode = lastHttpResponseCode;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("app_context: ").append(app_context).append("\n");
        sb.append("Username: ").append(username).append("\n");
        sb.append("Password: ").append(password).append("\n");
        sb.append("Email: ").append(email).append("\n");
        sb.append("Rolenames: ").append(rolenames).append("\n");
        sb.append("Logindate: ").append(logindate).append("\n");
        sb.append("Session Info: ").append(session).append("\n");
        sb.append("Last http response: ").append(lastHttpResponse).append("\n");
        sb.append("Last http response code: ").append(lastHttpResponseCode).
                append("\n");

//        if (rolenames != null && !rolenames.isEmpty()) {
//            String[] roles = rolenames.split(",");
//            sb.append("Rolenames: ");
//            sb.append(roles[0]);
//            if (roles.length > 1) {
//                for (int i = 1; i < roles.length; i++) {
//                    sb.append(", ");
//                    sb.append(roles[i]);
//                }
//            }
//        }
        return sb.toString();
    }

    /**
     *
     * @return retorna a organização armazenada durante o processo de login
     */
    public OrganizacaoDTO getOrganizacao() {
        return organizacao;
    }

    /**
     *
     * @param organizacao especifica a organizacao a ser armazenada
     */
    public void setOrganizacao(OrganizacaoDTO organizacao) {
        this.organizacao = organizacao;
    }

}
