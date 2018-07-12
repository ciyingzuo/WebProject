(function () {

    var firstName = $('#firstName');
    var lastName = $('#lastName');
    var password = $('#password');
    var password2 = $('#password2');
    var username = $('#username');
    var role = $('#role');
    var phone = $('#phone');
    var emailAddress = $('#emailAddress');
    var date_of_birth = $('#date_of_birth');
    var userServiceClient = new UserServiceClient();

    init();

    function init() {
        firstName = $('#firstName');
        lastName = $('#lastName');
        password = $('#password');
        password2 = $('#password2');
        username = $('#username');
        role = $('#role');
        phone = $('#phone');
        emailAddress = $('#emailAddress');
        date_of_birth = $('#date_of_birth');
    }

    var registerBtn = jQuery('#registerBtn');
    registerBtn.click(function () {
        firstName = firstName.val();
        lastName = lastName.val();
        password = password.val();
        password2 = password2.val();
        username = username.val();
        role = role.val();
        phone = phone.val();
        emailAddress = emailAddress.val();
        date_of_birth = date_of_birth.val();
        if (password2 != null && password2 != undefined && password2 != "" && password != password2) {
            init();
            alert("password does't match");
        } else {
            userServiceClient.registerHandler(firstName, lastName, password, password2,
                username, role, phone, emailAddress, date_of_birth);
            init();
        }
    });
})();