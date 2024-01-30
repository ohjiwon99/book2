package librarylogin;


	public class MemberVo {
		
		//필드
		private int Member_Id;
		private String Member_pw; 
		private String Member_email;
		
		public MemberVo() {
		
		}
		
		
		public MemberVo(int member_Id, String member_pw, String member_email) {
			super();
			Member_Id = member_Id;
			Member_pw = member_pw;
			Member_email = member_email;
		}


		public int getMember_Id() {
			return Member_Id;
		}


		public void setMember_Id(int member_Id) {
			Member_Id = member_Id;
		}


		public String getMember_pw() {
			return Member_pw;
		}


		public void setMember_pw(String member_pw) {
			Member_pw = member_pw;
		}


		public String getMember_email() {
			return Member_email;
		}


		public void setMember_email(String member_email) {
			Member_email = member_email;
		}


		@Override
		public String toString() {
			return "MemberVo [Member_Id=" + Member_Id + ", Member_pw=" + Member_pw + ", Member_email=" + Member_email
					+ "]";
		}
		
		
		
	
	}


