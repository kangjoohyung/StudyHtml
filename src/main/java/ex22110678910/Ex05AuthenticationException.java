package ex22110678910;
/**
 * 로그인할때 비번, 패스워드가 틀려려서 인증에 실패할때 발생하는 예외
 * */
public class Ex05AuthenticationException extends Exception {
   public Ex05AuthenticationException() {}
   public Ex05AuthenticationException(String message) {
	   super(message);
   }
}
