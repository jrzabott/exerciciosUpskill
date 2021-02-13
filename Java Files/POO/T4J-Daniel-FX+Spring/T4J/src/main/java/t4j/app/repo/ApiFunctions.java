package t4j.app.repo;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import t4j.app.exception.UsersAPIException;

public enum ApiFunctions {

    CONTEXT {
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("context");
            return sb.toString();
        }

        @Override
        @Deprecated
        URL getURL(String app_context, String username, String email, String password, String rolenames) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        @Deprecated
        URL getURL(String app_context, String username, String email, String password) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        @Deprecated
        URL getURL(String app_context, String p1, String p2) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        URL getURL(String app_key) {
            String queryString = new String();
            queryString = URL_API
                    + toString()
                    + QUERY_START_SYMBOL
                    + prepareQueryParam("app_key", app_key);
            URL url = newURL(queryString);
            return url;

        }

    },
    REGISTER_USER {
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("registerUser");
            return sb.toString();
        }

        @Override
        @Deprecated
        URL getURL(String app_context, String username, String email, String password, String rolenames) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        URL getURL(String app_context, String username, String email, String password) {
            String queryString = new String();
            queryString = URL_API
                    + toString()
                    + QUERY_START_SYMBOL
                    + prepareQueryParam("app_context", app_context)
                    + QUERY_CONCAT_SYMBOL
                    + prepareQueryParam("username", username)
                    + QUERY_CONCAT_SYMBOL
                    + prepareQueryParam("email", email)
                    + QUERY_CONCAT_SYMBOL
                    + prepareQueryParam("password", password);
            URL url = newURL(queryString);
            return url;
        }

        @Override
        @Deprecated
        URL getURL(String app_context, String p1, String p2) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        @Deprecated
        URL getURL(String app_context) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    },
    REGISTER_USER_WITH_ROLES {
        @Override
        @Deprecated
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("registerUserWithRoles");
            return sb.toString();
        }

        @Override
        URL getURL(String app_context, String username, String email, String password, String roleString) {
            String queryString = new String();
            queryString = URL_API
                    + toString()
                    + QUERY_START_SYMBOL
                    + prepareQueryParam("app_context", app_context)
                    + QUERY_CONCAT_SYMBOL
                    + prepareQueryParam("username", username)
                    + QUERY_CONCAT_SYMBOL
                    + prepareQueryParam("email", email)
                    + QUERY_CONCAT_SYMBOL
                    + prepareQueryParam("password", password)
                    + QUERY_CONCAT_SYMBOL
                    + prepareQueryParam("rolenames", roleString);
            URL url = newURL(queryString);
            return url;
        }

        @Override
        @Deprecated
        URL getURL(String app_context, String username, String email, String password) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        @Deprecated
        URL getURL(String app_context, String p1, String p2) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        @Deprecated
        URL getURL(String app_context) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    },
    LOGIN {
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("login");
            return sb.toString();
        }

        @Override
        @Deprecated
        URL getURL(String app_context, String username, String email, String password, String rolenames) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        @Deprecated
        URL getURL(String app_context, String username, String email, String password) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        URL getURL(String app_context, String username, String password) {
            String queryString = new String();
            queryString = URL_API
                    + toString()
                    + QUERY_START_SYMBOL
                    + prepareQueryParam("app_context", app_context)
                    + QUERY_CONCAT_SYMBOL
                    + prepareQueryParam("user_id", username)
                    + QUERY_CONCAT_SYMBOL
                    + prepareQueryParam("password", password);
            URL url = newURL(queryString);
            return url;
        }

        @Override
        @Deprecated
        URL getURL(String app_context) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    },
    LOGOUT {
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("logout");
            return sb.toString();
        }

        @Override
        @Deprecated
        URL getURL(String app_context, String username, String email, String password, String rolenames) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        @Deprecated
        URL getURL(String app_context, String username, String email, String password) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        @Deprecated
        URL getURL(String app_context, String p1, String p2) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        URL getURL(String app_context) {
            String queryString = new String();
            queryString = URL_API
                    + toString()
                    + QUERY_START_SYMBOL
                    + prepareQueryParam("app_context", app_context);
            URL url = newURL(queryString);
            return url;
        }
    },
    ROLES_GET {
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("roles");
            return sb.toString();
        }

        @Override
        @Deprecated
        URL getURL(String app_context, String username, String email, String password, String rolenames) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        @Deprecated
        URL getURL(String app_context, String username, String email, String password) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        @Deprecated
        URL getURL(String app_context, String p1, String p2) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        URL getURL(String app_context) {
            String queryString = new String();
            queryString = URL_API
                    + toString()
                    + QUERY_START_SYMBOL
                    + prepareQueryParam("app_context", app_context);
            URL url = newURL(queryString);
            return url;
        }
    },
    ROLES_POST {
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("roles");
            return sb.toString();
        }

        @Override
        URL getURL(String app_context, String username, String email, String password, String rolenames) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        @Deprecated
        URL getURL(String app_context, String username, String email, String password) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        URL getURL(String app_context, String rolename, String description) {
            String queryString = new String();
            queryString = URL_API
                    + toString()
                    + QUERY_START_SYMBOL
                    + prepareQueryParam("app_context", app_context)
                    + QUERY_CONCAT_SYMBOL
                    + prepareQueryParam("rolename", rolename)
                    + QUERY_CONCAT_SYMBOL
                    + prepareQueryParam("description", description);
            URL url = newURL(queryString);
            return url;
        }

        @Override
        @Deprecated
        URL getURL(String app_context) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    },
    SESSION {
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("session");
            return sb.toString();
        }

        @Override
        @Deprecated
        URL getURL(String app_context, String username, String email, String password, String rolenames) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        @Deprecated
        URL getURL(String app_context, String username, String email, String password) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        @Deprecated
        URL getURL(String app_context, String p1, String p2) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        URL getURL(String app_context) {
            String queryString = new String();
            queryString = URL_API
                    + toString()
                    + QUERY_START_SYMBOL
                    + prepareQueryParam("app_context", app_context);
            URL url = newURL(queryString);
            return url;
        }
    };
    private static final String URL_API = "http://multilogus.dynns.com:8001/";
    private static final String QUERY_START_SYMBOL = "?";
    private static final String QUERY_CONCAT_SYMBOL = "&";

    private static String prepareQueryParam(String key, String value) {
        String result;
        try {
            result = String.format("%s=%s",
                    URLEncoder.encode(key, "UTF-8"),
                    URLEncoder.encode(value, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new UsersAPIException("A codificação informada nos parâmetros "
                    + "é inválida. Por favor verifique o endereço informado.");
        }
        return result;
    }

    private static URL newURL(String url) {
        URL result = null;
        try {
            result = new URL(url);
            return result;
        } catch (MalformedURLException e) {
            throw new UsersAPIException("A URL informada é inválida. "
                    + "Por favor verifique o endereço informado.");
        }
    }

    abstract URL getURL(String app_context, String username, String email, String password, String rolenames);

    abstract URL getURL(String app_context, String username, String email, String password);

    abstract URL getURL(String app_context, String p1, String p2); // Usado para role e login

    abstract URL getURL(String app_context); // Usado para context e outros métodos

}
