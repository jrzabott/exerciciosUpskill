package t4j.app.repo;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import t4j.app.controller.UIApplicationController;
import t4j.app.dto.AppContextDTO;
import t4j.app.dto.RoleDTO;
import t4j.app.dto.UserInfoDTO;
import t4j.app.exception.LoginServerException;
import t4j.app.exception.UsersAPIException;

@SuppressWarnings({"serial", "ClassWithoutLogger"})
class UsersAPIAdapter implements Serializable {

    /**
     * 
     */
    private final String APP_KEY;

    /**
     * 
     * @param APP_KEY 
     */
    public UsersAPIAdapter(String APP_KEY) {
        this.APP_KEY = APP_KEY;
    }

    // 20210502 09:49 - Daniel Junior -  Removido método, pois já não é mais necessário
//    private UsersAPIAdapter() {
//        this.APP_KEY = UIApplicationController.getAPP_KEY();
//
//    }
    
    /**
     * 
     * @param u informação do utilizador que está a fazer logout
     * @return retorna true se logout bem sucedido e false se o contrário
     */
    public boolean logout(UserInfoDTO u) {
        URL url = ApiFunctions.LOGOUT.getURL(u.getApp_context());
        HttpRequest hr = new HttpRequest(url, HttpMethod.POST);
        hr.connect(u);
        if (hr.getResponseCode() == HttpURLConnection.HTTP_OK) {
            u.setApp_context("");
            System.out.println("==== FIM LOGOUT BEM SUCEDIDO ====\n");
            System.out.println(u);
            return true;
        }
        return false;
    }

