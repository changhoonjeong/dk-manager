package kr.onekey.dk.constant;

public class Constant {
    // login status
    public final static int MANAGER_STATUS_ACTIVITY = 1;
    public final static int MANAGER_STATUS_REST = 2;
    public final static int MANAGER_STATUS_STOP = 3;
    public final static int MANAGER_STATUS_NEW = 4;
    public final static int MANAGER_STATUS_REMOVE = MANAGER_STATUS_STOP;

    // login
    public final static int LOGIN_FAIL_COUNT = 5;

    // login session obj
    public final static String LOGIN_SESSION_OBJ = "login_session_obj";
}