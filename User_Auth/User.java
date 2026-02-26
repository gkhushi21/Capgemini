package User_Auth;

import java.util.ArrayList;

    public class User implements IValidate {
        static ArrayList<User> user = new ArrayList<>();

        private String userId;
        private String password;

        public void addUser(String userId,String password) {
            this.userId = userId;
            this.password = password;
            user.add(this);
        }

        public String toString() {
            return userId + "  " + password;
        }

        String getUserId() {
            return this.userId;
        }

        String getPassword() {
            return this.password;
        }

        public  boolean IsAuthenticated(String userid, String password) {
            for (User us : user) {
                if (userid.equals(us.getUserId()) &&
                        password.equals(us.getPassword())) {
                    return true;
                }
            }
            return false;
        }
    }

