package Controller;

public class Member {
    private String displayName;
    private String userId;
    private String email;
    private String roles;

    public String getRoles() {
        return roles;
    }

    public String getEmail() {

        return email;
    }

    public String getUserId() {
        return userId;
    }


    public String getDisplayName() {
        return displayName;
    }

    public Member(String displayName, String userId, String email, String roles){
        this.displayName = displayName;
        this.userId = userId;
        this.email = email;
        this.roles = roles;
    }
}
