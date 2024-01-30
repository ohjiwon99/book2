package librarylogin;

	import java.util.HashMap;
	import java.util.Map;
	import java.util.Scanner;

	public class OnlyLogin {

	    private static Map<String, String> userDatabase = new HashMap<>();

	    public static void main(String[] args) {
	    	
	        // 사용자 데이터베이스에 몇 명의 사용자를 추가. 
	    	//(실제로는 데이터베이스 연결 및 관리가 필요)
	    	
	        userDatabase.put("user1", "password1");
	        userDatabase.put("user2", "password2");

	        // 사용자에게 로그인 정보를 입력받는다.
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("사용자 아이디를 입력하세요: ");
	        String username = scanner.nextLine();
	        System.out.print("비밀번호를 입력하세요: ");
	        String password = scanner.nextLine();

	        // 로그인을 시도하고 결과를 출력
	        if (login(username, password)) {
	            System.out.println("로그인 성공!");
	        } else {
	            System.out.println("로그인 실패. 사용자 이름 또는 비밀번호가 잘못되었습니다.");
	        }
	    }

	    private static boolean login(String username, String password) {
	    	
	        // 사용자 데이터베이스에서 사용자 이름에 해당하는 비밀번호를 가져온다.
	        String storedPassword = userDatabase.get(username);

	        // 사용자 이름이 존재하고, 입력한 비밀번호가 저장된 비밀번호와 일치하면 로그인 성공을 반환합니다.
	        return storedPassword != null && storedPassword.equals(password);
	    }
	}