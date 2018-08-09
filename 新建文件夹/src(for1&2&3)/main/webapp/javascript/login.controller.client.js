(function () {
    var loginBtn = jQuery('#loginBtn');
    loginBtn.click(loginHandler);
    var userServiceClient = new UserServiceClient();

    function loginHandler() {
        var username = $('#username');
        username = username.val();
        var password = $('#password');
        password = password.val();
        userServiceClient.loginHandler(username, password);
    }
})();