    /**
     * 
     * @param u informação do utilizador que está a fazer login
     * @return retorna true se login bem sucedido e false se o contrário
     */
    public boolean login(UserInfoDTO u) {
        if (u.getApp_context().isEmpty()) {
            getNewAppContext(u);
        }

        URL url = ApiFunctions.LOGIN.getURL(
                u.getApp_context(),
                u.getUsername(),
                u.getPassword());

        HttpRequest hr = new HttpRequest(url, HttpMethod.POST);
        try {
            hr.connect(u);
            System.out.println(u.toString());
            if (u.getLastHttpResponseCode().equalsIgnoreCase(
                    String.valueOf(HttpURLConnection.HTTP_OK))) {
                System.out.println("==== FIM LOGIN BEM SUCEDIDO ====\n");
                System.out.println(u);
                return true;
            }
        } catch (UsersAPIException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * 
     * @param u informação do utilizador a ser registado
     * @return regista um novo utilizador
     */
    public boolean registerUser(UserInfoDTO u) {
        return registerUserWithRoles(u);
    }

    /**
     * 
     * @param u informação do utilizador a ser registado
     * @return regista um novo utilizador com papel
     */
    public boolean registerUserWithRoles(UserInfoDTO u) {
        String context = getNewAppContext();
        URL url = ApiFunctions.REGISTER_USER_WITH_ROLES.getURL(
                context,
                u.getUsername(),
                u.getEmail(),
                u.getPassword(),
                u.getRolenames());
        HttpRequest hr = new HttpRequest(url, HttpMethod.POST);
        hr.connect(u);
        System.out.println("\n\n====> CONFIRMAÇAO CRIAÇÃO DO USER <====");
        System.out.println(u.toString());
        return hr.getResponseCode() == HttpURLConnection.HTTP_OK;
    }

    /**
     * 
     * @param u informação do utilizador para o qual se pretende obter a app_context
     */
    public void getNewAppContext(UserInfoDTO u) {
        u.setApp_context(getNewAppContext());
    }

    /**
     * 
     * @param u informação do utilizador do qual se pretende saber o seu papel
     * @return retorna o papel do utilizador introduzido por parâmetro
     */
    public String getRoles(UserInfoDTO u) {
        URL url = ApiFunctions.ROLES_GET.getURL(u.getApp_context());
        StringBuilder sb = new StringBuilder();
        ArrayList<RoleDTO> roles = new ArrayList<>();
        TypeReference< ArrayList<RoleDTO>> tr = new TypeReference< ArrayList<RoleDTO>>() {
        };
        try {
            roles = new ObjectMapper().readValue(url, tr);
            int i = 0;
            sb.append(roles.get(i).getRolename());

            while (i < roles.size()) {
                sb.append(",").append(roles.get(i++).getRolename());
            }
        } catch (IOException ex) {
            throw new UsersAPIException("Falha do Criar Json: RoleDTO");
        }

        System.out.println("======== FIM getRoles() ======");
        System.out.println(sb.toString());
        return sb.toString();
    }

    /**
     * 
     * @param role informação do utilizador para o qual se pretende especificar o papel
     * @param u papel a ser especificado
     * @return verdadeiro se o papel foi especificado e falso se pelo contrário
     */
    public boolean setRole(RoleDTO role, UserInfoDTO u) {
        boolean result = false;

        URL url = ApiFunctions.ROLES_POST.getURL(
                u.getApp_context(),
                role.getRolename(),
                role.getDescription());
        String rolePOSTBody;
        try {
            rolePOSTBody = new ObjectMapper().writeValueAsString(role);
        } catch (JsonProcessingException ex) {
            throw new UsersAPIException("Falha do Criar Json: RoleDTO");
        }
        HttpRequest hr = new HttpRequest(url, rolePOSTBody);
        hr.connect(u);
        System.out.println("=============> POSTBODY <============");
        System.out.println(hr.getPOSTBody());
        System.out.println("=============> REPONSE <============");
        System.out.println(hr.getResponseBody());
        result = hr.getResponseCode() == HttpURLConnection.HTTP_OK;
        if (!result) {
            throw new UsersAPIException(hr.getResponseBody());
        }
        return result;
    }

    /**
     * 
     * @param u obtem a sessão do utilizador passado por parâmetro
     */
    public void getSession(UserInfoDTO u) {
        URL url = ApiFunctions.SESSION.getURL(u.getApp_context());
        HttpRequest hr = new HttpRequest(url);
        hr.connect(u);
        u.setSession(hr.getResponseBody());
        u.setRolenames(getRolenamesFromSession(hr.getResponseBody()));
    }

    /**
     * 
     * @return uma nova app_context
     */
    private String getNewAppContext() {
        ArrayList<AppContextDTO> appContextDTO = null;

        // Converter uma String em um objecto URL,
        // que virá a ser invocado pelo Jackson.
        URL url = ApiFunctions.CONTEXT.getURL(APP_KEY);

        // Criar uma nova TypeReference para que o Jackson possa armazenar o
        // array que é devolvido pela API
        TypeReference<ArrayList<AppContextDTO>> tr;
        tr = new TypeReference<ArrayList<AppContextDTO>>() {
        };

        try {
            // <editor-fold defaultstate="collapsed">
            /*
            * Aqui é onde a mágica acontece: O Jackson consegue e uma
            * só linha, fazer:
            * 1. Invocar um URL
            * 2. Ler o conteúdo
            * 3. Converter para um tip de objecto conhecido.
            *
            * Atenção à necessidade de declaração de um novo TypeReference
            * Uma vez que um ArrayList<AppContextDTO> não é trivial.
            *
             */
            // </editor-fold>

            appContextDTO = new ObjectMapper().readValue(
                    url, tr);
        } catch (JsonParseException e) {
            throw new LoginServerException("Falha no formato do JSON do contexto.\n" + e.getMessage());
        } catch (JsonMappingException e) {
            throw new LoginServerException("Não foi possível processar JSON do contexto." + e.getMessage());
        } catch (IOException e) {
            throw new LoginServerException("Não foi possível aceder à informação de login." + e.getMessage());
        }

        if (appContextDTO != null) {
            System.out.println(String.format("getNewAppContext() =>%s", appContextDTO.get(0).getApp_context()));
            return appContextDTO.get(0).getApp_context();
        }
        return "";
    }

//    public static void main(String[] args) {
//        String result = "";
//
////        String thisContext = "{aaa}";
//        String thisContext = "{36026E90-474C-4A5F-B0B3-788CFB360193}";
//        thisContext = "";
//
////        String username = "testedanieljrWITHROLE5";
////        String password = "testedanieljrWITHROLE5";
//        String username = "testedanieljrWITHROLE8";
//        String password = "testedanieljrWITHROLE8";
//        String rolenames = "gestor,colaborador";
//
//        UserInfoDTO u = new UserInfoDTO();
//        u.setApp_context(thisContext);
//        u.setUsername(username);
//        u.setPassword(password);
//        u.setEmail(username);
//        u.setRolenames(rolenames);
//
//        UsersAPIAdapter uapia = new UsersAPIAdapter("IBD0DEHBDID62EB1EAZBEoA95E3cB5BD5135d01F0FqE6eDDoD4yDEX05RFEF19q9BY04KBE03A919hAFM06");
////        uapia.registerUserWithRoles(u);
//        uapia.login(u);
//        String roles = uapia.getRoles(u);
//        System.out.println("============== getRoles() ==============");
//        System.out.println(roles);
//        uapia.logout(u);
//        System.out.println("============== u BEFORE LOGOUT ==============");
//        System.out.println(u);
//        boolean b = uapia.logout(u);
//        System.out.println("============== u AFTER LOGOUT ==============");
//        System.out.println(u);
//        uapia.login(u);
//        System.out.println("============== u AFTER LOGIN 1 ==============");
//        System.out.println(u);
//        uapia.login(u);
//        System.out.println("============== u AFTER LOGIN 2 ==============");
//        System.out.println(u);
//        uapia.getNewAppContext(u);
//        System.out.println("============== This Context ==============");
//        System.out.println("thisContext: " + u.getApp_context());
//        boolean result = uapia.login(
//                "testedanieljrNOROLE2",
//                "testedanieljrNOROLE2");
//        String thisContext = uapia.app_context;
//        String result = uapia.login(
//                thisContext,
//                "testedanieljrWITHROLE5",
//                "testedanieljrWITHROLE5");
//        System.out.println("============== u before login ==============");
//        
//        uapia.login(u);
//        System.out.println(u.toString());
//
//        u.setSession(uapia.getSession(u.getApp_context()));
//        System.out.println("==============SESSION==============");
//        System.out.println(u);
//    }
    /**
     * 
     * @param responseBody 
     * @return o pepel da sessão
     */
    private String getRolenamesFromSession(String responseBody) {
        ArrayList<UserInfoDTO> uidto = null;
        TypeReference<ArrayList<UserInfoDTO>> tr = new TypeReference<ArrayList<UserInfoDTO>>() {
        };
        try {
            uidto = new ObjectMapper().readValue(responseBody, tr);
        } catch (JsonProcessingException ex) {
            throw new UsersAPIException("Falha ao obter \"rolenames\" a partir da \"session\"");
        }
        if (uidto == null) {
            return "";
        }
        return uidto.get(0).getRolenames();
    }
}
