package peopleMoverWS.model;

/**
*
* @author maurice
*/
public class ValidateUser {
   private String login;
   private String pass;
   private String AppId;
   private String IP;
   private String token;
   public ValidateUser(String login, String pass)
   {
       this.login = login;
       this.pass = pass;
       this.AppId = "2";
       this.IP = "";
       
   }
   public ValidateUser(String login, String pass, String AppId)
   {
       this.login = login;
       this.pass = pass;
       this.AppId = AppId;
       this.IP = "";
       
   }
   public ValidateUser(String login, String pass, String AppId, String IP)
   {
       this.login = login;
       this.pass = pass;
       this.AppId = AppId;
       this.IP = IP;
   }
   
   
   public String getToken()
   {
       return this.token;
   }
   public void setToken(String token)
   {
       this.token = token;
   }

   public String getLogin() {
       return login;
   }

  

   public String getPass() {
       return pass;
   }

  

   public String getAppId() {
       return AppId;
   }

  

   public String getIP() {
       return IP;
   }

     
}
