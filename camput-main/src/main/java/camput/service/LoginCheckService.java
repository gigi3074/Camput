package camput.service;

import javax.servlet.http.HttpServletRequest;

public interface LoginCheckService {
    String checkLogin( HttpServletRequest request);
}
