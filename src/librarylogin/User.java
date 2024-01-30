package librarylogin;

public class User {
	
	 
    private String id;
    private String password;
    private String nickname;
    
    
  //기본 생성자
    User() {} 
    
    User(String id,String password,String nickname) {
        this.id = id;
        this.password = password;
        this.nickname = nickname;
    }
    
    
    //각 필드의 Getter, Setter
    void setId(String id) { 
    	this.id = id; }
    
    void setPassword(String password) { 
    	this.password = password; }
    
    void setNickname(String nickname) { 
    	this.nickname = nickname; }
    
    String getId() { 
    	return id;}
    
    String getPassword() { 
    	return password;}
    
    String getNickname() { 
    	return nickname;}
}
