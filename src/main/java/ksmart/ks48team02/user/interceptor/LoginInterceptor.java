package ksmart.ks48team02.user.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.Objects;

@Component
public class LoginInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        HttpSession session = request.getSession();
        String sessionId = (String) session.getAttribute("SID");

        if(sessionId != null) {
            int sessionLevel = (int) session.getAttribute("SLEVEL");
            String unregStatus = (String) session.getAttribute("UNREG_STATUS");
            String requestURI = request.getRequestURI();

            if(Objects.equals(unregStatus, "inactive")){
                if(requestURI.contains("user/mypage")){

                    response.sendRedirect("/user/account");
                }
            }
            //!!!! 권한에 따라 상단 메뉴가 달라지더라도, 직접 주소를 입력하여 접속할 수 있으므로
            // 이를 막기 위해 하단 코드 작성 할 것!

//            // 판매자
//            if(sessionLevel == 2) {
//                if( 	requestURI.indexOf("/member/memberList")  > -1
//                        ||	requestURI.indexOf("/member/modify") 	  > -1
//                        ||	requestURI.indexOf("/member/remove") 	  > -1	) {
//                    response.sendRedirect("/");
//                    return false;
//                }
//                // 구매자
//            }else if(sessionLevel == 3) {
//                if( 	requestURI.indexOf("/member/memberList")  > -1
//                        ||	requestURI.indexOf("/member/modify") 	  > -1
//                        ||	requestURI.indexOf("/member/remove") 	  > -1
//                        ||	requestURI.indexOf("/goods/add") 	  	  > -1
//                        ||	requestURI.indexOf("/goods/modify") 	  > -1
//                        ||	requestURI.indexOf("/goods/remove") 	  > -1	) {
//                    response.sendRedirect("/");
//                    return false;
//                }
//            }
//
//            return true;
        }

        response.sendRedirect("/user/account/login");

        return false;
    }
}











